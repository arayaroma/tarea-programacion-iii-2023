package cr.ac.una.controller;

import cr.ac.una.dto.CompanyDto;
import cr.ac.una.services.CompanyService;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 *
 * @author estebannajera
 */
@WebService(serviceName = "CompanyController")
public class CompanyController {

    @EJB
    CompanyService companyService;

    @WebMethod(operationName = "createCompany")
    public ResponseWrapper createCompany(CompanyDto companyDto) {
        return companyService.createCompany(companyDto);
    }

    @WebMethod(operationName = "updateCompany")
    public ResponseWrapper updateCompany(CompanyDto companyDto, String name) {
        return companyService.updateCompany(companyDto, name);
    }

}
