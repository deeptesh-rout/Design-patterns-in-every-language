# Subject interface
module Subject
    def request
        raise NotImplementedError, "Subclasses must implement the 'request' method"
    end
end

# RealSubject class
class RealSubject
    include Subject

    def request
        puts 'Concrete Subject Request Method'
    end
end

# Proxy class
class Proxy
    include Subject

    def request
        @real_subject ||= RealSubject.new # Lazy Initialization
        @real_subject.request
    end
end

# Client code
proxy = Proxy.new
proxy.request

=begin 
Concrete Subject Request Method
=end