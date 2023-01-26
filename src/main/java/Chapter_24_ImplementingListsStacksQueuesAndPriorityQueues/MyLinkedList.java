package Chapter_24_ImplementingListsStacksQueuesAndPriorityQueues;

// The MyLinkedList class uses a linked structure to implement a dynamic list

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0; // Number of elements in the list

    /** Create an empty list */
    public MyLinkedList() {
    }

    /** Create a list from an array of objects */
    public MyLinkedList( E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /** Return the head element in the list */
    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = head; // link the new node with the head (which will become the 2nd node)
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) // The new node is the only node in list
            tail = head;
    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node for e

        if (tail == null) {
            head = tail = newNode; // The only node in list, therefore head & tail both point to newNode
        } else {
            tail.next = newNode; // Link the new node with the last node
            tail = newNode; // tail now points to the last node
        }

        size++; // Increase size
    }

    @Override
    /** Add a new element at the specified index
     * in this list. The index of the head element is 0 */
    public void add(int index, E e) {
        if (index == 0) addFirst(e); // Insert first
        else if (index >= size) addLast(e); // Insert last
        else { // Insert in the middle
            /* Setting nodes on either side of the index as current and temp.
            the new node is to be inserted between the nodes current and temp */
            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node<E> temp = current.next;

            current.next = new Node<>(e);       // creating new node in between current and temp
            (current.next).next = temp;         // assigning temp to the new node's next
            size++;
        }
    }

    /** Remove the head node and
     * return the object that is contained in the removed node. */
    public E removeFirst() {
        if (size == 0) return null; // Nothing to delete
        else {
            Node<E> temp = head; // Keep the first node temporarily
            head = head.next; // Move head to point to next node, deleting the first node
            size--; // Reduce size by 1
            if (head == null) tail = null; // List becomes empty
            return temp.element; // Return the deleted element
        }
    }

    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
        if (size == 0 || size == 1) {       // empty? or size 1?
            return removeFirst();
        } else {
            // locate current to point to the second-to-last node
            Node<E> current = head;
            for (int i = 0; i < size -2; i++){
                current = current.next;
            }

            E temp = tail.element;  // Keep the last node temporarily
            tail = current;         // tail is now repositioned to point to the second-to-last node and destroy the last node
            tail.next = null;
            size--;
            return temp;
        }
    }

    @Override
    /** Remove the element at the specified position in this
     * list. Return the element that was removed from the list. */
    public E remove(int index) {
        if (index < 0 || index >= size) return null; // Out of range
        else if (index == 0) return removeFirst(); // Remove first
        else if (index == size -1)return removeLast(); // Remove last
         else{
            // locate the node at the specified index
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;    // assign current to the node to be deleted
            previous.next = current.next;       // eliminate the current node
            size--;
            return current.element;
        }
    }

    @Override
    /** Override toString() to return elements in the list */
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }
        return result.toString();
    }

    @Override
    /** Clear the list */
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    /** Return true if this list contains the element e */
    public boolean contains(Object e) {
        // Left as an exercise
        return true;
    }

    @Override
    /** Return the element at the specified index */
    public E get(int index) {
        // Left as an exercise
        return null;
    }

    @Override
    /** Return the index of the first matching element in
     * this list. Return −1 if no match. */
    public int indexOf(Object e) {
        // Left as an exercise
        return 0;
    }

    @Override
    /** Return the index of the last matching element in
     * this list. Return −1 if no match. */
    public int lastIndexOf(E e) {
        // Left as an exercise
        return 0;
    }

    @Override
    /** Replace the element at the specified position
     * in this list with the specified element. */
    public E set(int index, E e) {
        // Left as an exercise
        return null;
    }

    @Override
    /** Override iterator() defined in Iterable */
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

private class LinkedListIterator implements java.util.Iterator<E> {
    private Node<E> current = head; // Current index

    @Override
    public boolean hasNext() {
        return (current != null);
    }

    @Override
    public E next() {
        E e = current.element;
        current = current.next;
        return e;
    }

    @Override
    public void remove() {
        // Left as an exercise
    }
}

private static class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
        this.element = element;
    }

}

    @Override
    /** Return the number of elements in this list */
    public int size() {
        return size;
    }
}
