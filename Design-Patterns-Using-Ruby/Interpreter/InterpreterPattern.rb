# Abstract Expression
class AbstractExpression
    def interpret
        raise NotImplementedError, 'Subclasses must implement the interpret method'
    end
end

# Nonterminal Expression
class NonterminalExpression < AbstractExpression
    def initialize(expression)
        @expression = expression
    end

    def interpret
        puts 'NonTerminalExpression:interpret'
        @expression.interpret
    end
end

# Terminal Expression
class TerminalExpression < AbstractExpression
    def interpret
        puts 'TerminalExpression:interpret'
    end
end

# Client Code
tree = NonterminalExpression.new(TerminalExpression.new)
tree.interpret

=begin 
NonTerminalExpression:interpret
TerminalExpression:interpret
=end