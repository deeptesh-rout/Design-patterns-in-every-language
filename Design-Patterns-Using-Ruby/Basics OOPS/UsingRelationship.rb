class A
    def initialize
        puts "A created"
    end
  
    def fun1
      puts "fun1"
    end
end

class B
    def initialize
        puts "B created"
    end
  
    def fun2
        puts "fun2 start"
        A.new.fun1
        puts "fun2 end"
    end
end
  
# Client code
b = B.new
b.fun2
