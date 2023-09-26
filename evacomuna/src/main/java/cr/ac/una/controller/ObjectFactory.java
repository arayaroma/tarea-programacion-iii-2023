
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

<<<<<<< HEAD
    private final static QName _CreateFinalCalification_QNAME = new QName("http://controller.una.ac.cr/", "createFinalCalification");
    private final static QName _CreateFinalCalificationResponse_QNAME = new QName("http://controller.una.ac.cr/", "createFinalCalificationResponse");
    private final static QName _DeleteFinalCalificationById_QNAME = new QName("http://controller.una.ac.cr/", "deleteFinalCalificationById");
    private final static QName _DeleteFinalCalificationByIdResponse_QNAME = new QName("http://controller.una.ac.cr/", "deleteFinalCalificationByIdResponse");
    private final static QName _GetAllFinalCalification_QNAME = new QName("http://controller.una.ac.cr/", "getAllFinalCalification");
    private final static QName _GetAllFinalCalificationResponse_QNAME = new QName("http://controller.una.ac.cr/", "getAllFinalCalificationResponse");
    private final static QName _GetAverage_QNAME = new QName("http://controller.una.ac.cr/", "getAverage");
    private final static QName _GetAverageResponse_QNAME = new QName("http://controller.una.ac.cr/", "getAverageResponse");
    private final static QName _GetFinalCalificationById_QNAME = new QName("http://controller.una.ac.cr/", "getFinalCalificationById");
    private final static QName _GetFinalCalificationByIdResponse_QNAME = new QName("http://controller.una.ac.cr/", "getFinalCalificationByIdResponse");
    private final static QName _GetFinalCalificationNote_QNAME = new QName("http://controller.una.ac.cr/", "getFinalCalificationNote");
    private final static QName _GetFinalCalificationNoteResponse_QNAME = new QName("http://controller.una.ac.cr/", "getFinalCalificationNoteResponse");
    private final static QName _ListWrapper_QNAME = new QName("http://controller.una.ac.cr/", "listWrapper");
    private final static QName _UpdateFinalCalification_QNAME = new QName("http://controller.una.ac.cr/", "updateFinalCalification");
    private final static QName _UpdateFinalCalificationResponse_QNAME = new QName("http://controller.una.ac.cr/", "updateFinalCalificationResponse");
