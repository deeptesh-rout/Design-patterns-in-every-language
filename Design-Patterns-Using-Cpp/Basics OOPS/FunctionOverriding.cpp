#include <iostream>
#include <string>

class Person {
protected:
    std::string name;
    std::string oath;

public:
    Person(const std::string& name) : name(name) {}

    std::string toString() const {
        return "Person: " + name + ":" + oath;
    }

    virtual void setOath() {
        this->oath = "Always tell truth";
    }
};

class Citizen : public Person {
private:
    int id;

public:
    Citizen(const std::string& name, int id) : Person(name), id(id) {}

    void setOath() override {
        this->oath = "Country comes first";
    }
};

int main() {
    Person p("John");
    p.setOath();
    std::cout << p.toString() << std::endl;

    Citizen c("Smith", 31);
    c.setOath();
    std::cout << c.toString() << std::endl;

    return 0;
}

/*
Person: John:Always tell truth
Person: Smith:Country comes first
*/