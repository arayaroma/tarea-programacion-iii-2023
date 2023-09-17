package cr.ac.una.services;

import cr.ac.una.util.Constants;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

/**
 * 
 * @author arayaroma
 */
@Stateless
public class EmailService {

    @Resource(name = "mail/EvaComMailSession")
    private Session mailSession;

    private void sendEmail(String to, String subject, String body) throws MessagingException {
        try {
            Message message = new MimeMessage(mailSession);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(body, "text/html");
            mailSession.getProperties().setProperty("mail.smtp.user", Constants.MAIL_USER);
            mailSession.getProperties().setProperty("mail.smtp.password", Constants.MAIL_PASSWORD);
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new MessagingException("Failed to send email: " + e.getMessage(), e);
        }
    }

    public void sendActivationHashLink(String to, String subject, String body) throws MessagingException {
        sendEmail(to, subject, body);
    }

    public void sendActivatedUserEmail(String to, String subject, String body) throws MessagingException {
        sendEmail(to, subject, body);
    }
}