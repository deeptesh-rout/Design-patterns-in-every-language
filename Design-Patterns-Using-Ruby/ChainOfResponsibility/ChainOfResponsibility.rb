# Handler abstract class
class Handler
    attr_accessor :successor

    def initialize(successor = nil)
        @successor = successor
    end

    def handle_request(request)
        raise NotImplementedError, 'Subclasses must override this method'
    end
end

# ConcreteHandler1 class
class ConcreteHandler1 < Handler
    def handle_request(request)
        if request == 'request1'
        puts 'ConcreteHandler1 handles the request1.'
        elsif successor
        successor.handle_request(request)
        end
    end
end

# ConcreteHandler2 class
class ConcreteHandler2 < Handler
    def handle_request(request)
        if request == 'request2'
        puts 'ConcreteHandler2 handles the request2.'
        elsif successor
        successor.handle_request(request)
        end
    end
end

# ConcreteHandler3 class
class ConcreteHandler3 < Handler
    def handle_request(request)
        if request == 'request3'
        puts 'ConcreteHandler3 handles the request3.'
        elsif successor
        successor.handle_request(request)
        end
    end
end

# Client code
ch1 = ConcreteHandler1.new
ch2 = ConcreteHandler2.new(ch1)
ch3 = ConcreteHandler3.new(ch2)

ch3.handle_request('request1')
ch3.handle_request('request2')
ch3.handle_request('request3')
ch3.handle_request('request4')


=begin 
ConcreteHandler1 handles the request1.
ConcreteHandler2 handles the request2.
ConcreteHandler3 handles the request3. 
=end