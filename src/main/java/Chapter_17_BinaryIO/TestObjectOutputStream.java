package Chapter_17_BinaryIO;
import java.io.*;

// Uses object output streams to read/write objects
// writes students’ names, scores, and the current date to a file named object.dat
public class TestObjectOutputStream {
    public static void main(String[] args) throws IOException {
        try ( // Create an output stream for file object.dat
              ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.dat"));
        ) {
            // Write a string, double value, and object to the file
            output.writeUTF("John");                // writing primitive data types to the file
            output.writeDouble(85.5);
            output.writeObject(new java.util.Date());   // writing an object to the file
        }
    }
}