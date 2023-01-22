package Chapter_20_ListsStacksQueuesAndPriorityQueues;

// Demonstrates how to create a queue using a linked list and use the queue to store strings
// LinkedList is ideal for queue operations because it is efficient for inserting and removing elements from both ends of a list.

public class TestQueue {
    public static void main(String[] args) {
        java.util.Queue<String> queue = new java.util.LinkedList<>();       // creates a queue
        queue.offer("Oklahoma");        // inserting elements
        queue.offer("Indiana");
        queue.offer("Georgia");
        queue.offer("Texas");

        while (queue.size() > 0) {
            System.out.println(queue.remove() + " ");
            /* remove() retrieves and removes the head of this queue and
throws an exception if this queue is empty. */
        }
    }

}