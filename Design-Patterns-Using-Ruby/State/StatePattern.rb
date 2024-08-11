# Define BulbState interface
module BulbState
    def flip(bc)
        raise NotImplementedError, 'Subclasses must implement the flip method'
    end

    def to_s
        raise NotImplementedError, 'Subclasses must implement the to_s method'
    end
end

# Define BulbControl class
class BulbControl
    attr_accessor :current

    def initialize
        @current = Off.new
    end

    def set_state(state)
        @current = state
    end

    def flip
        @current.flip(self)
    end

    def to_s_state
        @current.to_s
    end
end

# Define On class implementing BulbState
class On
    include BulbState

    def flip(bc)
        bc.set_state(Off.new)
    end

    def to_s
        'On'
    end
end

# Define Off class implementing BulbState
class Off
    include BulbState

    def flip(bc)
        bc.set_state(On.new)
    end

    def to_s
        'Off'
    end
end

# Client code
c = BulbControl.new
c.flip
puts c.to_s_state
c.flip
puts c.to_s_state

=begin 
On
Off
=end