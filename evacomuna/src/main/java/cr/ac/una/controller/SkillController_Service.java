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
 * 2023-09-14T12:18:38.573-06:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "SkillController",
                  wsdlLocation = "file:/Users/estebannajera/Desktop/tarea-programacion-iii-2023/evacomuna/src/main/resources/cr/ac/una/evacomuna/wsdl/SkillService.wsdl",
                  targetNamespace = "http://controller.una.ac.cr/")
public class SkillController_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://controller.una.ac.cr/", "SkillController");
    public final static QName SkillControllerPort = new QName("http://controller.una.ac.cr/", "SkillControllerPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/estebannajera/Desktop/tarea-programacion-iii-2023/evacomuna/src/main/resources/cr/ac/una/evacomuna/wsdl/SkillService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SkillController_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/Users/estebannajera/Desktop/tarea-programacion-iii-2023/evacomuna/src/main/resources/cr/ac/una/evacomuna/wsdl/SkillService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public SkillController_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SkillController_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SkillController_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public SkillController_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public SkillController_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public SkillController_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns SkillController
     */
    @WebEndpoint(name = "SkillControllerPort")
    public SkillController getSkillControllerPort() {
        return super.getPort(SkillControllerPort, SkillController.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SkillController
     */
    @WebEndpoint(name = "SkillControllerPort")
    public SkillController getSkillControllerPort(WebServiceFeature... features) {
        return super.getPort(SkillControllerPort, SkillController.class, features);
    }

}
