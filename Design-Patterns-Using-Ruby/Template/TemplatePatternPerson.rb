# Define AbstractWorker
class AbstractWorker
    def daily_routine
        wake_up
        eat_breakfast
        go_to_work
        work
        come_back_home
        eat_dinner
        sleep
    end

    def wake_up
        puts 'Wake Up'
    end

    def eat_breakfast
        puts 'Eat Breakfast'
    end

    def go_to_work
        puts 'Go to work'
    end

    def work
        raise NotImplementedError, 'Subclasses must implement the work method'
    end

    def come_back_home
        puts 'Come back Home'
    end

    def eat_dinner
        puts 'Eat dinner'
    end

    def sleep
        puts 'Sleep'
    end
end

# Define Doctor extending AbstractWorker
class Doctor < AbstractWorker
    def work
        puts '...Treat Patients...'
    end
end

# Define FireFighter extending AbstractWorker
class FireFighter < AbstractWorker
    def work
        puts '...Fight Fire...'
    end
end

# Define SuperHero extending AbstractWorker
class SuperHero < AbstractWorker
    def work
        puts '...Save the world!...'
    end
end

# Client code
doctor = Doctor.new
doctor.daily_routine
puts

fire_fighter = FireFighter.new
fire_fighter.daily_routine
puts

super_hero = SuperHero.new
super_hero.daily_routine
=begin 
Wake Up
Eat Breakfast
Go to work
...Treat Patients...
Come back Home
Eat dinner
Sleep

Wake Up
Eat Breakfast
Go to work
...Fight Fire...
Come back Home
Eat dinner
Sleep

Wake Up
Eat Breakfast
Go to work
...Save the world!...
Come back Home
Eat dinner
Sleep
=end