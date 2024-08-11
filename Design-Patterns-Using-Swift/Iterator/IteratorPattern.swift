// Iterator protocol
protocol Iterator {
    func next() -> Int?
    func hasNext() -> Bool
}

// Aggregate protocol
protocol Aggregate {
    func getIterator() -> Iterator
}

// ConcreteIterator class
class ConcreteIterator: Iterator {
    private let aggregate: ConcreteAggregate
    private var index: Int = 0

    init(aggregate: ConcreteAggregate) {
        self.aggregate = aggregate
    }

    func next() -> Int? {
        guard hasNext() else { return nil }
        let value = aggregate.getData()[index]
        index += 1
        return value
    }

    func hasNext() -> Bool {
        return index < aggregate.getData().count
    }
}

// ConcreteAggregate class
class ConcreteAggregate: Aggregate {
    private var data: [Int] = []

    func addData(_ val: Int) {
        data.append(val)
    }

    func getIterator() -> Iterator {
        return ConcreteIterator(aggregate: self)
    }

    func getData() -> [Int] {
        return data
    }
}

// Client Code
let aggregate = ConcreteAggregate()
for i in 0..<5 {
    aggregate.addData(i)
}

let iterator = aggregate.getIterator()
while iterator.hasNext() {
    if let value = iterator.next() {
        print(value, terminator: " ")
    }
}

/*
0 1 2 3 4 
*/