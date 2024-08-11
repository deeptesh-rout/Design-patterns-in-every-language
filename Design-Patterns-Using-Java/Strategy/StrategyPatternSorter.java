import java.util.Arrays;

interface Sorting {
    void sort(int[] numbers);
}

class BubbleSort implements Sorting {
    @Override
    public void sort(int[] numbers) {
        // Bubble Sort Algorithm
        System.out.println("Bubble Sort Algorithm executed.");
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // Swapping
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}

class SelectionSort implements Sorting {
    @Override
    public void sort(int[] numbers) {
        // Selection Sort Algorithm
        System.out.println("Selection Sort Algorithm executed.");
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            int maxIndex = 0;
            for (int j = 1; j < size - i; j++) {
                if (numbers[j] > numbers[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = numbers[size - 1 - i];
            numbers[size - 1 - i] = numbers[maxIndex];
            numbers[maxIndex] = temp;
        }
    }
}

class StrategyClass {
    private Sorting sorter;

    StrategyClass(Sorting algo) {
        this.sorter = algo;
    }

    void setSorter(Sorting algo) {
        this.sorter = algo;
    }

    void sort(int[] a) {
        this.sorter.sort(a);
    }
}

public class StrategyPatternSorter {
    public static void main(String[] args) {
        int[] a = {4, 5, 3, 2, 6, 7, 1, 8, 9, 10};
        StrategyClass s = new StrategyClass(new BubbleSort());
        s.sort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {4, 5, 3, 2, 6, 7, 1, 8, 9, 10};
        s.setSorter(new SelectionSort());
        s.sort(b);
        System.out.println(Arrays.toString(b));
    }
}

/*
Bubble Sort Algorithm executed.
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Selection Sort Algorithm executed.
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
*/