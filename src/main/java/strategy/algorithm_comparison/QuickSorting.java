package strategy.algorithm_comparison;

import java.util.Random;

// O(n log n) time complexity
// source 1: https://www.youtube.com/watch?v=Vtckgz38QHs&t=108s
// source 2 (about Random): https://www.youtube.com/watch?v=h8eyY7dIiN4
public class QuickSorting implements SortingStrategy {

    @Override
    public void sort(int[] arr) {

        // quick sort = moves smaller elements to left of a pivot.
        //			   recursively divide array in 2 partitions

        //                       run-time complexity = Best case O(n log(n))
        //				   		                   Average case O(n log(n))
        //				   		                   Worst case O(n^2) if already sorted

        //                       space complexity    = O(log(n)) due to recursion

        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;

        // Avoiding Worst-Case Performance:
        int randomIndex = new Random().nextInt(high - low) + low;
        swap(arr, randomIndex, high);

        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotValue = arr[high];
        int i = low - 1;
        int j = low;
        for (; j < high; j++) {
            if (arr[j] < pivotValue) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
