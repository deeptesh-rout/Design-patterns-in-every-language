using System;

// Abstract Expression
interface AbstractExpression {
    void Interpret();
}

// Nonterminal Expression
class NonterminalExpression : AbstractExpression {
    private AbstractExpression expression;

    public NonterminalExpression(AbstractExpression expression) {
        this.expression = expression;
    }

    public void Interpret() {
        Console.WriteLine("NonTerminalExpression:Interpret");
        expression.Interpret();
    }
}

// Terminal Expression
class TerminalExpression : AbstractExpression {
    public void Interpret() {
        Console.WriteLine("TerminalExpression:Interpret");
    }
}

// Client Code
class InterpreterPattern {
    static void Main(string[] args) {
        AbstractExpression tree = new NonterminalExpression(new TerminalExpression());
        tree.Interpret();
    }
}

/*
NonTerminalExpression:Interpret
TerminalExpression:Interpret
*/