=======
    private final static QName _CharacteristicDto_QNAME = new QName("http://controller.una.ac.cr/", "CharacteristicDto");
    private final static QName _PositionDto_QNAME = new QName("http://controller.una.ac.cr/", "PositionDto");
    private final static QName _UserDto_QNAME = new QName("http://controller.una.ac.cr/", "UserDto");
    private final static QName _CreateCalification_QNAME = new QName("http://controller.una.ac.cr/", "createCalification");
    private final static QName _CreateCalificationResponse_QNAME = new QName("http://controller.una.ac.cr/", "createCalificationResponse");
    private final static QName _DeleteCalificationById_QNAME = new QName("http://controller.una.ac.cr/", "deleteCalificationById");
    private final static QName _DeleteCalificationByIdResponse_QNAME = new QName("http://controller.una.ac.cr/", "deleteCalificationByIdResponse");
    private final static QName _GetAllCalification_QNAME = new QName("http://controller.una.ac.cr/", "getAllCalification");
    private final static QName _GetAllCalificationResponse_QNAME = new QName("http://controller.una.ac.cr/", "getAllCalificationResponse");
    private final static QName _GetCalificationById_QNAME = new QName("http://controller.una.ac.cr/", "getCalificationById");
    private final static QName _GetCalificationByIdResponse_QNAME = new QName("http://controller.una.ac.cr/", "getCalificationByIdResponse");
    private final static QName _GetCalificationNote_QNAME = new QName("http://controller.una.ac.cr/", "getCalificationNote");
    private final static QName _GetCalificationNoteResponse_QNAME = new QName("http://controller.una.ac.cr/", "getCalificationNoteResponse");
    private final static QName _ListWrapper_QNAME = new QName("http://controller.una.ac.cr/", "listWrapper");
    private final static QName _UpdateCalification_QNAME = new QName("http://controller.una.ac.cr/", "updateCalification");
    private final static QName _UpdateCalificationResponse_QNAME = new QName("http://controller.una.ac.cr/", "updateCalificationResponse");
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cr.ac.una.controller
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateFinalCalification }
     * 
     */
    public CreateFinalCalification createCreateFinalCalification() {
        return new CreateFinalCalification();
    }

    /**
     * Create an instance of {@link CreateFinalCalificationResponse }
     * 
     */
    public CreateFinalCalificationResponse createCreateFinalCalificationResponse() {
        return new CreateFinalCalificationResponse();
    }

    /**
     * Create an instance of {@link DeleteFinalCalificationById }
     * 
     */
    public DeleteFinalCalificationById createDeleteFinalCalificationById() {
        return new DeleteFinalCalificationById();
    }

    /**
     * Create an instance of {@link DeleteFinalCalificationByIdResponse }
     * 
     */
    public DeleteFinalCalificationByIdResponse createDeleteFinalCalificationByIdResponse() {
        return new DeleteFinalCalificationByIdResponse();
    }

    /**
     * Create an instance of {@link GetAllFinalCalification }
     * 
     */
    public GetAllFinalCalification createGetAllFinalCalification() {
        return new GetAllFinalCalification();
    }

    /**
     * Create an instance of {@link GetAllFinalCalificationResponse }
     * 
     */
    public GetAllFinalCalificationResponse createGetAllFinalCalificationResponse() {
        return new GetAllFinalCalificationResponse();
    }

    /**
     * Create an instance of {@link GetAverage }
     * 
     */
    public GetAverage createGetAverage() {
        return new GetAverage();
    }

    /**
     * Create an instance of {@link GetAverageResponse }
     * 
     */
    public GetAverageResponse createGetAverageResponse() {
        return new GetAverageResponse();
    }

    /**
     * Create an instance of {@link GetFinalCalificationById }
     * 
     */
    public GetFinalCalificationById createGetFinalCalificationById() {
        return new GetFinalCalificationById();
    }

    /**
     * Create an instance of {@link GetFinalCalificationByIdResponse }
     * 
     */
    public GetFinalCalificationByIdResponse createGetFinalCalificationByIdResponse() {
        return new GetFinalCalificationByIdResponse();
    }

    /**
     * Create an instance of {@link GetFinalCalificationNote }
     * 
     */
    public GetFinalCalificationNote createGetFinalCalificationNote() {
        return new GetFinalCalificationNote();
    }

    /**
     * Create an instance of {@link GetFinalCalificationNoteResponse }
     * 
     */
    public GetFinalCalificationNoteResponse createGetFinalCalificationNoteResponse() {
        return new GetFinalCalificationNoteResponse();
    }

    /**
     * Create an instance of {@link ListWrapper }
     * 
     */
    public ListWrapper createListWrapper() {
        return new ListWrapper();
    }

    /**
     * Create an instance of {@link UpdateFinalCalification }
     * 
     */
    public UpdateFinalCalification createUpdateFinalCalification() {
        return new UpdateFinalCalification();
    }

    /**
     * Create an instance of {@link UpdateFinalCalificationResponse }
     * 
     */
    public UpdateFinalCalificationResponse createUpdateFinalCalificationResponse() {
        return new UpdateFinalCalificationResponse();
    }

    /**
     * Create an instance of {@link FinalCalificationDto }
     * 
     */
    public FinalCalificationDto createFinalCalificationDto() {
        return new FinalCalificationDto();
    }

    /**
     * Create an instance of {@link EvaluatedDto }
     * 
     */
    public EvaluatedDto createEvaluatedDto() {
        return new EvaluatedDto();
    }

    /**
     * Create an instance of {@link UserDto }
     * 
     */
    public UserDto createUserDto() {
        return new UserDto();
    }

    /**
     * Create an instance of {@link EvaluatorDto }
     * 
     */
    public EvaluatorDto createEvaluatorDto() {
        return new EvaluatorDto();
    }

    /**
     * Create an instance of {@link CalificationDto }
     * 
     */
    public CalificationDto createCalificationDto() {
        return new CalificationDto();
    }

    /**
     * Create an instance of {@link SkillDto }
     * 
     */
    public SkillDto createSkillDto() {
        return new SkillDto();
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
<<<<<<< HEAD
     * Create an instance of {@link EvaluationDto }
     * 
     */
    public EvaluationDto createEvaluationDto() {
        return new EvaluationDto();
    }

    /**
     * Create an instance of {@link ResponseWrapper }
=======
     * Create an instance of {@link UserDto }
     * 
     */
    public UserDto createUserDto() {
        return new UserDto();
    }

    /**
     * Create an instance of {@link CreateCalification }
     * 
     */
    public CreateCalification createCreateCalification() {
        return new CreateCalification();
    }

    /**
     * Create an instance of {@link CreateCalificationResponse }
     * 
     */
    public CreateCalificationResponse createCreateCalificationResponse() {
        return new CreateCalificationResponse();
    }

    /**
     * Create an instance of {@link DeleteCalificationById }
     * 
     */
    public DeleteCalificationById createDeleteCalificationById() {
        return new DeleteCalificationById();
    }

    /**
     * Create an instance of {@link DeleteCalificationByIdResponse }
     * 
     */
    public DeleteCalificationByIdResponse createDeleteCalificationByIdResponse() {
        return new DeleteCalificationByIdResponse();
    }

    /**
     * Create an instance of {@link GetAllCalification }
     * 
     */
    public GetAllCalification createGetAllCalification() {
        return new GetAllCalification();
    }

    /**
     * Create an instance of {@link GetAllCalificationResponse }
     * 
     */
    public GetAllCalificationResponse createGetAllCalificationResponse() {
        return new GetAllCalificationResponse();
    }

    /**
     * Create an instance of {@link GetCalificationById }
     * 
     */
    public GetCalificationById createGetCalificationById() {
        return new GetCalificationById();
    }

    /**
     * Create an instance of {@link GetCalificationByIdResponse }
     * 
     */
    public GetCalificationByIdResponse createGetCalificationByIdResponse() {
        return new GetCalificationByIdResponse();
    }

    /**
     * Create an instance of {@link GetCalificationNote }
     * 
     */
    public GetCalificationNote createGetCalificationNote() {
        return new GetCalificationNote();
    }

    /**
     * Create an instance of {@link GetCalificationNoteResponse }
     * 
     */
    public GetCalificationNoteResponse createGetCalificationNoteResponse() {
        return new GetCalificationNoteResponse();
    }

    /**
     * Create an instance of {@link ListWrapper }
     * 
     */
    public ListWrapper createListWrapper() {
        return new ListWrapper();
    }

    /**
     * Create an instance of {@link UpdateCalification }
     * 
     */
    public UpdateCalification createUpdateCalification() {
        return new UpdateCalification();
    }

    /**
     * Create an instance of {@link UpdateCalificationResponse }
     * 
     */
    public UpdateCalificationResponse createUpdateCalificationResponse() {
        return new UpdateCalificationResponse();
    }

    /**
     * Create an instance of {@link ResponseWrapper }
     * 
     */
    public ResponseWrapper createResponseWrapper() {
        return new ResponseWrapper();
    }

    /**
     * Create an instance of {@link CalificationDto }
     * 
     */
    public CalificationDto createCalificationDto() {
        return new CalificationDto();
    }

    /**
     * Create an instance of {@link EvaluatorDto }
     * 
     */
    public EvaluatorDto createEvaluatorDto() {
        return new EvaluatorDto();
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
     * Create an instance of {@link FinalCalificationDto }
     * 
     */
    public FinalCalificationDto createFinalCalificationDto() {
        return new FinalCalificationDto();
    }

    /**
     * Create an instance of {@link EvaluationDto }
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
     * 
     */
    public EvaluationDto createEvaluationDto() {
        return new EvaluationDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateFinalCalification }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateFinalCalification }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "createFinalCalification")
    public JAXBElement<CreateFinalCalification> createCreateFinalCalification(CreateFinalCalification value) {
        return new JAXBElement<CreateFinalCalification>(_CreateFinalCalification_QNAME, CreateFinalCalification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateFinalCalificationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateFinalCalificationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "createFinalCalificationResponse")
    public JAXBElement<CreateFinalCalificationResponse> createCreateFinalCalificationResponse(CreateFinalCalificationResponse value) {
        return new JAXBElement<CreateFinalCalificationResponse>(_CreateFinalCalificationResponse_QNAME, CreateFinalCalificationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFinalCalificationById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteFinalCalificationById }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "deleteFinalCalificationById")
    public JAXBElement<DeleteFinalCalificationById> createDeleteFinalCalificationById(DeleteFinalCalificationById value) {
        return new JAXBElement<DeleteFinalCalificationById>(_DeleteFinalCalificationById_QNAME, DeleteFinalCalificationById.class, null, value);
    }

    /**
<<<<<<< HEAD
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFinalCalificationByIdResponse }{@code >}
=======
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCalification }{@code >}
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
<<<<<<< HEAD
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteFinalCalificationByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "deleteFinalCalificationByIdResponse")
    public JAXBElement<DeleteFinalCalificationByIdResponse> createDeleteFinalCalificationByIdResponse(DeleteFinalCalificationByIdResponse value) {
        return new JAXBElement<DeleteFinalCalificationByIdResponse>(_DeleteFinalCalificationByIdResponse_QNAME, DeleteFinalCalificationByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFinalCalification }{@code >}
=======
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateCalification }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "createCalification")
    public JAXBElement<CreateCalification> createCreateCalification(CreateCalification value) {
        return new JAXBElement<CreateCalification>(_CreateCalification_QNAME, CreateCalification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCalificationResponse }{@code >}
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
<<<<<<< HEAD
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllFinalCalification }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getAllFinalCalification")
    public JAXBElement<GetAllFinalCalification> createGetAllFinalCalification(GetAllFinalCalification value) {
        return new JAXBElement<GetAllFinalCalification>(_GetAllFinalCalification_QNAME, GetAllFinalCalification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFinalCalificationResponse }{@code >}
=======
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateCalificationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "createCalificationResponse")
    public JAXBElement<CreateCalificationResponse> createCreateCalificationResponse(CreateCalificationResponse value) {
        return new JAXBElement<CreateCalificationResponse>(_CreateCalificationResponse_QNAME, CreateCalificationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCalificationById }{@code >}
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
<<<<<<< HEAD
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllFinalCalificationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getAllFinalCalificationResponse")
    public JAXBElement<GetAllFinalCalificationResponse> createGetAllFinalCalificationResponse(GetAllFinalCalificationResponse value) {
        return new JAXBElement<GetAllFinalCalificationResponse>(_GetAllFinalCalificationResponse_QNAME, GetAllFinalCalificationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAverage }{@code >}
=======
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteCalificationById }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "deleteCalificationById")
    public JAXBElement<DeleteCalificationById> createDeleteCalificationById(DeleteCalificationById value) {
        return new JAXBElement<DeleteCalificationById>(_DeleteCalificationById_QNAME, DeleteCalificationById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCalificationByIdResponse }{@code >}
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
<<<<<<< HEAD
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAverage }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getAverage")
    public JAXBElement<GetAverage> createGetAverage(GetAverage value) {
        return new JAXBElement<GetAverage>(_GetAverage_QNAME, GetAverage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAverageResponse }{@code >}
=======
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteCalificationByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "deleteCalificationByIdResponse")
    public JAXBElement<DeleteCalificationByIdResponse> createDeleteCalificationByIdResponse(DeleteCalificationByIdResponse value) {
        return new JAXBElement<DeleteCalificationByIdResponse>(_DeleteCalificationByIdResponse_QNAME, DeleteCalificationByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCalification }{@code >}
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
<<<<<<< HEAD
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAverageResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getAverageResponse")
    public JAXBElement<GetAverageResponse> createGetAverageResponse(GetAverageResponse value) {
        return new JAXBElement<GetAverageResponse>(_GetAverageResponse_QNAME, GetAverageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFinalCalificationById }{@code >}
=======
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllCalification }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getAllCalification")
    public JAXBElement<GetAllCalification> createGetAllCalification(GetAllCalification value) {
        return new JAXBElement<GetAllCalification>(_GetAllCalification_QNAME, GetAllCalification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCalificationResponse }{@code >}
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
<<<<<<< HEAD
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFinalCalificationById }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getFinalCalificationById")
    public JAXBElement<GetFinalCalificationById> createGetFinalCalificationById(GetFinalCalificationById value) {
        return new JAXBElement<GetFinalCalificationById>(_GetFinalCalificationById_QNAME, GetFinalCalificationById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFinalCalificationByIdResponse }{@code >}
=======
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllCalificationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getAllCalificationResponse")
    public JAXBElement<GetAllCalificationResponse> createGetAllCalificationResponse(GetAllCalificationResponse value) {
        return new JAXBElement<GetAllCalificationResponse>(_GetAllCalificationResponse_QNAME, GetAllCalificationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCalificationById }{@code >}
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
<<<<<<< HEAD
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFinalCalificationByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getFinalCalificationByIdResponse")
    public JAXBElement<GetFinalCalificationByIdResponse> createGetFinalCalificationByIdResponse(GetFinalCalificationByIdResponse value) {
        return new JAXBElement<GetFinalCalificationByIdResponse>(_GetFinalCalificationByIdResponse_QNAME, GetFinalCalificationByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFinalCalificationNote }{@code >}
=======
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCalificationById }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getCalificationById")
    public JAXBElement<GetCalificationById> createGetCalificationById(GetCalificationById value) {
        return new JAXBElement<GetCalificationById>(_GetCalificationById_QNAME, GetCalificationById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCalificationByIdResponse }{@code >}
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
<<<<<<< HEAD
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFinalCalificationNote }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getFinalCalificationNote")
    public JAXBElement<GetFinalCalificationNote> createGetFinalCalificationNote(GetFinalCalificationNote value) {
        return new JAXBElement<GetFinalCalificationNote>(_GetFinalCalificationNote_QNAME, GetFinalCalificationNote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFinalCalificationNoteResponse }{@code >}
=======
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCalificationByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getCalificationByIdResponse")
    public JAXBElement<GetCalificationByIdResponse> createGetCalificationByIdResponse(GetCalificationByIdResponse value) {
        return new JAXBElement<GetCalificationByIdResponse>(_GetCalificationByIdResponse_QNAME, GetCalificationByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCalificationNote }{@code >}
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
<<<<<<< HEAD
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFinalCalificationNoteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getFinalCalificationNoteResponse")
    public JAXBElement<GetFinalCalificationNoteResponse> createGetFinalCalificationNoteResponse(GetFinalCalificationNoteResponse value) {
        return new JAXBElement<GetFinalCalificationNoteResponse>(_GetFinalCalificationNoteResponse_QNAME, GetFinalCalificationNoteResponse.class, null, value);
=======
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCalificationNote }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getCalificationNote")
    public JAXBElement<GetCalificationNote> createGetCalificationNote(GetCalificationNote value) {
        return new JAXBElement<GetCalificationNote>(_GetCalificationNote_QNAME, GetCalificationNote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCalificationNoteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCalificationNoteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "getCalificationNoteResponse")
    public JAXBElement<GetCalificationNoteResponse> createGetCalificationNoteResponse(GetCalificationNoteResponse value) {
        return new JAXBElement<GetCalificationNoteResponse>(_GetCalificationNoteResponse_QNAME, GetCalificationNoteResponse.class, null, value);
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
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
<<<<<<< HEAD
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFinalCalification }{@code >}
=======
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCalification }{@code >}
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
<<<<<<< HEAD
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateFinalCalification }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updateFinalCalification")
    public JAXBElement<UpdateFinalCalification> createUpdateFinalCalification(UpdateFinalCalification value) {
        return new JAXBElement<UpdateFinalCalification>(_UpdateFinalCalification_QNAME, UpdateFinalCalification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFinalCalificationResponse }{@code >}
=======
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateCalification }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updateCalification")
    public JAXBElement<UpdateCalification> createUpdateCalification(UpdateCalification value) {
        return new JAXBElement<UpdateCalification>(_UpdateCalification_QNAME, UpdateCalification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCalificationResponse }{@code >}
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
<<<<<<< HEAD
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateFinalCalificationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updateFinalCalificationResponse")
    public JAXBElement<UpdateFinalCalificationResponse> createUpdateFinalCalificationResponse(UpdateFinalCalificationResponse value) {
        return new JAXBElement<UpdateFinalCalificationResponse>(_UpdateFinalCalificationResponse_QNAME, UpdateFinalCalificationResponse.class, null, value);
=======
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateCalificationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.una.ac.cr/", name = "updateCalificationResponse")
    public JAXBElement<UpdateCalificationResponse> createUpdateCalificationResponse(UpdateCalificationResponse value) {
        return new JAXBElement<UpdateCalificationResponse>(_UpdateCalificationResponse_QNAME, UpdateCalificationResponse.class, null, value);
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
    }

}
