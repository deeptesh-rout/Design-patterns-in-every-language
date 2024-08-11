#include <iostream>

// Abstract Expression
class AbstractExpression {
public:
    virtual void interpret() = 0;
    virtual ~AbstractExpression() = default;
};

// Nonterminal Expression
class NonterminalExpression : public AbstractExpression {
private:
    AbstractExpression* expression;

public:
    NonterminalExpression(AbstractExpression* expr) : expression(expr) {}

    void interpret() override {
        std::cout << "NonTerminalExpression:interpret" << std::endl;
        expression->interpret();
    }

    ~NonterminalExpression() {
        delete expression;
    }
};

// Terminal Expression
class TerminalExpression : public AbstractExpression {
public:
    void interpret() override {
        std::cout << "TerminalExpression:interpret" << std::endl;
    }
};

// Client Code
int main() {
    AbstractExpression* tree = new NonterminalExpression(new TerminalExpression());
    tree->interpret();
    delete tree;
    return 0;
}

/*
NonTerminalExpression:interpret
TerminalExpression:interpret
*/