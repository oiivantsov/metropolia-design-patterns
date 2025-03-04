package iterator.fibonacci;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        int limit = 10;

        Sequence fibonacci = new FibonacciSequence(limit);
        Iterator<Integer> iterator = fibonacci.iterator();

        System.out.println("First " + limit + " Fibonacci numbers:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
