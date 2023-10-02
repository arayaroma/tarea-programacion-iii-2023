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
 * 2023-10-01T22:03:14.130-06:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "FinalCalificationController",
                  wsdlLocation = "http://localhost:8080/evacomunaws/FinalCalificationController?wsdl",
                  targetNamespace = "http://controller.evacomunaws.una.ac.cr/")
public class FinalCalificationController_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://controller.evacomunaws.una.ac.cr/", "FinalCalificationController");
    public final static QName FinalCalificationControllerPort = new QName("http://controller.evacomunaws.una.ac.cr/", "FinalCalificationControllerPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/evacomunaws/FinalCalificationController?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(FinalCalificationController_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/evacomunaws/FinalCalificationController?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public FinalCalificationController_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public FinalCalificationController_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FinalCalificationController_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public FinalCalificationController_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public FinalCalificationController_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public FinalCalificationController_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns FinalCalificationController
     */
    @WebEndpoint(name = "FinalCalificationControllerPort")
    public FinalCalificationController getFinalCalificationControllerPort() {
        return super.getPort(FinalCalificationControllerPort, FinalCalificationController.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FinalCalificationController
     */
    @WebEndpoint(name = "FinalCalificationControllerPort")
    public FinalCalificationController getFinalCalificationControllerPort(WebServiceFeature... features) {
        return super.getPort(FinalCalificationControllerPort, FinalCalificationController.class, features);
    }

}
