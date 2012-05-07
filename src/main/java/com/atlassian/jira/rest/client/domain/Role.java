package com.atlassian.jira.rest.client.domain;

import java.util.List;

public class Role {
    private final String name;
    private final String id;
    private final List<Actor> actors;


    public Role(String name, String id, List<Actor> actors) {
        this.name = name;
        this.id = id;
        this.actors = actors;
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }


    public List<Actor> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "Role{" +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", actors=" + actors +
                '}';
    }

}
