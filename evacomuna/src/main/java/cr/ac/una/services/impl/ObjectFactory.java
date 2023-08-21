
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

    private final static QName _CreateUser_QNAME = new QName("http://impl.services.una.ac.cr/", "createUser");
    private final static QName _CreateUserResponse_QNAME = new QName("http://impl.services.una.ac.cr/", "createUserResponse");
    private final static QName _DeleteUserById_QNAME = new QName("http://impl.services.una.ac.cr/", "deleteUserById");
    private final static QName _DeleteUserByIdResponse_QNAME = new QName("http://impl.services.una.ac.cr/", "deleteUserByIdResponse");
    private final static QName _GetUserById_QNAME = new QName("http://impl.services.una.ac.cr/", "getUserById");
    private final static QName _GetUserByIdResponse_QNAME = new QName("http://impl.services.una.ac.cr/", "getUserByIdResponse");
    private final static QName _UpdateUserById_QNAME = new QName("http://impl.services.una.ac.cr/", "updateUserById");
    private final static QName _UpdateUserByIdResponse_QNAME = new QName("http://impl.services.una.ac.cr/", "updateUserByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cr.ac.una.services.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link DeleteUserById }
     * 
     */
    public DeleteUserById createDeleteUserById() {
        return new DeleteUserById();
    }

    /**
     * Create an instance of {@link DeleteUserByIdResponse }
     * 
     */
    public DeleteUserByIdResponse createDeleteUserByIdResponse() {
        return new DeleteUserByIdResponse();
    }

    /**
     * Create an instance of {@link GetUserById }
     * 
     */
    public GetUserById createGetUserById() {
        return new GetUserById();
    }

    /**
     * Create an instance of {@link GetUserByIdResponse }
     * 
     */
    public GetUserByIdResponse createGetUserByIdResponse() {
        return new GetUserByIdResponse();
    }

    /**
     * Create an instance of {@link UpdateUserById }
     * 
     */
    public UpdateUserById createUpdateUserById() {
        return new UpdateUserById();
    }

    /**
     * Create an instance of {@link UpdateUserByIdResponse }
     * 
     */
    public UpdateUserByIdResponse createUpdateUserByIdResponse() {
        return new UpdateUserByIdResponse();
    }

    /**
     * Create an instance of {@link UserDto }
     * 
     */
    public UserDto createUserDto() {
        return new UserDto();
    }

    /**
     * Create an instance of {@link PositionDto }
     * 
     */
    public PositionDto createPositionDto() {
        return new PositionDto();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "createUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "createUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteUserById }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "deleteUserById")
    public JAXBElement<DeleteUserById> createDeleteUserById(DeleteUserById value) {
        return new JAXBElement<DeleteUserById>(_DeleteUserById_QNAME, DeleteUserById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteUserByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "deleteUserByIdResponse")
    public JAXBElement<DeleteUserByIdResponse> createDeleteUserByIdResponse(DeleteUserByIdResponse value) {
        return new JAXBElement<DeleteUserByIdResponse>(_DeleteUserByIdResponse_QNAME, DeleteUserByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetUserById }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "getUserById")
    public JAXBElement<GetUserById> createGetUserById(GetUserById value) {
        return new JAXBElement<GetUserById>(_GetUserById_QNAME, GetUserById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetUserByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "getUserByIdResponse")
    public JAXBElement<GetUserByIdResponse> createGetUserByIdResponse(GetUserByIdResponse value) {
        return new JAXBElement<GetUserByIdResponse>(_GetUserByIdResponse_QNAME, GetUserByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateUserById }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "updateUserById")
    public JAXBElement<UpdateUserById> createUpdateUserById(UpdateUserById value) {
        return new JAXBElement<UpdateUserById>(_UpdateUserById_QNAME, UpdateUserById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateUserByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://impl.services.una.ac.cr/", name = "updateUserByIdResponse")
    public JAXBElement<UpdateUserByIdResponse> createUpdateUserByIdResponse(UpdateUserByIdResponse value) {
        return new JAXBElement<UpdateUserByIdResponse>(_UpdateUserByIdResponse_QNAME, UpdateUserByIdResponse.class, null, value);
    }

}
