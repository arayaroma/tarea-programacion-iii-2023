package cr.ac.una.services;

import cr.ac.una.dto.UserDto;
import cr.ac.una.util.ResponseCode;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * 
 * @author arayaroma
 */
@Stateless
@LocalBean
public class ActivationServiceImp implements ActivationService {

    @EJB
    UserService userService;

    @Override
    public ResponseWrapper activateUser(Long id, String hash) {
        UserDto userDto = (UserDto) userService.getUserById(id).getData();
        if (validateHash(userDto.getActivationCode(), hash)) {
            userService.activateUser(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User activated",
                    null);
        }
        return new ResponseWrapper(
                ResponseCode.UNAUTHORIZED.getCode(),
                ResponseCode.UNAUTHORIZED,
                "Invalid hash",
                null);
    }

    private Boolean validateHash(String userHash, String hash) {
        return userHash.equals(hash);
    }
}
