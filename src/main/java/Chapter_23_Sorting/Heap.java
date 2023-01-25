package Chapter_23_Sorting;

// Demonstrates how to design a heap class
// A heap sort uses a binary heap. It first adds all the elements to a heap and then removes the largest elements successively to obtain a sorted list.

public class Heap<E> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();      // internal heap representation as ArrayList
    private java.util.Comparator<? super E> c;                              // comparator

    /** Create a default heap using a natural order for comparison */
    public Heap() {                                                             // no-arg constructor creates an empty heap using a natural order for the elements as the comparator
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);                 // create a comparator
    }

    /** Create a heap with a specified comparator */
    public Heap(java.util.Comparator<E> c) {                                    // internal heap representation
        this.c = c;
    }

    /** Create a heap from an array of objects */
    public Heap(E[] objects) {                                                  // constructor
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /** Add a new object into the heap */
    /*
    appends the object to the tree then swaps
    the object with its parent if the object is greater than its parent. This process continues until
    the new object becomes the root or is not greater than its parent.
     */
    public void add(E newObject) {                                              // add a new object
        list.add(newObject); // Append to the heap                              // append the object
        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            // Swap if the current object is greater than its parent
            if (c.compare(list.get(currentIndex),
                    list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);                                // swap with parent
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            }
            else
                break; // the tree is a heap now

            currentIndex = parentIndex;
        }
    }

    /** Remove the root from the heap */
    public E remove() {                                                         // remove the root
        if (list.size() == 0) return null;                                      // empty heap

        E removedObject = list.get(0);                                          // root
        list.set(0, list.get(list.size() - 1));                                 // new root
        list.remove(list.size() - 1);                                     // remove the last

        int currentIndex = 0;
        while (currentIndex < list.size()) {                                    // adjust the tree
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the maximum between two children
            if (leftChildIndex >= list.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (c.compare(list.get(maxIndex),                               // compare two children
                        list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than the maximum
            if (c.compare(list.get(currentIndex),
                    list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);                                    // swap with the larger child
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            }
            else
                break; // The tree is a heap
        }

        return removedObject;
    }

    /** Get the number of nodes in the tree */
    public int getSize() {
        return list.size();
    }

    /** Return true if heap is empty */
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
