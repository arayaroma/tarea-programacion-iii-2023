package cr.ac.una.controller;

import cr.ac.una.dto.GeneralInformationDto;
import cr.ac.una.services.GeneralInformationService;
import cr.ac.una.util.ResponseWrapper;
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
    GeneralInformationService companyService;

    /**
     * @param generalInformationDto
     * @return ResponseWrapper with the result of the operation and the created
     *         GeneralInformationDto
     */
    @WebMethod(operationName = "createGeneralInformation")
    public ResponseWrapper createGeneralInformation(GeneralInformationDto generalInformationDto) {
        return companyService.createGeneralInfomation(generalInformationDto);
    }

    /**
     * @param generalInformationDto
     * @return ResponseWrapper with the result of the operation and the updated
     *         GeneralInformationDto
     */
    @WebMethod(operationName = "updateGeneralInformation")
    public ResponseWrapper updateGeneralInformation(GeneralInformationDto generalInformationDto) {
        return companyService.updateGeneralInformation(generalInformationDto);
    }

    /**
     * @return ResponseWrapper with the result of the operation and the
     *         GeneralInformationDto
     */
    @WebMethod(operationName = "getGeneralInformation")
    public ResponseWrapper getGeneralInformation() {
        return companyService.getGeneralInformation();
    }

    /**
     * @param id the id of the company to be retrieved
     * @return ResponseWrapper with the result of the operation and the
     *         GeneralInformationDto
     */
    @WebMethod(operationName = "getGeneralInformationById")
    public ResponseWrapper getGeneralInformation(Long id) {
        return companyService.getGeneralInformation(id);
    }

    /**
     * @param id the id of the company to be deleted
     * @return ResponseWrapper with the result of the operation
     *         GeneralInformationDto
     */
    @WebMethod(operationName = "deleteGeneralInformationById")
    public ResponseWrapper deleteGeneralInformation(Long id) {
        return companyService.deleteGeneralInformation(id);
    }

}