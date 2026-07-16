package org.example.standard.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalSample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 스레드별 값 확인 ===");

        printThreadId();
        printThreadId();

        Thread firstThread = new Thread(
                ThreadLocalSample::runTask,
                "worker-1"
        );

        Thread secondThread = new Thread(
                ThreadLocalSample::runTask,
                "worker-2"
        );

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println();
        System.out.println("=== main 스레드 값 재확인 ===");

        printThreadId();

        System.out.println();
        System.out.println("=== remove 후 재초기화 ===");

        ThreadLocalId.remove();
        printThreadId();

        System.out.println();
        System.out.println("=== 스레드 풀에서 값이 남는 문제 ===");

        runThreadPoolSample();
    }

    private static void runTask() {
        try {
            printThreadId();
            printThreadId();
        } finally {
            ThreadLocalId.remove();
        }
    }

    private static void printThreadId() {
        System.out.printf(
                "threadName=%s, threadId=%d%n",
                Thread.currentThread().getName(),
                ThreadLocalId.get()
        );
    }

    private static void runThreadPoolSample() {
        ExecutorService executorService =
                Executors.newSingleThreadExecutor();

        ThreadLocal<String> currentUser = new ThreadLocal<>();

        executorService.submit(() -> {
            currentUser.set("user-A");

            System.out.printf(
                    "첫 번째 작업: thread=%s, user=%s%n",
                    Thread.currentThread().getName(),
                    currentUser.get()
            );

            // remove()를 호출하지 않아 값이 스레드에 남는다.
        });

        executorService.submit(() -> {
            System.out.printf(
                    "두 번째 작업: thread=%s, user=%s%n",
                    Thread.currentThread().getName(),
                    currentUser.get()
            );

            currentUser.remove();
        });

        executorService.shutdown();
    }
}

class ThreadLocalId {

    private static final AtomicInteger nextId =
            new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId =
            ThreadLocal.withInitial(() -> {
                int newId = nextId.getAndIncrement();

                System.out.printf(
                        "[초기화] threadName=%s, newId=%d%n",
                        Thread.currentThread().getName(),
                        newId
                );

                return newId;
            });

    public static int get() {
        return threadId.get();
    }

    public static void remove() {
        threadId.remove();

        System.out.printf(
                "[제거] threadName=%s%n",
                Thread.currentThread().getName()
        );
    }
}