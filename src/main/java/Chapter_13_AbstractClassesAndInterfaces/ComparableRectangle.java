package Chapter_13_AbstractClassesAndInterfaces;

// Class which compares rectangle using the comparable interface.

public class ComparableRectangle extends Rectangle implements Comparable<ComparableRectangle> {
    /**
     * Construct a ComparableRectangle with specified properties
     */
    public ComparableRectangle(double width, double height) {
        super(width, height);
    }

    @Override // Implement the compareTo method defined in Comparable. This will compare our objects
    public int compareTo(ComparableRectangle o) {   // o is an object that we have passed as a parameter
        if (getArea() > o.getArea())
            return 1;
        else if (getArea() < o.getArea())
            return -1;
         else
        return 0;
    }

    @Override // Implement the toString method in GeometricObject
    public String toString() {
        return "Width: " + getWidth() + " Height: " + getHeight() +
                "Area: " + getArea();
    }

}
