package Chapter_20_ListsStacksQueuesAndPriorityQueues;
import Chapter_13_AbstractClassesAndInterfaces.Circle;
import Chapter_13_AbstractClassesAndInterfaces.GeometricObject;
import Chapter_13_AbstractClassesAndInterfaces.Rectangle;

import java.util.Comparator;

// Returns a larger object between two geometric objects. The objects are compared using the GeometricObjectComparator.

/* The GeometricObjectComparator is created and passed
to the max method and this comparator is used in the max method to compare the
geometric objects   */

public class TestComparator {
    public static void main(String[] args) {
        GeometricObject g1 = new Rectangle(5, 5);
        GeometricObject g2 = new Circle(5);

        GeometricObject g = max(g1, g2, new GeometricObjectComparator());   // invoke max method

        System.out.println("The area of the larger object is " + g.getArea());
    }

    public static GeometricObject max(GeometricObject g1, GeometricObject g2, Comparator<GeometricObject> c) {
        if (c.compare(g1, g2) > 0) {
            return g1;
        } else {
            return g2;
        }
    }
}
