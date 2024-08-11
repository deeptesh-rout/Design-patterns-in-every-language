// Abstract Expression
interface AbstractExpression {
    void interpret();
}

// Nonterminal Expression
class NonterminalExpression implements AbstractExpression {
    private AbstractExpression expression;

    public NonterminalExpression(AbstractExpression expression) {
        this.expression = expression;
    }

    @Override
    public void interpret() {
        System.out.println("NonTerminalExpression:interpret");
        expression.interpret();
    }
}

// Terminal Expression
class TerminalExpression implements AbstractExpression {
    @Override
    public void interpret() {
        System.out.println("TerminalExpression:interpret");
    }
}

// Client Code
public class InterpreterPattern {
    public static void main(String[] args) {
        AbstractExpression tree = new NonterminalExpression(new TerminalExpression());
        tree.interpret();
    }
}

/* 
NonTerminalExpression:interpret
TerminalExpression:interpret 
*/