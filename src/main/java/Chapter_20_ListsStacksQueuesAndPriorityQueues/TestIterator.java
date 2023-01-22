package Chapter_20_ListsStacksQueuesAndPriorityQueues;
import java.util.*;

// Demonstrates the use of the iterator to traverse all the elements in an array list
// Each collection is Iterable. You can obtain its Iterator object to traverse all the elements in the collection

public class TestIterator {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();      // create array list
        collection.add("New York");     // add elements#
        collection.add("Dallas");
        collection.add("Madison");
        collection.add("Atlanta");

        // create iterator
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().toUpperCase() + " ");
        }
        System.out.println();
    }
}
