package cr.ac.una.util;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import cr.ac.una.model.User;
import cr.ac.una.services.UserService;
import static cr.ac.una.config.Server.REMOTE_SERVER_URL;

public class RequestExample {
    public static void request() {
        String serviceUrl = REMOTE_SERVER_URL;

        // Create a JaxWsProxyFactoryBean
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(UserService.class); // Define your service interface
        factory.setAddress(serviceUrl + "/user");

        // Create the client proxy
        UserService client = (UserService) factory.create();

        // Make the SOAP request using the client proxy
        User user = client.getUser(1);

        // Process the response
        System.out.println("Response: " + user.toString());
    }
}
