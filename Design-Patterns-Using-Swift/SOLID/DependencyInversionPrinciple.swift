import Foundation

protocol MailSender {
    func sendMail(toAddress: String, fromAddress: String, subject: String, body: String)
}

class SmtpServer: MailSender {
    func sendMail(toAddress: String, fromAddress: String, subject: String, body: String) {
        print("Send mail: subject: \(subject) from: \(fromAddress) to: \(toAddress) body: \(body)")
    }
}

class EmailSender {
    private let mailSender: MailSender

    init(mailSender: MailSender) {
        self.mailSender = mailSender
    }

    func sendEmail(toAddress: String, fromAddress: String, subject: String, body: String) {
        // Delegate email sending to the mail sender implementation
        mailSender.sendMail(toAddress: toAddress, fromAddress: fromAddress, subject: subject, body: body)
    }
}

// Client code.
let smtpServer = SmtpServer()
let emailSender = EmailSender(mailSender: smtpServer)

emailSender.sendEmail(
    toAddress: "recipient@example.com",
    fromAddress: "sender@example.com",
    subject: "mail subject.",
    body: "This is a test email body."
)

/*
Send mail: subject: mail subject. from: sender@example.com to: recipient@example.com body: This is a test email body.
*/
