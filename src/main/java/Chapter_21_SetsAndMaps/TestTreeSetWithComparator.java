package Chapter_21_SetsAndMaps;
import Chapter_13_AbstractClassesAndInterfaces.Circle;
import Chapter_13_AbstractClassesAndInterfaces.GeometricObject;
import Chapter_13_AbstractClassesAndInterfaces.Rectangle;
import Chapter_20_ListsStacksQueuesAndPriorityQueues.GeometricObjectComparator;
import java.util.*;

// Demonstrates how to sort elements in a tree set using the Comparator interface.

/*
Two circles of the same radius are added to the tree set, but only one is
stored because the two circles are equal (determined by the comparator in this case) and the
set does not allow duplicates.
 */

public class TestTreeSetWithComparator {
    public static void main(String[] args) {
        // Create a tree set for geometric objects using a comparator
        Set<GeometricObject> set = new TreeSet<>(new GeometricObjectComparator());
        set.add(new Rectangle(4, 5));
        set.add(new Circle(40));
        set.add(new Circle(40));
        set.add(new Rectangle(4, 1));

        // Display geometric objects in the tree set
        System.out.println("A Sorted set of geometric objects by area ");
        for (GeometricObject g: set){
            System.out.println("area = " + g.getArea());
        }
    }
}
