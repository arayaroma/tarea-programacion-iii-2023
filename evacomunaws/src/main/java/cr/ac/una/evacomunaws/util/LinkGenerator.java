package cr.ac.una.evacomunaws.util;

/**
 * 
 * @author arayaroma
 */
public class LinkGenerator {

    public static String generateActivationLink(String hash) {
        return "http://" + Connection.getSocket() + Constants.WEB_BASE_DIR + "activation.html?hash=" + hash;
    }

}
