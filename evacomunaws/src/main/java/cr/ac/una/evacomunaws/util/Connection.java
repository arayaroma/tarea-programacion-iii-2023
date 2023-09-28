package cr.ac.una.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Connection {

    static String host;
    static String port = Constants.PORT;

    public static String getSocket() {
        try {
            host = InetAddress.getLocalHost().getHostAddress();
            System.out.println(host);
            return host + ":" + port;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }

    }
}