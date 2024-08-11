#include <iostream>
#include <string>

class ImmutablePerson {
private:
    const std::string name;
    const int age;
    const std::string gender;

public:
    ImmutablePerson(const std::string& name, int age, const std::string& gender)
        : name(name), age(age), gender(gender) {}

    std::string getName() const {
        return name;
    }

    int getAge() const {
        return age;
    }

    std::string getGender() const {
        return gender;
    }
};

// Client code
int main() {
    ImmutablePerson person("John Doe", 30, "Male");
    ImmutablePerson newPerson("John Doe", 31, "Male");

    std::cout << "Name: " << person.getName() << ", Age: " << person.getAge() << ", Gender: " << person.getGender() << std::endl;
    std::cout << "Name: " << newPerson.getName() << ", Age: " << newPerson.getAge() << ", Gender: " << newPerson.getGender() << std::endl;

    // Attempting to modify the values will result in a compilation error
    // person.age = 32;  // Error: 'const' member function called on a non-const object

    return 0;
}

/*
Name: John Doe, Age: 30, Gender: Male
Name: John Doe, Age: 31, Gender: Male
*/