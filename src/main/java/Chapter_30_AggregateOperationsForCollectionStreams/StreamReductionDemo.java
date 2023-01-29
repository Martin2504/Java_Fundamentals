package Chapter_30_AggregateOperationsForCollectionStreams;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Demonstrates the use of the reduce method
// You can use the reduce method to reduce the elements in a stream into a single value

public class StreamReductionDemo {
    public static void main(String[] args) {
        int[] values = {3, 4, 1, 5, 20, 1, 3, 3, 4, 6};

        System.out.print("The values are ");
        IntStream.of(values).forEach(e -> System.out.print(e + " "));
        System.out.println();

        System.out.println("The result of multiplying all vales is "
                + IntStream.of(values).parallel().reduce(1, (e1, e2) -> e1 * e2));

        System.out.print("The values are "
                + IntStream.of(values).mapToObj(e -> e + "").reduce((e1, e2) -> e1 + ", " + e2).get());

        String[] names = {"John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy", "Michelle", "john"};
        System.out.print("\nThe names are: ");
        System.out.println(Stream.of(names).reduce((x, y) -> x + ", " + y).get());

        System.out.print("Concat names: ");
        System.out.println(Stream.of(names).reduce((x, y) -> x + y).get());

        System.out.print("Total number of characters: ");
        System.out.println(Stream.of(names).reduce((x, y) -> x + y).get().length());
    }
}
