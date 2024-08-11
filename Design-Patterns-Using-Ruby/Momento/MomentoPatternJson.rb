require 'json'

class Memento
    attr_reader :state

    def initialize(state)
        @state = state
    end

    def clone
        Memento.new(JSON.parse(@state.to_json))
    end
end

class Originator
    attr_accessor :state

    def set_state(state)
        @state = state
    end

    def get_state
        @state
    end

    def create_memento
        Memento.new(JSON.parse(@state.to_json))
    end

    def set_memento(memento)
        @state = JSON.parse(memento.state.to_json)
    end
end

class CareTaker
    attr_reader :history, :top, :max

    def initialize
        @history = []
        @top = -1
        @max = -1
    end

    def add_memento(memento)
        @top += 1
        @max = @top

        if @top <= @history.size - 1
            @history[@top] = memento.clone
        else
            @history << memento.clone
        end
    end

    def get_memento(index)
        @history[index]
    end

    def undo
        puts 'Undoing state.'
        if @top <= 0
            @top = 0
            return get_memento(0)
        end

        @top -= 1
        get_memento(@top)
    end

    def redo
        puts 'Redoing state.'
        if @top >= (@history.size - 1) || @top >= @max
            return get_memento(@top)
        end

        @top += 1
        get_memento(@top)
    end

    def states_count
        @history.size
    end
end

# Client code
originator = Originator.new
care_taker = CareTaker.new

originator.set_state('State 1')
care_taker.add_memento(originator.create_memento)
puts originator.get_state

originator.set_state('State 2')
care_taker.add_memento(originator.create_memento)
puts originator.get_state

originator.set_state('State 3')
care_taker.add_memento(originator.create_memento)
puts originator.get_state

originator.set_memento(care_taker.undo)
puts originator.get_state

originator.set_memento(care_taker.undo)
puts originator.get_state

originator.set_state('State 4')
care_taker.add_memento(originator.create_memento)
puts originator.get_state

originator.set_memento(care_taker.redo)
puts originator.get_state

originator.set_memento(care_taker.redo)
puts originator.get_state

originator.set_memento(care_taker.redo)
puts originator.get_state
