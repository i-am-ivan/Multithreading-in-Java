package com.i_am_ivan.multithreading.ThreadManagement;

/**
 * ThreadLifecycle demonstrates different states of a thread
 * in its lifecycle, such as New, Runnable, Blocked, and Terminated.
 */
public class ThreadLifecycle implements Runnable {

    public static void main(String[] args) {
        // Creating an instance of the Runnable
        ThreadLifecycle instance = new ThreadLifecycle();
        // Creating a new thread with the Runnable instance
        Thread thread = new Thread(instance);

        // Thread is in New state, it hasn’t started yet.
        thread.start();  // Thread enters the Runnable state

        // The thread completes its run method and enters the Terminated state
    }

    @Override
    public void run() {
        System.out.println("Thread is running.");
        // Simulate thread work by making it sleep for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread is finished.");
    }
}
