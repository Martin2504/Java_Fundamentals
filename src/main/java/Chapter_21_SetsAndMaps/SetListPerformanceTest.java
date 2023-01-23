package Chapter_21_SetsAndMaps;
import java.util.*;

/*
Demonstrates a program that shows the execution time of (1) testing whether an element is in a hash
set, linked hash set, tree set, array list, or linked list and (2) removing elements from a hash
set, linked hash set, tree set, array list, and linked list.
 */

public class SetListPerformanceTest {
    static final int N = 5000;

    public static void main(String[] args) {
        // Add numbers 0, 1, 2, ..., N - 1 to the array list
        List<Integer> list = new ArrayList<>();                             // Create test data
        for (int i = 0; i < N; i++)
            list.add(i);
        Collections.shuffle(list);                                          // Shuffle the array list

        // Create a hash set, and test its performance
        Collection<Integer> set1 = new HashSet<>(list);
        System.out.println("Member test time for hash set is " +
                getTestTime(set1) + " milliseconds");                       // obtains the execution time for testing whether a number is in the hash set
        System.out.println("Remove element time for hash set is " +
                getRemoveTime(set1) + " milliseconds");

        // Create a linked hash set, and test its performance
        Collection<Integer> set2 = new LinkedHashSet<>(list);
        System.out.println("Member test time for linked hash set is " +
                getTestTime(set2) + " milliseconds");
        System.out.println("Remove element time for linked hash set is "
                + getRemoveTime(set2) + " milliseconds");

        // Create a tree set, and test its performance
        Collection<Integer> set3 = new TreeSet<>(list);
        System.out.println("Member test time for tree set is " +
                getTestTime(set3) + " milliseconds");
        System.out.println("Remove element time for tree set is " +
                getRemoveTime(set3) + " milliseconds");

        // Create an array list, and test its performance
        Collection<Integer> list1 = new ArrayList<>(list);
        System.out.println("Member test time for array list is " +
                getTestTime(list1) + " milliseconds");
        System.out.println("Remove element time for array list is " +
                getRemoveTime(list1) + " milliseconds");

        // Create a linked list, and test its performance
        Collection<Integer> list2 = new LinkedList<>(list);
        System.out.println("Member test time for linked list is " +
                getTestTime(list2) + " milliseconds");
        System.out.println("Remove element time for linked list is " +
                getRemoveTime(list2) + " milliseconds");
    }

    public static long getTestTime(Collection<Integer> c) {
        long startTime = System.currentTimeMillis();                        // Start time

        // Test if a number is in the collection
        for (int i = 0; i < N; i++)
            c.contains((int)(Math.random() * 2 * N));                       // Test membership

        return System.currentTimeMillis() - startTime;                      // Return execution time
    }

    public static long getRemoveTime(Collection<Integer> c) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < N; i++)
            c.remove(i);                                                    // Remove from container

        return System.currentTimeMillis() - startTime;
    }
}

/*
As these runtimes illustrate, sets are much more efficient than lists for testing whether an
element is in a set or a list
 */