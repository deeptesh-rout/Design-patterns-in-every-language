#include <iostream>
#include <vector>

// Iterator interface
class Iterator {
public:
    virtual int next() = 0;
    virtual bool hasNext() = 0;
    virtual ~Iterator() = default;
};

// Aggregate interface
class Aggregate {
public:
    virtual Iterator* getIterator() = 0;
    virtual ~Aggregate() = default;
};


// Concrete Aggregate
class ConcreteAggregate : public Aggregate {
private:
    std::vector<int> data;

public:
    void addData(int val) {
        data.push_back(val);
    }

    Iterator* getIterator() override; 

    const std::vector<int>& getData() const {
        return data;
    }
};

// Concrete Iterator
class ConcreteIterator : public Iterator {
private:
    ConcreteAggregate* aggregate;
    int index;

public:
    ConcreteIterator(ConcreteAggregate* aggregate) : aggregate(aggregate), index(0) {}

    int next() override {
        if (index >= aggregate->getData().size()) {
            throw std::out_of_range("Index out of bounds");
        }
        int value = aggregate->getData()[index];
        index++;
        return value;
    }

    bool hasNext() override {
        return index < aggregate->getData().size();
    }
};

Iterator* ConcreteAggregate::getIterator() {
    return new ConcreteIterator(this);
}

// Client code
int main() {
    ConcreteAggregate aggregate;
    for (int i = 0; i < 5; i++) {
        aggregate.addData(i);
    }

    Iterator* iterator = aggregate.getIterator();
    while (iterator->hasNext()) {
        std::cout << iterator->next() << " ";
    }

    delete iterator;

    return 0;
}

/*
0 1 2 3 4 
*/