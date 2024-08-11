#include <iostream>
#include <string>

class BulbControl;

class BulbState {
public:
    virtual void flip(BulbControl& bc) = 0;
    virtual std::string toString() const = 0;
    virtual ~BulbState() {}
};

class On : public BulbState {
public:
    void flip(BulbControl& bc) override;
    std::string toString() const override;
};

class Off : public BulbState {
public:
    void flip(BulbControl& bc) override;
    std::string toString() const override;
};

class BulbControl {
private:
    BulbState* current;

public:
    BulbControl() {
        this->current = new Off();
    }

    void setState(BulbState* state) {
        delete this->current;
        this->current = state;
    }

    void flip() {
        this->current->flip(*this);
    }

    std::string toStringState() const {
        return this->current->toString();
    }

    ~BulbControl() {
        delete this->current;
    }
};



void On::flip(BulbControl& bc) {
    bc.setState(new Off());
}

std::string On::toString() const {
    return "On";
}

void Off::flip(BulbControl& bc) {
    bc.setState(new On());
}

std::string Off::toString() const {
    return "Off";
}

// Client code
int main() {
    BulbControl c;
    c.flip();
    std::cout << c.toStringState() << std::endl;
    c.flip();
    std::cout << c.toStringState() << std::endl;

    return 0;
}

/*
On
Off
*/