package org.example.test.syncronized;

public class SynchronizedEx {
    synchronized public void consume() {
        // logic
    }

    public void produce() {
        synchronized (this) {
            // logic
        }
    }
}
