class Student
    attr_reader :name

    def initialize(name)
        @name = name
    end

    def to_s
        "Student: #{@name}"
    end
end

class SchoolClass
    attr_reader :class_name, :students

    def initialize(class_name)
        @class_name = class_name
        @students = []
    end

    def add_student(student)
        @students << student
    end

    def display
        @students.each { |student| puts student }
    end
end

# Client code
school_class = SchoolClass.new("SS1")
student1 = Student.new("John Smith")
student2 = Student.new("Jane Smith")

school_class.add_student(student1)
school_class.add_student(student2)

school_class.display
