package cr.ac.una.services.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.2
 * 2023-08-20T21:12:21.034-06:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "UserService",
                  wsdlLocation = "file:/home/araya/Repositories/tarea-programacion-iii-2023/evacomuna/src/main/resources/wsdl/UserService.wsdl",
                  targetNamespace = "http://impl.services.una.ac.cr/")
public class UserService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.services.una.ac.cr/", "UserService");
    public final static QName UserServiceImplPort = new QName("http://impl.services.una.ac.cr/", "UserServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/araya/Repositories/tarea-programacion-iii-2023/evacomuna/src/main/resources/wsdl/UserService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(UserService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/home/araya/Repositories/tarea-programacion-iii-2023/evacomuna/src/main/resources/wsdl/UserService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public UserService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UserService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public UserService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public UserService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public UserService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
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
