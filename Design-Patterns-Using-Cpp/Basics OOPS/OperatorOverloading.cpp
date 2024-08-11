#include <iostream>
#include <cmath>

class Rectangle {
private:
    double length;
    double breadth;

public:
    Rectangle(double length, double breadth) : length(length), breadth(breadth) {}

    double area() const {
        return length * breadth;
    }

    double perimeter() const {
        return 2 * (length + breadth);
    }

    // Overloading + operator
    Rectangle add(const Rectangle& rec) const {
        return Rectangle(this->length + rec.length, this->breadth + rec.breadth);
    }

    // Overloading - operator
    Rectangle subtract(const Rectangle& rec) const {
        return Rectangle(std::abs(this->length - rec.length), std::abs(this->breadth - rec.breadth));
    }

    // Overloading == operator
    bool equals(const Rectangle& rec) const {
        return this->length == rec.length && this->breadth == rec.breadth;
    }

    // Overriding toString method
    friend std::ostream& operator<<(std::ostream& os, const Rectangle& rec) {
        os << "Rectangle length and width: " << rec.length << " " << rec.breadth;
        return os;
    }
};

int main() {
    Rectangle r1(4, 6);
    Rectangle r2(10, 6);

    std::cout << "Is r1 == r2 ? " << (r1.equals(r2) ? "true" : "false") << std::endl;

    Rectangle r3 = r1.add(r2);
    Rectangle r4 = r1.subtract(r2);

    std::cout << r1 << std::endl;
    std::cout << r2 << std::endl;
    std::cout << r3 << std::endl;
    std::cout << r4 << std::endl;

    return 0;
}

/*
Is r1 == r2 ? false
Rectangle length and width: 4 6
Rectangle length and width: 10 6
Rectangle length and width: 14 12
Rectangle length and width: 6 0
*/