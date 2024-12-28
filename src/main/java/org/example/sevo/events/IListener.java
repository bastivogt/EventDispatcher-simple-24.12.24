package org.example.sevo.events;

@FunctionalInterface
public interface IListener<E extends Event> {
    void listener(E event);
}
