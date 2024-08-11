# Iterator interface
class Iterator
    def next
        raise NotImplementedError, 'Subclasses must implement the next method'
    end

    def has_next
        raise NotImplementedError, 'Subclasses must implement the has_next method'
    end
end

# Aggregate interface
class Aggregate
    def get_iterator
        raise NotImplementedError, 'Subclasses must implement the get_iterator method'
    end
end

# Concrete Iterator
class ConcreteIterator < Iterator
    def initialize(aggregate)
        @aggregate = aggregate
        @index = 0
    end

    def next
        raise IndexError if @index >= @aggregate.data.size
        value = @aggregate.data[@index]
        @index += 1
        value
    end

    def has_next
        @index < @aggregate.data.size
    end
end

# Concrete Aggregate
class ConcreteAggregate < Aggregate
    attr_reader :data

    def initialize
        @data = []
    end

    def add_data(val)
        @data.push(val)
    end

    def get_iterator
        ConcreteIterator.new(self)
    end
end

# Client code
aggregate = ConcreteAggregate.new
(0..4).each { |i| aggregate.add_data(i) }

iterator = aggregate.get_iterator
while iterator.has_next
    print "#{iterator.next} "
end

=begin 
0 1 2 3 4 
=end