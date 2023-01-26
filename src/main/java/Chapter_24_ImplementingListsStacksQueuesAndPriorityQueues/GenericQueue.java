package Chapter_24_ImplementingListsStacksQueuesAndPriorityQueues;

// GenericQueue uses a linked list to provide a first-in, first-out data structure.

public class GenericQueue<E> {
    // create linked list which takes any object as a param
    private java.util.LinkedList<E> list = new java.util.LinkedList<>();

    public void enqueue(E e){   // add element to tail of the queue
        list.addLast(e);
    }

    public E dequeue() {        // removes an element from the head of the queue
        return list.removeFirst();
    }

    public int getSize(){       // returns the number of elements in the queue.
        return list.size();
    }

    @Override
    public String toString() {
        return "Queue: " + list.toString();
    }
}
