require 'thread'

class Barrier
    def initialize(count)
        @count = count
        @mutex = Mutex.new
        @condition = ConditionVariable.new
    end

    def wait_barrier
        @mutex.synchronize do
            @count -= 1
            if @count > 0
                @condition.wait(@mutex)
            else
                @condition.broadcast
            end
        end
    end
end

class Worker
    def initialize(barrier, id)
        @barrier = barrier
        @id = id
    end

    def run
        puts "Worker #{@id} started"
        # Simulating some work
        3.times do
            puts "Worker #{@id} working..."
            # Simulating some computation
        end
        puts "Worker #{@id} finished"
        @barrier.wait_barrier
    end
end

# Client code
num_workers = 3
barrier = Barrier.new(num_workers)
threads = []

num_workers.times do |i|
  worker = Worker.new(barrier, i)
  threads << Thread.new { worker.run }
end

threads.each(&:join)

puts "All workers finished. Proceeding to the next step."

=begin 
Worker 0 started
Worker 0 working...
Worker 0 working...
Worker 0 working...
Worker 0 finished
Worker 1 started
Worker 1 working...
Worker 1 working...
Worker 1 working...
Worker 1 finished
Worker 2 started
Worker 2 working...
Worker 2 working...
Worker 2 working...
Worker 2 finished
All workers finished. Proceeding to the next step.
=end
