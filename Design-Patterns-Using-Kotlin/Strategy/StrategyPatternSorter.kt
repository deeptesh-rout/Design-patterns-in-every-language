interface Sorting {
    fun sort(numbers: IntArray)
}

class BubbleSort : Sorting {
    override fun sort(numbers: IntArray) {
        // Bubble Sort Algorithm
        println("Bubble Sort Algorithm executed.")
        val size = numbers.size
        for (i in 0 until size - 1) {
            for (j in 0 until size - i - 1) {
                if (numbers[j] > numbers[j + 1]) {
                    // Swapping
                    val temp = numbers[j]
                    numbers[j] = numbers[j + 1]
                    numbers[j + 1] = temp
                }
            }
        }
    }
}

class SelectionSort : Sorting {
    override fun sort(numbers: IntArray) {
        // Selection Sort Algorithm
        println("Selection Sort Algorithm executed.")
        val size = numbers.size
        for (i in 0 until size - 1) {
            var maxIndex = 0
            for (j in 1 until size - i) {
                if (numbers[j] > numbers[maxIndex]) {
                    maxIndex = j
                }
            }
            val temp = numbers[size - 1 - i]
            numbers[size - 1 - i] = numbers[maxIndex]
            numbers[maxIndex] = temp
        }
    }
}

class StrategyClass(private var sorter: Sorting) {
    fun setSorter(algo: Sorting) {
        this.sorter = algo
    }

    fun sort(a: IntArray) {
        sorter.sort(a)
    }
}

// Client code
fun main() {
    val a = intArrayOf(4, 5, 3, 2, 6, 7, 1, 8, 9, 10)
    val s = StrategyClass(BubbleSort())
    s.sort(a)
    println(a.contentToString())

    val b = intArrayOf(4, 5, 3, 2, 6, 7, 1, 8, 9, 10)
    s.setSorter(SelectionSort())
    s.sort(b)
    println(b.contentToString())
}


/*
Bubble Sort Algorithm executed.
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Selection Sort Algorithm executed.
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
*/