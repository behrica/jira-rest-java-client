package com.atlassian.jira.rest.client;

import com.atlassian.jira.rest.client.domain.Role;
import com.atlassian.jira.rest.client.internal.jersey.JerseyJiraRestClientFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class JiraRolesSpike{
    public static void main(String[] args) throws URISyntaxException {
        String name = "behrica_adm";
        String password = "CB310853!";

        JiraRestClient jiraRestClient=new JerseyJiraRestClientFactory().createWithBasicHttpAuthentication(new URI("https://efsajira.jira.com"), name, password);
        ProjectRestClient projectRestClient=jiraRestClient.getProjectClient();
        final Map<String,Role> rawRoles = projectRestClient.getProjectRoles("RAW");
        System.out.println(" raw-admin role = " + rawRoles.get("Administrators"));
        final Map<String,Role> essRoles = projectRestClient.getProjectRoles("ESS");
        System.out.println(" ess-admin role = " + essRoles.get("Administrators"));

    }
}
