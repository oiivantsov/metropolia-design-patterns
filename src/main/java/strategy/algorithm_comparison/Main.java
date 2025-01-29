package strategy.algorithm_comparison;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SortContext context = new SortContext();

        // data sets
        int smallSize = 30;
        int largeSize = 100_000;

        SortingStrategy[] strategies = {new BubbleSorting(), new MergeSorting(), new QuickSorting()};

        for (SortingStrategy strategy : strategies) {
            System.out.println("Testing " + strategy.getClass().getSimpleName() + ":\n");

            testSortingPerformance(context, strategy, smallSize);
            testSortingPerformance(context, strategy, largeSize);
            System.out.println("--------------------------------------------------\n");
        }
    }

    private static void testSortingPerformance(SortContext context, SortingStrategy strategy, int size) {
        int[] array = generateRandomArray(size);

        context.setStrategy(strategy);

        long startTime = System.nanoTime();
        context.sort(array);
        long endTime = System.nanoTime();

        double durationMillis = (endTime - startTime) / 1_000_000.0;
        System.out.println("Array size: " + size + " | Time taken: " + durationMillis + " ms");
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000);
        }
        return array;
    }
}