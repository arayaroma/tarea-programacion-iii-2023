
package cr.ac.una.services.impl;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cr.ac.una.services.impl package. 
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

    private final static QName _CreatePosition_QNAME = new QName("http://impl.services.una.ac.cr/", "createPosition");
    private final static QName _CreatePositionResponse_QNAME = new QName("http://impl.services.una.ac.cr/", "createPositionResponse");
    private final static QName _DeletePositionById_QNAME = new QName("http://impl.services.una.ac.cr/", "deletePositionById");
    private final static QName _DeletePositionByIdResponse_QNAME = new QName("http://impl.services.una.ac.cr/", "deletePositionByIdResponse");
    private final static QName _GetPositionById_QNAME = new QName("http://impl.services.una.ac.cr/", "getPositionById");
    private final static QName _GetPositionByIdResponse_QNAME = new QName("http://impl.services.una.ac.cr/", "getPositionByIdResponse");
    private final static QName _UpdatePositionById_QNAME = new QName("http://impl.services.una.ac.cr/", "updatePositionById");
    private final static QName _UpdatePositionByIdResponse_QNAME = new QName("http://impl.services.una.ac.cr/", "updatePositionByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cr.ac.una.services.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreatePosition }
     * 
     */
    public CreatePosition createCreatePosition() {
        return new CreatePosition();
    }

    /**
     * Create an instance of {@link CreatePositionResponse }
     * 
     */
    public CreatePositionResponse createCreatePositionResponse() {
        return new CreatePositionResponse();
    }

    /**
     * Create an instance of {@link DeletePositionById }
     * 
     */
    public DeletePositionById createDeletePositionById() {
        return new DeletePositionById();
    }

    /**
     * Create an instance of {@link DeletePositionByIdResponse }
     * 
     */
    public DeletePositionByIdResponse createDeletePositionByIdResponse() {
        return new DeletePositionByIdResponse();
    }

    /**
     * Create an instance of {@link GetPositionById }
     * 
     */
    public GetPositionById createGetPositionById() {
        return new GetPositionById();
    }

    /**
     * Create an instance of {@link GetPositionByIdResponse }
     * 
     */
    public GetPositionByIdResponse createGetPositionByIdResponse() {
        return new GetPositionByIdResponse();
    }

    /**
     * Create an instance of {@link UpdatePositionById }
     * 
     */
    public UpdatePositionById createUpdatePositionById() {
        return new UpdatePositionById();
    }

    /**
     * Create an instance of {@link UpdatePositionByIdResponse }
     * 
     */
    public UpdatePositionByIdResponse createUpdatePositionByIdResponse() {
        return new UpdatePositionByIdResponse();
    }

    /**
     * Create an instance of {@link PositionDto }
     * 
     */
    public PositionDto createPositionDto() {
        return new PositionDto();
    }

    /**
     * Create an instance of {@link UserDto }
     * 
     */
    public UserDto createUserDto() {
        return new UserDto();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePosition }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreatePosition }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "createPosition")
    public JAXBElement<CreatePosition> createCreatePosition(CreatePosition value) {
        return new JAXBElement<CreatePosition>(_CreatePosition_QNAME, CreatePosition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePositionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreatePositionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "createPositionResponse")
    public JAXBElement<CreatePositionResponse> createCreatePositionResponse(CreatePositionResponse value) {
        return new JAXBElement<CreatePositionResponse>(_CreatePositionResponse_QNAME, CreatePositionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePositionById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeletePositionById }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "deletePositionById")
    public JAXBElement<DeletePositionById> createDeletePositionById(DeletePositionById value) {
        return new JAXBElement<DeletePositionById>(_DeletePositionById_QNAME, DeletePositionById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePositionByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeletePositionByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "deletePositionByIdResponse")
    public JAXBElement<DeletePositionByIdResponse> createDeletePositionByIdResponse(DeletePositionByIdResponse value) {
        return new JAXBElement<DeletePositionByIdResponse>(_DeletePositionByIdResponse_QNAME, DeletePositionByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPositionById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPositionById }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "getPositionById")
    public JAXBElement<GetPositionById> createGetPositionById(GetPositionById value) {
        return new JAXBElement<GetPositionById>(_GetPositionById_QNAME, GetPositionById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPositionByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPositionByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "getPositionByIdResponse")
    public JAXBElement<GetPositionByIdResponse> createGetPositionByIdResponse(GetPositionByIdResponse value) {
        return new JAXBElement<GetPositionByIdResponse>(_GetPositionByIdResponse_QNAME, GetPositionByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePositionById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePositionById }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "updatePositionById")
    public JAXBElement<UpdatePositionById> createUpdatePositionById(UpdatePositionById value) {
        return new JAXBElement<UpdatePositionById>(_UpdatePositionById_QNAME, UpdatePositionById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePositionByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePositionByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "updatePositionByIdResponse")
    public JAXBElement<UpdatePositionByIdResponse> createUpdatePositionByIdResponse(UpdatePositionByIdResponse value) {
        return new JAXBElement<UpdatePositionByIdResponse>(_UpdatePositionByIdResponse_QNAME, UpdatePositionByIdResponse.class, null, value);
    }

}
