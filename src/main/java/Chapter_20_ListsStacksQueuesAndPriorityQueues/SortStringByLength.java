package Chapter_20_ListsStacksQueuesAndPriorityQueues;

// Demonstrates the use of a comparator to sort strings in an array by length

import java.util.Comparator;

public class SortStringByLength {
    public static void main(String[] args) {
        String[] cities = {"Atlanta", "Savannah", "New York", "Dallas"};

        java.util.Arrays.sort(cities, new MyComparator());      // sort using comparator
        java.util.Arrays.sort(cities, Comparator.comparing(String::length));    // sort using comparator but with method reference instead of anonymous inner class. String because we are sorting objects of type string
        // java.util.Arrays.sort(cities, Comparator.comparing(String::length).reversed());      // sorts them in reversed order

        for (String s : cities) {
            System.out.print(s + " ");
        }
    }

    public static class MyComparator implements java.util.Comparator<String> {      // define custom comparator
        @Override
        public int compare(String s1, String s2) {      // override compare method
            return s1.length() - s2.length();
        }
    }
}
