package Chapter_30_AggregateOperationsForCollectionStreams;
import java.util.*;
import java.util.stream.Collectors;

// Demonstrates how streams can be used to simplify coding
/* We want to filter anyone with over 100billion */

public class StreamsExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Warren Buffett", 120));
        people.add(new Person("Jeff Bezos", 150));
        people.add(new Person("Bill Gates", 100));
        people.add(new Person("Mark Zuckerburg", 50));

        // Method 1 (without streams)
        List<Person> hunderdClubNormal = new ArrayList<>();      // create new list to hold these people
        for(Person p: people){
            if(p.billions >= 100){
                hunderdClubNormal.add(p);
            }
        }
        hunderdClubNormal.forEach(person -> System.out.println(person.name));
        System.out.println();

        // Method 2 (using streams)
        List<Person> hunderdClubStream = new ArrayList<>();             // create new list to hold these people
        hunderdClubStream = people.stream()
                .filter(person -> person.billions >= 100)               // filters the list
                .sorted(Comparator.comparing(person -> person.name))    // sorts the filtered list in alphabetical order
                .collect(Collectors.toList());

        hunderdClubStream.forEach(person -> System.out.println(person.name));

    }

    static class Person {
        String name;
        int billions;

        public Person(String name, int billions) {
            this.name = name;
            this.billions = billions;
        }
    }
}
