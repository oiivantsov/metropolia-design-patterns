package iterator.fibonacci;

import java.util.Iterator;


// the state of the Fibonacci sequence is maintained inside the FibonacciIterator class
// this allows multiple independent iterators without interfering with each other
public class FibonacciIterator implements Iterator<Integer> {
    private int count = 0;
    private final int limit;
    private int prev = 0, curr = 1;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return count < limit;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements in sequence.");
        }

        int nextValue = (count == 0) ? 1 : prev + curr;
        prev = curr;
        curr = nextValue;
        count++;
        return nextValue;
    }
}
