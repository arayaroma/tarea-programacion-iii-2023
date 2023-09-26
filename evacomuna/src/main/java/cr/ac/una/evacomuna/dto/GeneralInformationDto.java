package cr.ac.una.evacomuna.dto;

/**
 * FIXME: Equals and Hash
 * 
 * @author arayaroma
 */
public class GeneralInformationDto {

    private Long id;
    private String name;
    private String email;
    private byte[] photo;
    private String htmltemplate;
    private Long version;

    public GeneralInformationDto() {
    }

    public GeneralInformationDto(cr.ac.una.controller.GeneralInformationDto generalInformationDto) {
        this.id = generalInformationDto.getId();
        this.name = generalInformationDto.getName();
        this.email = generalInformationDto.getEmail();
        this.photo = generalInformationDto.getPhoto();
        this.htmltemplate = generalInformationDto.getHtmltemplate();
        this.version = generalInformationDto.getVersion();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return this.photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getHtmltemplate() {
        return this.htmltemplate;
    }

    public void setHtmltemplate(String htmltemplate) {
        this.htmltemplate = htmltemplate;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", email='" + getEmail() + "'" +
                ", photo='" + getPhoto() + "'" +
                ", htmltemplate='" + getHtmltemplate() + "'" +
                ", version='" + getVersion() + "'" +
                "}";
    }
}
