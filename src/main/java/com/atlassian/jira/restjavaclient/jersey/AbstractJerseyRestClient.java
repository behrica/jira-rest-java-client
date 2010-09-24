/*
 * Copyright (C) 2010 Atlassian
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.atlassian.jira.restjavaclient.jersey;

import com.atlassian.jira.restjavaclient.RestClientException;
import com.atlassian.jira.restjavaclient.json.JsonParseUtil;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.client.apache.ApacheHttpClient;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.net.URI;
import java.util.concurrent.Callable;

/**
 * TODO: Document this class / interface here
 *
 * @since v0.1
 */
public class AbstractJerseyRestClient {
	protected final ApacheHttpClient client;
	protected final URI baseUri;

	public AbstractJerseyRestClient(URI baseUri, ApacheHttpClient client) {
		this.baseUri = baseUri;
		this.client = client;
	}

	protected <T> T invoke(Callable<T> callable) {
		try {
			return callable.call();
		} catch (UniformInterfaceException e) {
			final String body = e.getResponse().getEntity(String.class);
			try {
				JSONObject jsonObject = new JSONObject(body);
				final JSONArray errorMessages = jsonObject.getJSONArray("errorMessages");
				throw new RestClientException(JsonParseUtil.toStringCollection(errorMessages), e);
			} catch (JSONException e1) {
				throw new RestClientException(e);
			}
		} catch (RestClientException e) {
			throw e;
		} catch (Exception e) {
			throw new RestClientException(e);
		}
	}


}
