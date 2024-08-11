interface IChatRoom {
    fun addParticipant(participant: IParticipant)
    fun broadcast(message: String, origin: String)
    fun sendMessage(message: String, to: String)
}

class ChatRoom : IChatRoom {
    private val participants: MutableMap<String, IParticipant> = HashMap()

    override fun addParticipant(participant: IParticipant) {
        participants[participant.name] = participant
    }

    override fun broadcast(message: String, origin: String) {
        println("ChatRoom broadcast Message : $message")
        participants.values.stream()
                .filter { p: IParticipant -> p.name != origin }
                .forEach { p: IParticipant -> p.receive(message) }
    }

    override fun sendMessage(message: String, to: String) {
        participants[to]!!.receive(message)
    }
}

interface IParticipant {
    val name: String
    fun broadcast(message: String)
    fun send(message: String, to: String)
    fun receive(message: String)
}

class Participant(override val name: String, private val chatRoom: IChatRoom) : IParticipant {
    init {
        chatRoom.addParticipant(this)
    }

    override fun broadcast(message: String) {
        println("$name broadcast Message : $message")
        chatRoom.broadcast(message, name)
    }

    override fun send(message: String, to: String) {
        println("$name sent Message : $message")
        chatRoom.sendMessage(message, to)
    }

    override fun receive(message: String) {
        println("$name received Message : $message")
    }
}

// Client Code
fun main() {
    val chatRoom = ChatRoom()
    val james = Participant("James", chatRoom)
    val michael = Participant("Michael", chatRoom)
    Participant("Robert", chatRoom)

    michael.send("Good Morning.", "James")
    james.broadcast("Hello, World!")
}

/*
Michael sent Message : Good Morning.
James received Message : Good Morning.
James broadcast Message : Hello, World!
ChatRoom broadcast Message : Hello, World!
Robert received Message : Hello, World!
Michael received Message : Hello, World!
*/