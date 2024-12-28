package org.example;

import org.example.sevo.counter.Counter;
import org.example.sevo.counter.CounterEvent;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        counter.getEventDispatcher().addListener(CounterEvent.COUNTER_STARTED, (CounterEvent e) -> {
            System.out.println(e.getType() + ": " + e.getCount() + "___" + e.getSender().getCount());

        });

        counter.getEventDispatcher().addListener(CounterEvent.COUNTER_CHANGED, (CounterEvent e) -> {
            System.out.println(e.getType() + ": " + e.getCount() + "___" + e.getSender().getCount());
        });

        counter.getEventDispatcher().addListener(CounterEvent.COUNTER_FINISHED, (CounterEvent e) -> {
            System.out.println(e.getType() + ": " + e.getCount() + "___" + e.getSender().getCount());
        });

        // counter.getEventDispatcher().removeListener(Counter.COUNTER_CHANGED_EVENT);
        counter.run();
    }
}