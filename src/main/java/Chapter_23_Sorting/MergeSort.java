package Chapter_23_Sorting;

// Demonstrates Merge Sort

/*
The merge-sort algorithm can be described recursively as follows: The algorithm
divides the array into two halves and applies a merge sort on each half recursively.
After the two halves are sorted, the algorithm then merges them.
Merge sort employs a divide-and-conquer approach to sort the array.
The recursive call continues dividing the array into subarrays until each subarray contains
only one element. The algorithm then merges these small subarrays into larger sorted subarrays
until one sorted array results.
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        mergeSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    // The method for sorting numbers
    public static void mergeSort(int[] list) {
        if (list.length > 1) {                      // base case
            // Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);                   // sort first half

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);                  // sort second half

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

    public static void merge(int[] list1, int[] list2, int[] temp){         // Two sorted arrays are merged into one sorted array

        int current1 = 0;                           // Current index in list1
        int current2 = 0;                           // Current index in list2
        int current3 = 0;                           // Current index in temp

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
            temp[current3++] = list2[current2++];
            }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }
}
