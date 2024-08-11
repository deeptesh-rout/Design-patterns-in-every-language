#include <iostream>
#include <vector>

// Data Access Layer
class DataAccessLayer {
private:
    std::vector<std::string> products;

public:
    DataAccessLayer() {}

    std::vector<std::string> getData() {
        return products;
    }

    void addData(std::string product) {
        products.push_back(product);
    }
};

// Business Logic Layer
class BusinessLogicLayer {
private:
    DataAccessLayer* dataAccess;

public:
    BusinessLogicLayer(DataAccessLayer* dataAccess) : dataAccess(dataAccess) {}

    std::vector<std::string> getAllProducts() {
        return dataAccess->getData();
    }

    void addProduct(std::string product) {
        dataAccess->addData(product);
    }
};

// Presentation Layer
class PresentationLayer {
private:
    BusinessLogicLayer* businessLogic;

public:
    PresentationLayer(BusinessLogicLayer* businessLogic) : businessLogic(businessLogic) {}

    void displayProducts() {
        std::vector<std::string> products = businessLogic->getAllProducts();
        for (size_t i = 0; i < products.size(); i++) {
            std::cout << (i + 1) << ". " << products[i] << std::endl;
        }
    }

    void addProduct(std::string product) {
        businessLogic->addProduct(product);
    }
};

// Client code
int main() {
    DataAccessLayer dataAccess;
    BusinessLogicLayer businessLogic(&dataAccess);
    PresentationLayer presentationLayer(&businessLogic);

    presentationLayer.addProduct("Apple");
    presentationLayer.addProduct("Banana");
    presentationLayer.addProduct("Mango");
    presentationLayer.displayProducts();

    return 0;
}


/*
1. Apple
2. Banana
3. Mango
*/