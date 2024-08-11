# Model
class Model
    attr_accessor :data

    def initialize
        @data = 'Default.'
    end

    def data=(value)
        puts 'Model: Set data.'
        @data = value
    end

    def data
        puts 'Model: Get data.'
        @data
    end
end

# ViewModel
class ViewModel
    attr_reader :model

    def initialize(model)
        @model = model
    end

    def data=(value)
        puts 'ViewModel: Set data.'
        model.data = value
    end

    def data
        puts 'ViewModel: Get data.'
        model.data
    end
end

# View
class View
    attr_reader :view_model

    def initialize(view_model)
        @view_model = view_model
    end

    def display_data
        puts "Display Data: #{view_model.data}"
    end

    def get_user_input
        puts 'View: Enter user input: '
        # user_input = gets.chomp
        user_input = 'Hello, World!'
        puts user_input
        view_model.data = user_input
    end
end

# Main
model = Model.new
view_model = ViewModel.new(model)
view = View.new(view_model)

# Display initial data
view.display_data

# Get user input and update data
view.get_user_input

# Display updated data
view.display_data

=begin 
ViewModel: Get data.
Model: Get data.
Display Data: Default.
View: Enter user input: 
hello, world!
ViewModel: Set data.
Model: Set data.
ViewModel: Get data.
Model: Get data.
Display Data: hello, world!
=end