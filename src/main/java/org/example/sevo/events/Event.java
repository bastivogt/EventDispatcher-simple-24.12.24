package org.example.sevo.events;

public class Event {

    protected String type;
    protected Object sender;

    public Event(String type, Object sender) {
        this.type = type;
        this.sender = sender;
    }

    public String getType() {
        return this.type;
    }

    public Object getSender() {
        return this.sender;
    }
}
