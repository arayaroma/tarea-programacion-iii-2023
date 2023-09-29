package cr.ac.una.evacomunaws.controller;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.2
 * 2023-09-28T21:21:14.883-06:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "CalificationController",
                  wsdlLocation = "http://localhost:8080/evacomunaws/CalificationController?wsdl",
                  targetNamespace = "http://controller.evacomunaws.una.ac.cr/")
public class CalificationController_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://controller.evacomunaws.una.ac.cr/", "CalificationController");
    public final static QName CalificationControllerPort = new QName("http://controller.evacomunaws.una.ac.cr/", "CalificationControllerPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/evacomunaws/CalificationController?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CalificationController_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/evacomunaws/CalificationController?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CalificationController_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CalificationController_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalificationController_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public CalificationController_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CalificationController_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CalificationController_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns CalificationController
     */
    @WebEndpoint(name = "CalificationControllerPort")
    public CalificationController getCalificationControllerPort() {
        return super.getPort(CalificationControllerPort, CalificationController.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CalificationController
     */
    @WebEndpoint(name = "CalificationControllerPort")
    public CalificationController getCalificationControllerPort(WebServiceFeature... features) {
        return super.getPort(CalificationControllerPort, CalificationController.class, features);
    }

}
