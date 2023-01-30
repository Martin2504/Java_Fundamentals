package Chapter_32_MultithreadingAndParallelProgramming;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

// Demonstrates the use of locks to synchronize methods to avoid race conditions
// this program adds pennies to an account using 100 threads

public class AccountWithSyncUsingLock {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }

        System.out.println("What is balance? " + account.getBalance());
    }

    // A thread for adding a penny to the account
    public static class AddAPennyTask implements Runnable {
        public void run() {
            account.deposit(1);         // deposit 1 penny
        }
    }

    // An inner class for Account
    public static class Account {
        private static Lock lock = new ReentrantLock();         // create a lock (only one thread can access the deposit method at a time)

        /* Below a semaphore with one permit is demonstrated. Because the permit is only 1 it's the same as using a lock.
        Semaphores allow multiple threads to access the same resource depending on the amount of permits. */
        //private static Semaphore semaphore = new Semaphore(1);

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            lock.lock();                        // whichever thread accesses this method acquires the lock, or waits until the lock is unlocked
            // semaphore.acquire();             // Acquire a permit from the semaphore

            try {
                int newBalance = balance + amount;

                /* This delay is deliberately added to magnify the
                data-corruption problem and make it easy to see. */
                Thread.sleep(5);

                balance = newBalance;
            } catch (InterruptedException ex) {}
            finally { lock.unlock(); }      // release the lock
        }
    }
}
