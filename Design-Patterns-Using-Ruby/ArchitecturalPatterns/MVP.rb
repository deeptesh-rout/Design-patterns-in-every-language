# Model
class Model
    attr_accessor :data
  
    def initialize
        @data = 'Hello'
    end
  
    def data=(value)
        puts "Model: Set data: #{value}"
        @data = value
    end
  
    def data
        puts "Model: Get data: #{@data}"
        @data
    end
end
  
# View
class View
    def get_user_input
        puts 'View: getUserInput'
        puts 'View: Enter user input: '
        # user_input = gets.chomp
        user_input = 'Hello, World!'
        puts user_input
        user_input
    end

    def display_data(data)
        puts "View: Display Result: #{data}"
    end
end

# Presenter
class Presenter
    def initialize(model, view)
        @model = model
        @view = view
    end

    def on_button_click
        puts 'Presenter: onButtonClick.'
        data = @view.get_user_input
        @model.data = data
        data = @model.data
        @view.display_data(data)
    end
end

# Main
model = Model.new
view = View.new
presenter = Presenter.new(model, view)
presenter.on_button_click

=begin 
Presenter: onButtonClick.
View: getUserInput
View: Enter user input: 
Hello, World!
Model: Set data: Hello, World!
Model: Get data: Hello, World!
View: Display Result: Hello, World!
=end