package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.*;

/**
 *
 * @author estebannajera
 */
public class Company {

    private CompanyController_Service service;
    private CompanyController port;

    public Company() {
        port = service.getCompanyControllerPort();

    }

    public ResponseWrapper createCompany(CompanyDto companyDto) {
        return port.createCompany(companyDto);
    }

    public ResponseWrapper updateCompany(CompanyDto companyDto, String name) {
        return port.updateCompany(companyDto, name);
    }

}
