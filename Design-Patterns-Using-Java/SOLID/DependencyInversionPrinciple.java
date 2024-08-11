import java.util.Objects;

abstract class IMailSender {
    abstract void sendMail(String toAddress, String fromAddress, String subject, String body);
}

class SmtpServer extends IMailSender {
    @Override
    void sendMail(String toAddress, String fromAddress, String subject, String body) {
        System.out.printf("Send mail: subject: %s from: %s to: %s body: %s%n", subject, fromAddress, toAddress, body);
    }
}

class EmailSender {
    private final IMailSender mailSender;

    public EmailSender(IMailSender mailSender) {
        this.mailSender = Objects.requireNonNull(mailSender);
    }

    public void sendEmail(String toAddress, String fromAddress, String subject, String body) {
        // Delegate email sending to the mail sender implementation
        mailSender.sendMail(toAddress, fromAddress, subject, body);
    }
}

// Client code.
public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        // Create an instance of the SmtpServer class
        SmtpServer smtpServer = new SmtpServer();

        // Create an instance of the EmailSender class and pass in the SmtpServer instance
        EmailSender emailSender = new EmailSender(smtpServer);

        // Send an email using the EmailSender instance
        emailSender.sendEmail(
                "recipient@example.com",
                "sender@example.com",
                "mail subject.",
                "This is a test email body.");
    }
}

/*
Send mail: subject: mail subject. from: sender@example.com to: recipient@example.com body: This is a test email body.
*/