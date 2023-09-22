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
 * 2023-09-21T21:51:15.999-06:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "EvaluatedController",
                  wsdlLocation = "http://localhost:8080/evacomunaws/EvaluatedController?wsdl",
                  targetNamespace = "http://controller.una.ac.cr/")
public class EvaluatedController_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://controller.una.ac.cr/", "EvaluatedController");
    public final static QName EvaluatedControllerPort = new QName("http://controller.una.ac.cr/", "EvaluatedControllerPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/evacomunaws/EvaluatedController?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EvaluatedController_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/evacomunaws/EvaluatedController?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EvaluatedController_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EvaluatedController_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EvaluatedController_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public EvaluatedController_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EvaluatedController_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EvaluatedController_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns EvaluatedController
     */
    @WebEndpoint(name = "EvaluatedControllerPort")
    public EvaluatedController getEvaluatedControllerPort() {
        return super.getPort(EvaluatedControllerPort, EvaluatedController.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EvaluatedController
     */
    @WebEndpoint(name = "EvaluatedControllerPort")
    public EvaluatedController getEvaluatedControllerPort(WebServiceFeature... features) {
        return super.getPort(EvaluatedControllerPort, EvaluatedController.class, features);
    }

}
