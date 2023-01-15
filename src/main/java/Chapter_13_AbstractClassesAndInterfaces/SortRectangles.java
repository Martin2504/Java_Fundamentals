package Chapter_13_AbstractClassesAndInterfaces;

// Class which utilizes the ComparableRectangle class to compare rectangles.

public class SortRectangles {
    public static void main(String[] args) {
        ComparableRectangle[] rectangles = {
                new ComparableRectangle(3.4, 5.4),
                new ComparableRectangle(13.24, 55.4),
                new ComparableRectangle(7.4, 35.4),
                new ComparableRectangle(1.4, 25.4)};
        java.util.Arrays.sort(rectangles);      // use this method to sort the array
        for (Rectangle rectangle : rectangles) {
            System.out.print(rectangle + " ");
            System.out.println();
        }
    }
}
