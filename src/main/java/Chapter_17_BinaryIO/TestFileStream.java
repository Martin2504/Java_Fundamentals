package Chapter_17_BinaryIO;

import java.io.*;

// Class demonstrates the use of File steams to write data to a file

public class TestFileStream {
    public static void main(String[] args) throws IOException {

        // write numbers to the file
        try (
                // Create an output stream to the file
                FileOutputStream output = new FileOutputStream("temp.dat");
        ) {
            // Output values to the file
            for (int i = 1; i <= 10; i++) {
                output.write(i);
            }
        }

        // read numbers from file and output them to the console
        try (
                // Create an input stream to the file
                FileInputStream input = new FileInputStream("temp.dat");
        ) {
            // Read values from the filel
            int value;
            while ((value = input.read()) != -1) {
                System.out.print(value + " ");
            }
        }
    }
}
