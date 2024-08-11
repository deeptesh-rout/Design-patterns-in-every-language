#include <iostream>
#include <vector>

// Abstract Sorting class
class Sorting {
public:
    virtual void sort(std::vector<int>& numbers) = 0;
    virtual ~Sorting() {}
};

// BubbleSort class
class BubbleSort : public Sorting {
public:
    void sort(std::vector<int>& numbers) override {
        // Bubble Sort Algorithm
        std::cout << "Bubble Sort Algorithm executed." << std::endl;
        int size = numbers.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // Swapping
                    std::swap(numbers[j], numbers[j + 1]);
                }
            }
        }
    }
};

// SelectionSort class
class SelectionSort : public Sorting {
public:
    void sort(std::vector<int>& numbers) override {
        // Selection Sort Algorithm
        std::cout << "Selection Sort Algorithm executed." << std::endl;
        int size = numbers.size();
        for (int i = 0; i < size - 1; i++) {
            int maxIndex = 0;
            for (int j = 1; j < size - i; j++) {
                if (numbers[j] > numbers[maxIndex]) {
                    maxIndex = j;
                }
            }
            std::swap(numbers[size - 1 - i], numbers[maxIndex]);
        }
    }
};

// StrategyClass class
class StrategyClass {
private:
    Sorting* sorter;

public:
    StrategyClass(Sorting* algo) : sorter(algo) {}

    void setSorter(Sorting* algo) {
        sorter = algo;
    }

    void sort(std::vector<int>& numbers) {
        sorter->sort(numbers);
    }
};

// Client code
int main() {
    std::vector<int> a = {4, 5, 3, 2, 6, 7, 1, 8, 9, 10};
    StrategyClass s(new BubbleSort());
    s.sort(a);
    for (int num : a) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    std::vector<int> b = {4, 5, 3, 2, 6, 7, 1, 8, 9, 10};
    s.setSorter(new SelectionSort());
    s.sort(b);
    for (int num : b) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    return 0;
}

/*
Bubble Sort Algorithm executed.
1 2 3 4 5 6 7 8 9 10 
Selection Sort Algorithm executed.
1 2 3 4 5 6 7 8 9 10 
*/