// Abstract Expression
interface AbstractExpression {
    fun interpret()
}

// Nonterminal Expression
class NonterminalExpression(private val expression: AbstractExpression) : AbstractExpression {
    override fun interpret() {
        println("NonTerminalExpression:interpret")
        expression.interpret()
    }
}

// Terminal Expression
class TerminalExpression : AbstractExpression {
    override fun interpret() {
        println("TerminalExpression:interpret")
    }
}

// Client Code
fun main() {
    val tree: AbstractExpression = NonterminalExpression(TerminalExpression())
    tree.interpret()
}

/*
NonTerminalExpression:interpret
TerminalExpression:interpret 
*/