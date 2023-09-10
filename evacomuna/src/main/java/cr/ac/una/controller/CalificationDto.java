
package cr.ac.una.controller;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para calificationDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="calificationDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="calification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="evaluator" type="{http://controller.una.ac.cr/}userDto" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="skill" type="{http://controller.una.ac.cr/}skillDto" minOccurs="0"/&gt;
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
@XmlType(name = "calificationDto", propOrder = {
    "calification",
    "evaluator",
    "id",
    "skill",
    "version"
})
public class CalificationDto {

    protected String calification;
    protected UserDto evaluator;
    protected Long id;
    protected SkillDto skill;
    protected Long version;

    /**
     * Obtiene el valor de la propiedad calification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalification() {
        return calification;
    }

    /**
     * Define el valor de la propiedad calification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalification(String value) {
        this.calification = value;
    }

    /**
     * Obtiene el valor de la propiedad evaluator.
     * 
     * @return
     *     possible object is
     *     {@link UserDto }
     *     
     */
    public UserDto getEvaluator() {
        return evaluator;
    }

    /**
     * Define el valor de la propiedad evaluator.
     * 
     * @param value
     *     allowed object is
     *     {@link UserDto }
     *     
     */
    public void setEvaluator(UserDto value) {
        this.evaluator = value;
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
     * Obtiene el valor de la propiedad skill.
     * 
     * @return
     *     possible object is
     *     {@link SkillDto }
     *     
     */
    public SkillDto getSkill() {
        return skill;
    }

    /**
     * Define el valor de la propiedad skill.
     * 
     * @param value
     *     allowed object is
     *     {@link SkillDto }
     *     
     */
    public void setSkill(SkillDto value) {
        this.skill = value;
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