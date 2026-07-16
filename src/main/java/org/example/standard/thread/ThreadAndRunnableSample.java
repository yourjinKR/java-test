package org.example.standard.thread;

public class ThreadAndRunnableSample {
    public static void main(String[] args) {
        ThreadSample threadSample = new ThreadSample();
        threadSample.run();
        threadSample.start();

        RunnableSample runnableSample = new RunnableSample();
        runnableSample.run();
        new Thread(runnableSample).start();
    }
}

class ThreadSample extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": thread sample");
    }
}

class RunnableSample implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": runnable sample");
    }
}
