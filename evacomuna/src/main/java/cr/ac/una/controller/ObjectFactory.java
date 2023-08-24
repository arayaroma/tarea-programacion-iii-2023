
package cr.ac.una.controller;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cr.ac.una.controller package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateCompany_QNAME = new QName("http://controller.una.ac.cr/", "createCompany");
    private final static QName _CreateCompanyResponse_QNAME = new QName("http://controller.una.ac.cr/", "createCompanyResponse");
    private final static QName _UpdateCompany_QNAME = new QName("http://controller.una.ac.cr/", "updateCompany");
    private final static QName _UpdateCompanyResponse_QNAME = new QName("http://controller.una.ac.cr/", "updateCompanyResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cr.ac.una.controller
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateCompany }
     * 
     */
    public CreateCompany createCreateCompany() {
        return new CreateCompany();
    }

    /**
     * Create an instance of {@link CreateCompanyResponse }
     * 
     */
    public CreateCompanyResponse createCreateCompanyResponse() {
        return new CreateCompanyResponse();
    }

    /**
     * Create an instance of {@link UpdateCompany }
     * 
     */
    public UpdateCompany createUpdateCompany() {
        return new UpdateCompany();
    }

    /**
     * Create an instance of {@link UpdateCompanyResponse }
     * 
     */
    public UpdateCompanyResponse createUpdateCompanyResponse() {
        return new UpdateCompanyResponse();
    }

    /**
     * Create an instance of {@link CompanyDto }
     * 
     */
    public CompanyDto createCompanyDto() {
        return new CompanyDto();
    }

    /**
     * Create an instance of {@link ResponseWrapper }
     * 
     */
    public ResponseWrapper createResponseWrapper() {
        return new ResponseWrapper();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCompany }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateCompany }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "createCompany")
    public JAXBElement<CreateCompany> createCreateCompany(CreateCompany value) {
        return new JAXBElement<CreateCompany>(_CreateCompany_QNAME, CreateCompany.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCompanyResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateCompanyResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "createCompanyResponse")
    public JAXBElement<CreateCompanyResponse> createCreateCompanyResponse(CreateCompanyResponse value) {
        return new JAXBElement<CreateCompanyResponse>(_CreateCompanyResponse_QNAME, CreateCompanyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCompany }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateCompany }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updateCompany")
    public JAXBElement<UpdateCompany> createUpdateCompany(UpdateCompany value) {
        return new JAXBElement<UpdateCompany>(_UpdateCompany_QNAME, UpdateCompany.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCompanyResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateCompanyResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updateCompanyResponse")
    public JAXBElement<UpdateCompanyResponse> createUpdateCompanyResponse(UpdateCompanyResponse value) {
        return new JAXBElement<UpdateCompanyResponse>(_UpdateCompanyResponse_QNAME, UpdateCompanyResponse.class, null, value);
    }

}
