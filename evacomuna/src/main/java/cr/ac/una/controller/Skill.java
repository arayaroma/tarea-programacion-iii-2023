
package cr.ac.una.controller;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for skill complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="skill"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="califications" type="{http://controller.una.ac.cr/}calification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="characteristics" type="{http://controller.una.ac.cr/}characteristic" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="finalCalifications" type="{http://controller.una.ac.cr/}finalCalification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="positions" type="{http://controller.una.ac.cr/}position" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "skill", propOrder = {
    "califications",
    "characteristics",
    "finalCalifications",
    "id",
    "name",
    "positions",
    "state",
    "version"
})
public class Skill {

    @XmlElement(nillable = true)
    protected List<Calification> califications;
    @XmlElement(nillable = true)
    protected List<Characteristic> characteristics;
    @XmlElement(nillable = true)
    protected List<FinalCalification> finalCalifications;
    protected Long id;
    protected String name;
    @XmlElement(nillable = true)
    protected List<Position> positions;
    protected String state;
    protected Long version;

    /**
     * Gets the value of the califications property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the califications property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCalifications().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Calification }
     * 
     * 
     */
    public List<Calification> getCalifications() {
        if (califications == null) {
            califications = new ArrayList<Calification>();
        }
        return this.califications;
    }

    /**
     * Gets the value of the characteristics property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the characteristics property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharacteristics().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Characteristic }
     * 
     * 
     */
    public List<Characteristic> getCharacteristics() {
        if (characteristics == null) {
            characteristics = new ArrayList<Characteristic>();
        }
        return this.characteristics;
    }

    /**
     * Gets the value of the finalCalifications property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the finalCalifications property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFinalCalifications().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FinalCalification }
     * 
     * 
     */
    public List<FinalCalification> getFinalCalifications() {
        if (finalCalifications == null) {
            finalCalifications = new ArrayList<FinalCalification>();
        }
        return this.finalCalifications;
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
     * Gets the value of the name property.
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
     * Sets the value of the name property.
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
     * Gets the value of the positions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the positions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPositions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Position }
     * 
     * 
     */
    public List<Position> getPositions() {
        if (positions == null) {
            positions = new ArrayList<Position>();
        }
        return this.positions;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
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
