package Chapter_6_Methods;

public class MaxOfTwoIntegers {
    // Class to find the max of two integers

    // Write method
    public static int max(int num1, int num2) {
        int result;
        if (num1 > num2)
            result = num1;
        else result = num2;
        return result;
        }

    // Call method
    public static void main(String[] args) {
        int i = 34;
        int j = 72;
        int k = max(i, j);
        System.out.println("The maximum of " + i +
                " and " + j + " is " + k);
        }
}
