package Chapter_20_ListsStacksQueuesAndPriorityQueues;
import java.util.*;

// Demonstrates use of ArrayList and LinkedList

/* LinkedList is efficient for inserting and removing elements at the beginning of the list, and ArrayList
 is more efficient for all other operations. */

public class TestArrayAndLinkedList {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);       // 1 is autoboxed to an Integer object
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(0, 10);   // add at a certain index
        arrayList.add(3, 30);

        System.out.println("A list of integers in the array list: ");
        System.out.println(arrayList);

        // Create linked list using arrayList's elements
        LinkedList<Object> linkedList = new LinkedList<Object>(arrayList);
        linkedList.add(1, "red");       // add more elements
        linkedList.removeLast();
        linkedList.addFirst("green");

        System.out.println("Display the linked list forward: ");
        ListIterator<Object> listIterator = linkedList.listIterator(); // creating a list iterator
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

        System.out.println("Display the linked list backwards: ");
        listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()){
            System.out.print(listIterator.previous() + " ");
        }
    }
}
