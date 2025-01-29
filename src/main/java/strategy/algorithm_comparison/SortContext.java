package strategy.algorithm_comparison;

public class SortContext {

        private SortingStrategy sortingStrategy;

        public void setStrategy(SortingStrategy sortingStrategy) {
            this.sortingStrategy = sortingStrategy;
        }

        public void sort(int[] arr) {
            sortingStrategy.sort(arr);
        }
}
