using System;
using System.Collections.Generic;

// Abstract Expression
interface Expression {
    int Interpret();
}

// Terminal Expression
class NumberExpression : Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    public int Interpret() {
        return number;
    }
}

// Non-terminal Expression
class AddExpression : Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public AddExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public int Interpret() {
        return leftExpression.Interpret() + rightExpression.Interpret();
    }
}

// Context
class Context {
    private Dictionary<string, int> variables = new Dictionary<string, int>();

    public void SetVariable(string variable, int value) {
        variables[variable] = value;
    }

    public int GetVariable(string variable) {
        return variables.TryGetValue(variable, out var value) ? value : 0;
    }
}

// Client code
class InterpreterPattern2 {
    static void Main(string[] args) {
        Context context = new Context();
        context.SetVariable("x", 10);
        context.SetVariable("y", 5);

        // Create the expression tree: x + (y + 2)
        Expression expression = new AddExpression(
            new NumberExpression(context.GetVariable("x")),
            new AddExpression(
                new NumberExpression(context.GetVariable("y")),
                new NumberExpression(2)
            )
        );

        int result = expression.Interpret();
        Console.WriteLine("Result: " + result);  // Output: Result: 17
    }
}

/*
Result: 17
*/