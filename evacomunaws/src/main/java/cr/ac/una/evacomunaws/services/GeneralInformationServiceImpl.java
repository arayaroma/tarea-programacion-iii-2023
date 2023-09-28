package cr.ac.una.evacomunaws.services;

<<<<<<< HEAD
import cr.ac.una.evacomunaws.dto.GeneralInformationDto;
import cr.ac.una.evacomunaws.entities.GeneralInformation;
import static cr.ac.una.evacomunaws.util.Constants.PERSISTENCE_UNIT_NAME;
=======
<<<<<<< HEAD
import static cr.ac.una.evacomunaws.util.Constants.PERSISTENCE_UNIT_NAME;

import cr.ac.una.evacomunaws.dto.GeneralInformationDto;
import cr.ac.una.evacomunaws.entities.GeneralInformation;
=======
import cr.ac.una.evacomunaws.dto.GeneralInformationDto;
import cr.ac.una.evacomunaws.entities.GeneralInformation;
import static cr.ac.una.evacomunaws.util.Constants.PERSISTENCE_UNIT_NAME;
>>>>>>> 29c7236 ([FIXING] cr.ac.una.evacomunaws import to ALL CLASSES)
>>>>>>> master
import cr.ac.una.evacomunaws.util.ResponseCode;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
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
     *         GeneralInformationDto
     */
    @Override
    public ResponseWrapper updateGeneralInformation(GeneralInformationDto generalInformationDto) {
        try {
            GeneralInformation generalInformation = em.find(GeneralInformation.class, generalInformationDto.getId());
            if (isGeneralInformationNull(generalInformation)) {
                return handleGeneralInformationNull();
            }
            generalInformation = generalInformationDto.convertFromDTOToEntity(generalInformationDto,
                    generalInformation);
            em.merge(generalInformation);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Company updated successfully.",
                    generalInformationDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while updating company: " + e.getMessage(),
                    null);
        }
    }

    /**
     * @return ResponseWrapper with the result of the operation and the
     *         GeneralInformationDto
     */
    @Override
    public ResponseWrapper getGeneralInformation() {
        try {
            GeneralInformation generalInformation = (GeneralInformation) em
                    .createNamedQuery("GeneralInformation.findAll")
                    .getSingleResult();
            if (isGeneralInformationNull(generalInformation)) {
                return handleGeneralInformationNull();
            }
            GeneralInformationDto generalInformationDto = new GeneralInformationDto(generalInformation);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Company retrieved successfully.",
                    generalInformationDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving company: " + e.getMessage(),
                    null);
        }
    }

    /**
     * @param id the id of the company to be retrieved
     * @return ResponseWrapper with the result of the operation and the
     *         GeneralInformationDto
     */
    @Override
    public ResponseWrapper getGeneralInformationById(Long id) {
        try {
            GeneralInformation generalInformation = em.find(GeneralInformation.class, id);
            if (isGeneralInformationNull(generalInformation)) {
                return handleGeneralInformationNull();
            }
            GeneralInformationDto generalInformationDto = new GeneralInformationDto(generalInformation);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Company retrieved successfully.",
                    generalInformationDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving company: " + e.getMessage(),
                    null);
        }
    }

    /**
     * @param id the id of the company to be deleted
     * @return ResponseWrapper with the result of the operation
     *         GeneralInformationDto
     */
    @Override
    public ResponseWrapper deleteGeneralInformation(Long id) {
        try {
            GeneralInformation generalInformation = em.find(GeneralInformation.class, id);
            if (isGeneralInformationNull(generalInformation)) {
                return handleGeneralInformationNull();
            }
            em.remove(generalInformation);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Company deleted successfully.",
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting company: " + e.getMessage(),
                    null);
        }
    }

    private Boolean isGeneralInformationNull(GeneralInformation generalInformation) {
        return generalInformation == null;
    }

    private ResponseWrapper handleGeneralInformationNull() {
        return new ResponseWrapper(
                ResponseCode.NOT_FOUND.getCode(),
                ResponseCode.NOT_FOUND,
                "Company not found.",
                null);
    }
}