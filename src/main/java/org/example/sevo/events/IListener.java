package org.example.sevo.events;

@FunctionalInterface
public interface IListener<TYPE_SENDER, TYPE_EVENT extends Event<TYPE_SENDER>> {
    void listener(TYPE_EVENT event);
}
