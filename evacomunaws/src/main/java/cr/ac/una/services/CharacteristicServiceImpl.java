package cr.ac.una.services;

import cr.ac.una.dto.CharacteristicDto;
import cr.ac.una.entities.Characteristic;
import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;
import static cr.ac.una.util.EntityUtil.verifyEntity;
import cr.ac.una.util.ResponseCode;
import cr.ac.una.util.ResponseWrapper;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.ws.rs.core.GenericEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arayaroma
 */
@Stateless
@LocalBean
public class CharacteristicServiceImpl implements CharacteristicService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

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

    @Override
    public ResponseWrapper updateCharacteristic(CharacteristicDto characteristicDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseWrapper selectCharacteristics() {
        try {
            //Revisar el envio de listas por XML
            Query query = em.createNamedQuery("Characteristic.findAll");
            List<Characteristic> characteristics = query.getResultList();
            List<CharacteristicDto> characteristicDto = new ArrayList<>();
            for (Characteristic i : characteristics) {
                characteristicDto.add(new CharacteristicDto(i));
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Characteristic selected successfully.",
                    characteristicDto);
//            return new RespuestaEsteban(ResponseCode.OK.getCode(), ResponseCode.OK, "Characteristics selected", "characteristics", characteristicDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while creating characteristic: " + e.getMessage(),
                    null);
//            return new RespuestaEsteban(ResponseCode.OK.getCode(), ResponseCode.OK, "error selected" + e.toString(), "error", null);
        }
    }

}
