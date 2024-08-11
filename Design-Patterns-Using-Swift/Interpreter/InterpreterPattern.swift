// Abstract Expression
protocol AbstractExpression {
    func interpret()
}

// Nonterminal Expression
class NonterminalExpression: AbstractExpression {
    private let expression: AbstractExpression

    init(_ expression: AbstractExpression) {
        self.expression = expression
    }

    func interpret() {
        print("NonTerminalExpression:interpret")
        expression.interpret()
    }
}

// Terminal Expression
class TerminalExpression: AbstractExpression {
    func interpret() {
        print("TerminalExpression:interpret")
    }
}

// Client Code
let tree: AbstractExpression = NonterminalExpression(TerminalExpression())
tree.interpret()

/*
NonTerminalExpression:interpret
TerminalExpression:interpret
*/