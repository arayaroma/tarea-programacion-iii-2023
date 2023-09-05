package cr.ac.una.dto;

import cr.ac.una.entities.GeneralInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author arayaroma
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralInformationDto {

    private String name;
    private String email;
    private byte[] photo;
    private String htmltemplate;
    private Long version;

    /**
     * @param generalInformation constructor to convert an entity to a dto
     */
    public GeneralInformationDto(GeneralInformation generalInformation) {
        this.name = generalInformation.getName();
        this.email = generalInformation.getEmail();
        this.photo = generalInformation.getPhoto();
        this.htmltemplate = generalInformation.getHtmltemplate();
        this.version = generalInformation.getVersion();
    }

}