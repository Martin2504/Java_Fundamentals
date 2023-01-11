package Chapter_7_SingleDimArrays;
public class AnalyzeNumbers {

    // A class to analyze n numbers

    public static void main(String[] args){
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter the new number of items: ");
        int n = input.nextInt();
        double[] numbers = new double[n];
        double sum = 0;

        System.out.print("Enter the numbers: ");
        for (int i = 0; i < n; i++){
            numbers[i] = input.nextDouble();
            sum += numbers[i];
        }

        double average = sum / n;

        int count = 0; // The number of elements above average
        for (int i = 0; i < n; i++){
            if (numbers[i] > average) {
                count++;
            }
        }

        System.out.println("Average is " + average);
        System.out.println("Number of elemets above the average is " + count);

    }
}
