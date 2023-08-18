package cr.ac.una.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.2
 * 2023-08-18T00:52:06.056-06:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "user",
                  wsdlLocation = "file:/home/araya/Repositories/tarea-programacion-iii-2023/evacomuna/src/main/resources/user.wsdl",
                  targetNamespace = "http://services.una.ac.cr/")
public class User_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://services.una.ac.cr/", "user");
    public final static QName UserServiceImplPort = new QName("http://services.una.ac.cr/", "UserServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/araya/Repositories/tarea-programacion-iii-2023/evacomuna/src/main/resources/user.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(User_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/home/araya/Repositories/tarea-programacion-iii-2023/evacomuna/src/main/resources/user.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public User_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public User_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public User_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public User_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public User_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public User_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns UserServiceImpl
     */
    @WebEndpoint(name = "UserServiceImplPort")
    public UserServiceImpl getUserServiceImplPort() {
        return super.getPort(UserServiceImplPort, UserServiceImpl.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserServiceImpl
     */
    @WebEndpoint(name = "UserServiceImplPort")
    public UserServiceImpl getUserServiceImplPort(WebServiceFeature... features) {
        return super.getPort(UserServiceImplPort, UserServiceImpl.class, features);
    }

}
