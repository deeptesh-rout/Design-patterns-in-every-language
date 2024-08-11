#include <iostream>
#include <vector>

class Tyre {
private:
    std::string type;

public:
    Tyre(const std::string& type) : type(type) {}

    std::string getType() const {
        return type;
    }
};

class Car {
private:
    std::string model;
    std::vector<Tyre> tyres;

public:
    Car(const std::string& model) : model(model) {
        for (int i = 0; i < 4; i++) {
            tyres.push_back(Tyre("MRF"));
        }
    }

    void display() const {
        std::cout << "Car: " << model << ", Tyre: " << tyres[0].getType() << std::endl;
    }
};

int main() {
    Car car("BMW");
    car.display();

    return 0;
}
/*
Car: BMW, Tyre: MRF
*/