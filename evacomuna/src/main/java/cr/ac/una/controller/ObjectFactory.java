
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
    private final static QName _CreateEvaluation_QNAME = new QName("http://controller.una.ac.cr/", "createEvaluation");
    private final static QName _CreateEvaluationResponse_QNAME = new QName("http://controller.una.ac.cr/", "createEvaluationResponse");
    private final static QName _DeleteEvaluationById_QNAME = new QName("http://controller.una.ac.cr/", "deleteEvaluationById");
    private final static QName _DeleteEvaluationByIdResponse_QNAME = new QName("http://controller.una.ac.cr/", "deleteEvaluationByIdResponse");
    private final static QName _GetAllEvaluation_QNAME = new QName("http://controller.una.ac.cr/", "getAllEvaluation");
    private final static QName _GetAllEvaluationResponse_QNAME = new QName("http://controller.una.ac.cr/", "getAllEvaluationResponse");
    private final static QName _GetEvaluationById_QNAME = new QName("http://controller.una.ac.cr/", "getEvaluationById");
    private final static QName _GetEvaluationByIdResponse_QNAME = new QName("http://controller.una.ac.cr/", "getEvaluationByIdResponse");
    private final static QName _GetEvaluationByName_QNAME = new QName("http://controller.una.ac.cr/", "getEvaluationByName");
    private final static QName _GetEvaluationByNameResponse_QNAME = new QName("http://controller.una.ac.cr/", "getEvaluationByNameResponse");
    private final static QName _ListWrapper_QNAME = new QName("http://controller.una.ac.cr/", "listWrapper");
    private final static QName _UpdateEvaluation_QNAME = new QName("http://controller.una.ac.cr/", "updateEvaluation");
    private final static QName _UpdateEvaluationResponse_QNAME = new QName("http://controller.una.ac.cr/", "updateEvaluationResponse");

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
     * Create an instance of {@link CreateEvaluation }
     * 
     */
    public CreateEvaluation createCreateEvaluation() {
        return new CreateEvaluation();
    }

    /**
     * Create an instance of {@link CreateEvaluationResponse }
     * 
     */
    public CreateEvaluationResponse createCreateEvaluationResponse() {
        return new CreateEvaluationResponse();
    }

    /**
     * Create an instance of {@link DeleteEvaluationById }
     * 
     */
    public DeleteEvaluationById createDeleteEvaluationById() {
        return new DeleteEvaluationById();
    }

    /**
     * Create an instance of {@link DeleteEvaluationByIdResponse }
     * 
     */
    public DeleteEvaluationByIdResponse createDeleteEvaluationByIdResponse() {
        return new DeleteEvaluationByIdResponse();
    }

    /**
     * Create an instance of {@link GetAllEvaluation }
     * 
     */
    public GetAllEvaluation createGetAllEvaluation() {
        return new GetAllEvaluation();
    }

    /**
     * Create an instance of {@link GetAllEvaluationResponse }
     * 
     */
    public GetAllEvaluationResponse createGetAllEvaluationResponse() {
        return new GetAllEvaluationResponse();
    }

    /**
     * Create an instance of {@link GetEvaluationById }
     * 
     */
    public GetEvaluationById createGetEvaluationById() {
        return new GetEvaluationById();
    }

    /**
     * Create an instance of {@link GetEvaluationByIdResponse }
     * 
     */
    public GetEvaluationByIdResponse createGetEvaluationByIdResponse() {
        return new GetEvaluationByIdResponse();
    }

    /**
     * Create an instance of {@link GetEvaluationByName }
     * 
     */
    public GetEvaluationByName createGetEvaluationByName() {
        return new GetEvaluationByName();
    }

    /**
     * Create an instance of {@link GetEvaluationByNameResponse }
     * 
     */
    public GetEvaluationByNameResponse createGetEvaluationByNameResponse() {
        return new GetEvaluationByNameResponse();
    }

    /**
     * Create an instance of {@link ListWrapper }
     * 
     */
    public ListWrapper createListWrapper() {
        return new ListWrapper();
    }

    /**
     * Create an instance of {@link UpdateEvaluation }
     * 
     */
    public UpdateEvaluation createUpdateEvaluation() {
        return new UpdateEvaluation();
    }

    /**
     * Create an instance of {@link UpdateEvaluationResponse }
     * 
     */
    public UpdateEvaluationResponse createUpdateEvaluationResponse() {
        return new UpdateEvaluationResponse();
    }

    /**
     * Create an instance of {@link EvaluationDto }
     * 
     */
    public EvaluationDto createEvaluationDto() {
        return new EvaluationDto();
    }

    /**
     * Create an instance of {@link EvaluatedDto }
     * 
     */
    public EvaluatedDto createEvaluatedDto() {
        return new EvaluatedDto();
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
     * Create an instance of {@link FinalCalificationDto }
     * 
     */
    public FinalCalificationDto createFinalCalificationDto() {
        return new FinalCalificationDto();
    }

    /**
     * Create an instance of {@link EvaluatorDto }
     * 
     */
    public EvaluatorDto createEvaluatorDto() {
        return new EvaluatorDto();
    }

    /**
     * Create an instance of {@link ResponseWrapper }
     * 
     */
    public ResponseWrapper createResponseWrapper() {
        return new ResponseWrapper();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateEvaluation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateEvaluation }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "createEvaluation")
    public JAXBElement<CreateEvaluation> createCreateEvaluation(CreateEvaluation value) {
        return new JAXBElement<CreateEvaluation>(_CreateEvaluation_QNAME, CreateEvaluation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateEvaluationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateEvaluationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "createEvaluationResponse")
    public JAXBElement<CreateEvaluationResponse> createCreateEvaluationResponse(CreateEvaluationResponse value) {
        return new JAXBElement<CreateEvaluationResponse>(_CreateEvaluationResponse_QNAME, CreateEvaluationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEvaluationById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteEvaluationById }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "deleteEvaluationById")
    public JAXBElement<DeleteEvaluationById> createDeleteEvaluationById(DeleteEvaluationById value) {
        return new JAXBElement<DeleteEvaluationById>(_DeleteEvaluationById_QNAME, DeleteEvaluationById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEvaluationByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteEvaluationByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "deleteEvaluationByIdResponse")
    public JAXBElement<DeleteEvaluationByIdResponse> createDeleteEvaluationByIdResponse(DeleteEvaluationByIdResponse value) {
        return new JAXBElement<DeleteEvaluationByIdResponse>(_DeleteEvaluationByIdResponse_QNAME, DeleteEvaluationByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllEvaluation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllEvaluation }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getAllEvaluation")
    public JAXBElement<GetAllEvaluation> createGetAllEvaluation(GetAllEvaluation value) {
        return new JAXBElement<GetAllEvaluation>(_GetAllEvaluation_QNAME, GetAllEvaluation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllEvaluationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllEvaluationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getAllEvaluationResponse")
    public JAXBElement<GetAllEvaluationResponse> createGetAllEvaluationResponse(GetAllEvaluationResponse value) {
        return new JAXBElement<GetAllEvaluationResponse>(_GetAllEvaluationResponse_QNAME, GetAllEvaluationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEvaluationById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEvaluationById }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getEvaluationById")
    public JAXBElement<GetEvaluationById> createGetEvaluationById(GetEvaluationById value) {
        return new JAXBElement<GetEvaluationById>(_GetEvaluationById_QNAME, GetEvaluationById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEvaluationByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEvaluationByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getEvaluationByIdResponse")
    public JAXBElement<GetEvaluationByIdResponse> createGetEvaluationByIdResponse(GetEvaluationByIdResponse value) {
        return new JAXBElement<GetEvaluationByIdResponse>(_GetEvaluationByIdResponse_QNAME, GetEvaluationByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEvaluationByName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEvaluationByName }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getEvaluationByName")
    public JAXBElement<GetEvaluationByName> createGetEvaluationByName(GetEvaluationByName value) {
        return new JAXBElement<GetEvaluationByName>(_GetEvaluationByName_QNAME, GetEvaluationByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEvaluationByNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEvaluationByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getEvaluationByNameResponse")
    public JAXBElement<GetEvaluationByNameResponse> createGetEvaluationByNameResponse(GetEvaluationByNameResponse value) {
        return new JAXBElement<GetEvaluationByNameResponse>(_GetEvaluationByNameResponse_QNAME, GetEvaluationByNameResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEvaluation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateEvaluation }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updateEvaluation")
    public JAXBElement<UpdateEvaluation> createUpdateEvaluation(UpdateEvaluation value) {
        return new JAXBElement<UpdateEvaluation>(_UpdateEvaluation_QNAME, UpdateEvaluation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEvaluationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateEvaluationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updateEvaluationResponse")
    public JAXBElement<UpdateEvaluationResponse> createUpdateEvaluationResponse(UpdateEvaluationResponse value) {
        return new JAXBElement<UpdateEvaluationResponse>(_UpdateEvaluationResponse_QNAME, UpdateEvaluationResponse.class, null, value);
    }

}
