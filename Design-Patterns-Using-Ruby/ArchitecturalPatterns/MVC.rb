# Model
class Model
    attr_accessor :data

    def initialize
        @data = nil
        @observers = []
    end

    def data=(value)
        puts 'Model : Set data.'
        @data = value
        notify_observers
    end

    def add_observer(observer)
        @observers << observer
    end

    def remove_observer(observer)
        @observers.delete(observer)
    end

    def notify_observers
        puts 'Model : Notify observers.'
        @observers.each(&:update)
    end
end

# View
class View
    def initialize(model, controller)
        @model = model
        @controller = controller
        @model.add_observer(self)
    end

    def update
        puts 'View : Update.'
        data = @model.data
        puts "Data: #{data}"
    end

    def get_user_input
        print 'View : Enter user input: '
        # user_input = gets.chomp
        user_input = 'Hello, World!'
        puts user_input
        @controller.handle_user_input(user_input)
    end
end

# Controller
class Controller
    def initialize(model)
        @model = model
    end

    def handle_user_input(user_input)
        puts 'Controller : Handle user input.'
        @model.data = user_input
    end

    def set_view(view)
        @view = view
    end
end

# Main
model = Model.new
controller = Controller.new(model)
view = View.new(model, controller)
controller.set_view(view)
view.get_user_input

=begin 
View : Enter user input: Hello, World!
Controller : Handle user input.
Model : Set data.
Model : Notify observers.
View : Update.
Data: Hello, World! 
=end