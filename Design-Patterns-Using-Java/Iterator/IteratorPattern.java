import java.util.ArrayList;
import java.util.List;

interface Aggregate {
    Iterator getIterator();
}

class ConcreteAggregate implements Aggregate {
    private List<Integer> data;

    public ConcreteAggregate() {
        this.data = new ArrayList<>();
    }

    public void addData(int val) {
        data.add(val);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(this);
    }

    public List<Integer> getData() {
        return data;
    }
}

interface Iterator {
    int next();
    boolean hasNext();
}

class ConcreteIterator implements Iterator {
    private ConcreteAggregate aggregate;
    private int index;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
        this.index = 0;
    }

    @Override
    public int next() {
        if (index >= aggregate.getData().size()) {
            throw new IndexOutOfBoundsException();
        }
        int value = aggregate.getData().get(index);
        index++;
        return value;
    }

    @Override
    public boolean hasNext() {
        return index < aggregate.getData().size();
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        for (int i = 0; i < 5; i++) {
            aggregate.addData(i);
        }

        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}

/* 
0 1 2 3 4  
*/
