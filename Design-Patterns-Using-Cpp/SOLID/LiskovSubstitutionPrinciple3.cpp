#include <iostream>

class Rectangle {
private:
    int height;
    int width;

public:
    Rectangle(int l, int w) : height(l), width(w) {}

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
        Rectangle::setWidth(w);
        Rectangle::setHeight(w);
    }

    void setHeight(int h) override {
        Rectangle::setWidth(h);
        Rectangle::setHeight(h);
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
    s.setWidth(20);
    testRect(s);

    return 0;
}

/*
success
failure
*/