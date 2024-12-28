package org.example.sevo.events;

import java.util.HashMap;

public class EventDispatcher<S, E extends Event<S>> {

    HashMap<String, IListener<E>> listeners;

    public static  <T, F extends Event<T>> EventDispatcher<T, F> initialize(){
        return new EventDispatcher<>();
    }

    public EventDispatcher() {
        this.listeners = new HashMap<>();
    }

    public boolean hasListener(String type) {
        return this.listeners.containsKey(type);
    }

    public boolean addListener(String type, IListener<E> listener) {
        if(!this.hasListener(type)) {
            this.listeners.put(type, listener);
            return true;
        }
        return false;
    }

    public boolean removeListener(String type) {
        if(this.hasListener(type)) {
            this.listeners.remove(type);
            return true;
        }
        return false;
    }

    public void dispatchEvent(E event) {
        if(this.hasListener(event.getType())) {
            this.listeners.get(event.getType()).listener(event);
        }
    }
}
