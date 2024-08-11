import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ConcreteAggregate implements Iterable<Integer> {
    private List<Integer> data;

    public ConcreteAggregate() {
        this.data = new ArrayList<>();
    }

    public void addData(int val) {
        data.add(val);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ConcreteIterator(this);
    }

    public List<Integer> getData() {
        return data;
    }
}

class ConcreteIterator implements Iterator<Integer> {
    private ConcreteAggregate aggregate;
    private int index;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < aggregate.getData().size();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException();
        }
        int value = aggregate.getData().get(index);
        index++;
        return value;
    }
}

public class IteratorPatternCollection {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        for (int i = 0; i < 10; i++) {
            aggregate.addData(i);
        }

        for (int val : aggregate) {
            System.out.print(val + " ");
        }
    }
}
/* 
0 1 2 3 4 5 6 7 8 9
*/