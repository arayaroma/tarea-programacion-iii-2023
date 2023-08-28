package cr.ac.una.services;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import static cr.ac.una.util.Constants.MAIL_USER;
import static cr.ac.una.util.Constants.MAIL_PASSWORD;

@Stateless
public class EmailService {
    @Resource(name = "mail/EvaComMailSession")
    private Session mailSession;

    public void sendRegistrationEmail(String to, String subject, String body) throws MessagingException {
        try {
            Message message = new MimeMessage(mailSession);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(body, "text/html");
            mailSession.getProperties().setProperty("mail.smtp.user", MAIL_USER);
            mailSession.getProperties().setProperty("mail.smtp.password", MAIL_PASSWORD);

            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new MessagingException("Failed to send email: " + e.getMessage(), e);
        }
    }
}