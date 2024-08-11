package main

import "fmt"

// IMailSender interface
type IMailSender interface {
	SendMail(toAddress, fromAddress, subject, body string)
}

// SmtpServer struct
type SmtpServer struct{}

// SendMail method for SmtpServer
func (s SmtpServer) SendMail(toAddress, fromAddress, subject, body string) {
	fmt.Printf("Send mail: subject: %s from: %s to: %s body: %s\n", subject, fromAddress, toAddress, body)
}

// EmailSender struct
type EmailSender struct {
	MailSender IMailSender
}

// SendEmail method for EmailSender
func (e EmailSender) SendEmail(toAddress, fromAddress, subject, body string) {
	// Delegate email sending to the mail sender implementation
	e.MailSender.SendMail(toAddress, fromAddress, subject, body)
}

// Client code
func main() {
	// Create an instance of the SmtpServer class
	smtpServer := SmtpServer{}

	// Create an instance of the EmailSender class and pass in the SmtpServer instance
	emailSender := EmailSender{MailSender: smtpServer}

	// Send an email using the EmailSender instance
	emailSender.SendEmail(
		"recipient@example.com",
		"sender@example.com",
		"mail subject.",
		"This is a test email body.",
	)
}

/*
Send mail: subject: mail subject. from: sender@example.com to: recipient@example.com body: This is a test email body.
*/