package Chapter_21_SetsAndMaps;

// Demonstrates how methods in collection can be used for sets
// Since a set is an instance of Collection, all methods defined in Collection can be used for sets

public class TestMethodsInCollection {
    public static void main(String[] args) {
        // Create set1
        java.util.Set<String> set1 = new java.util.HashSet<>();

        // Add strings to the set1
        set1.add("London");
        set1.add("Paris");
        set1.add("New York");
        set1.add("San Francisco");
        set1.add("Beijing");
        set1.add("New York");

        System.out.println("Set1 is " + set1);
        System.out.println(set1.size() + " elements in set1");   // get size

        // Delete string from set1
        set1.remove("London");      // remove element
        System.out.println("\nset1 is " + set1);
        System.out.println(set1.size() + " elements in set1");

        // Create set2
        java.util.Set<String> set2 = new java.util.HashSet<>();

        // Add strings to the set2
        set2.add("London");
        set2.add("Shanghai");
        set2.add("Paris");
        System.out.println("\nset2 is " + set2);
        System.out.println(set2.size() + " elements in set2");

        System.out.println("\nIs Taipei in set2? " + set2.contains("Taipei"));  // contains element?

        set1.addAll(set2);          // addAll
        System.out.println("\nAfter adding set2 to set1, set1 is " + set1);

        set1.removeAll(set2);       // removeAll
        System.out.println("\nAfter removing set2 from set1, set1 is " + set1);

        set1.retainAll(set2);       // retainAll
        System.out.println("\nAfter retaining common elements in set1 and set2, set1 is " + set1);
    }
}
