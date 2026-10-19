package org.example.test.syncronized.monitor;

public class BoundedBuffer {
    private final int[] buffer = new int[5];
    private int count = 0;

    synchronized public void produce(int item) {
        while (count == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        buffer[count++] = item;
        notifyAll();
    }

    public void consume() {
        synchronized (this) {
            while (count == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            int item = buffer[count--];
            notifyAll();
            System.out.println("consume: " + item);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer buffer = new BoundedBuffer();

        Thread consume = new Thread(buffer::consume);
        Thread produce = new Thread(() -> buffer.produce(100));

        consume.start();
        produce.start();

        consume.join();
        produce.join();

        System.out.println("완료");
    }
}
