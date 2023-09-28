
package cr.ac.una.evacomunaws.controller;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para userDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="userDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="activationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="evaluated" type="{http://controller.evacomunaws.una.ac.cr/}evaluatedDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="evaluators" type="{http://controller.evacomunaws.una.ac.cr/}evaluatorDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="identification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isActive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isAdmin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="landlineNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="passwordChanged" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="position" type="{http://controller.evacomunaws.una.ac.cr/}positionDto" minOccurs="0"/&gt;
 *         &lt;element name="profilePhoto" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="secondLastname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userDto", propOrder = {
    "activationCode",
    "email",
    "evaluated",
    "evaluators",
    "id",
    "identification",
    "isActive",
    "isAdmin",
    "landlineNumber",
    "lastname",
    "name",
    "password",
    "passwordChanged",
    "phoneNumber",
    "position",
    "profilePhoto",
    "secondLastname",
    "username",
    "version"
})
public class UserDto {

    protected String activationCode;
    protected String email;
    @XmlElement(nillable = true)
    protected List<EvaluatedDto> evaluated;
    @XmlElement(nillable = true)
    protected List<EvaluatorDto> evaluators;
    protected Long id;
    protected String identification;
    protected String isActive;
    protected String isAdmin;
    protected String landlineNumber;
    protected String lastname;
    protected String name;
    protected String password;
    protected String passwordChanged;
    protected String phoneNumber;
    protected PositionDto position;
    protected byte[] profilePhoto;
    protected String secondLastname;
    protected String username;
    protected Long version;

    /**
     * Obtiene el valor de la propiedad activationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivationCode() {
        return activationCode;
    }

    /**
     * Define el valor de la propiedad activationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivationCode(String value) {
        this.activationCode = value;
    }

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the evaluated property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the evaluated property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvaluated().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EvaluatedDto }
     * 
     * 
     */
    public List<EvaluatedDto> getEvaluated() {
        if (evaluated == null) {
            evaluated = new ArrayList<EvaluatedDto>();
        }
        return this.evaluated;
    }

    /**
     * Gets the value of the evaluators property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the evaluators property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvaluators().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EvaluatorDto }
     * 
     * 
     */
    public List<EvaluatorDto> getEvaluators() {
        if (evaluators == null) {
            evaluators = new ArrayList<EvaluatorDto>();
        }
        return this.evaluators;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad identification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * Define el valor de la propiedad identification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentification(String value) {
        this.identification = value;
    }

    /**
     * Obtiene el valor de la propiedad isActive.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * Define el valor de la propiedad isActive.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsActive(String value) {
        this.isActive = value;
    }

    /**
     * Obtiene el valor de la propiedad isAdmin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsAdmin() {
        return isAdmin;
    }

    /**
     * Define el valor de la propiedad isAdmin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsAdmin(String value) {
        this.isAdmin = value;
    }

    /**
     * Obtiene el valor de la propiedad landlineNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandlineNumber() {
        return landlineNumber;
    }

    /**
     * Define el valor de la propiedad landlineNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandlineNumber(String value) {
        this.landlineNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad lastname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Define el valor de la propiedad lastname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define el valor de la propiedad password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Obtiene el valor de la propiedad passwordChanged.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPasswordChanged() {
        return passwordChanged;
    }

    /**
     * Define el valor de la propiedad passwordChanged.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPasswordChanged(String value) {
        this.passwordChanged = value;
    }

    /**
     * Obtiene el valor de la propiedad phoneNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Define el valor de la propiedad phoneNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad position.
     * 
     * @return
     *     possible object is
     *     {@link PositionDto }
     *     
     */
    public PositionDto getPosition() {
        return position;
    }

    /**
     * Define el valor de la propiedad position.
     * 
     * @param value
     *     allowed object is
     *     {@link PositionDto }
     *     
     */
    public void setPosition(PositionDto value) {
        this.position = value;
    }

    /**
     * Obtiene el valor de la propiedad profilePhoto.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    /**
     * Define el valor de la propiedad profilePhoto.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setProfilePhoto(byte[] value) {
        this.profilePhoto = value;
    }

    /**
     * Obtiene el valor de la propiedad secondLastname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondLastname() {
        return secondLastname;
    }

    /**
     * Define el valor de la propiedad secondLastname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondLastname(String value) {
        this.secondLastname = value;
    }

    /**
     * Obtiene el valor de la propiedad username.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Define el valor de la propiedad username.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVersion(Long value) {
        this.version = value;
    }

}
