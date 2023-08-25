package cr.ac.una.services;

import cr.ac.una.dto.CompanyDto;
import cr.ac.una.entities.Company;
import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;
import cr.ac.una.util.ResponseCode;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author estebannajera
 */
@Stateless
@LocalBean
public class CompanyServiceImpl implements CompanyService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    @Override
    public ResponseWrapper createCompany(CompanyDto companyDto) {
        try {
            Company company = new Company(companyDto);
            em.persist(company);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Company created successfully.",
                    companyDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while creating user: " + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper updateCompany(CompanyDto companyDto, String name) {
        try {
        } catch (Exception e) {
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
