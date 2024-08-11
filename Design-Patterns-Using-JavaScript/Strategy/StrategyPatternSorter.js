// Define Sorting interface
class Sorting {
    sort(numbers) {
        throw new Error("sort method must be implemented");
    }
}

// Define BubbleSort class implementing Sorting
class BubbleSort extends Sorting {
    sort(numbers) {
        // Bubble Sort Algorithm
        console.log("Bubble Sort Algorithm executed.");
        const size = numbers.length;
        for (let i = 0; i < size - 1; i++) {
            for (let j = 0; j < size - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // Swapping
                    const temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}

// Define SelectionSort class implementing Sorting
class SelectionSort extends Sorting {
    sort(numbers) {
        // Selection Sort Algorithm
        console.log("Selection Sort Algorithm executed.");
        const size = numbers.length;
        for (let i = 0; i < size - 1; i++) {
            let maxIndex = 0;
            for (let j = 1; j < size - i; j++) {
                if (numbers[j] > numbers[maxIndex]) {
                    maxIndex = j;
                }
            }
            const temp = numbers[size - 1 - i];
            numbers[size - 1 - i] = numbers[maxIndex];
            numbers[maxIndex] = temp;
        }
    }
}

// Define StrategyClass
class StrategyClass {
    constructor(algo) {
        this.sorter = algo;
    }

    setSorter(algo) {
        this.sorter = algo;
    }

    sort(a) {
        this.sorter.sort(a);
    }
}

// Client code
const a = [4, 5, 3, 2, 6, 7, 1, 8, 9, 10];
const s = new StrategyClass(new BubbleSort());
s.sort(a);
console.log(a);

const b = [4, 5, 3, 2, 6, 7, 1, 8, 9, 10];
s.setSorter(new SelectionSort());
s.sort(b);
console.log(b);

/*
Bubble Sort Algorithm executed.
[ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ]
Selection Sort Algorithm executed.
[ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ]
*/