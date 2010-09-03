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

package com.atlassian.jira.restjavaclient.json;

import com.atlassian.jira.restjavaclient.ExpandableProperty;
import com.atlassian.jira.restjavaclient.domain.User;
import com.atlassian.jira.restjavaclient.domain.Watchers;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.net.URI;
import java.util.Collection;

/**
 * TODO: Document this class / interface here
 *
 * @since v0.1
 */
public class WatchersJsonParser extends JsonParserWithJsonObjectValue<Watchers> {
	private final UserJsonParser userJsonParser = new UserJsonParser();

    @Override
    protected Watchers parseValue(JSONObject json) throws JSONException {
        final URI self = JsonParseUtil.getSelfUri(json);
        final boolean isWatching = json.getBoolean("isWatching");
        final Collection<User> list = JsonParseUtil.parseJsonArray(json.getJSONArray("list"), userJsonParser);
        return new Watchers(self, isWatching, list);
    }
}