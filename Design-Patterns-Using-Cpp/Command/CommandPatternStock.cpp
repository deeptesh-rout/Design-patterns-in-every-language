#include <iostream>

// Receiver
class ReceiverStockTrade {
public:
    void buy() {
        std::cout << "Buy stocks" << std::endl;
    }

    void sell() {
        std::cout << "Sell stocks" << std::endl;
    }
};

// Order (Command)
class Order {
public:
    virtual void execute() = 0;
    virtual ~Order() = default;
};

// BuyStockOrder (ConcreteCommand)
class BuyStockOrder : public Order {
private:
    ReceiverStockTrade* stock;

public:
    BuyStockOrder(ReceiverStockTrade* stock) : stock(stock) {}

    void execute() override {
        stock->buy();
    }
};

// SellStockOrder (ConcreteCommand)
class SellStockOrder : public Order {
private:
    ReceiverStockTrade* stock;

public:
    SellStockOrder(ReceiverStockTrade* stock) : stock(stock) {}

    void execute() override {
        stock->sell();
    }
};

// Agent (Invoker)
class Agent {
public:
    void placeOrder(Order* command) {
        command->execute();
    }
};

// Client code
int main() {
    ReceiverStockTrade trader;
    BuyStockOrder buyStock(&trader);
    SellStockOrder sellStock(&trader);

    Agent agent;
    agent.placeOrder(&buyStock);
    agent.placeOrder(&sellStock);

    return 0;
}

/*
Buy stocks
Sell stocks
*/