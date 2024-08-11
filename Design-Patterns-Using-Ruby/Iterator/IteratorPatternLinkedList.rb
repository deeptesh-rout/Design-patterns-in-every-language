class LinkedList
    class Node
        attr_accessor :value, :next

        def initialize(value, next_node)
            @value = value
            @next = next_node
        end
    end

    include Enumerable

    attr_accessor :head, :tail, :size

    def initialize
        @head = nil
        @tail = nil
        @size = 0
    end

    def add_head(value)
        new_node = Node.new(value, head)
        @tail = new_node if head.nil?
        @head = new_node
        @size += 1
    end

    def each(&block)
        current = head
        while current
            block.call(current.value)
            current = current.next
        end
    end
end
      
# Client code
aggregate = LinkedList.new
(0..4).each { |i| aggregate.add_head(i) }

aggregate.each { |val| print "#{val} " }

=begin 
4 3 2 1 0 
=end