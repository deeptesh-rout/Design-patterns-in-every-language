# Expression interface
class Expression
    def interpret(context)
        raise NotImplementedError, 'Subclasses must implement the interpret method'
    end
end

# Number class implementing Expression
class Number < Expression
    def initialize(value)
        @value = value
    end

    def interpret(_context)
        @value
    end
end

# Plus class implementing Expression
class Plus < Expression
    def initialize(left, right)
        @left = left
        @right = right
    end

    def interpret(context)
        @left.interpret(context) + @right.interpret(context)
    end
end

# Minus class implementing Expression
class Minus < Expression
    def initialize(left, right)
        @left = left
        @right = right
    end

    def interpret(context)
        @left.interpret(context) - @right.interpret(context)
    end
end

# Context class
class Context
    def initialize
        @variables = {}
    end

    def get_value(name)
        @variables[name] 
    end

    def set_value(name, value)
        @variables[name] = value
    end
end

def parse_expression(expression, context)
    if expression.include?('+')
        parts = expression.split(' + ', 2)
        Plus.new(parse_expression(parts[0], context), parse_expression(parts[1], context))
    elsif expression.include?('-')
        parts = expression.split(' - ', 2)
        Minus.new(parse_expression(parts[0], context), parse_expression(parts[1], context))
    elsif expression.match?(/\d+/)
        Number.new(expression.to_i)
    else
        Number.new(context.get_value(expression))
    end
end

# Client code
context = Context.new
context.set_value('x', 10)
context.set_value('y', 5)

expression = parse_expression('x + y + 2', context)
result = expression.interpret(context)
puts result

=begin 
17 
=end