package cr.ac.una.util;

/**
 * 
 * @author arayaroma
 */
public class LinkGenerator {

    public static String generateActivationLink(Long id, String hash) {
        return Constants.APP_ENDPOINT + "Activation?id=" + id + "&hash=" + hash;
    }
}
