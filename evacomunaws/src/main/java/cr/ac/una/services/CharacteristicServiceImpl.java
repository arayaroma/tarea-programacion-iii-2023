package cr.ac.una.services;

import cr.ac.una.dto.CharacteristicDto;
import cr.ac.una.dto.SkillDto;
import cr.ac.una.entities.Characteristic;
import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;
import static cr.ac.una.util.EntityUtil.verifyEntity;
import cr.ac.una.util.EntityUtil;
import cr.ac.una.util.ResponseCode;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author enajera
 * @author arayaroma
 */
@Stateless
@LocalBean
public class CharacteristicServiceImpl implements CharacteristicService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    /**
     * @param characteristic characteristic to be created
     * @return ResponseWrapper with the response of the service call
     * createCharacteristic
     */
    @Override
    public ResponseWrapper createCharacteristic(CharacteristicDto characteristicDto) {
        try {
            Characteristic characteristic = new Characteristic(characteristicDto);
            ResponseWrapper INVALID_REQUEST = verifyEntity(characteristic, Characteristic.class);
            if (INVALID_REQUEST != null) {
                return INVALID_REQUEST;
            }
            em.persist(characteristic);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Characteristic created successfully.",
                    characteristicDto);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while creating characteristic: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param characteristic characteristic to be updated
     * @return ResponseWrapper with the response of the service call
     * updateCharacteristic
     */
    @Override
    public ResponseWrapper updateCharacteristic(CharacteristicDto characteristicDto) {
        try {
            Characteristic characteristic = em.find(Characteristic.class, characteristicDto.getId());

            if (characteristic == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Characteristic doesn't exist.",
                        null);
            }
            characteristic.updateCharacteristic(characteristicDto);
            System.out.println(characteristic.getSkill());
            ResponseWrapper INVALID_REQUEST = verifyEntity(characteristic, Characteristic.class);
            if (INVALID_REQUEST != null) {
                return INVALID_REQUEST;
            }
            em.merge(characteristic);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Characteristic updated successfully.",
                    characteristicDto);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while updating characteristic: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param id characteristic id to be searched
     * @return ResponseWrapper with the response of the service call
     * getCharacteristicById
     */
    @Override
    public ResponseWrapper getCharacteristicById(Long id) {
        try {
            Characteristic characteristic = em.find(Characteristic.class, id);
            if (characteristic == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Characteristic doesn't exist.",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Characteristic found successfully.",
                    new CharacteristicDto(characteristic));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while fetching the characteristic: " + e.getMessage(),
                    null);
        }
    }

    /**
     * @param name characteristic name to be searched
     * @return ResponseWrapper with the response of the service call
     * getCharacteristicByName
     */
    @Override
    public ResponseWrapper getCharacteristicByName(String name) {
        try {
            Characteristic characteristic = (Characteristic) em.createNamedQuery("Characteristic.findByName")
                    .setParameter("name", name)
                    .getSingleResult();
            if (characteristic == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Characteristic doesn't exist.",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Characteristic found successfully.",
                    new CharacteristicDto(characteristic));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while fetching the characteristic: " + e.getMessage(),
                    null);
        }
    }

    /**
     * @return ResponseWrapper with the response of the service call
     * getCharacteristics
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getCharacteristics() {
        try {
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Characteristic selected successfully.",
                    EntityUtil.fromEntityList(
                            em.createNamedQuery("Characteristic.findAll")
                                    .getResultList(),
                            CharacteristicDto.class));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while creating characteristic: " + e.getMessage(),
                    null);
        }
    }

    /**
     * @param id
     * @return ResponseWrapper with the response of the service call
     * getSkillsByCharacteristicId
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getSkillsByCharacteristicId(Long id) {
        try {
            Characteristic characteristic = em.find(Characteristic.class, id);
            if (characteristic == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Characteristic not found.",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Skills retrieved successfully.",
                    EntityUtil.fromEntityList(
                            em.createNamedQuery("Characteristic.getSkillsByCharacteristicId").getResultList(),
                            SkillDto.class));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving skills: " + e.getMessage(),
                    null);
        }
    }

    /**
     * @param id characteristic id to be deleted
     * @return ResponseWrapper with the response of the service call
     * deleteCharacteristicById
     */
    @Override
    public ResponseWrapper deleteCharacteristicById(Long id) {
        try {
            Characteristic characteristic = em.find(Characteristic.class, id);
            if (characteristic == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Characteristic doesn't exist.",
                        null);
            }
            em.remove(characteristic);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Characteristic deleted successfully.",
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting characteristic: " + e.getMessage(),
                    null);
        }
    }

    /**
     * @param name characteristic name to be deleted
     * @return ResponseWrapper with the response of the service call
     * deleteCharacteristicByName
     */
    @Override
    public ResponseWrapper deleteCharacteristicByName(String name) {
        try {
            Characteristic characteristic = (Characteristic) em.createNamedQuery("Characteristic.findByName")
                    .setParameter("name", name)
                    .getSingleResult();
            if (characteristic == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Characteristic doesn't exist.",
                        null);
            }
            em.remove(characteristic);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Characteristic deleted successfully.",
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting characteristic: " + e.getMessage(),
                    null);
        }
    }

    /**
     * @return ResponseWrapper with the response of the service call
     * deleteAllCharacteristics
     */
    @Override
    public ResponseWrapper deleteAllCharacteristics() {
        try {
            em.createNamedQuery("Characteristic.deleteAll")
                    .executeUpdate();
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "All characteristics deleted successfully.",
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting characteristics: " + e.getMessage(),
                    null);
        }
    }

}
