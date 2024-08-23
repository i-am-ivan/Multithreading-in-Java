package com.i_am_ivan.multithreading.ThreadManagement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadPoolExample demonstrates the use of thread pools
 * to manage multiple threads efficiently.
 *
 * In this example, a fixed thread pool is created, which
 * manages a pool of 5 threads to handle 10 tasks.
 */
public class ThreadPoolExample {

    public static void main(String[] args) {
        // Creating a thread pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submitting 10 tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);  // Assigning each task to the pool
        }

        // Initiating an orderly shutdown of the thread pool
        executor.shutdown();

        // Waiting for all tasks to complete
        while (!executor.isTerminated()) {
        }

        System.out.println("Finished all threads");
    }
}

/**
 * WorkerThread represents a task that will be executed by a thread.
 */
class WorkerThread implements Runnable {
    private String command;

    public WorkerThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        // Simulate work by making the thread sleep for 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " End.");
    }
}
