package Chapter_11_InheritanceAndPolymorphism.polymorphism;

// Java program for method Overloading using different types of and number of arguments.

// Helper class.
public class Helper {

    // Method 1
    static int Multiply(int a, int b){
        System.out.print("Method 1 executing: ");
        // Returns product of 2 int numbers.
        return a * b;
    }

    // Method 2, same name but different type of params.
    static double Multiply(double a, double b){
        System.out.print("Method 2 executing: ");
        // Returns product of 2 double numbers.
        return a * b;
    }

    // Method 3, same name but different number of params.
    static int Multiply(int a, int b, int c){
        System.out.print("Method 3 executing: ");
        // Returns product of 3 int numbers.
        return a * b * c;
    }
}
