#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <string>

class Observer {
public:
    virtual void notify(const std::string& subject, const std::string& message) = 0;
};

class Courses {
private:
    std::unordered_map<std::string, std::unordered_set<Observer*>> courseStudents;

public:
    void subscribe(const std::string& subject, Observer* student) {
        courseStudents[subject].insert(student);
    }

    void unsubscribe(const std::string& subject, Observer* student) {
        auto it = courseStudents.find(subject);
        if (it != courseStudents.end()) {
            it->second.erase(student);
        }
    }

    void publish(const std::string& subject, const std::string& message) {
        auto it = courseStudents.find(subject);
        if (it != courseStudents.end()) {
            for (Observer* student : it->second) {
                student->notify(subject, message);
            }
        } else {
            std::cout << "No subscribers for subject '" << subject << "'." << std::endl;
        }
    }
};

class Student : public Observer {
private:
    std::string name;

public:
    Student(const std::string& name) : name(name) {}

    void notify(const std::string& subject, const std::string& message) override {
        std::cout << name << " received message on subject '" << subject << "': " << message << std::endl;
    }
};

// Client code
int main() {
    Courses courses;
    Student john("John");
    Student eric("Eric");
    Student jack("Jack");

    courses.subscribe("English", &john);
    courses.subscribe("English", &eric);
    courses.subscribe("Maths", &eric);
    courses.subscribe("Science", &jack);

    courses.publish("English", "Tomorrow class at 11");
    courses.publish("Maths", "Tomorrow class at 1");

    // Unsubscribe Eric from English
    courses.unsubscribe("English", &eric);

    courses.publish("English", "Updated schedule for English");

    return 0;
}

/*
Eric received message on subject 'English': Tomorrow class at 11
John received message on subject 'English': Tomorrow class at 11
Eric received message on subject 'Maths': Tomorrow class at 1
John received message on subject 'English': Updated schedule for English
*/