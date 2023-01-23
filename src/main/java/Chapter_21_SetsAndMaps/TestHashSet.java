package Chapter_21_SetsAndMaps;
import java.util.*;

/* Demonstrates how to create a hash set to store strings and uses a foreach loop
and a forEach method to traverse the elements in the set.
There is no particular order for the elements in a hash set  */

public class TestHashSet {
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

        System.out.println(set);

        // Display the elements of the hash set
        for (String s: set) {
            System.out.print(s.toUpperCase() + " ");
        }

        // Process the elements using a forEach method
        System.out.println();
        set.forEach(e -> System.out.print(e.toLowerCase() + " "));
    }
}
