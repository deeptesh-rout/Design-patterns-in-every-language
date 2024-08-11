using System;
using System.Collections;
using System.Collections.Generic;

class ConcreteAggregate : IEnumerable<int> {
    private List<int> data;

    public ConcreteAggregate() {
        this.data = new List<int>();
    }

    public void AddData(int val) {
        data.Add(val);
    }

    public IEnumerator<int> GetEnumerator() {
        return new ConcreteIterator(this);
    }

    IEnumerator IEnumerable.GetEnumerator() {
        return GetEnumerator();
    }

    public List<int> GetData() {
        return data;
    }
}

class ConcreteIterator : IEnumerator<int> {
    private ConcreteAggregate aggregate;
    private int index;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
        this.index = -1;
    }

    public bool MoveNext() {
        index++;
        return index < aggregate.GetData().Count;
    }

    public void Reset() {
        index = -1;
    }

    public int Current {
        get {
            if (index == -1 || index >= aggregate.GetData().Count) {
                throw new InvalidOperationException();
            }
            return aggregate.GetData()[index];
        }
    }

    object IEnumerator.Current => Current;

    public void Dispose() {
        // Dispose logic, if needed
    }
}

// Client code

class IteratorPatternCollection {
    static void Main(string[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        for (int i = 0; i < 10; i++) {
            aggregate.AddData(i);
        }

        foreach (int val in aggregate) {
            Console.Write(val + " ");
        }
    }
}

/*
0 1 2 3 4 5 6 7 8 9 
*/