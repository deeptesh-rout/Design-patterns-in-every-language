#include <iostream>
#include <vector>

class Student {
private:
    std::string name;

public:
    Student(const std::string& name) : name(name) {}

    friend std::ostream& operator<<(std::ostream& os, const Student& student) {
        os << "Student: " << student.name;
        return os;
    }
};

class SchoolClass {
private:
    std::string className;
    std::vector<Student> students;

public:
    SchoolClass(const std::string& className) : className(className) {}

    void addStudent(const Student& student) {
        students.push_back(student);
    }

    void display() const {
        for (const Student& student : students) {
            std::cout << student << std::endl;
        }
    }
};

int main() {
    SchoolClass schoolClass("SS1");
    Student student1("John Smith");
    Student student2("Jane Smith");

    schoolClass.addStudent(student1);
    schoolClass.addStudent(student2);

    schoolClass.display();

    return 0;
}
/*
Student: John Smith
Student: Jane Smith
*/