package Chapter_30_AggregateOperationsForCollectionStreams;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

// Demonstrates the use of parallel and sequential streams
// Streams can be executed in parallel mode to improve performance.

public class ParallelStreamDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int[] list = random.ints(200_000_000).toArray();        // create an array

        System.out.println("Number of processors: "
                + Runtime.getRuntime().availableProcessors());

        long startTime = System.currentTimeMillis();
        int[] list1 = IntStream.of(list).filter(e -> e > 0).sorted().limit(5).toArray();    // sequential stream
        System.out.println(Arrays.toString(list1));
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential stream execution time is "
                + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();                                             // parallel stream
        int[] list2 = IntStream.of(list).parallel().filter(e -> e > 0).sorted().limit(5).toArray();
        System.out.println(Arrays.toString(list2));
        endTime = System.currentTimeMillis();
        System.out.println("Parallel stream execution time is "
                + (endTime - startTime) + " milliseconds");
    }
}
