package Chapter_32_MultithreadingAndParallelProgramming;
import Chapter_23_Sorting.MergeSort;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

// Demonstrates using fork and join to perform a merge sort in parallel.
// Compares execution times of sequential and parallel merge sort.

public class ParallelMergeSort {
    public static void main(String[] args) {
        final int SIZE = 7000000;
        int[] list1 = new int[SIZE];
        int[] list2 = new int[SIZE];

        for (int i = 0; i < list1.length; i++)
            list1[i] = list2[i] = (int)(Math.random() * 10000000);

        long startTime = System.currentTimeMillis();
        parallelMergeSort(list1); // Invoke parallel merge sort
        long endTime = System.currentTimeMillis();
        System.out.println("\nParallel time with "
                + Runtime.getRuntime().availableProcessors() +
                " processors is " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        MergeSort.mergeSort(list2); // MergeSort in chapter 23               // invoke sequential sort
        endTime = System.currentTimeMillis();
        System.out.println("\nSequential time is " +
                (endTime - startTime) + " milliseconds");
    }

    public static void parallelMergeSort(int[] list) {
        RecursiveAction mainTask = new SortTask(list);      // create a ForkJoinTask
        ForkJoinPool pool = new ForkJoinPool();             // create a ForkJoinPool
        pool.invoke(mainTask);                              // execute a task
    }

    private static class SortTask extends RecursiveAction {     // define concrete ForkJoinTask
        private final int THRESHOLD = 500;
        private int[] list;

        SortTask(int[] list) {
            this.list = list;
        }

        @Override
        protected void compute() {                          // perform the task
            if (list.length < THRESHOLD)
                java.util.Arrays.sort(list);                // sort a small list
            else {
                // Obtain the first half
                int[] firstHalf = new int[list.length / 2];     //split into two parts
                System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

                // Obtain the second half
                int secondHalfLength = list.length - list.length / 2;
                int[] secondHalf = new int[secondHalfLength];
                System.arraycopy(list, list.length / 2,
                        secondHalf, 0, secondHalfLength);

                // Recursively sort the two halves
                invokeAll(new SortTask(firstHalf),
                        new SortTask(secondHalf));

                // Merge firstHalf with secondHalf into list
                MergeSort.merge(firstHalf, secondHalf, list);
            }
        }
    }
}
