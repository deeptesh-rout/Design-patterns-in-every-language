class ThreadLocalVariable
    THREAD_LOCAL_VAR = :my_thread_local_var

    def self.set_thread_local_value(value)
        Thread.current[THREAD_LOCAL_VAR] = value
    end

    def self.get_thread_local_value
        Thread.current[THREAD_LOCAL_VAR]
    end
end

# Client code
# Create and start three threads
threads = []

threads << Thread.new do
    ThreadLocalVariable.set_thread_local_value("Thread 1 Value")
    puts "Thread 1: #{ThreadLocalVariable.get_thread_local_value}"
end

threads << Thread.new do
    ThreadLocalVariable.set_thread_local_value("Thread 2 Value")
    puts "Thread 2: #{ThreadLocalVariable.get_thread_local_value}"
end

threads << Thread.new do
    ThreadLocalVariable.set_thread_local_value("Thread 3 Value")
    puts "Thread 3: #{ThreadLocalVariable.get_thread_local_value}"
end

# Wait for all threads to complete
threads.each(&:join)

=begin 
Thread 1: Thread 1 Value
Thread 2: Thread 2 Value
Thread 3: Thread 3 Value
=end
