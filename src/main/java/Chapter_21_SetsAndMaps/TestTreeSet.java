package Chapter_21_SetsAndMaps;
import java.util.*;

// Demonstrates how to create a Tree Set
/* displays the strings in alphabetical order using the TreeSet class.
 */

public class TestTreeSet {
    public static void main(String[] args) {
        // Create hash set
        Set<String> set = new HashSet<>();

        // Add strings to the set
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");

        TreeSet<String> treeSet = new TreeSet<>(set);       // Create tree set with set's element
        System.out.println("Sorted tree set " + treeSet);   // Sorts in alphabetical order

        // Use the methods in SortedSet interface
        System.out.println("first(): " + treeSet.first());
        System.out.println("last(): " + treeSet.last());
        System.out.println("headSet(\"New York\"): " + treeSet.headSet("New York"));        // Return the element in the treeSet before New York
        System.out.println("tailSet(\"New York\"): " + treeSet.tailSet("New York"));      // Return the element in the treeSet after New York, including New York

        // Use the methods in NavigableSet interface
        System.out.println("lower(\"P\"): " + treeSet.lower("P"));          // Returns the largest element less than P in treeSet
        System.out.println("higher(\"P\"): " + treeSet.higher("P"));        // Returns the smallest element greater than P in treeSet
        System.out.println("floor(\"P\"): " + treeSet.floor("P"));          // Returns the largest element less than or equal to P in treeSet
        System.out.println("ceiling(\"P\"): " + treeSet.ceiling("P"));      // Returns the smallest element greater than or equal to P in the treeSet
        System.out.println("pollFirst(): " + treeSet.pollFirst());             // Removes the first element in treeSet and returns the removed element
        System.out.println("pollLast(): " + treeSet.pollLast());               // Removes the last element in treeSet and returns the removed element
        System.out.println("New tree set: " + treeSet);
    }
}
