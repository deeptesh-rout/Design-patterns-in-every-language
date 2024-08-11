#include <iostream>

class Animal {
protected:
    std::string name;

public:
    Animal(const std::string& name) : name(name) {}

    virtual void makeSound() const {
        std::cout << "Animal sound" << std::endl;
    }
};

class Dog : public Animal {
public:
    Dog(const std::string& name) : Animal(name) {}

    void makeSound() const override {
        std::cout << "woof woof!" << std::endl;
    }
};

class Cat : public Animal {
public:
    Cat(const std::string& name) : Animal(name) {}

    void makeSound() const override {
        std::cout << "meow!" << std::endl;
    }
};

class Rectangle {
protected:
    int height;
    int width;

public:
    Rectangle(int h, int w) : height(h), width(w) {}

    virtual void setWidth(int w) {
        width = w;
    }

    virtual void setHeight(int h) {
        height = h;
    }

    int getWidth() const {
        return width;
    }

    int getHeight() const {
        return height;
    }
};

class Square : public Rectangle {
public:
    Square(int l) : Rectangle(l, l) {}

    void setWidth(int w) override {
        width = w;
        height = w;
    }

    void setHeight(int h) override {
        width = h;
        height = h;
    }
};

void testRect(Rectangle& rect) {
    rect.setHeight(10);
    rect.setWidth(20);
    if (200 == rect.getHeight() * rect.getWidth())
        std::cout << "success" << std::endl;
    else
        std::cout << "failure" << std::endl;
}

// Client code
int main() {
    Rectangle r(10, 20);
    testRect(r);
    Square s(10);
    testRect(s);
    return 0;
}


/*
success
failure
*/