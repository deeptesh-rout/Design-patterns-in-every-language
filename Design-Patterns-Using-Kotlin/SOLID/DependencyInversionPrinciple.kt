
abstract class IMailSender {
    abstract fun sendMail(toAddress: String, fromAddress: String, subject: String, body: String)
}

class SmtpServer : IMailSender() {
    override fun sendMail(toAddress: String, fromAddress: String, subject: String, body: String) {
        println("Send mail: subject: $subject from: $fromAddress to: $toAddress body: $body")
    }
}

class EmailSender(private val mailSender: IMailSender) {
    fun sendEmail(toAddress: String, fromAddress: String, subject: String, body: String) {
        // Delegate email sending to the mail sender implementation
        mailSender.sendMail(toAddress, fromAddress, subject, body)
    }
}

// Client code.
fun main() {
    // Create an instance of the SmtpServer class
    val smtpServer = SmtpServer()

    // Create an instance of the EmailSender class and pass in the SmtpServer instance
    val emailSender = EmailSender(smtpServer)

    // Send an email using the EmailSender instance
    emailSender.sendEmail(
        "recipient@example.com",
        "sender@example.com",
        "mail subject.",
        "This is a test email body."
    )
}
/*
Send mail: subject: mail subject. from: sender@example.com to: recipient@example.com body: This is a test email body.
*/