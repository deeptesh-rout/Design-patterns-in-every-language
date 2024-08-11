#include <iostream>
#include <string>
#include <memory>

// Abstract base class for mail sender
class IMailSender {
public:
    virtual void sendMail(const std::string& toAddress, const std::string& fromAddress, const std::string& subject, const std::string& body) = 0;
    virtual ~IMailSender() {}
};

// Concrete implementation of mail sender using SMTP
class SmtpServer : public IMailSender {
public:
    void sendMail(const std::string& toAddress, const std::string& fromAddress, const std::string& subject, const std::string& body) override {
        std::cout << "Send mail: subject: " << subject << " from: " << fromAddress << " to: " << toAddress << " body: " << body << std::endl;
    }
};

// EmailSender class
class EmailSender {
private:
    std::shared_ptr<IMailSender> mailSender;

public:
    EmailSender(std::shared_ptr<IMailSender> mailSender) : mailSender(std::move(mailSender)) {}

    void sendEmail(const std::string& toAddress, const std::string& fromAddress, const std::string& subject, const std::string& body) {
        // Delegate email sending to the mail sender implementation
        mailSender->sendMail(toAddress, fromAddress, subject, body);
    }
};

// Client code
int main() {
    // Create an instance of the SmtpServer class
    std::shared_ptr<IMailSender> smtpServer = std::make_shared<SmtpServer>();

    // Create an instance of the EmailSender class and pass in the SmtpServer instance
    EmailSender emailSender(smtpServer);

    // Send an email using the EmailSender instance
    emailSender.sendEmail(
        "recipient@example.com",
        "sender@example.com",
        "mail subject.",
        "This is a test email body.");

    return 0;
}

/*
Send mail: subject: mail subject. from: sender@example.com to: recipient@example.com body: This is a test email body.
*/