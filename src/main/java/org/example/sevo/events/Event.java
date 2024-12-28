package org.example.sevo.events;

public class Event<TYPE_SENDER> {

    protected String type;
    protected TYPE_SENDER sender;

    public Event(String type, TYPE_SENDER sender) {
        this.type = type;
        this.sender = sender;
    }

    public String getType() {
        return this.type;
    }

    public TYPE_SENDER getSender() {
        return this.sender;
    }
}
