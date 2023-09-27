package cr.ac.una.evacomunaws.controller;

import cr.ac.una.evacomunaws.dto.GeneralInformationDto;
import cr.ac.una.evacomunaws.services.GeneralInformationService;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 *
 * @author arayaroma
 */
@WebService(serviceName = "GeneralInformationController")
public class GeneralInformationController {

    @EJB
    GeneralInformationService generalInformationService;

    /**
     * @param generalInformationDto the GeneralInformationDto to be created
     * @return ResponseWrapper with the result of the operation and the created
     *         GeneralInformationDto
     */
    @WebMethod(operationName = "createGeneralInformation")
    public ResponseWrapper createGeneralInformation(GeneralInformationDto generalInformationDto) {
        return generalInformationService.createGeneralInfomation(generalInformationDto);
    }

    /**
     * @param generalInformationDto the GeneralInformationDto to be updated
     * @return ResponseWrapper with the result of the operation and the updated
     *         GeneralInformationDto
     */
    @WebMethod(operationName = "updateGeneralInformation")
    public ResponseWrapper updateGeneralInformation(GeneralInformationDto generalInformationDto) {
        return generalInformationService.updateGeneralInformation(generalInformationDto);
    }

    /**
     * @return ResponseWrapper with the result of the operation and the
     *         GeneralInformationDto
     */
    @WebMethod(operationName = "getGeneralInformation")
    public ResponseWrapper getGeneralInformation() {
        return generalInformationService.getGeneralInformation();
    }

    /**
     * @param id the id of the company to be retrieved
     * @return ResponseWrapper with the result of the operation and the
     *         GeneralInformationDto
     */
    @WebMethod(operationName = "getGeneralInformationById")
    public ResponseWrapper getGeneralInformationById(Long id) {
        return generalInformationService.getGeneralInformationById(id);
    }

    /**
     * @param id the id of the company to be deleted
     * @return ResponseWrapper with the result of the operation
     *         GeneralInformationDto
     */
    @WebMethod(operationName = "deleteGeneralInformationById")
    public ResponseWrapper deleteGeneralInformation(Long id) {
        return generalInformationService.deleteGeneralInformation(id);
    }

}