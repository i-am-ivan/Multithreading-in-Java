package com.i_am_ivan.multithreading.ConcurrencyControl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LocksExample demonstrates the use of explicit locks
 * to control thread access to shared resources.
 *
 * This example uses ReentrantLock to control access to
 * the increment method, ensuring thread safety.
 */
public class LocksExample {

    private final Lock lock = new ReentrantLock();
    private int count = 0;

    public void increment() {
        // Acquire the lock before entering the critical section
        lock.lock();
        try {
            count++;
        } finally {
            // Ensure that the lock is released even if an exception is thrown
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LocksExample example = new LocksExample();
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
        System.out.println("Count is: " + count);
    }
}
