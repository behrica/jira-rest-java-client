package com.atlassian.jira.rest.client.domain;

import org.junit.Test;

public class RoleTest {
    @Test
    public void role() {
        String roleInJson="{\"self\":\"https://efsajira.jira.com/rest/api/2.0.alpha1/project/ESS/role/10002\",\n" +
                "  \"name\":\"Administrators\", \n" +
                "  \"id\":10002,\n" +
                "  \"description\":\"A project role that represents administrators in a project\", \n" +
                "  \"actors\":[\n" +
                "      {\"id\":10125,\"displayName\":\"administrators\",\"type\":\"atlassian-group-role-actor\",\"name\":\"administrators\",\"avatarUrl\":\"/secure/useravatar?size=small&avatarId=10073\"},\n" +
                "      {\"id\":10252,\"displayName\":\"Carsten Behring\",\"type\":\"atlassian-user-role-actor\",\"name\":\"behrica\",\"avatarUrl\":\"/secure/useravatar?size=small&avatarId=10065\"},\n" +
                "      {\"id\":10541,\"displayName\":\"Catherine Minciotti\",\"type\":\"atlassian-user-role-actor\",\"name\":\"mincica\",\"avatarUrl\":\"/secure/useravatar?size=small&avatarId=10072\"},\n" +
                "      {\"id\":11212,\"displayName\":\"Giovanni Betuzzi\",\"type\":\"atlassian-user-role-actor\",\"name\":\"betuzgi\",\"avatarUrl\":\"/secure/useravatar?size=small&avatarId=10072\"},\n" +
                "      {\"id\":10540,\"displayName\":\"Marco Castaldini\",\"type\":\"atlassian-user-role-actor\",\"name\":\"castama\",\"avatarUrl\":\"/secure/useravatar?size=small&avatarId=10072\"}\n" +
                "    ]\n" +
                "}";

        /*
        Role role=new Gson().fromJson(roleInJson,Role.class);
        assertEquals("10002", role.getId());
        assertEquals("behrica", role.getActors().get(1).getName());
        */
    }


    @Test
    public void roles() {
        String rolesInJson="{\"Users\":\"https://efsajira.jira.com/rest/api/2.0.alpha1/project/ESS/role/10000\",\n" +
                " \"techlead\":\"https://efsajira.jira.com/rest/api/2.0.alpha1/project/ESS/role/10020\",\n" +
                " \"Administrators\":\"https://efsajira.jira.com/rest/api/2.0.alpha1/project/ESS/role/10002\",\n" +
                " \"Developer\":\"https://efsajira.jira.com/rest/api/2.0.alpha1/project/ESS/role/10010\"}\n";

        /*
        Map<String,String> roles=new Gson().fromJson(rolesInJson,new TypeToken<Map<String,String>>(){}.getType());
        System.out.println("roles = " + roles);
        */
    }

}
