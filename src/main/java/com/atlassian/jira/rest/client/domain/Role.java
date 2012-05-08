package com.atlassian.jira.rest.client.domain;

import java.util.Collection;

public class Role {
    private final String name;
    private final String id;
    private final Collection<Actor> actors;


    public Role(String name, String id, Collection<Actor> actors) {
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


    public Collection<Actor> getActors() {
        return actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (actors != null ? !actors.equals(role.actors) : role.actors != null) return false;
        if (id != null ? !id.equals(role.id) : role.id != null) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (actors != null ? actors.hashCode() : 0);
        return result;
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
