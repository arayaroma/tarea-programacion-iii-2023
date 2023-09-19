package cr.ac.una.util;

/**
 * 
 * @author arayaroma
 */
public class LinkGenerator {

    public static String generateActivationLink(String hash) {
        return Connection.getSocket() + Constants.WEB_BASE_DIR + "activation.html?hash=" + hash;
    }

}
