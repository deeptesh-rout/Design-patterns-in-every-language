#include <iostream>

// OrderPackingTemplate class
class OrderPackingTemplate {
public:
    void packProduct() {
        getProduct();
        addProductToBox();
        delivery();
    }

    virtual ~OrderPackingTemplate() {}

private:
    void getProduct() {
        std::cout << "Get the product from the shelf." << std::endl;
    }

    void addProductToBox() {
        std::cout << "Put the product inside the box." << std::endl;
    }

    virtual void delivery() = 0;
};

// OnlineOrderPacking class
class OnlineOrderPacking : public OrderPackingTemplate {
private:
    void delivery() override {
        std::cout << "Add delivery address slip and ship." << std::endl;
    }
};

// StoreOrderPacking class
class StoreOrderPacking : public OrderPackingTemplate {
private:
    void delivery() override {
        std::cout << "Add thanks message to the box and deliver to the customer." << std::endl;
    }
};

// Client code
int main() {
    OrderPackingTemplate* onlineOrder = new OnlineOrderPacking();
    onlineOrder->packProduct();
    std::cout << std::endl;
    OrderPackingTemplate* storeOrder = new StoreOrderPacking();
    storeOrder->packProduct();
    delete onlineOrder; // Freeing allocated memory
    delete storeOrder;  // Freeing allocated memory
    return 0;
}

/*
Get the product from the shelf.
Put the product inside the box.
Add delivery address slip and ship.

Get the product from the shelf.
Put the product inside the box.
Add thanks message to the box and deliver to the customer.
*/