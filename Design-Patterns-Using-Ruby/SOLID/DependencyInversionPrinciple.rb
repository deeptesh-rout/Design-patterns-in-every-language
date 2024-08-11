# Define the abstract IMailSender class
class IMailSender
    def send_mail(to_address, from_address, subject, body)
        raise NotImplementedError, 'Subclasses must implement the send_mail method'
    end
end

# Implement the SmtpServer class extending IMailSender
class SmtpServer < IMailSender
    def send_mail(to_address, from_address, subject, body)
        puts "Send mail: subject: #{subject} from: #{from_address} to: #{to_address} body: #{body}"
    end
end

# Implement the EmailSender class
class EmailSender
    def initialize(mail_sender)
        @mail_sender = mail_sender
    end

    def send_email(to_address, from_address, subject, body)
        # Delegate email sending to the mail sender implementation
        @mail_sender.send_mail(to_address, from_address, subject, body)
    end
end

# Client code
# Create an instance of the SmtpServer class
smtp_server = SmtpServer.new

# Create an instance of the EmailSender class and pass in the SmtpServer instance
email_sender = EmailSender.new(smtp_server)

# Send an email using the EmailSender instance
email_sender.send_email(
  'recipient@example.com',
  'sender@example.com',
  'mail subject.',
  'This is a test email body.'
)
=begin 
Send mail: subject: mail subject. from: sender@example.com to: recipient@example.com body: This is a test email body.
=end
