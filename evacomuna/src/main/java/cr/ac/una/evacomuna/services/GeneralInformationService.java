package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.GeneralInformationController_Service;
import cr.ac.una.controller.GeneralInformationController;
import cr.ac.una.evacomuna.dto.GeneralInformationDto;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public class GeneralInformationService {

    private GeneralInformationController port;
    private GeneralInformationController_Service service;

    /**
     * Default instance of the service
     */
    public GeneralInformationService() {
        service = new GeneralInformationController_Service();
        port = service.getGeneralInformationControllerPort();
    }

    /**
     * Creates a new generalInformation
     * 
     * @param generalInformationDto object to create
     * @return GeneralInformationDto with the created generalInformation if found,
     *         null otherwise
     */
    public ResponseWrapper createGeneralInformation(GeneralInformationDto generalInformationDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port
                    .createGeneralInformation(generalInformationDto.getDto());
            cr.ac.una.controller.GeneralInformationDto generalInformation = (cr.ac.una.controller.GeneralInformationDto) response
                    .getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "GeneralInformation created successfully",
                    new GeneralInformationDto(generalInformation));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating generalInformation",
                    null);
        }
    }

    /**
     * Updates the generalInformation
     * 
     * @param generalInformationDto object to update
     * @return GeneralInformationDto with the updated generalInformation if found,
     *         null otherwise
     */
    public ResponseWrapper updateGeneralInformation(GeneralInformationDto generalInformationDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port
                    .updateGeneralInformation(generalInformationDto.getDto());
            cr.ac.una.controller.GeneralInformationDto generalInformation = (cr.ac.una.controller.GeneralInformationDto) response
                    .getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "GeneralInformation updated successfully",
                    new GeneralInformationDto(generalInformation));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating generalInformation",
                    null);
        }
    }

    /**
     * Get all generalInformations
     * 
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getGeneralInformation() {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getGeneralInformation();
            cr.ac.una.controller.GeneralInformationDto generalInformation = (cr.ac.una.controller.GeneralInformationDto) response
                    .getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "GeneralInformation found successfully",
                    new GeneralInformationDto(generalInformation));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "GeneralInformation not found",
                    null);
        }
    }

    /**
     * Get a generalInformation by id
     * 
     * @param id of the generalInformation
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getGeneralInformationById(Long id) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getGeneralInformationById(id);
            cr.ac.una.controller.GeneralInformationDto generalInformation = (cr.ac.una.controller.GeneralInformationDto) response
                    .getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "GeneralInformation found successfully",
                    new GeneralInformationDto(generalInformation));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "GeneralInformation not found",
                    null);
        }
    }

    /**
     * Deletes a generalInformation by id
     * 
     * @param id of the generalInformation
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper deleteGeneralInformationById(Long id) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.deleteGeneralInformationById(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "GeneralInformation deleted successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "GeneralInformation not found",
                    null);
        }
    }

}
