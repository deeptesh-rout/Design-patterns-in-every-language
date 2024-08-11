import java.util.HashMap;
import java.util.Map;

// Expression interface
interface Expression {
    int interpret();
}

// Number class implementing Expression
class Number implements Expression {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}

// Plus class implementing Expression
class Plus implements Expression {
    private Expression left;
    private Expression right;

    public Plus(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

// Minus class implementing Expression
class Minus implements Expression {
    private Expression left;
    private Expression right;

    public Minus(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

// Context class
class Context {
    private Map<String, Integer> variables = new HashMap<>();

    public int getValue(String name) {
        return variables.getOrDefault(name, 0);
    }

    public void setValue(String name, int value) {
        variables.put(name, value);
    }
}

public class Interpreter {
    public static Expression parseExpression(String expression, Context context) {
        if (expression.matches("\\d+")) {
            return new Number(Integer.parseInt(expression));
        } else if (expression.contains("+")) {
            String[] parts = expression.split(" \\+ ", 2);
            return new Plus(parseExpression(parts[0], context), parseExpression(parts[1], context));
        } else if (expression.contains("-")) {
            String[] parts = expression.split(" - ", 2);
            return new Minus(parseExpression(parts[0], context), parseExpression(parts[1], context));
        } else {
            return new Number(context.getValue(expression));
        }
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.setValue("x", 10);
        context.setValue("y", 5);

        Expression expression = parseExpression("x + y + 2", context);
        int result = expression.interpret();
        System.out.println(result);
    }
}
// 17
