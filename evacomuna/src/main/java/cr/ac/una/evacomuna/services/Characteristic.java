package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.*;

/**
 *
 * @author estebannajera
 */
public class Characteristic {

    CharacteristicController port;
    CharacteristicController_Service service;

    public Characteristic() {
        service = new CharacteristicController_Service();
        port = service.getCharacteristicControllerPort();
    }

    public ResponseWrapper createCharacteristic(CharacteristicDto characteristicDto) {
        return port.createCharacteristic(characteristicDto);
    }
//    public ResponseWrapper getCharacteristics() {
//        return port.
//    }

//    private CharacteristicService service;
//    private CompanyController port;
//    public Company() {
//        port = service.getCompanyControllerPort();
//
//    }
//
//    public ResponseWrapper createCompany(CompanyDto companyDto) {
//        return port.createCompany(companyDto);
//    }
//
//    public ResponseWrapper updateCompany(CompanyDto companyDto, String name) {
//        return port.updateCompany(companyDto, name);
//    }
}
