using System;

interface ISorting
{
    void Sort(int[] numbers);
}

class BubbleSort : ISorting
{
    public void Sort(int[] numbers)
    {
        // Bubble Sort Algorithm
        Console.WriteLine("Bubble Sort Algorithm executed.");
        int size = numbers.Length;
        for (int i = 0; i < size - 1; i++)
        {
            for (int j = 0; j < size - i - 1; j++)
            {
                if (numbers[j] > numbers[j + 1])
                {
                    // Swapping
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}

class SelectionSort : ISorting
{
    public void Sort(int[] numbers)
    {
        // Selection Sort Algorithm
        Console.WriteLine("Selection Sort Algorithm executed.");
        int size = numbers.Length;
        for (int i = 0; i < size - 1; i++)
        {
            int maxIndex = 0;
            for (int j = 1; j < size - i; j++)
            {
                if (numbers[j] > numbers[maxIndex])
                {
                    maxIndex = j;
                }
            }
            int temp = numbers[size - 1 - i];
            numbers[size - 1 - i] = numbers[maxIndex];
            numbers[maxIndex] = temp;
        }
    }
}

class StrategyClass
{
    private ISorting sorter;

    public StrategyClass(ISorting algo)
    {
        this.sorter = algo;
    }

    public void SetSorter(ISorting algo)
    {
        this.sorter = algo;
    }

    public void Sort(int[] a)
    {
        this.sorter.Sort(a);
    }
}

// Client code
public class StrategyPatternSorter
{
    public static void Main(string[] args)
    {
        int[] a = { 4, 5, 3, 2, 6, 7, 1, 8, 9, 10 };
        StrategyClass s = new StrategyClass(new BubbleSort());
        s.Sort(a);
        Console.WriteLine(string.Join(", ", a));

        int[] b = { 4, 5, 3, 2, 6, 7, 1, 8, 9, 10 };
        s.SetSorter(new SelectionSort());
        s.Sort(b);
        Console.WriteLine(string.Join(", ", b));
    }
}
