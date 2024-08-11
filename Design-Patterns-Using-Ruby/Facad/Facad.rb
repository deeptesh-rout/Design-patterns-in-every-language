# Subsystem1
class Subsystem1
    def operation1
        puts 'Subsystem1 operation1'
    end

    def operation2
        puts 'Subsystem1 operation2'
    end
end

# Subsystem2
class Subsystem2
    def operation1
        puts 'Subsystem2 operation1'
    end

    def operation2
        puts 'Subsystem2 operation2'
    end
end

# SystemManagerFacade
class SystemManagerFacade
    def initialize
        @subsystem1 = Subsystem1.new
        @subsystem2 = Subsystem2.new
    end

    def operation
        @subsystem1.operation1
        @subsystem1.operation2
        @subsystem2.operation1
        @subsystem2.operation2
    end
end

# Client code
facade = SystemManagerFacade.new
facade.operation

=begin 
Subsystem1 operation1
Subsystem1 operation2
Subsystem2 operation1
Subsystem2 operation2
=end