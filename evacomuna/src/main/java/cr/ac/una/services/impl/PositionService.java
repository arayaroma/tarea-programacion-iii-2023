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
 * 2023-08-20T21:23:33.418-06:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "PositionService",
                  wsdlLocation = "file:/home/araya/Repositories/tarea-programacion-iii-2023/evacomuna/src/main/resources/wsdl/PositionService.wsdl",
                  targetNamespace = "http://impl.services.una.ac.cr/")
public class PositionService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.services.una.ac.cr/", "PositionService");
    public final static QName PositionServiceImplPort = new QName("http://impl.services.una.ac.cr/", "PositionServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/araya/Repositories/tarea-programacion-iii-2023/evacomuna/src/main/resources/wsdl/PositionService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PositionService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/home/araya/Repositories/tarea-programacion-iii-2023/evacomuna/src/main/resources/wsdl/PositionService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PositionService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PositionService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PositionService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public PositionService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public PositionService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public PositionService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns PositionServiceImpl
     */
    @WebEndpoint(name = "PositionServiceImplPort")
    public PositionServiceImpl getPositionServiceImplPort() {
        return super.getPort(PositionServiceImplPort, PositionServiceImpl.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PositionServiceImpl
     */
    @WebEndpoint(name = "PositionServiceImplPort")
    public PositionServiceImpl getPositionServiceImplPort(WebServiceFeature... features) {
        return super.getPort(PositionServiceImplPort, PositionServiceImpl.class, features);
    }

}
