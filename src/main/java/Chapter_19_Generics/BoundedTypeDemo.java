package Chapter_19_Generics;
import Chapter_13_AbstractClassesAndInterfaces.Circle;
import Chapter_13_AbstractClassesAndInterfaces.GeometricObject;
import Chapter_13_AbstractClassesAndInterfaces.Rectangle;

// Demonstrates the use of bounded generic types
// A generic type can be specified as a subtype of another type. Such a generic type is called bounded

public class BoundedTypeDemo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2,2);
        Circle circle = new Circle(2);
    }

    public static <E extends GeometricObject> boolean equalArea(E object1, E object2) {     // bounded generic type
        return object1.getArea() == object2.getArea();
    }
}
