# Define Sorting interface
module Sorting
    def sort(numbers)
        raise NotImplementedError, 'Subclasses must implement the sort method'
    end
end

# Define BubbleSort class implementing Sorting
class BubbleSort
    include Sorting

    def sort(numbers)
        # Bubble Sort Algorithm
        puts 'Bubble Sort Algorithm executed.'
        size = numbers.length
        (0...size - 1).each do |i|
            (0...size - i - 1).each do |j|
                if numbers[j] > numbers[j + 1]
                    # Swapping
                    numbers[j], numbers[j + 1] = numbers[j + 1], numbers[j]
                end
            end
        end
    end
end

# Define SelectionSort class implementing Sorting
class SelectionSort
    include Sorting

    def sort(numbers)
        # Selection Sort Algorithm
        puts 'Selection Sort Algorithm executed.'
        size = numbers.length
        (0...size - 1).each do |i|
            max_index = 0
            (1...size - i).each do |j|
                max_index = j if numbers[j] > numbers[max_index]
            end
            numbers[size - 1 - i], numbers[max_index] = numbers[max_index], numbers[size - 1 - i]
        end
    end
end

# Define StrategyClass
class StrategyClass
    attr_accessor :sorter

    def initialize(algo)
        @sorter = algo
    end

    def set_sorter(algo)
        @sorter = algo
    end

    def sort(a)
        @sorter.sort(a)
    end
end

# Client code
a = [4, 5, 3, 2, 6, 7, 1, 8, 9, 10]
s = StrategyClass.new(BubbleSort.new)
s.sort(a)
puts a.to_s

b = [4, 5, 3, 2, 6, 7, 1, 8, 9, 10]
s.set_sorter(SelectionSort.new)
s.sort(b)
puts b.to_s

=begin 
Bubble Sort Algorithm executed.
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Selection Sort Algorithm executed.
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
=end