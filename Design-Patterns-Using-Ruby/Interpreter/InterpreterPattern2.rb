# Abstract Expression
class Expression
    def interpret
        raise NotImplementedError, 'Subclasses must implement the interpret method'
    end
end

# Terminal Expression
class NumberExpression < Expression
    def initialize(number)
        @number = number
    end

    def interpret
        @number
    end
end

# Non-terminal Expression
class AddExpression < Expression
    def initialize(left_expression, right_expression)
        @left_expression = left_expression
        @right_expression = right_expression
    end

    def interpret
        @left_expression.interpret + @right_expression.interpret
    end
end

# Context
class Context
    def initialize
        @variables = {}
    end

    def set_variable(variable, value)
        @variables[variable] = value
    end

    def get_variable(variable)
        @variables[variable] || 0
    end
end

# Client code
context = Context.new
context.set_variable('x', 10)
context.set_variable('y', 5)

# Create the expression tree: x + (y + 2)
expression = AddExpression.new(
    NumberExpression.new(context.get_variable('x')),
    AddExpression.new(
    NumberExpression.new(context.get_variable('y')),
    NumberExpression.new(2)
    )
)

# Client code
result = expression.interpret
puts "Result: #{result}" 

=begin 
Result: 17
=end