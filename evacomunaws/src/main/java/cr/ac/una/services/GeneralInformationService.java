package cr.ac.una.services;

import cr.ac.una.dto.GeneralInformationDto;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 *
 * @author arayaroma
 */
@Local
public interface GeneralInformationService {

    ResponseWrapper createGeneralInfomation(GeneralInformationDto generalInformationDto);

    ResponseWrapper updateGeneralInformation(GeneralInformationDto generalInformationDto);

}