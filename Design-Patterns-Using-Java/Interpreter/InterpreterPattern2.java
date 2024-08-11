import java.util.HashMap;
import java.util.Map;

// Abstract Expression
interface Expression {
    int interpret();
}

// Terminal Expression
class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

// Non-terminal Expression
class AddExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public AddExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}

// Context
class Context {
    private Map<String, Integer> variables = new HashMap<>();

    public void setVariable(String variable, int value) {
        variables.put(variable, value);
    }

    public int getVariable(String variable) {
        return variables.getOrDefault(variable, 0);
    }
}

// Client code
public class InterpreterPattern2 {
    public static void main(String[] args) {
        Context context = new Context();
        context.setVariable("x", 10);
        context.setVariable("y", 5);

        // Create the expression tree: x + (y + 2)
        Expression expression = new AddExpression(
                new NumberExpression(context.getVariable("x")),
                new AddExpression(
                        new NumberExpression(context.getVariable("y")),
                        new NumberExpression(2)
                )
        );

        int result = expression.interpret();
        System.out.println("Result: " + result);  // Output: Result: 17
    }
}

// Result: 17

