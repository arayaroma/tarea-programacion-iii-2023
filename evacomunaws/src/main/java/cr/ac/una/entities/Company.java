package cr.ac.una.entities;

import cr.ac.una.dto.CompanyDto;
import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author estebannajera
 */
@Entity
@Table(name = "TBL_COMPANY")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name"),
    @NamedQuery(name = "Company.findByEmail", query = "SELECT c FROM Company c WHERE c.email = :email")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "PHOTO")
    private byte[] photo;

    public Company(CompanyDto companyDto) {
        this.name = companyDto.getName();
        this.email = companyDto.getEmail();
        this.photo = companyDto.getPhoto();
    }

}
