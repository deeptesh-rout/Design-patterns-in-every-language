using System;

public abstract class IMailSender
{
    public abstract void SendMail(string toAddress, string fromAddress, string subject, string body);
}

public class SmtpServer : IMailSender
{
    public override void SendMail(string toAddress, string fromAddress, string subject, string body)
    {
        Console.WriteLine($"Send mail: subject: {subject} from: {fromAddress} to: {toAddress} body: {body}");
    }
}

public class EmailSender
{
    private readonly IMailSender mailSender;

    public EmailSender(IMailSender mailSender)
    {
        this.mailSender = mailSender;
    }

    public void SendEmail(string toAddress, string fromAddress, string subject, string body)
    {
        // Delegate email sending to the mail sender implementation
        mailSender.SendMail(toAddress, fromAddress, subject, body);
    }
}

// Client code.
public class DependencyInversionPrinciple
{
    public static void Main(string[] args)
    {
        // Create an instance of the SmtpServer class
        SmtpServer smtpServer = new SmtpServer();

        // Create an instance of the EmailSender class and pass in the SmtpServer instance
        EmailSender emailSender = new EmailSender(smtpServer);

        // Send an email using the EmailSender instance
        emailSender.SendEmail(
            "recipient@example.com",
            "sender@example.com",
            "mail subject.",
            "This is a test email body.");
    }
}

/*
Send mail: subject: mail subject. from: sender@example.com to: recipient@example.com body: This is a test email body.
*/