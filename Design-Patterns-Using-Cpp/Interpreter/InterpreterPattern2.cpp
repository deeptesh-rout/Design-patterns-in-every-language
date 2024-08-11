#include <iostream>
#include <unordered_map>

// Abstract Expression
class Expression {
public:
    virtual int interpret() = 0;
    virtual ~Expression() = default;
};

// Terminal Expression
class NumberExpression : public Expression {
private:
    int number;

public:
    NumberExpression(int number) : number(number) {}

    int interpret() override {
        return number;
    }
};

// Non-terminal Expression
class AddExpression : public Expression {
private:
    Expression* leftExpression;
    Expression* rightExpression;

public:
    AddExpression(Expression* left, Expression* right) : leftExpression(left), rightExpression(right) {}

    int interpret() override {
        return leftExpression->interpret() + rightExpression->interpret();
    }

    ~AddExpression() {
        delete leftExpression;
        delete rightExpression;
    }
};

// Context
class Context {
private:
    std::unordered_map<std::string, int> variables;

public:
    void setVariable(const std::string& variable, int value) {
        variables[variable] = value;
    }

    int getVariable(const std::string& variable) {
        auto it = variables.find(variable);
        return (it != variables.end()) ? it->second : 0;
    }
};

// Client code
int main() {
    Context context;
    context.setVariable("x", 10);
    context.setVariable("y", 5);

    // Create the expression tree: x + (y + 2)
    Expression* expression = new AddExpression(
        new NumberExpression(context.getVariable("x")),
        new AddExpression(
            new NumberExpression(context.getVariable("y")),
            new NumberExpression(2)
        )
    );

    int result = expression->interpret();
    std::cout << "Result: " << result << std::endl;  // Output: Result: 17

    delete expression;

    return 0;
}

/*
Result: 17
*/