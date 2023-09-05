package cr.ac.una.services;

import cr.ac.una.dto.GeneralInformationDto;
import cr.ac.una.entities.GeneralInformation;
import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;
import cr.ac.una.util.ResponseCode;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author arayaroma
 */
@Stateless
@LocalBean
public class GeneralInformationServiceImpl implements GeneralInformationService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    /**
     * @param generalInformationDto the information of the company to be created
     * @return ResponseWrapper with the result of the operation and the created
     *         GeneralInformationDto
     */
    @Override
    public ResponseWrapper createGeneralInfomation(GeneralInformationDto generalInformationDto) {
        try {
            GeneralInformation generalInformation = new GeneralInformation(generalInformationDto);
            em.persist(generalInformation);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Company created successfully.",
                    generalInformationDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while creating user: " + e.getMessage(),
                    null);
        }
    }

    /**
     * @param generalInformationDto the information of the company to be updated
     * @return ResponseWrapper with the result of the operation and the updated 
     *        GeneralInformationDto
     */
    @Override
    public ResponseWrapper updateGeneralInformation(GeneralInformationDto generalInformationDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateGeneralInformation'");
    }

}