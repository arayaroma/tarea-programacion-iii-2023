package cr.ac.una.evacomunaws.util;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master

import static cr.ac.una.evacomunaws.util.PlaceHolders.BODY;
import static cr.ac.una.evacomunaws.util.PlaceHolders.FOOTER;
import static cr.ac.una.evacomunaws.util.PlaceHolders.HEADER;
import static cr.ac.una.evacomunaws.util.PlaceHolders.TEAM;
import static cr.ac.una.evacomunaws.util.PlaceHolders.TITLE;
import static cr.ac.una.evacomunaws.util.PlaceHolders.USER_NAME;
<<<<<<< HEAD
=======

=======

import static cr.ac.una.evacomunaws.util.PlaceHolders.BODY;
import static cr.ac.una.evacomunaws.util.PlaceHolders.FOOTER;
import static cr.ac.una.evacomunaws.util.PlaceHolders.HEADER;
import static cr.ac.una.evacomunaws.util.PlaceHolders.TEAM;
import static cr.ac.una.evacomunaws.util.PlaceHolders.TITLE;
import static cr.ac.una.evacomunaws.util.PlaceHolders.USER_NAME;
>>>>>>> 29c7236 ([FIXING] cr.ac.una.evacomunaws import to ALL CLASSES)
>>>>>>> master
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author arayaroma
 */
public class HtmlFileReader {

    public static final String TEMPLATE_DIR = "/templates/";

    public static String readHtmlFromWebApp(String path) {
        String WEBAPP_DIR = "src/main/webapp/";
        return new String(WEBAPP_DIR + path);
    }

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
