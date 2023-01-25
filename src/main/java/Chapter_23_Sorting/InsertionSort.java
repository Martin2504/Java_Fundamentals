package Chapter_23_Sorting;

// Demonstrates Insertion Sort
// The insertion-sort algorithm sorts a list of values by repeatedly inserting a new element into a sorted sublist until the whole list is sorted.

/*
The insertion-sort algorithm presented here sorts a list of elements by repeatedly inserting a new
element into a sorted partial array until the whole array is sorted.
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] list = {3, 6, 2, 8, 1, 14};
        insertionSort(list);
        for(int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
    }

    public static void insertionSort(int[] list){

        for (int i = 1; i < list.length; i++){              // This loop is iterated in order to create the sublist
            /** Insert list[i] into a sorted sublist list[0..i−1] so that
             list[0..i] is sorted. */
            int currentElement = list[i];
            int k;
            for (k = i-1; k >=0 && list[k] > currentElement; k--){      // shift
                list[k + 1] = list[k];
            }

            // Insert the current element into list[k + 1]
            list[k + 1] = currentElement;       // insert
        }
    }
}
