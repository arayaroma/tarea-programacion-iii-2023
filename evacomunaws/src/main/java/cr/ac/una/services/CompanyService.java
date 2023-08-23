package cr.ac.una.services;

import cr.ac.una.dto.CompanyDto;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 *
 * @author estebannajera
 */
@Local
public interface CompanyService {

    ResponseWrapper createCompany(CompanyDto companyDto);

    ResponseWrapper updateCompany(CompanyDto companyDto, String name);
    
}
