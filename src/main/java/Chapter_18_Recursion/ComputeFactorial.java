package Chapter_18_Recursion;
import java.util.Scanner;

// Class demonstrates the use of recursion to compute the factorial of a number
// A recursive method is one that invokes itself directly or indirectly

public class ComputeFactorial {
    // Main method
    public static void main(String[] args){
        // Create a scanner
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter a non negative number: ");
        int n = scanner1.nextInt();

        // Display factorial
        System.out.println("Factorial of " + n + " is " + factorial(n));
    }

    // Return the factorial of a specified number
    public static long factorial(int n){
        if (n == 0){
            return 1;
        } else {
            return n * factorial(n- 1); // Recursive call
        }
    }
}
