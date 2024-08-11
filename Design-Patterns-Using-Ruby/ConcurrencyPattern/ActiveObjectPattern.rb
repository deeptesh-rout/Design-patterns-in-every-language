require 'thread'

# MethodRequest encapsulates a method call along with its arguments
class MethodRequest
    def initialize(&block)
        @block = block
    end

    def execute
        @block.call
    end
end

# ActiveObject encapsulates its own thread of control and executes methods asynchronously
class ActiveObject
    def initialize
        @queue = Queue.new
        @is_running = true
    end

    def run
        until !@is_running && @queue.empty?
        method_request = @queue.pop
        method_request.execute
        end
    end

    def schedule_method(&block)
        method_request = MethodRequest.new(&block)
        @queue.push(method_request)
    end

    def stop_thread
        @is_running = false
    end
end

# Proxy acts as a wrapper around the ActiveObject and forwards method calls to it
class Proxy
    def initialize(active_object)
        @active_object = active_object
    end

    def invoke_method(&block)
        @active_object.schedule_method(&block)
    end
end

# Client code
active_object = ActiveObject.new
proxy = Proxy.new(active_object)

# Start the ActiveObject thread
active_object_thread = Thread.new { active_object.run }

# Invoke methods on the Proxy
proxy.invoke_method { puts 'Hello' }
proxy.invoke_method { puts 'World' }

# Stop the ActiveObject thread
active_object.stop_thread
active_object_thread.join

=begin 
Hello
World
=end
