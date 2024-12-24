package org.example.sevo.counter;

import org.example.sevo.events.Event;

public class CounterEvent extends Event {

    public static final String COUNTER_STARTED = "COUNTER_STARTED";
    public static final String COUNTER_CHANGED = "COUNTER_CHANGED";
    public static final String COUNTER_FINISHED = "COUNTER_FINISHED";

    private final int count;

    public CounterEvent(String type, Object sender, int count) {
        super(type, sender);
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }
}
