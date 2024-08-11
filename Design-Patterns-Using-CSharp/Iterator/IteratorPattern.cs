using System;
using System.Collections.Generic;

interface Aggregate {
    Iterator GetIterator();
}

class ConcreteAggregate : Aggregate {
    private List<int> data;

    public ConcreteAggregate() {
        this.data = new List<int>();
    }

    public void AddData(int val) {
        data.Add(val);
    }

    public Iterator GetIterator() {
        return new ConcreteIterator(this);
    }

    public List<int> GetData() {
        return data;
    }
}


interface Iterator {
    int Next();
    bool HasNext();
}

class ConcreteIterator : Iterator {
    private ConcreteAggregate aggregate;
    private int index;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
        this.index = 0;
    }

    public int Next() {
        if (index >= aggregate.GetData().Count) {
            throw new IndexOutOfRangeException();
        }
        int value = aggregate.GetData()[index];
        index++;
        return value;
    }

    public bool HasNext() {
        return index < aggregate.GetData().Count;
    }
}

// Client code
class IteratorPattern {
    static void Main(string[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        for (int i = 0; i < 5; i++) {
            aggregate.AddData(i);
        }

        Iterator iterator = aggregate.GetIterator();
        while (iterator.HasNext()) {
            Console.Write(iterator.Next() + " ");
        }
    }
}

/*
0 1 2 3 4 
*/