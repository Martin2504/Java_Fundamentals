package Chapter_20_ListsStacksQueuesAndPriorityQueues;
import java.util.*;

// Demonstrates how to create a priority queue to store strings

/* The priority queue orders its elements according to their natural ordering using Comparable
The element with the least value is assigned the highest priority, and thus is
removed from the queue first. To oder differently use a comparator */


public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<String> queue1 = new PriorityQueue<>();   // elements will be ordered using comparable
        queue1.offer("Oklahoma");        // inserting elements
        queue1.offer("Indiana");
        queue1.offer("Georgia");
        queue1.offer("Texas");

        System.out.println("Priority queue using Comparable: ");
        while (queue1.size() > 0) {
            System.out.print(queue1.remove() + " ");
        }

        PriorityQueue<String> queue2 = new PriorityQueue<>(4, Collections.reverseOrder());  // elements will be ordered using the comparator
        queue2.offer("Oklahoma");        // inserting elements
        queue2.offer("Indiana");
        queue2.offer("Georgia");
        queue2.offer("Texas");

        System.out.println("\nPriority queue using Comparator:");
        while (queue2.size() > 0) {
            System.out.print(queue2.remove() + " ");
        }
    }
}
