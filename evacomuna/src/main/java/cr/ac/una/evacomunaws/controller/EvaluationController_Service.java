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
 * 2023-10-02T16:14:21.701-06:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "EvaluationController",
                  wsdlLocation = "http://localhost:8080/evacomunaws/EvaluationController?wsdl",
                  targetNamespace = "http://controller.evacomunaws.una.ac.cr/")
public class EvaluationController_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://controller.evacomunaws.una.ac.cr/", "EvaluationController");
    public final static QName EvaluationControllerPort = new QName("http://controller.evacomunaws.una.ac.cr/", "EvaluationControllerPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/evacomunaws/EvaluationController?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EvaluationController_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/evacomunaws/EvaluationController?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EvaluationController_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EvaluationController_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EvaluationController_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public EvaluationController_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EvaluationController_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EvaluationController_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns EvaluationController
     */
    @WebEndpoint(name = "EvaluationControllerPort")
    public EvaluationController getEvaluationControllerPort() {
        return super.getPort(EvaluationControllerPort, EvaluationController.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EvaluationController
     */
    @WebEndpoint(name = "EvaluationControllerPort")
    public EvaluationController getEvaluationControllerPort(WebServiceFeature... features) {
        return super.getPort(EvaluationControllerPort, EvaluationController.class, features);
    }

}
