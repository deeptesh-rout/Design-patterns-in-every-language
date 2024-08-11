class ChatRoom
    def initialize
        @participants = {}
    end

    def add_participant(participant)
        @participants[participant.name] = participant
    end

    def broadcast(message, origin)
        puts "ChatRoom broadcast Message : #{message}"
        @participants.values.each do |p|
            p.receive(message) unless p.name == origin
        end
    end

    def send_message(message, to)
        @participants[to].receive(message)
    end
end

class Participant
    attr_reader :name, :chat_room

    def initialize(name, chat_room)
        @name = name
        @chat_room = chat_room
        chat_room.add_participant(self)
    end

    def broadcast(message)
        puts "#{name} broadcast Message : #{message}"
        chat_room.broadcast(message, name)
    end

    def send_message(message, to)
        puts "#{name} sent Message : #{message}"
        chat_room.send_message(message, to)
    end

    def receive(message)
        puts "#{name} received Message : #{message}"
    end
end

# Client code
chat_room = ChatRoom.new
james = Participant.new("James", chat_room)
michael = Participant.new("Michael", chat_room)
robert = Participant.new("Robert", chat_room)

michael.send_message("Good Morning.", "James")
james.broadcast("Hello, World!")

=begin 
Michael sent Message : Good Morning.
James received Message : Good Morning.
James broadcast Message : Hello, World!
ChatRoom broadcast Message : Hello, World!
Michael received Message : Hello, World!
Robert received Message : Hello, World!
=end