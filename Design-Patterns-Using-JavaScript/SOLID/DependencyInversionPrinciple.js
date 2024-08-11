class IMailSender {
    sendMail(toAddress, fromAddress, subject, body) {
        // Abstract method, to be implemented by subclasses
    }
}

class SmtpServer extends IMailSender {
    sendMail(toAddress, fromAddress, subject, body) {
        console.log(`Send mail: subject: ${subject} from: ${fromAddress} to: ${toAddress} body: ${body}`);
    }
}

class EmailSender {
    constructor(mailSender) {
        this.mailSender = mailSender;
    }

    sendEmail(toAddress, fromAddress, subject, body) {
        // Delegate email sending to the mail sender implementation
        this.mailSender.sendMail(toAddress, fromAddress, subject, body);
    }
}

// Client code.
const smtpServer = new SmtpServer();
const emailSender = new EmailSender(smtpServer);

// Send an email using the EmailSender instance
emailSender.sendEmail(
    "recipient@example.com",
    "sender@example.com",
    "mail subject.",
    "This is a test email body."
);

/*
Send mail: subject: mail subject. from: sender@example.com to: recipient@example.com body: This is a test email body.
*/
