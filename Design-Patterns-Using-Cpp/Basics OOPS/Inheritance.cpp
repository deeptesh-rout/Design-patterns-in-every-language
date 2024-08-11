#include <iostream>
#include <string>

class Person {
protected:
    std::string name;
    int age;
    std::string gender;

public:
    Person(const std::string& name, int age, const std::string& gender)
        : name(name), age(age), gender(gender) {}

    virtual std::string toString() const {
        return "Person: " + name + " is a " + gender + " and " + std::to_string(age) + " years old.";
    }

    std::string getGender() const {
        return gender;
    }
};

class Citizen : public Person {
private:
    int id;

public:
    Citizen(const std::string& name, int age, int id, const std::string& gender)
        : Person(name, age, gender), id(id) {}

    int getVoterId() const {
        return id;
    }

    std::string toString() const override {
        return "Citizen: " + name + " is a " + gender + " and " + std::to_string(age) +
               " years old with voter id " + std::to_string(id) + ".";
    }
};

int main() {
    Person p("John", 32, "Male");
    std::cout << p.toString() << std::endl;

    Citizen c("Smith", 31, 1234, "Male");
    std::cout << c.toString() << std::endl;

    return 0;
}

/*
Person: John is a Male and 32 years old.
Citizen: Smith is a Male and 31 years old with voter id 1234.
*/