package main

import "fmt"

type Sorting interface {
	sort(numbers []int)
}

type BubbleSort struct{}

func (bs *BubbleSort) sort(numbers []int) {
	// Bubble Sort Algorithm
	fmt.Println("Bubble Sort Algorithm executed.")
	size := len(numbers)
	for i := 0; i < size-1; i++ {
		for j := 0; j < size-i-1; j++ {
			if numbers[j] > numbers[j+1] {
				// Swapping
				temp := numbers[j]
				numbers[j] = numbers[j+1]
				numbers[j+1] = temp
			}
		}
	}
}

type SelectionSort struct{}

func (ss *SelectionSort) sort(numbers []int) {
	// Selection Sort Algorithm
	fmt.Println("Selection Sort Algorithm executed.")
	size := len(numbers)
	for i := 0; i < size-1; i++ {
		maxIndex := 0
		for j := 1; j < size-i; j++ {
			if numbers[j] > numbers[maxIndex] {
				maxIndex = j
			}
		}
		temp := numbers[size-1-i]
		numbers[size-1-i] = numbers[maxIndex]
		numbers[maxIndex] = temp
	}
}

type StrategyClass struct {
	sorter Sorting
}

func NewStrategyClass(algo Sorting) *StrategyClass {
	return &StrategyClass{
		sorter: algo,
	}
}

func (sc *StrategyClass) setSorter(algo Sorting) {
	sc.sorter = algo
}

func (sc *StrategyClass) sort(a []int) {
	sc.sorter.sort(a)
}

// Client code
func main() {
	a := []int{4, 5, 3, 2, 6, 7, 1, 8, 9, 10}
	s := NewStrategyClass(&BubbleSort{})
	s.sort(a)
	fmt.Println(a)

	a = []int{4, 5, 3, 2, 6, 7, 1, 8, 9, 10}
	s.setSorter(&SelectionSort{})
	s.sort(a)
	fmt.Println(a)
}

/*
Bubble Sort Algorithm executed.
[1 2 3 4 5 6 7 8 9 10]
Selection Sort Algorithm executed.
[1 2 3 4 5 6 7 8 9 10]
*/