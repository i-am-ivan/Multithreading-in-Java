package com.i_am_ivan.multithreading.ThreadManagement;

/**
 * CustomThread demonstrates a basic thread creation
 * by extending the Thread class.
 *
 * This example shows how to override the run() method
 * to define the code that the thread will execute.
 */
public class CustomThread extends Thread {

    @Override
    public void run() {
        // The code inside this method defines the behavior of the thread.
        System.out.println("Custom thread is running.");
        // You can place any task here that you want the thread to perform.
    }

    public static void main(String[] args) {
        // Creating an instance of CustomThread.
        CustomThread thread = new CustomThread();
        // Starting the thread which will invoke the run() method.
        thread.start();
    }
}
