package cr.ac.una.evacomunaws.services;

import cr.ac.una.evacomunaws.dto.GeneralInformationDto;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 *
 * @author arayaroma
 */
@Local
public interface GeneralInformationService {

    ResponseWrapper createGeneralInfomation(GeneralInformationDto generalInformationDto);

    ResponseWrapper updateGeneralInformation(GeneralInformationDto generalInformationDto);

    ResponseWrapper getGeneralInformation();

    ResponseWrapper getGeneralInformationById(Long id);

    ResponseWrapper deleteGeneralInformation(Long id);

}