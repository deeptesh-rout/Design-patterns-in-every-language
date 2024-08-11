# Observer interface
module Observer
    def notify(subject, message)
        raise NotImplementedError, 'Subclasses must implement the notify method'
    end
end

# Courses class
class Courses
    def initialize
        @course_students = Hash.new { |hash, key| hash[key] = Set.new }
    end

    def subscribe(subject, student)
        @course_students[subject] << student
    end

    def unsubscribe(subject, student)
        @course_students[subject].delete(student)
    end

    def publish(subject, message)
        return puts("No subscribers for subject '#{subject}'.") unless @course_students.key?(subject)

        @course_students[subject].each do |student|
            student.notify(subject, message)
        end
    end
end

# Student class
class Student
    include Observer

    attr_reader :name

    def initialize(name)
        @name = name
    end

    def notify(subject, message)
        puts "#{name} received message on subject '#{subject}': #{message}"
    end
end

# Client code
courses = Courses.new
john = Student.new('John')
eric = Student.new('Eric')
jack = Student.new('Jack')

courses.subscribe('English', john)
courses.subscribe('English', eric)
courses.subscribe('Maths', eric)
courses.subscribe('Science', jack)

courses.publish('English', 'Tomorrow class at 11')
courses.publish('Maths', 'Tomorrow class at 1')

# Unsubscribe Eric from English
courses.unsubscribe('English', eric)

courses.publish('English', 'Tomorrow class at 3')

=begin 
John received message on subject 'English': Tomorrow class at 11
Eric received message on subject 'English': Tomorrow class at 11
Eric received message on subject 'Maths': Tomorrow class at 1
John received message on subject 'English': Tomorrow class at 3
=end
