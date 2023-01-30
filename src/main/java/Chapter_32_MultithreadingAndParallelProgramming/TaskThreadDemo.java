package Chapter_32_MultithreadingAndParallelProgramming;

// Demonstrates the use of threads and tasks
/* Creates three tasks and three threads to run them.
The three threads will share the CPU and take turns printing letters
and numbers on the console. */

public class TaskThreadDemo {
    public static void main(String[] args) {

        // Create tasks to be executed in the threads
        Runnable printA = new PrintChar('a', 100);          // Creating instances of the task classes
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);

        // Create threads
        Thread thread1 = new Thread(printA);    // Task passed to the thread
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        // thread3.setPriority(Thread.MAX_PRIORITY); // Sets thread priority

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

// The task for printing a character a specified number of times
class PrintChar implements Runnable {       // This is the PrintChar task class
    private char charToPrint;       // The character to print
    private int times;              // The number of times to repeat

    /**  Construct a class with a specific character and number
    of times to print the character. */
    public PrintChar(char c, int t) {       // Constructor
        charToPrint = c;
        times = t;
    }

    @Override // Override the run() method to tell the system what task to perform
    public void run() {     // The run method tells the system how to run this custom thread
        for (int i = 0; i < times; i++){
            System.out.print(charToPrint);
            // Thread.yield(); // Causes a thread to pause temporarily and allow other threads to execute.
        }
    }
}

// The task class for printing numbers from 1 to n for a given n
class PrintNum implements Runnable {        // This is the PrintNum task class
    private int lastNum;

    /** Construct a task for printing 1, 2, ..., n */
    public PrintNum(int n) {
        lastNum = n;
    }

    @Override   /** Tell the thread how to run */
    public void run() {
        for (int i = 0; i <= lastNum; i++) {
            System.out.print(" " + i);
        }

        /* The following code utilises the join() method to force one thread to wait for another thread to finish.
        In this case thread3 is forced to wait for thread4 to execute. For this to work properly comment out the
        above for loop.
        */
        Thread thread4 = new Thread(new PrintChar('c', 40));
        thread4.start();
        try {
            for (int i = 1; i <= lastNum; i++) {
                System.out.print (" " + i);
                if (i == 50) thread4.join();
            }
        }
        catch (InterruptedException ex) {
        }
    }
}