package cr.ac.una.services;

import java.io.IOException;

import cr.ac.una.dto.UserDto;
import cr.ac.una.util.Constants;
import cr.ac.una.util.HtmlFileReader;
import cr.ac.una.util.LinkGenerator;
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

    public void sendActivationHashLink(UserDto to) throws MessagingException {
        try {
            String subject = "Complete your account registration";
            String link = LinkGenerator.generateActivationLink(to.getId(), to.getActivationCode());
            sendEmail(
                    to.getEmail(),
                    subject,
                    HtmlFileReader.readEmailTemplate(
                            subject,
                            "Welcome to " + Constants.COMPANY_NAME + "!",
                            to.getName(),
                            "Please <a href=" + link + "> Activate account!</a>",
                            "Thank you for registering with us!"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new MessagingException("Failed to send email: " + e.getMessage(), e);
        }
    }

    public void sendActivatedUserEmail(UserDto to) throws MessagingException {
        try {
            String subject = "Account activated successfully";
            sendEmail(
                    to.getEmail(),
                    subject,
                    HtmlFileReader.readEmailTemplate(
                            subject,
                            "We're glad to hear from you again, ",
                            to.getName(),
                            "Feel free to explore our application and enjoy!",
                            "Thank you for choosing us!"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessagingException("Failed to send email: " + e.getMessage(), e);
        }
    }
}