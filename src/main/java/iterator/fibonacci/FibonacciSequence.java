package iterator.fibonacci;

import java.util.Iterator;


// serves as a factory for creating new iterators, reinforcing the separation between sequence generation and iteration logic
public class FibonacciSequence implements Sequence {
    private final int limit;

    public FibonacciSequence(int limit) {
        this.limit = limit;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(limit);
    }
}