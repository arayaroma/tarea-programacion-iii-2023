
package cr.ac.una.evacomunaws.controller;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para finalCalificationDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="finalCalificationDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="average" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="evaluated" type="{http://controller.evacomunaws.una.ac.cr/}evaluatedDto" minOccurs="0"/&gt;
 *         &lt;element name="finalNote" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="skill" type="{http://controller.evacomunaws.una.ac.cr/}skillDto" minOccurs="0"/&gt;
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
@XmlType(name = "finalCalificationDto", propOrder = {
    "average",
    "evaluated",
    "finalNote",
    "id",
    "skill",
    "version"
})
public class FinalCalificationDto {

    protected Long average;
    protected EvaluatedDto evaluated;
    protected Long finalNote;
    protected Long id;
    protected SkillDto skill;
    protected Long version;

    /**
     * Obtiene el valor de la propiedad average.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAverage() {
        return average;
    }

    /**
     * Define el valor de la propiedad average.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAverage(Long value) {
        this.average = value;
    }

    /**
     * Obtiene el valor de la propiedad evaluated.
     * 
     * @return
     *     possible object is
     *     {@link EvaluatedDto }
     *     
     */
    public EvaluatedDto getEvaluated() {
        return evaluated;
    }

    /**
     * Define el valor de la propiedad evaluated.
     * 
     * @param value
     *     allowed object is
     *     {@link EvaluatedDto }
     *     
     */
    public void setEvaluated(EvaluatedDto value) {
        this.evaluated = value;
    }

    /**
     * Obtiene el valor de la propiedad finalNote.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFinalNote() {
        return finalNote;
    }

    /**
     * Define el valor de la propiedad finalNote.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFinalNote(Long value) {
        this.finalNote = value;
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
