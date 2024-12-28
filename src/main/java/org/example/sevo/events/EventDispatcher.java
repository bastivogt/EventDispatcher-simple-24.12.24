package org.example.sevo.events;

import java.util.HashMap;

public class EventDispatcher<TYPE_SENDER, TYPE_EVENT extends Event<TYPE_SENDER>> {

    HashMap<String, IListener<TYPE_SENDER, TYPE_EVENT>> listeners;

    public static  <T_SENDER, T_EVENT extends Event<T_SENDER>> EventDispatcher<T_SENDER, T_EVENT> initialize(){
        return new EventDispatcher<T_SENDER, T_EVENT>();
    }

    public EventDispatcher() {
        this.listeners = new HashMap<>();
    }

    public boolean hasListener(String type) {
        return this.listeners.containsKey(type);
    }

    public boolean addListener(String type, IListener<TYPE_SENDER, TYPE_EVENT> listener) {
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

    public void dispatchEvent(TYPE_EVENT event) {
        if(this.hasListener(event.getType())) {
            this.listeners.get(event.getType()).listener(event);
        }
    }
}
