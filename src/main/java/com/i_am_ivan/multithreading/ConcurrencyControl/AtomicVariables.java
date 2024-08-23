package com.i_am_ivan.multithreading.ConcurrencyControl;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicVariables demonstrates the use of atomic variables
 * for thread-safe operations without explicit locks.
 *
 * This example uses AtomicInteger to perform a thread-safe
 * increment operation on a shared counter.
 */
public class AtomicVariables {

    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        // Increment the counter atomically
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicVariables example = new AtomicVariables();
        example.doWork();
    }

    public void doWork() throws InterruptedException {
        // Creating two threads that will attempt to increment the count
        Thread t1 = new Thread(this::increment);
        Thread t2 = new Thread(this::increment);

        // Starting both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Print the final value of count
        System.out.println("Count is: " + count.get());
    }
}
