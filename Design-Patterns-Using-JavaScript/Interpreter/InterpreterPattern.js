// Abstract Expression
class AbstractExpression {
    interpret() { }
}

// Nonterminal Expression
class NonterminalExpression extends AbstractExpression {
    constructor(expression) {
        super();
        this.expression = expression;
    }

    interpret() {
        console.log("NonTerminalExpression:interpret");
        this.expression.interpret();
    }
}

// Terminal Expression
class TerminalExpression extends AbstractExpression {
    interpret() {
        console.log("TerminalExpression:interpret");
    }
}

// Client Code
const tree = new NonterminalExpression(new TerminalExpression());
tree.interpret();

/*
NonTerminalExpression:interpret
TerminalExpression:interpret
*/