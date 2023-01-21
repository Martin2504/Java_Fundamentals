package Chapter_19_Generics;

// Demonstrates the use of a generic method

public class GenericMethodDemo {
    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4,5};
        String[] strings = {"London", "Paris", "New York", "Austin"};

        GenericMethodDemo.<Integer>print(integers);     // invoke generic method
        GenericMethodDemo.<String>print(strings);
    }

    public static <E> void print(E[] list) {    // generic method
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();;
    }
}
