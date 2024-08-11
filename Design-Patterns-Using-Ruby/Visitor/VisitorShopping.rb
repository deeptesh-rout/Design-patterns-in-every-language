class Element
    def accept(visitor)
        raise NotImplementedError, 'Subclasses must implement the accept method'
    end

    def price
        raise NotImplementedError, 'Subclasses must implement the price method'
    end
end

class Book < Element
    attr_reader :price, :isbn

    def initialize(price, isbn)
        @price = price
        @isbn = isbn
    end

    def price
        @price
    end

    def accept(visitor)
        visitor.visit_book(self)
    end
end

class Fruit < Element
    attr_reader :price, :quantity, :type

    def initialize(price, quantity, type)
        @price = price
        @quantity = quantity
        @type = type
    end

    def price
        @price
    end

    def accept(visitor)
        visitor.visit_fruit(self) * quantity
    end
end

class Visitor
    def visit_book(book)
        raise NotImplementedError, 'Subclasses must implement the visit_book method'
    end

    def visit_fruit(fruit)
        raise NotImplementedError, 'Subclasses must implement the visit_fruit method'
    end
end

class SundayDiscount < Visitor
    def visit_book(book)
        book.price - 50
    end

    def visit_fruit(fruit)
        fruit.price - 5
    end
end

class SaleDiscount < Visitor
    def visit_book(book)
        book.price / 2
    end

    def visit_fruit(fruit)
        fruit.price / 2
    end
end

class ShoppingCart
    attr_accessor :list, :visitor

    def initialize
        @list = []
        @visitor = nil
    end

    def add(element)
        list << element
    end

    def set_discount_visitor(discount)
        self.visitor = discount
    end

    def accept
        cost = list.sum { |element| element.accept(visitor) }
        puts "Total cost: #{cost}"
    end
end

# Client code
cart = ShoppingCart.new
cart.add(Fruit.new(100, 10, 'Apple'))
cart.add(Book.new(100, 12345))

cart.set_discount_visitor(SundayDiscount.new)
cart.accept

cart.set_discount_visitor(SaleDiscount.new)
cart.accept

=begin 
Total cost: 1000
Total cost: 550
=end