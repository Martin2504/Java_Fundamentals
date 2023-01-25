package Chapter_23_Sorting;

// Demonstrates quick sort
/*
A quick sort works as follows: The algorithm selects an element, called the pivot,
in the array. It divides the array into two parts so all the elements in the first part are
less than or equal to the pivot, and all the elements in the second part are greater than
the pivot. The quick-sort algorithm is then recursively applied to the first part and then
the second part
 */

public class QuickSort {

    public static void quicksort(int[] list){       // Sort method
        quicksort(list, 0, list.length - 1);
    }

    public static void quicksort(int[] list, int first, int last){      // helper method
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quicksort(list, first, pivotIndex -1);      // recursive call
            quicksort(list, pivotIndex + 1, last);
        }
    }

    /** Partition the array list[first...last] */
    public static int partition(int[] list, int first, int last){
        int pivot = list[first];    // Choose the first element as the pivot
        int low = first + 1;        // index for forward search
        int high = last;            // index for backward search

        while (high > low){
            // search forward from left
            while (low <= high && list[low] <= pivot){
                low++;
            }
            // Search backward from right
            while (low <= high && list[high] > pivot){
                high--;
            }
            // Swap two elements in the list
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot){
            high--;
        }

        // swap pivot with list[high]
        if (pivot > list[high]){
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        quicksort(list);
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
    }
}
