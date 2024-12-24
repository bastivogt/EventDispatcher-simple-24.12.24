package org.example.sevo.counter;

import org.example.sevo.events.Event;
import org.example.sevo.events.EventDispatcher;

public class Counter {

    private int start;
    private int stop;
    private int step;
    private int count;

    private final EventDispatcher eventDispatcher;



    public int getCount() {
        return this.count;
    }

    public EventDispatcher getEventDispatcher() {
        return this.eventDispatcher;
    }



    public Counter(int start, int stop, int step) {
        this.reset(start, stop, step);
        // this.eventDispatcher = new EventDispatcher();
        this.eventDispatcher = EventDispatcher.initialize();
    }

    public Counter(int start, int stop) {
        this(start, stop, 1);
    }

    public Counter(int start) {
        this(start, 10, 1);
    }

    public Counter() {
        this(0, 10, 1);
    }


    public void run() {
        this.count = this.start;
        // System.out.println("STARTED");
        this.getEventDispatcher().dispatchEvent(new CounterEvent(CounterEvent.COUNTER_STARTED, this, this.count));
        for(; this.count < this.stop; this.count += this.step) {
            // System.out.println("CHANGED");
            this.getEventDispatcher().dispatchEvent(new CounterEvent(CounterEvent.COUNTER_CHANGED, this, this.count));
        }
        // System.out.println("FINISHED");
        this.getEventDispatcher().dispatchEvent(new CounterEvent(CounterEvent.COUNTER_FINISHED, this, this.count));
    }

    public void reset(int start, int stop, int step) {
        this.start = start;
        this.stop = stop;
        this.step = step;
        this.count = this.start;
    }
}
