
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

    private final static QName _CharacteristicDto_QNAME = new QName("http://controller.una.ac.cr/", "CharacteristicDto");
    private final static QName _PositionDto_QNAME = new QName("http://controller.una.ac.cr/", "PositionDto");
    private final static QName _UserDto_QNAME = new QName("http://controller.una.ac.cr/", "UserDto");
    private final static QName _CreatePosition_QNAME = new QName("http://controller.una.ac.cr/", "createPosition");
    private final static QName _CreatePositionResponse_QNAME = new QName("http://controller.una.ac.cr/", "createPositionResponse");
    private final static QName _DeletePositionById_QNAME = new QName("http://controller.una.ac.cr/", "deletePositionById");
    private final static QName _DeletePositionByIdResponse_QNAME = new QName("http://controller.una.ac.cr/", "deletePositionByIdResponse");
    private final static QName _GetPositionById_QNAME = new QName("http://controller.una.ac.cr/", "getPositionById");
    private final static QName _GetPositionByIdResponse_QNAME = new QName("http://controller.una.ac.cr/", "getPositionByIdResponse");
    private final static QName _GetPositionByName_QNAME = new QName("http://controller.una.ac.cr/", "getPositionByName");
    private final static QName _GetPositionByNameResponse_QNAME = new QName("http://controller.una.ac.cr/", "getPositionByNameResponse");
    private final static QName _GetPositions_QNAME = new QName("http://controller.una.ac.cr/", "getPositions");
    private final static QName _GetPositionsResponse_QNAME = new QName("http://controller.una.ac.cr/", "getPositionsResponse");
    private final static QName _ListWrapper_QNAME = new QName("http://controller.una.ac.cr/", "listWrapper");
    private final static QName _UpdatePosition_QNAME = new QName("http://controller.una.ac.cr/", "updatePosition");
    private final static QName _UpdatePositionById_QNAME = new QName("http://controller.una.ac.cr/", "updatePositionById");
    private final static QName _UpdatePositionByIdResponse_QNAME = new QName("http://controller.una.ac.cr/", "updatePositionByIdResponse");
    private final static QName _UpdatePositionResponse_QNAME = new QName("http://controller.una.ac.cr/", "updatePositionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cr.ac.una.controller
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CharacteristicDto }
     * 
     */
    public CharacteristicDto createCharacteristicDto() {
        return new CharacteristicDto();
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
     * Create an instance of {@link GetPositionByName }
     * 
     */
    public GetPositionByName createGetPositionByName() {
        return new GetPositionByName();
    }

    /**
     * Create an instance of {@link GetPositionByNameResponse }
     * 
     */
    public GetPositionByNameResponse createGetPositionByNameResponse() {
        return new GetPositionByNameResponse();
    }

    /**
     * Create an instance of {@link GetPositions }
     * 
     */
    public GetPositions createGetPositions() {
        return new GetPositions();
    }

    /**
     * Create an instance of {@link GetPositionsResponse }
     * 
     */
    public GetPositionsResponse createGetPositionsResponse() {
        return new GetPositionsResponse();
    }

    /**
     * Create an instance of {@link ListWrapper }
     * 
     */
    public ListWrapper createListWrapper() {
        return new ListWrapper();
    }

    /**
     * Create an instance of {@link UpdatePosition }
     * 
     */
    public UpdatePosition createUpdatePosition() {
        return new UpdatePosition();
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
     * Create an instance of {@link UpdatePositionResponse }
     * 
     */
    public UpdatePositionResponse createUpdatePositionResponse() {
        return new UpdatePositionResponse();
    }

    /**
     * Create an instance of {@link ResponseWrapper }
     * 
     */
    public ResponseWrapper createResponseWrapper() {
        return new ResponseWrapper();
    }

    /**
     * Create an instance of {@link EvaluatedDto }
     * 
     */
    public EvaluatedDto createEvaluatedDto() {
        return new EvaluatedDto();
    }

    /**
     * Create an instance of {@link EvaluationDto }
     * 
     */
    public EvaluationDto createEvaluationDto() {
        return new EvaluationDto();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link EvaluatorDto }
     * 
     */
    public EvaluatorDto createEvaluatorDto() {
        return new EvaluatorDto();
    }

    /**
     * Create an instance of {@link FinalCalificationDto }
     * 
     */
    public FinalCalificationDto createFinalCalificationDto() {
        return new FinalCalificationDto();
    }

    /**
     * Create an instance of {@link SkillDto }
     * 
     */
    public SkillDto createSkillDto() {
        return new SkillDto();
    }

    /**
     * Create an instance of {@link CalificationDto }
     * 
     */
    public CalificationDto createCalificationDto() {
        return new CalificationDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CharacteristicDto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CharacteristicDto }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "CharacteristicDto")
    public JAXBElement<CharacteristicDto> createCharacteristicDto(CharacteristicDto value) {
        return new JAXBElement<CharacteristicDto>(_CharacteristicDto_QNAME, CharacteristicDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PositionDto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PositionDto }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "PositionDto")
    public JAXBElement<PositionDto> createPositionDto(PositionDto value) {
        return new JAXBElement<PositionDto>(_PositionDto_QNAME, PositionDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserDto }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "UserDto")
    public JAXBElement<UserDto> createUserDto(UserDto value) {
        return new JAXBElement<UserDto>(_UserDto_QNAME, UserDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePosition }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreatePosition }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "createPosition")
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
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "createPositionResponse")
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
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "deletePositionById")
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
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "deletePositionByIdResponse")
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
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getPositionById")
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
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getPositionByIdResponse")
    public JAXBElement<GetPositionByIdResponse> createGetPositionByIdResponse(GetPositionByIdResponse value) {
        return new JAXBElement<GetPositionByIdResponse>(_GetPositionByIdResponse_QNAME, GetPositionByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPositionByName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPositionByName }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getPositionByName")
    public JAXBElement<GetPositionByName> createGetPositionByName(GetPositionByName value) {
        return new JAXBElement<GetPositionByName>(_GetPositionByName_QNAME, GetPositionByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPositionByNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPositionByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getPositionByNameResponse")
    public JAXBElement<GetPositionByNameResponse> createGetPositionByNameResponse(GetPositionByNameResponse value) {
        return new JAXBElement<GetPositionByNameResponse>(_GetPositionByNameResponse_QNAME, GetPositionByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPositions }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPositions }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getPositions")
    public JAXBElement<GetPositions> createGetPositions(GetPositions value) {
        return new JAXBElement<GetPositions>(_GetPositions_QNAME, GetPositions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPositionsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPositionsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getPositionsResponse")
    public JAXBElement<GetPositionsResponse> createGetPositionsResponse(GetPositionsResponse value) {
        return new JAXBElement<GetPositionsResponse>(_GetPositionsResponse_QNAME, GetPositionsResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePosition }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePosition }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updatePosition")
    public JAXBElement<UpdatePosition> createUpdatePosition(UpdatePosition value) {
        return new JAXBElement<UpdatePosition>(_UpdatePosition_QNAME, UpdatePosition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePositionById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePositionById }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updatePositionById")
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
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updatePositionByIdResponse")
    public JAXBElement<UpdatePositionByIdResponse> createUpdatePositionByIdResponse(UpdatePositionByIdResponse value) {
        return new JAXBElement<UpdatePositionByIdResponse>(_UpdatePositionByIdResponse_QNAME, UpdatePositionByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePositionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePositionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updatePositionResponse")
    public JAXBElement<UpdatePositionResponse> createUpdatePositionResponse(UpdatePositionResponse value) {
        return new JAXBElement<UpdatePositionResponse>(_UpdatePositionResponse_QNAME, UpdatePositionResponse.class, null, value);
    }

}
