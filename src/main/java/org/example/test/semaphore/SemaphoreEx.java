package org.example.test.semaphore;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreEx {

    public static void main(String[] args) throws InterruptedException {
        List<Worker> workers = List.of(
                new Worker("유어진", 10),
                new Worker("카리나", 100),
                new Worker("윈터", 10)
        );

        runSequentially(workers);

        System.out.println("=".repeat(30));

        runWithSemaphore(workers);
    }

    private static void runSequentially(List<Worker> workers) throws InterruptedException {
        Task task = new Task();

        for (Worker worker : workers) {
            worker.work(task);
        }
    }

    private static void runWithSemaphore(List<Worker> workers) throws InterruptedException {
        Task task = new Task();
        Semaphore semaphore = new Semaphore(2);

        List<Thread> threads = workers.stream()
                .map(worker -> new Thread(() -> {
                    try {
                        semaphore.acquire();

                        try {
                            worker.work(task);
                        } finally {
                            semaphore.release();
                        }

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }))
                .toList();

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }
    }
}

class Task {

    private final AtomicInteger success = new AtomicInteger();

    public int getSuccess() {
        return success.get();
    }

    public int success() {
        return success.incrementAndGet();
    }
}

class Worker {

    private final String name;
    private final long workTimeMillis;

    public Worker(String name, long workTimeMillis) {
        this.name = name;
        this.workTimeMillis = workTimeMillis;
    }

    public void work(Task task) throws InterruptedException {
        System.out.println(name + " 작업 시작 - 현재 완료: " + task.getSuccess());
        Thread.sleep(workTimeMillis);
        int success = task.success();
        System.out.println(name + " 작업 종료 - 현재 완료: " + success);
    }
}