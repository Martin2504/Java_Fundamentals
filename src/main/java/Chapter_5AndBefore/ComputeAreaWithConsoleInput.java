package Chapter_5AndBefore;
import java.util.Scanner;

public class ComputeAreaWithConsoleInput {
    public static void main(String[] args) {

        // Creating scanner object.
        Scanner input = new Scanner(System.in);

        // Prompting user to enter a radius.
        System.out.println("Enter a number for radius: ");
        double radius = input.nextDouble();

        // Computing area.
        double area = radius * radius * Math.PI;

        // Displaying results.
        System.out.println("The ares for the circle of radius " + radius + " is " + area);
    }
}
