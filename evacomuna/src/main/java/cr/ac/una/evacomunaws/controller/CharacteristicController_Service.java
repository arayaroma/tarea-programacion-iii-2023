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
 * 2023-10-01T20:15:38.666-06:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "CharacteristicController",
                  wsdlLocation = "http://localhost:8080/evacomunaws/CharacteristicController?wsdl",
                  targetNamespace = "http://controller.evacomunaws.una.ac.cr/")
public class CharacteristicController_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://controller.evacomunaws.una.ac.cr/", "CharacteristicController");
    public final static QName CharacteristicControllerPort = new QName("http://controller.evacomunaws.una.ac.cr/", "CharacteristicControllerPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/evacomunaws/CharacteristicController?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CharacteristicController_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/evacomunaws/CharacteristicController?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CharacteristicController_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CharacteristicController_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CharacteristicController_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public CharacteristicController_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CharacteristicController_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CharacteristicController_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns CharacteristicController
     */
    @WebEndpoint(name = "CharacteristicControllerPort")
    public CharacteristicController getCharacteristicControllerPort() {
        return super.getPort(CharacteristicControllerPort, CharacteristicController.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CharacteristicController
     */
    @WebEndpoint(name = "CharacteristicControllerPort")
    public CharacteristicController getCharacteristicControllerPort(WebServiceFeature... features) {
        return super.getPort(CharacteristicControllerPort, CharacteristicController.class, features);
    }

}
