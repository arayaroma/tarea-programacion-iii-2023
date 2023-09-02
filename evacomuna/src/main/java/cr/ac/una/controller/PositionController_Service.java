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
 * 2023-08-28T14:38:15.768-06:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "PositionController",
                  wsdlLocation = "file:/Users/estebannajera/Desktop/tarea-programacion-iii-2023/evacomuna/src/main/resources/cr/ac/una/evacomuna/wsdl/PositionService.wsdl",
                  targetNamespace = "http://controller.una.ac.cr/")
public class PositionController_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://controller.una.ac.cr/", "PositionController");
    public final static QName PositionControllerPort = new QName("http://controller.una.ac.cr/", "PositionControllerPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/estebannajera/Desktop/tarea-programacion-iii-2023/evacomuna/src/main/resources/cr/ac/una/evacomuna/wsdl/PositionService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PositionController_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/Users/estebannajera/Desktop/tarea-programacion-iii-2023/evacomuna/src/main/resources/cr/ac/una/evacomuna/wsdl/PositionService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PositionController_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PositionController_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PositionController_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public PositionController_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public PositionController_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public PositionController_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns PositionController
     */
    @WebEndpoint(name = "PositionControllerPort")
    public PositionController getPositionControllerPort() {
        return super.getPort(PositionControllerPort, PositionController.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PositionController
     */
    @WebEndpoint(name = "PositionControllerPort")
    public PositionController getPositionControllerPort(WebServiceFeature... features) {
        return super.getPort(PositionControllerPort, PositionController.class, features);
    }

}
