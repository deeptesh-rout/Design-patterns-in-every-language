// Abstract Expression
interface Expression {
    fun interpret(): Int
}

// Terminal Expression
class NumberExpression(private val number: Int) : Expression {
    override fun interpret(): Int {
        return number
    }
}

// Non-terminal Expression
class AddExpression(private val leftExpression: Expression, private val rightExpression: Expression) : Expression {
    override fun interpret(): Int {
        return leftExpression.interpret() + rightExpression.interpret()
    }
}

// Context
class Context {
    private val variables: MutableMap<String, Int> = HashMap()

    fun setVariable(variable: String, value: Int) {
        variables[variable] = value
    }

    fun getVariable(variable: String): Int {
        return variables.getOrDefault(variable, 0)
    }
}

// Client code
fun main() {
    val context = Context()
    context.setVariable("x", 10)
    context.setVariable("y", 5)

    // Create the expression tree: x + (y + 2)
    val expression: Expression = AddExpression(
            NumberExpression(context.getVariable("x")),
            AddExpression(
                    NumberExpression(context.getVariable("y")),
                    NumberExpression(2)
            )
    )

    val result = expression.interpret()
    println("Result: $result")
}

/*
Result: 17
*/