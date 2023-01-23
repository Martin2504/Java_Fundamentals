package Chapter_21_SetsAndMaps;
import java.util.*;

// Demonstrates how to create a hash map, linked hash map, and tree map for mapping students to ages.
// A map consists of keys and values. Each key is unique and corresponds to a certain value
/*
The program first creates a hash map with the student’s name as its
key and the age as its value. The program then creates a tree map from the hash map and
displays the entries in ascending order of the keys. Finally, the program creates a linked hash
map, adds the same entries to the map, and displays the entries.
 */

public class TestMap {
    public static void main(String[] args) {
        // Create a hash map
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);       // add entries
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);

        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");

        // Create a TreeMap from the preceding HashMap
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);

        // Create a LinkedHashMap
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);

        // Display age for Lewis
        System.out.println("\nThe age for Lewis is " + linkedHashMap.get("Lewis"));

        System.out.println("Display entries in LinkedHashMap");
        System.out.println(linkedHashMap);

        // Display each entry with name and age
        System.out.println("\nNames and ages are");
        treeMap.forEach((name, age) -> System.out.println(name + " " + age + " "));

    }
}
