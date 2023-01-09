package Chapter_6_Methods;
import java.util.Scanner;

public class LargestCommonMultiple {
    // Class to find the Largest Common Multiple of two given numbers.

    public static int lcm(int n1,int n2) {
        int lcm = 1; // Initial lcm is 1
        int k = 2; // Possible lcm
        while (k <= n1 && k <= n2) {
            if (n1 % k == 0 && n2 % k == 0)
                lcm = k; // Update lcm
            k++;
            }
        return lcm; // Return lcm
    }

    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        // Prompt the user to enter two integers
        System.out.print("Enter first integer: ");
        int n1 = input.nextInt();
        System.out.print("Enter second integer: ");
        int n2 = input.nextInt();
        System.out.println("The largest common multiple for " + n1 + " and " + n2 + " is " + lcm(n1, n2));
    }
}
