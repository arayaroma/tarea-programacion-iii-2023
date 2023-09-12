package cr.ac.una.controller;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.2
 * 2023-09-12T10:24:00.839-06:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "UserController",
                  wsdlLocation = "file:/Users/estebannajera/Desktop/tarea-programacion-iii-2023/evacomuna/src/main/resources/cr/ac/una/evacomuna/wsdl/UserService.wsdl",
                  targetNamespace = "http://controller.una.ac.cr/")
public class UserController_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://controller.una.ac.cr/", "UserController");
    public final static QName UserControllerPort = new QName("http://controller.una.ac.cr/", "UserControllerPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/estebannajera/Desktop/tarea-programacion-iii-2023/evacomuna/src/main/resources/cr/ac/una/evacomuna/wsdl/UserService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(UserController_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/Users/estebannajera/Desktop/tarea-programacion-iii-2023/evacomuna/src/main/resources/cr/ac/una/evacomuna/wsdl/UserService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public UserController_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UserController_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserController_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public UserController_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public UserController_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public UserController_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns UserController
     */
    @WebEndpoint(name = "UserControllerPort")
    public UserController getUserControllerPort() {
        return super.getPort(UserControllerPort, UserController.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserController
     */
    @WebEndpoint(name = "UserControllerPort")
    public UserController getUserControllerPort(WebServiceFeature... features) {
        return super.getPort(UserControllerPort, UserController.class, features);
    }

}
