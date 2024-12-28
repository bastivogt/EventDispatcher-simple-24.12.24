package org.example.sevo.events;

public class Event<S> {

    protected String type;
    protected S sender;

    public Event(String type, S sender) {
        this.type = type;
        this.sender = sender;
    }

    public String getType() {
        return this.type;
    }

    public S getSender() {
        return this.sender;
    }
}
