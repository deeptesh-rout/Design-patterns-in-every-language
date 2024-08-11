// Expression interface
class Expression {
    interpret(context) { }
}

// Number class implementing Expression
class NumberExpression extends Expression {
    constructor(value) {
        super();
        this.value = value;
    }

    interpret(context) {
        return this.value;
    }
}

// Plus class implementing Expression
class PlusExpression extends Expression {
    constructor(left, right) {
        super();
        this.left = left;
        this.right = right;
    }

    interpret(context) {
        return this.left.interpret(context) + this.right.interpret(context);
    }
}

// Minus class implementing Expression
class MinusExpression extends Expression {
    constructor(left, right) {
        super();
        this.left = left;
        this.right = right;
    }

    interpret(context) {
        return this.left.interpret(context) - this.right.interpret(context);
    }
}

// Context class
class Context {
    constructor() {
        this.variables = new Map();
    }

    getValue(name) {
        return this.variables.get(name) || 0;
    }

    setValue(name, value) {
        this.variables.set(name, value);
    }
}

// Interpreter class
class Interpreter {
    static parseExpression(expression, context) {
        if (/^\d+$/.test(expression)) {
            return new NumberExpression(parseInt(expression));
        } else if (expression.includes("+")) {
            const index = expression.indexOf(' + ');
            const left = expression.substring(0, index);
            const right = expression.substring(index + 3);
            return new PlusExpression(
                Interpreter.parseExpression(left, context),
                Interpreter.parseExpression(right, context)
            );
        } else if (expression.includes("-")) {
            const index = expression.indexOf(' - ');
            const left = expression.substring(0, index);
            const right = expression.substring(index + 3);
            return new MinusExpression(
                Interpreter.parseExpression(left, context),
                Interpreter.parseExpression(right, context)
            );
        } else {
            return new NumberExpression(context.getValue(expression));
        }
    }
}

// Client code
const context = new Context();
context.setValue("x", 10);
context.setValue("y", 5);

const expression = Interpreter.parseExpression("x + y + 2", context);
const result = expression.interpret(context);
console.log(result);

/*
17
*/