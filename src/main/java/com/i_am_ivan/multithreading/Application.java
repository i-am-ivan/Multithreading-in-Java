package com.i_am_ivan.multithreading;

/**
 * Application serves as the main entry point of the project.
 *
 * This class can be used to initialize and execute
 * various multithreading examples within the project.
 */
public class Application {

    public static void main(String[] args) {
        // Initialize and run different examples of multithreading concepts
        System.out.println("Multithreading in Java project initialized.");

        // Example: Running CustomThread example
        com.yourusername.multithreading.ThreadManagement.CustomThread customThread = new com.yourusername.multithreading.ThreadManagement.CustomThread();
        customThread.start();

        // Add more examples as needed
    }
}
