package cr.ac.una.util;

/**
 * 
 * @author arayaroma
 */
public class LinkGenerator {

    public static String generateActivationLink(String hash) {
        return Constants.APP_ENDPOINT + "activation.html?hash=" + hash;
    }
}
