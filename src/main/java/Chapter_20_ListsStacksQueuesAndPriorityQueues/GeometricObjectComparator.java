package Chapter_20_ListsStacksQueuesAndPriorityQueues;
import Chapter_13_AbstractClassesAndInterfaces.GeometricObject;

import java.util.Comparator;

// Demonstrates the use of a comparator to compare elements of different classes

/* Comparator can be used to compare the objects of a class that doesn’t implement
Comparable or define a new criteria for comparing objects.  */

public class GeometricObjectComparator implements Comparator<GeometricObject>, java.io.Serializable{ // implements Comparator
    // It is generally a good idea for comparators to implement Serializable so they can be serialized.

    public int compare(GeometricObject o1, GeometricObject o2){     // implements compare
        double area1 = o1.getArea();
        double area2 = o2.getArea();

        if (area1 < area2) {
            return -1;
        } else if (area1 == area2) {
            return 0;
        } else {
            return 1;
        }
    }
}

// Code continued in TextComparator class
