package cr.ac.una.services;

import jakarta.xml.ws.Endpoint;

public class Exporter {
    public static void main(String[] args) {
        Endpoint.publish("http://18.188.253.151:8080/evacomuna/user", new UserServiceImpl());
    }
}
