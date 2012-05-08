package com.atlassian.jira.rest.client.domain;

public class Actor {


    private final String id;
    private final String displayName;
    private final String name;
    private final ActorType actorType;

    public Actor(String id, String displayName, String name, ActorType actorType) {
        this.id = id;
        this.displayName = displayName;
        this.name = name;
        this.actorType = actorType;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return name;
    }

    public ActorType getActorType() {
        return actorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (actorType != actor.actorType) return false;
        if (displayName != null ? !displayName.equals(actor.displayName) : actor.displayName != null) return false;
        if (id != null ? !id.equals(actor.id) : actor.id != null) return false;
        if (name != null ? !name.equals(actor.name) : actor.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (actorType != null ? actorType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", name='" + name + '\'' +
                ", actorType=" + actorType +
                '}';
    }

    public enum ActorType {
        USER, GROUP;

        public static ActorType fromString(String type) {
            if (type.equals("atlassian-group-role-actor"))
                return GROUP;
            else if (type.equals("atlassian-user-role-actor"))
                return USER;
            else throw new IllegalArgumentException("unkown type: "+type);
        }
    }
}
