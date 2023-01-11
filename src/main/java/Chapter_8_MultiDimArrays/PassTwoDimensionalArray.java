package Chapter_8_MultiDimArrays;

import java.util.Scanner;

// Class demonstrating passing multi dim arrays to methods

public class PassTwoDimensionalArray {
    public static void main(String[] args) {
        int[][] m = getArray(); // Get an array
        // Display sum of elements
        printArray(m);
        System.out.println("\nSum of all elements is " + sum(m));

    }

    public static int[][] getArray() {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        // Enter array values
        int[][] m = new int[3][4];
        System.out.println("Enter " + m.length + " rows and " + m[0].length + " columns: ");
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                m[i][j] = input.nextInt();
        return m;
    }

    public static int sum(int[][] m) {
        int total = 0;
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                total += m[row][column];
            }
        }
        return total;
    }

    public static void printArray(int[][] m) {
        int count = 0;
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                if (count % 4 == 0 && count != 0) {
                    System.out.println();
                    System.out.print(m[row][column] + " ");
                } else {
                    System.out.print(m[row][column] + " ");
                }
                count++;
            }
        }
    }
}
