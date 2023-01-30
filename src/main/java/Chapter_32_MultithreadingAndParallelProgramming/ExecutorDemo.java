package Chapter_32_MultithreadingAndParallelProgramming;
import java.util.concurrent.*;

// Demonstrates re-writing TaskThreadDemo using an executor

/*
Using a thread pool is an ideal way to manage the number of tasks executing concurrently.
Java provides the Executor interface for executing tasks in a thread pool and the ExecutorService interface for managing and controlling tasks.
The three tasks will be executed simultaneously now.
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        // Create a fixed thread pool with maximum three threads
        ExecutorService executor = Executors.newFixedThreadPool(3);     // creates a thread pool executor

        // Submit runnable tasks to the executor
        executor.execute(new PrintChar('a', 100));
        executor.execute(new PrintChar('b', 100));
        executor.execute(new PrintNum(100));

        // Shut down the executor
        executor.shutdown();
    }
}
