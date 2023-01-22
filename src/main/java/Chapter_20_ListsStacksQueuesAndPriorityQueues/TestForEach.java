package Chapter_20_ListsStacksQueuesAndPriorityQueues;
import java.util.*;

// Demonstrates the use of the ForEach method to perform an action on each element in a collection

public class TestForEach {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();  // create array list
        collection.add("New York");     // add elements
        collection.add("Dallas");
        collection.add("Madison");
        collection.add("Atlanta");

        // forEach method using lambda expression (equivalent to using an anonymous inner class)
        collection.forEach(e -> System.out.print(e.toUpperCase() + " "));

        // Anonymous inner class commented out but is the same thing as the lambda expression
//        forEach(
//                new java.util.function.Consumer<String>() {
//                    public void accept(String e) {
//                        System.out.print(e.toUpperCase() + " ");
//                    }
//                }
//        )

    }
}
