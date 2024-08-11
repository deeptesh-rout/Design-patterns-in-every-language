# Abstract class representing an ATM handler
class ATMHandlerAbstract
    attr_accessor :successor, :denomination
  
    def initialize(successor, denomination)
        @successor = successor
        @denomination = denomination
    end
  
    def handle_request(amount)
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# Class representing an ATM handler
class ATMHandler < ATMHandlerAbstract
    def initialize(successor, denomination)
        super(successor, denomination)
    end
  
    def handle_request(amount)
        q, r = amount.divmod(denomination)
    
        puts "#{q} notes of #{denomination}" if q != 0
    
        successor&.handle_request(r) if r != 0
    end
end

# Client code
handler = ATMHandler.new( ATMHandler.new( ATMHandler.new( ATMHandler.new(nil, 10), 50 ), 100 ), 1000 )
handler.handle_request(5560)

=begin 
5 notes of 1000
5 notes of 100
1 notes of 50
1 notes of 10
=end