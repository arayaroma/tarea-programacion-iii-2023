package cr.ac.una.evacomuna.dto;

import cr.ac.una.evacomuna.util.DtoMapper;

/**
 * 
 * @author arayaroma
 */
public class GeneralInformationDto
        implements DtoMapper<cr.ac.una.evacomunaws.controller.GeneralInformationDto, GeneralInformationDto> {

    private Long id;
    private String name;
    private String email;
    private byte[] photo;
    private String htmltemplate;
    private Long version;

    @Override
    public GeneralInformationDto convertFromGeneratedToDTO(cr.ac.una.evacomunaws.controller.GeneralInformationDto generated,
            GeneralInformationDto dto) {
        return new GeneralInformationDto(generated);
    }

    @Override
    public cr.ac.una.evacomunaws.controller.GeneralInformationDto convertFromDTOToGenerated(GeneralInformationDto dto,
            cr.ac.una.evacomunaws.controller.GeneralInformationDto generated) {
        return dto.getDto();
    }

    public GeneralInformationDto() {
    }

    public GeneralInformationDto(cr.ac.una.evacomunaws.controller.GeneralInformationDto generalInformationDto) {
        this.id = generalInformationDto.getId();
        this.name = generalInformationDto.getName();
        this.email = generalInformationDto.getEmail();
        this.photo = generalInformationDto.getPhoto();
        this.htmltemplate = generalInformationDto.getHtmltemplate();
        this.version = generalInformationDto.getVersion();
    }

    public cr.ac.una.evacomunaws.controller.GeneralInformationDto getDto() {
        cr.ac.una.evacomunaws.controller.GeneralInformationDto dto = new cr.ac.una.evacomunaws.controller.GeneralInformationDto();
        dto.setName(this.name);
        dto.setEmail(this.email);
        dto.setPhoto(this.photo);
        dto.setHtmltemplate(this.htmltemplate);
        dto.setVersion(this.version);
        return dto;
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
