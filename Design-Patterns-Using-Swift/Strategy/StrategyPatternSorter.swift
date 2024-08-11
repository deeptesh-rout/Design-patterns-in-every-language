import Foundation

protocol Sorting {
    func sort(_ numbers: inout [Int])
}

class BubbleSort: Sorting {
    func sort(_ numbers: inout [Int]) {
        // Bubble Sort Algorithm
        print("Bubble Sort Algorithm executed.")
        let size = numbers.count
        for i in 0..<(size - 1) {
            for j in 0..<(size - i - 1) {
                if numbers[j] > numbers[j + 1] {
                    // Swapping
                    let temp = numbers[j]
                    numbers[j] = numbers[j + 1]
                    numbers[j + 1] = temp
                }
            }
        }
    }
}

class SelectionSort: Sorting {
    func sort(_ numbers: inout [Int]) {
        // Selection Sort Algorithm
        print("Selection Sort Algorithm executed.")
        let size = numbers.count
        for i in 0..<(size - 1) {
            var maxIndex = 0
            for j in 1..<(size - i) {
                if numbers[j] > numbers[maxIndex] {
                    maxIndex = j
                }
            }
            let temp = numbers[size - 1 - i]
            numbers[size - 1 - i] = numbers[maxIndex]
            numbers[maxIndex] = temp
        }
    }
}

class StrategyClass {
    private var sorter: Sorting

    init(_ algo: Sorting) {
        self.sorter = algo
    }

    func setSorter(_ algo: Sorting) {
        self.sorter = algo
    }

    func sort(_ a: inout [Int]) {
        self.sorter.sort(&a)
    }
}

// Client code.
var a = [4, 5, 3, 2, 6, 7, 1, 8, 9, 10]
let s = StrategyClass(BubbleSort())
s.sort(&a)
print(a)

var b = [4, 5, 3, 2, 6, 7, 1, 8, 9, 10]
s.setSorter(SelectionSort())
s.sort(&b)
print(b)

/*
Bubble Sort Algorithm executed.
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Selection Sort Algorithm executed.
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
*/