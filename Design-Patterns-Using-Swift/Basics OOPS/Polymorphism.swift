class Adder {
    private var sum: Int

    init() {
        self.sum = 0
    }

    // Overloaded method for incrementing by a specific value
    func increment(_ a: Int) {
        self.sum += a
    }

    // Overloaded method for incrementing by 1
    func increment() {
        self.sum += 1
    }

    func getValue() -> Int {
        return self.sum
    }
}

let a = Adder()
a.increment(10)
a.increment()
print(a.getValue())
