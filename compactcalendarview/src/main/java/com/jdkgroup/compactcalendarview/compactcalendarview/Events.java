package com.jdkgroup.compactcalendarview.compactcalendarview;

import java.util.List;

class Events {

    private final List<Events> events;
    private final long timeInMillis;

    Events(long timeInMillis, List<Events> events) {
        this.timeInMillis = timeInMillis;
        this.events = events;
    }

    long getTimeInMillis() {
        return timeInMillis;
    }

    List<Events> getEvents() {
        return events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Events event = (Events) o;

        if (timeInMillis != event.timeInMillis) return false;
        if (events != null ? !events.equals(event.events) : event.events != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = events != null ? events.hashCode() : 0;
        result = 31 * result + (int) (timeInMillis ^ (timeInMillis >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Events{" +
                "events=" + events +
                ", timeInMillis=" + timeInMillis +
                '}';
    }
}
