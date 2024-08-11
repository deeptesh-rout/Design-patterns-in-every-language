# BookParser interface
module BookParser
    def num_pages
        raise NotImplementedError, "Subclasses must implement the 'num_pages' method"
    end
end

# ConcreteBookParser class
class ConcreteBookParser
    include BookParser

    def initialize
        puts 'Concrete Book Parser Created'
        # Number of pages calculation heavy operation.
        # Suppose this calculation results in 1000 pages.
        @num_pages = 1000
    end

    def num_pages
        puts 'Concrete Book Parser Request Method'
        @num_pages
    end
end

# LazyBookParserProxy class
class LazyBookParserProxy
    include BookParser

    def num_pages
        @subject ||= ConcreteBookParser.new
        @subject.num_pages
    end
end

# Client code
proxy = LazyBookParserProxy.new
puts proxy.num_pages

=begin 
Concrete Book Parser Created
Concrete Book Parser Request Method
1000
=end