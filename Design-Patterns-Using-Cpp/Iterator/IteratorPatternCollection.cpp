#include <iostream>
#include <vector>

// Forward declarations
class ConcreteAggregate;

// Iterator interface
class Iterator {
public:
    virtual bool hasNext() = 0;
    virtual int next() = 0;
    virtual ~Iterator() = default;
};

// Concrete Iterator
class ConcreteIterator;

// Aggregate interface
class Aggregate {
public:
    virtual Iterator* createIterator() = 0;
    virtual ~Aggregate() = default;
};

class ConcreteIterator;

// Concrete Aggregate
class ConcreteAggregate : public Aggregate {
private:
    std::vector<int> data;

public:
    void addData(int val) {
        data.push_back(val);
    }

    Iterator* createIterator() override ;

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

    bool hasNext() override {
        return index < aggregate->getData().size();
    }

    int next() override {
        if (!hasNext()) {
            throw std::out_of_range("Index out of bounds");
        }
        int value = aggregate->getData()[index];
        index++;
        return value;
    }
};

Iterator* ConcreteAggregate::createIterator() {
    return new ConcreteIterator(this);
}

// Client code
int main() {
    ConcreteAggregate aggregate;
    for (int i = 0; i < 10; i++) {
        aggregate.addData(i);
    }

    Iterator* iterator = aggregate.createIterator();
    while (iterator->hasNext()) {
        std::cout << iterator->next() << " ";
    }

    delete iterator;

    return 0;
}

/*
0 1 2 3 4 5 6 7 8 9 
*/