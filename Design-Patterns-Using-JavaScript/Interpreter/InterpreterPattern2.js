// Abstract Expression
class Expression {
    interpret(context) { }
}

// Terminal Expression
class NumberExpression extends Expression {
    constructor(number) {
        super();
        this.number = number;
    }

    interpret() {
        return this.number;
    }
}

// Non-terminal Expression
class AddExpression extends Expression {
    constructor(leftExpression, rightExpression) {
        super();
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    interpret(context) {
        return this.leftExpression.interpret(context) + this.rightExpression.interpret(context);
    }
}

// Context
class Context {
    constructor() {
        this.variables = new Map();
    }

    setVariable(variable, value) {
        this.variables.set(variable, value);
    }

    getVariable(variable) {
        return this.variables.get(variable) || 0;
    }
}

// Client code
const context = new Context();
context.setVariable("x", 10);
context.setVariable("y", 5);

// Create the expression tree: x + (y + 2)
const expression = new AddExpression(
    new NumberExpression(context.getVariable("x")),
    new AddExpression(
        new NumberExpression(context.getVariable("y")),
        new NumberExpression(2)
    )
);

const result = expression.interpret(context);
console.log("Result:", result);  // Output: Result: 17

/*
Result: 17
*/