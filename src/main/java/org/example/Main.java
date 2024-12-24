package org.example;

import org.example.sevo.counter.Counter;
import org.example.sevo.counter.CounterEvent;
import org.example.sevo.events.Event;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        counter.getEventDispatcher().addListener(CounterEvent.COUNTER_STARTED, (Event e) -> {
            CounterEvent event = (CounterEvent) e;
            Counter sender = (Counter) event.getSender();
            System.out.println(event.getType() + ": " + event.getCount());

        });

        counter.getEventDispatcher().addListener(CounterEvent.COUNTER_CHANGED, (Event e) -> {
            CounterEvent event = (CounterEvent) e;
            Counter sender = (Counter) event.getSender();
            System.out.println(event.getType() + ": " + event.getCount());
        });

        counter.getEventDispatcher().addListener(CounterEvent.COUNTER_FINISHED, (Event e) -> {
            CounterEvent event = (CounterEvent) e;
            Counter sender = (Counter) event.getSender();
            System.out.println(event.getType() + ": " + event.getCount());
        });

        // counter.getEventDispatcher().removeListener(Counter.COUNTER_CHANGED_EVENT);
        counter.run();
    }
}