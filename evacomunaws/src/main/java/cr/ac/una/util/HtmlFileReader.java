package cr.ac.una.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static cr.ac.una.util.Constants.COMPANY_NAME;
import static cr.ac.una.util.PlaceHolders.*;

public class HtmlFileReader {
    public static String readHtml(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static String readRegistrationTemplate(String name, String username, String email) throws IOException {
        try (InputStream inputStream = HtmlFileReader.class.getResourceAsStream("/templates/registration.html")) {
            if (inputStream != null) {
                String template = new String(inputStream.readAllBytes());
                String emailContent = template
                        .replace(NAME_PLACEHOLDER, name)
                        .replace(USERNAME_PLACEHOLDER, username)
                        .replace(EMAIL_PLACEHOLDER, email)
                        .replace(COMPANY_NAME_PLACEHOLDER, COMPANY_NAME);
                return emailContent;
            } else {
                throw new IOException("Resource not found: /templates/registration.html");
            }
        }
    }
}
