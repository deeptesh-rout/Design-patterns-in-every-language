// Abstract Expression
interface Expression {
    fun interpret(): Int
}

// Number class implementing Expression
class Number(private val value: Int) : Expression {
    override fun interpret(): Int {
        return value
    }
}

// Plus class implementing Expression
class Plus(private val left: Expression, private val right: Expression) : Expression {
    override fun interpret(): Int {
        return left.interpret() + right.interpret()
    }
}

// Minus class implementing Expression
class Minus(private val left: Expression, private val right: Expression) : Expression {
    override fun interpret(): Int {
        return left.interpret() - right.interpret()
    }
}

// Context class
class Context {
    private val variables: MutableMap<String, Int> = HashMap()

    fun getValue(name: String): Int {
        return variables.getOrDefault(name, 0)
    }

    fun setValue(name: String, value: Int) {
        variables[name] = value
    }
}

fun parseExpression(expression: String, context: Context): Expression {
    return when {
        expression.matches("\\d+".toRegex()) -> Number(expression.toInt())
        "+" in expression -> {
            val (left, right) = expression.split(" + ", limit = 2)
            Plus(parseExpression(left, context), parseExpression(right, context))
        }
        "-" in expression -> {
            val (left, right) = expression.split(" - ", limit = 2)
            Minus(parseExpression(left, context), parseExpression(right, context))
        }
        else -> Number(context.getValue(expression))
    }
}

// Client Code
fun main() {
    val context = Context()
    context.setValue("x", 10)
    context.setValue("y", 5)

    val expression = parseExpression("x + y + 2", context)
    val result = expression.interpret()
    println(result)
}

/*
17 
*/