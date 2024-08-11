#include <iostream>
#include <iterator>

class LinkedList {
private:
    class Node {
    public:
        int value;
        Node* next;

        Node(int v, Node* n) : value(v), next(n) {}
    };

    Node* head;
    Node* tail;
    int size;

public:
    LinkedList() : head(nullptr), tail(nullptr), size(0) {}

    void addHead(int value) {
        Node* newNode = new Node(value, head);
        if (head == nullptr) {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    class LinkedListIterator : public std::iterator<std::input_iterator_tag, int> {
    private:
        LinkedList* aggregate;
        Node* current;

    public:
        LinkedListIterator(LinkedList* aggregate, Node* current) : aggregate(aggregate), current(current) {}

        bool operator!=(const LinkedListIterator& other) const {
            return current != other.current && current != nullptr;
        }

        int operator*() const {
            return current->value;
        }

        LinkedListIterator& operator++() {
            if (current != nullptr) {
                current = current->next;
            }
            return *this;
        }
    };

    LinkedListIterator begin() {
        return LinkedListIterator(this, head);
    }

    LinkedListIterator end() {
        return LinkedListIterator(this, nullptr);
    }

    int getSize() const {
        return size;
    }
};

// Client code
int main() {
    LinkedList aggregate;
    for (int i = 0; i < 5; i++) {
        aggregate.addHead(i);
    }

    for (int val : aggregate) {
        std::cout << val << " ";
    }

    return 0;
}

/*
4 3 2 1 0 
*/