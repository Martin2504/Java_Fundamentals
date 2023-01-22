package Chapter_20_ListsStacksQueuesAndPriorityQueues;
import java.util.*;

// Demonstrates a method defined in the collection interface
// The Collection interface defines the common operations for lists, vectors, stacks, queues, priority queues, and sets.

public class TestCollection {
    public static void main(String[] args) {
        ArrayList<String> collection1 = new ArrayList<>();

        collection1.add("New York");        // add elements
        collection1.add("Atlanta");
        collection1.add("Dallas");
        collection1.add("Madison");

        System.out.print("A list of cities in collection1: ");
        System.out.println(collection1);

        System.out.println("Is Dallas in collection1? " + collection1.contains("Dallas"));
        collection1.remove("Dallas");

        System.out.printf("\n" + collection1.size() + " cities are in collection1 now");

        Collection<String> collection2 = new ArrayList<>();     // creating new collection
        collection2.add("Seattle");
        collection2.add("Portland");
        collection2.add("Los Angeles");
        collection2.add("Atlanta");

        System.out.print("\nA list of cities in collection2: ");
        System.out.println(collection2);

        ArrayList<String> c1 = (ArrayList<String>)(collection1.clone());       // clone so we can keep the original arraylist intact and use a copy
        c1.addAll(collection2);         // addAll just adds all of collection2's items to c1
        System.out.println("\nCities in collection1 or collection2: ");
        System.out.println(c1);

        c1 = (ArrayList<String>)(collection1.clone());      // creating copy to perform operations on
        c1.retainAll(collection2);      // retainAll keeps all the items already in c1 which are in collection2
        System.out.print("\nCities in collection1 and collection2: ");
        System.out.println(c1);

        c1 = (ArrayList<String>)(collection1.clone());      // creating copy to perform operations on
        c1.removeAll(collection2);      // removes all items already in c1 which appear in collection2
        System.out.print("\nCities in collection1, but not in 2: ");
        System.out.println(c1);
    }
}
