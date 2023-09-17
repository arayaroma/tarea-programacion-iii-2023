package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.GeneralInformationController_Service;
import cr.ac.una.controller.GeneralInformationController;
import cr.ac.una.controller.GeneralInformationDto;
import cr.ac.una.controller.ResponseWrapper;

/**
 *
 * @author estebannajera
 */
public class Company {

    private GeneralInformationController port;
    private GeneralInformationController_Service service;

    public Company() {
        service = new GeneralInformationController_Service();
        port = service.getGeneralInformationControllerPort();
    }

    ResponseWrapper createGeneralInformation(GeneralInformationDto generalInformationDto) {
        return port.createGeneralInformation(generalInformationDto);
    }

    ResponseWrapper updateGeneralInformation(GeneralInformationDto generalInformationDto) {
        return port.updateGeneralInformation(generalInformationDto);
    }

}
