package Chapter_18_Recursion;
import java.util.Scanner;

// Class demonstrates the use of recursion to prompt the user to enter an index and computes the Fibonacci number for that index
// Fibonacci series is a series of numbers in which each number (Fibonacci number) is the sum of the two preceding numbers.

public class ComputeFibonacci {
    // Main method
    public static void main(String[] args){
        // Create a scanner
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the index of a Fibonacci number: ");
        int index = scanner1.nextInt();

        // Find and display the Fibonacci number
        System.out.println("The Fibonacci number at index " + index + "  is " + fibonacci(index));
    }

    // The method for finding the Fibonacci number
    public static long fibonacci(int index){
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return fibonacci(index - 1) + fibonacci(index - 2);
        }
    }
}
