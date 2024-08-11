package main

import "fmt"

// IChatRoom interface
type IChatRoom interface {
	AddParticipant(participant *Participant)
	Broadcast(message, origin string)
	SendMessage(message, to string)
}

// ChatRoom struct implementing IChatRoom
type ChatRoom struct {
	participants map[string]*Participant
}

// AddParticipant adds a participant to the chat room
func (cr *ChatRoom) AddParticipant(participant *Participant) {
	cr.participants[participant.name] = participant
}

// Broadcast sends a message to all participants except the origin
func (cr *ChatRoom) Broadcast(message, origin string) {
	fmt.Printf("ChatRoom broadcast Message: %s\n", message)
	for name, p := range cr.participants {
		if name != origin {
			p.Receive(message)
		}
	}
}

// SendMessage sends a message from one participant to another
func (cr *ChatRoom) SendMessage(message, to string) {
	cr.participants[to].Receive(message)
}

// IParticipant interface
type IParticipant interface {
	Broadcast(message string)
	Send(message, to string)
	Receive(message string)
}

// Participant struct implementing IParticipant
type Participant struct {
	name     string
	chatRoom *ChatRoom
}

// NewParticipant creates a new participant and adds it to the chat room
func NewParticipant(name string, chatRoom *ChatRoom) *Participant {
	participant := &Participant{name: name, chatRoom: chatRoom}
	chatRoom.AddParticipant(participant)
	return participant
}

// Broadcast sends a message to all participants
func (p *Participant) Broadcast(message string) {
	fmt.Printf("%s broadcast Message: %s\n", p.name, message)
	p.chatRoom.Broadcast(message, p.name)
}

// Send sends a message from one participant to another
func (p *Participant) Send(message, to string) {
	fmt.Printf("%s sent Message: %s\n", p.name, message)
	p.chatRoom.SendMessage(message, to)
}

// Receive receives a message
func (p *Participant) Receive(message string) {
	fmt.Printf("%s received Message: %s\n", p.name, message)
}

// Client code
func main() {
	chatRoom := &ChatRoom{participants: make(map[string]*Participant)}
	James := NewParticipant("James", chatRoom)
	Michael := NewParticipant("Michael", chatRoom)
	NewParticipant("Robert", chatRoom)

	Michael.Send("Good Morning.", "James")
	James.Broadcast("Hello, World!")
}

/*
Michael sent Message: Good Morning.
James received Message: Good Morning.
James broadcast Message: Hello, World!
ChatRoom broadcast Message: Hello, World!
Michael received Message: Hello, World!
Robert received Message: Hello, World!
*/