import java.util.Iterator;

class LinkedList implements Iterable<Integer> {
    // Node class representing elements of linked list.
    class Node {
        int value;
        Node next;

        public Node(int v, Node n) {
            value = v;
            next = n;
        }
    }

    Node head;
    Node tail;
    int size;

    // Constructor of linked list.
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addHead(int value) {
        Node newNode = new Node(value, head);
        if (head == null) {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator(this);
    }

    public int getSize() {
        return size;
    }
}

class LinkedListIterator implements Iterator<Integer> {
    LinkedList aggregate;
    LinkedList.Node current;

    public LinkedListIterator(LinkedList aggregate) {
        this.aggregate = aggregate;
        this.current = aggregate.head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        int value = current.value;
        current = current.next;
        return value;
    }
}

class IteratorPatternLinkedList {
    public static void main(String[] args) {
        LinkedList aggregate = new LinkedList();
        for (int i = 0; i < 5; i++) {
            aggregate.addHead(i);
        }

        for (int val : aggregate) {
            System.out.print(val + " ");
        }
    }
}

/* 
4 3 2 1 0
*/
