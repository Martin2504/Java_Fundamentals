package Chapter_17_BinaryIO;
import java.io.*;

// Class demonstrates the use of a Random Access File
// RandomAccessFile class to allow data to be read from and written to at any locations in the file.

public class TestRandomAccessFile {
    public static void main(String[] args) throws IOException {

        try (   // Create a random access file
                RandomAccessFile inOut = new RandomAccessFile("inOut.dat", "rw");       // rw specifies it can be a read/write file
                ){

            // Clear the file to destroy the old contents if exists
            inOut.setLength(0);

            // Write integers to the file
            for (int i = 0; i < 200; i++){
                inOut.writeInt(i);
            }

            // Display the current length of the file
            System.out.println("Current file length is " + inOut.length());

            // Retrieve the 1st number
            inOut.seek(0);  // Move the file pointer to the beginning
            System.out.println("The 1st number is " + inOut.readInt());

            // Retrieve the 2nd number
            inOut.seek(1 * 4); // Move the file pointer to the 2nd number (int occupies 4 bytes)
            System.out.println("The 2nd number is " + inOut.readInt());

            // Retrieve the 10th number
            inOut.seek(9 * 4);  // 9 * 4 will move the pointer to the end of the 9th integer
            System.out.println("The 10th number is " + inOut.readInt());

            // Modify the 11th number
            inOut.writeInt(555);    // Pointer is already at the end of the 10th number due to inOut.readInt()

            // Append a new number
            inOut.seek(inOut.length()); // Move the file pointer to the end
            inOut.writeInt(999);

            // Display the length
            System.out.println("The new length is " + inOut.length());

            // Retrieve the new 11th number
            inOut.seek(10 * 4);
            System.out.println("The 11th number is " + inOut.readInt());
        }
    }
}
