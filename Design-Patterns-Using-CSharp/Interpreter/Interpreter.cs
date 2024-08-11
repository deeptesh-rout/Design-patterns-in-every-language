using System;
using System.Collections.Generic;

// Expression interface
interface Expression
{
    int Interpret();
}

// Number class implementing Expression
class Number : Expression
{
    private int value;

    public Number(int value)
    {
        this.value = value;
    }

    public int Interpret()
    {
        return value;
    }
}

// Plus class implementing Expression
class Plus : Expression
{
    private Expression left;
    private Expression right;

    public Plus(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    public int Interpret()
    {
        return left.Interpret() + right.Interpret();
    }
}

// Minus class implementing Expression
class Minus : Expression
{
    private Expression left;
    private Expression right;

    public Minus(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    public int Interpret()
    {
        return left.Interpret() - right.Interpret();
    }
}

// Context class
class Context
{
    private Dictionary<string, int> variables = new Dictionary<string, int>();

    public int GetValue(string name)
    {
        return variables.TryGetValue(name, out int value) ? value : 0;
    }

    public void SetValue(string name, int value)
    {
        variables[name] = value;
    }
}

class Interpreter
{
    public static Expression ParseExpression(string expression, Context context)
    {
        expression = expression.Trim();
        if (int.TryParse(expression, out int numericValue))
        {
            return new Number(numericValue);
        }
        else if (expression.Contains("+"))
        {
            string[] parts = expression.Split(new string[] { "+" }, 2, StringSplitOptions.None);
            return new Plus(ParseExpression(parts[0], context), ParseExpression(parts[1], context));
        }
        else if (expression.Contains("-"))
        {
            string[] parts = expression.Split(new string[] { "-" }, 2, StringSplitOptions.None);
            return new Minus(ParseExpression(parts[0], context), ParseExpression(parts[1], context));
        }
        else
        {
            return new Number(context.GetValue(expression));
        }
    }

    public static void Main()
    {
        Context context = new Context();
        context.SetValue("x", 10);
        context.SetValue("y", 5);

        Expression expression = ParseExpression("x + y + 2", context);
        int result = expression.Interpret();
        Console.WriteLine(result);
    }
}
