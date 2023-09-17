
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

    private final static QName _CreateGeneralInformation_QNAME = new QName("http://controller.una.ac.cr/", "createGeneralInformation");
    private final static QName _CreateGeneralInformationResponse_QNAME = new QName("http://controller.una.ac.cr/", "createGeneralInformationResponse");
    private final static QName _DeleteGeneralInformation_QNAME = new QName("http://controller.una.ac.cr/", "deleteGeneralInformation");
    private final static QName _DeleteGeneralInformationResponse_QNAME = new QName("http://controller.una.ac.cr/", "deleteGeneralInformationResponse");
    private final static QName _GetGeneralInformation_QNAME = new QName("http://controller.una.ac.cr/", "getGeneralInformation");
    private final static QName _GetGeneralInformationResponse_QNAME = new QName("http://controller.una.ac.cr/", "getGeneralInformationResponse");
    private final static QName _ListWrapper_QNAME = new QName("http://controller.una.ac.cr/", "listWrapper");
    private final static QName _UpdateGeneralInformation_QNAME = new QName("http://controller.una.ac.cr/", "updateGeneralInformation");
    private final static QName _UpdateGeneralInformationResponse_QNAME = new QName("http://controller.una.ac.cr/", "updateGeneralInformationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cr.ac.una.controller
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateGeneralInformation }
     * 
     */
    public CreateGeneralInformation createCreateGeneralInformation() {
        return new CreateGeneralInformation();
    }

    /**
     * Create an instance of {@link CreateGeneralInformationResponse }
     * 
     */
    public CreateGeneralInformationResponse createCreateGeneralInformationResponse() {
        return new CreateGeneralInformationResponse();
    }

    /**
     * Create an instance of {@link DeleteGeneralInformation }
     * 
     */
    public DeleteGeneralInformation createDeleteGeneralInformation() {
        return new DeleteGeneralInformation();
    }

    /**
     * Create an instance of {@link DeleteGeneralInformationResponse }
     * 
     */
    public DeleteGeneralInformationResponse createDeleteGeneralInformationResponse() {
        return new DeleteGeneralInformationResponse();
    }

    /**
     * Create an instance of {@link GetGeneralInformation }
     * 
     */
    public GetGeneralInformation createGetGeneralInformation() {
        return new GetGeneralInformation();
    }

    /**
     * Create an instance of {@link GetGeneralInformationResponse }
     * 
     */
    public GetGeneralInformationResponse createGetGeneralInformationResponse() {
        return new GetGeneralInformationResponse();
    }

    /**
     * Create an instance of {@link ListWrapper }
     * 
     */
    public ListWrapper createListWrapper() {
        return new ListWrapper();
    }

    /**
     * Create an instance of {@link UpdateGeneralInformation }
     * 
     */
    public UpdateGeneralInformation createUpdateGeneralInformation() {
        return new UpdateGeneralInformation();
    }

    /**
     * Create an instance of {@link UpdateGeneralInformationResponse }
     * 
     */
    public UpdateGeneralInformationResponse createUpdateGeneralInformationResponse() {
        return new UpdateGeneralInformationResponse();
    }

    /**
     * Create an instance of {@link GeneralInformationDto }
     * 
     */
    public GeneralInformationDto createGeneralInformationDto() {
        return new GeneralInformationDto();
    }

    /**
     * Create an instance of {@link ResponseWrapper }
     * 
     */
    public ResponseWrapper createResponseWrapper() {
        return new ResponseWrapper();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGeneralInformation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateGeneralInformation }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "createGeneralInformation")
    public JAXBElement<CreateGeneralInformation> createCreateGeneralInformation(CreateGeneralInformation value) {
        return new JAXBElement<CreateGeneralInformation>(_CreateGeneralInformation_QNAME, CreateGeneralInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGeneralInformationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateGeneralInformationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "createGeneralInformationResponse")
    public JAXBElement<CreateGeneralInformationResponse> createCreateGeneralInformationResponse(CreateGeneralInformationResponse value) {
        return new JAXBElement<CreateGeneralInformationResponse>(_CreateGeneralInformationResponse_QNAME, CreateGeneralInformationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteGeneralInformation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteGeneralInformation }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "deleteGeneralInformation")
    public JAXBElement<DeleteGeneralInformation> createDeleteGeneralInformation(DeleteGeneralInformation value) {
        return new JAXBElement<DeleteGeneralInformation>(_DeleteGeneralInformation_QNAME, DeleteGeneralInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteGeneralInformationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteGeneralInformationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "deleteGeneralInformationResponse")
    public JAXBElement<DeleteGeneralInformationResponse> createDeleteGeneralInformationResponse(DeleteGeneralInformationResponse value) {
        return new JAXBElement<DeleteGeneralInformationResponse>(_DeleteGeneralInformationResponse_QNAME, DeleteGeneralInformationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGeneralInformation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetGeneralInformation }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getGeneralInformation")
    public JAXBElement<GetGeneralInformation> createGetGeneralInformation(GetGeneralInformation value) {
        return new JAXBElement<GetGeneralInformation>(_GetGeneralInformation_QNAME, GetGeneralInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGeneralInformationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetGeneralInformationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getGeneralInformationResponse")
    public JAXBElement<GetGeneralInformationResponse> createGetGeneralInformationResponse(GetGeneralInformationResponse value) {
        return new JAXBElement<GetGeneralInformationResponse>(_GetGeneralInformationResponse_QNAME, GetGeneralInformationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListWrapper }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListWrapper }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "listWrapper")
    public JAXBElement<ListWrapper> createListWrapper(ListWrapper value) {
        return new JAXBElement<ListWrapper>(_ListWrapper_QNAME, ListWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateGeneralInformation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateGeneralInformation }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updateGeneralInformation")
    public JAXBElement<UpdateGeneralInformation> createUpdateGeneralInformation(UpdateGeneralInformation value) {
        return new JAXBElement<UpdateGeneralInformation>(_UpdateGeneralInformation_QNAME, UpdateGeneralInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateGeneralInformationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateGeneralInformationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updateGeneralInformationResponse")
    public JAXBElement<UpdateGeneralInformationResponse> createUpdateGeneralInformationResponse(UpdateGeneralInformationResponse value) {
        return new JAXBElement<UpdateGeneralInformationResponse>(_UpdateGeneralInformationResponse_QNAME, UpdateGeneralInformationResponse.class, null, value);
    }

}
