package Chapter_12_ExceptionHandlingAndTextIO;
import java.util.Scanner;

// Class to demonstrate exception handling using try/catch.

public class QuotientWithException {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two integers
        System.out.print("Enter two integers: ");
        int number1 = input.nextInt();
        int number2 = input.nextInt();

        // Try block
        try {
            int result = quotient(number1, number2);
            System.out.println(number1 + " / " + number2 + " is " + result);
        }
        // Handling the exception
        // ArithmeticException specifies what type of exception the catch block can catch.
        catch (ArithmeticException ex){
            System.out.println("Exception: an integer cannot be divided by 0");
        }
    }

    public static int quotient(int number1, int number2){
        if (number2 == 0){
            throw new ArithmeticException("Divisor cannot be 0");  // Throwing an exception
        }
        return number1 / number2;
    }
}
