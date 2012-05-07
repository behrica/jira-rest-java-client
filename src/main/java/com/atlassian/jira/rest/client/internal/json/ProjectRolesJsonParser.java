package com.atlassian.jira.rest.client.internal.json;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProjectRolesJsonParser implements JsonParser<Map<String,String>> {
    @Override
    public Map<String,String> parse(JSONObject json) throws JSONException {
        Map<String,String> roleSelfMap= new HashMap<String, String>();
        final Iterator keys = json.keys();
        while (keys.hasNext()) {
            String nextKey = (String) keys.next();
            String self= (String) json.get(nextKey);
            roleSelfMap.put(nextKey,self);
        }
        return roleSelfMap;
    }
}
