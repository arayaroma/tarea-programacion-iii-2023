
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package cr.ac.una.services;

import java.util.logging.Logger;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 4.0.2
 * 2023-08-19T01:31:22.257-06:00
 * Generated source version: 4.0.2
 *
 */

@jakarta.jws.WebService(
                      serviceName = "user",
                      portName = "UserServiceImplPort",
                      targetNamespace = "http://services.una.ac.cr/",
                      wsdlLocation = "file:/home/araya/Repositories/tarea-programacion-iii-2023/evacomuna/src/main/resources/user.wsdl",
                      endpointInterface = "cr.ac.una.services.UserServiceImpl")

public class UserServiceImplPortImpl implements UserServiceImpl {

    private static final Logger LOG = Logger.getLogger(UserServiceImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see cr.ac.una.services.UserServiceImpl#getUser(int arg0)*
     */
    public cr.ac.una.services.User getUser(int arg0) {
        LOG.info("Executing operation getUser");
        System.out.println(arg0);
        try {
            cr.ac.una.services.User _return = new cr.ac.una.services.User();
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
