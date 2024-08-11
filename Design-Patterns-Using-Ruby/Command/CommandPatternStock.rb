# Agent (Invoker)
class Agent
    def place_order(command)
        command.execute
    end
end

# Order (Command)
class Order
    def execute
        raise NotImplementedError, 'Subclasses must implement this method'
    end
end

# BuyStockOrder (ConcreteCommand)
class BuyStockOrder < Order
    def initialize(stock)
        @stock = stock
    end
  
    def execute
        @stock.buy
    end
end

# SellStockOrder (ConcreteCommand)
class SellStockOrder < Order
    def initialize(stock)
        @stock = stock
    end
    
    def execute
        @stock.sell
    end
end

# Receiver
class ReceiverStockTrade
    def buy
        puts 'Buy stocks'
    end
    
    def sell
        puts 'Sell stocks'
    end
end

# Client code
trader = ReceiverStockTrade.new
buy_stock = BuyStockOrder.new(trader)
sell_stock = SellStockOrder.new(trader)

agent = Agent.new
agent.place_order(buy_stock)
agent.place_order(sell_stock)

=begin 
Buy stocks
Sell stocks 
=end