package cr.ac.una.evacomuna.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class Connection {

    static final String PORT = "8080";

    static String host;
    static String port = PORT;

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

    public static Boolean isConnected(String serviceUrl) {
        try {
            URL url = new URL(serviceUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (IOException e) {
            return false;
        }
    }

}
