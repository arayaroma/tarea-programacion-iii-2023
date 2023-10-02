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
 * 2023-10-02T16:14:22.007-06:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "GeneralInformationController",
                  wsdlLocation = "http://localhost:8080/evacomunaws/GeneralInformationController?wsdl",
                  targetNamespace = "http://controller.evacomunaws.una.ac.cr/")
public class GeneralInformationController_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://controller.evacomunaws.una.ac.cr/", "GeneralInformationController");
    public final static QName GeneralInformationControllerPort = new QName("http://controller.evacomunaws.una.ac.cr/", "GeneralInformationControllerPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/evacomunaws/GeneralInformationController?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(GeneralInformationController_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/evacomunaws/GeneralInformationController?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public GeneralInformationController_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public GeneralInformationController_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GeneralInformationController_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public GeneralInformationController_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public GeneralInformationController_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public GeneralInformationController_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns GeneralInformationController
     */
    @WebEndpoint(name = "GeneralInformationControllerPort")
    public GeneralInformationController getGeneralInformationControllerPort() {
        return super.getPort(GeneralInformationControllerPort, GeneralInformationController.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GeneralInformationController
     */
    @WebEndpoint(name = "GeneralInformationControllerPort")
    public GeneralInformationController getGeneralInformationControllerPort(WebServiceFeature... features) {
        return super.getPort(GeneralInformationControllerPort, GeneralInformationController.class, features);
    }

}
