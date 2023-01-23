package Chapter_21_SetsAndMaps;
import java.util.*;

// Demonstrates how to create a Linked Hash Set which keeps the elements in the same order as they were inserted

public class TestLinkedHashSet {
    public static void main(String[] args) {

        // Create hash set
        Set<String> set = new LinkedHashSet<>();

        // Add strings to the set
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");

        System.out.println(set);

        // Display the elements of the hash set
        for (String element: set) {
            System.out.print(element.toUpperCase() + " ");
        }

        // Process the elements using a forEach method
        System.out.println();
        set.forEach(e -> System.out.print(e.toLowerCase() + " "));
    }
}
