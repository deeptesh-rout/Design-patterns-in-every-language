// Abstract Expression
protocol Expression {
    func interpret() -> Int
}

// Terminal Expression
class NumberExpression: Expression {
    private var number: Int

    init(_ number: Int) {
        self.number = number
    }

    func interpret() -> Int {
        return number
    }
}

// Non-terminal Expression
class AddExpression: Expression {
    private var leftExpression: Expression
    private var rightExpression: Expression

    init(_ leftExpression: Expression, _ rightExpression: Expression) {
        self.leftExpression = leftExpression
        self.rightExpression = rightExpression
    }

    func interpret() -> Int {
        return leftExpression.interpret() + rightExpression.interpret()
    }
}

// Context
class Context {
    private var variables: [String: Int] = [:]

    func setVariable(_ variable: String, _ value: Int) {
        variables[variable] = value
    }

    func getVariable(_ variable: String) -> Int {
        return variables[variable] ?? 0
    }
}

// Client code
let context = Context()
context.setVariable("x", 10)
context.setVariable("y", 5)

// Create the expression tree: x + (y + 2)
let expression: Expression = AddExpression(
    NumberExpression(context.getVariable("x")),
    AddExpression(
        NumberExpression(context.getVariable("y")),
        NumberExpression(2)
    )
)

let result = expression.interpret()
print("Result: \(result)") 

/*
Result: 17
*/