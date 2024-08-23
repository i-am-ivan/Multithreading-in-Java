package com.i_am_ivan.multithreading.ConcurrencyControl;

/**
 * SynchronizedBlocks demonstrates synchronization
 * using synchronized blocks to control access to shared resources.
 *
 * In this example, the increment method is synchronized to ensure
 * that only one thread can execute it at a time, preventing race conditions.
 */
public class SynchronizedBlocks {

    private int count = 0;

    public void increment() {
        // Synchronized block ensures that only one thread can execute this block at a time
        synchronized (this) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedBlocks example = new SynchronizedBlocks();
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
