#include <iostream>
#include <map>
#include <random>

// Shape abstract class
class Shape {
protected:
    int colour; // Intrinsic State

public:
    Shape(int colour) : colour(colour) {}

    virtual void draw(int x1, int y1, int x2, int y2) = 0; // Extrinsic State
};

// Rectangle class
class Rectangle : public Shape {
public:
    Rectangle(int colour) : Shape(colour) {}

    void draw(int x1, int y1, int x2, int y2) override {
        std::cout << "Draw Rectangle colour:" << colour << " topleft: (" << x1 << "," << y1 << ") rightBottom: (" << x2 << "," << y2 << ")\n";
    }
};

// RectangleFactory class
class RectangleFactory {
private:
    std::map<int, Shape*> shapes;

public:
    Shape* getRectangle(int colour) {
        if (shapes.find(colour) == shapes.end()) {
            shapes[colour] = new Rectangle(colour);
        }
        return shapes[colour];
    }

    int getCount() const {
        return shapes.size();
    }

    ~RectangleFactory() {
        for (auto& pair : shapes) {
            delete pair.second;
        }
    }
};

// Client code
int main() {
    RectangleFactory factory;
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<int> dis(0, 999);

    for (int i = 0; i < 1000; ++i) {
        Shape* rect = factory.getRectangle(dis(gen));
        rect->draw(dis(gen), dis(gen), dis(gen), dis(gen));
    }

    std::cout << factory.getCount() << std::endl;

    return 0;
}
