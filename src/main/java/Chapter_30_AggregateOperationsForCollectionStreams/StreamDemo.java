package Chapter_30_AggregateOperationsForCollectionStreams;
import java.util.Locale;
import java.util.stream.Stream;

// Demonstrates creating a stream and adding methods to it

public class StreamDemo {
    public static void main(String[] args) {
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy", "Michelle", "john"};

        // Display the first four names sorted
        Stream.of(names).limit(4).sorted().forEach(e -> System.out.print(e + " "));
        System.out.println();

        // Skip four names and display the rest sorted ignore case (ignoring lower case and upper case differences)
        Stream.of(names).skip(4).sorted((e1, e2) -> e1.compareToIgnoreCase(e2)).forEach(e -> System.out.print(e + " "));
        System.out.println();

        // Same as above but using method reference since the lambda expression simply invokes a method
        Stream.of(names).skip(4).sorted(String::compareToIgnoreCase).forEach(e -> System.out.print(e + " "));
        System.out.println();

        System.out.println("Largest string with length >4 "
                + Stream.of(names).filter(e -> e.length() > 4).max(String::compareTo).get());

        System.out.println("Smallest string alphabetically "
                + Stream.of(names).min(String::compareTo).get());

        System.out.println("Is Stacy in names? "
                + Stream.of(names).anyMatch(e -> e.equals("Stacy")));

        System.out.println("Do all names start with a capital letter? "
                + Stream.of(names).allMatch(e -> Character.isUpperCase(e.charAt(0))));

        System.out.println("No name begins with Ko? "
                + Stream.of(names).noneMatch(e -> e.startsWith("Ko")));

        System.out.println("Number of distinct case-insensitive strings: "
                + Stream.of(names).map(e -> e.toUpperCase()).distinct().count());

        System.out.println("First element in this stream in lowercase: "
                + Stream.of(names).map(String::toLowerCase).findFirst().get());

        System.out.println("Skip 4 and get any element in this stream: "
                + Stream.of(names).skip(4).sorted().findAny().get());

        Object[] namesInLowerCase = Stream.of(names).map(String::toLowerCase).toArray();
        System.out.println(java.util.Arrays.toString(namesInLowerCase));

    }
}
