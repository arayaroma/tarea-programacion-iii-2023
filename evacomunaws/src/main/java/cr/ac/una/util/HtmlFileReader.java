package cr.ac.una.util;

import java.io.IOException;
import java.io.InputStream;
import static cr.ac.una.util.PlaceHolders.*;

/**
 * 
 * @author arayaroma
 */
public class HtmlFileReader {

    public static final String TEMPLATE_DIR = "/templates/";

    public static String readHtml(String path) throws IOException {
        return new String(HtmlFileReader.class
                .getResourceAsStream(TEMPLATE_DIR + path)
                .readAllBytes());
    }

    public static String readEmailTemplate(
            String title,
            String header,
            String userName,
            String body,
            String footer) throws IOException {
        try (InputStream inputStream = HtmlFileReader.class.getResourceAsStream(TEMPLATE_DIR + "template.html")) {
            String template = new String(inputStream.readAllBytes());
            String emailContent = template
                    .replace(TITLE, title)
                    .replace(HEADER, header)
                    .replace(USER_NAME, userName)
                    .replace(BODY, body)
                    .replace(FOOTER, footer)
                    .replace(TEAM, Constants.COMPANY_NAME);
            return emailContent;
        } catch (IOException e) {
            throw new IOException("Failed to read email template: " + e.getMessage(), e);
        }
    }
}
