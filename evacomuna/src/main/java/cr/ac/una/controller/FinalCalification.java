
package cr.ac.una.controller;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for finalCalification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="finalCalification"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="average" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="evaluated" type="{http://controller.una.ac.cr/}evaluated" minOccurs="0"/&gt;
 *         &lt;element name="finalNote" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="skill" type="{http://controller.una.ac.cr/}skill" minOccurs="0"/&gt;
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
@XmlType(name = "finalCalification", propOrder = {
    "average",
    "evaluated",
    "finalNote",
    "id",
    "skill",
    "version"
})
public class FinalCalification {

    protected Long average;
    protected Evaluated evaluated;
    protected Long finalNote;
    protected Long id;
    protected Skill skill;
    protected Long version;

    /**
     * Gets the value of the average property.
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
     * Sets the value of the average property.
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
     * Gets the value of the evaluated property.
     * 
     * @return
     *     possible object is
     *     {@link Evaluated }
     *     
     */
    public Evaluated getEvaluated() {
        return evaluated;
    }

    /**
     * Sets the value of the evaluated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Evaluated }
     *     
     */
    public void setEvaluated(Evaluated value) {
        this.evaluated = value;
    }

    /**
     * Gets the value of the finalNote property.
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
     * Sets the value of the finalNote property.
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
     * Gets the value of the id property.
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
     * Sets the value of the id property.
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
     * Gets the value of the skill property.
     * 
     * @return
     *     possible object is
     *     {@link Skill }
     *     
     */
    public Skill getSkill() {
        return skill;
    }

    /**
     * Sets the value of the skill property.
     * 
     * @param value
     *     allowed object is
     *     {@link Skill }
     *     
     */
    public void setSkill(Skill value) {
        this.skill = value;
    }

    /**
     * Gets the value of the version property.
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
     * Sets the value of the version property.
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
