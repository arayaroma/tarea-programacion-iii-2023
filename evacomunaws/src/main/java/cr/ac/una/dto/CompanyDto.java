package cr.ac.una.dto;

import cr.ac.una.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author estebannajera
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    private String name;
    private String email;
    private byte[] photo;

    public CompanyDto(Company company) {
        this.name = company.getName();
        this.email = company.getEmail();
        this.photo = company.getPhoto();
    }

}
