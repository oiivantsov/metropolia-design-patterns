package strategy.algorithm_comparison;

// O(n^2) time complexity
// source: https://www.youtube.com/watch?v=Dv4qLJcxus8
public class BubbleSorting implements SortingStrategy {

    // bubble sort = pairs of adjacent elements are compared, and the elements
    //		            swapped if they are not in order.

    //				 Quadratic time O(n^2)
    //				 small data set = okay-ish
    //				 large data set = BAD (plz don't)

    public void sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
