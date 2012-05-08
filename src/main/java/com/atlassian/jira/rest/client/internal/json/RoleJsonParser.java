package com.atlassian.jira.rest.client.internal.json;

import com.atlassian.jira.rest.client.domain.Actor;
import com.atlassian.jira.rest.client.domain.Role;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RoleJsonParser implements JsonParser<Role> {
    @Override
    public Role parse(JSONObject json) throws JSONException {
        JSONArray actorArray=json.getJSONArray("actors");
        List<Actor> actors=new ArrayList<Actor>();
        for (int i=0;i<actorArray.length();i++) {
            JSONObject actorObject=actorArray.getJSONObject(i);
            Actor.ActorType actorType = Actor.ActorType.fromString(actorObject.getString("type"));
            actors.add(new Actor(actorObject.getString("id"),
                    actorObject.getString("displayName"),
                    actorObject.getString("name"), actorType));
        }
        return new Role(json.getString("name"),
                json.getString("id"),
                actors);
    }
}
