
package cr.ac.una.controller;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para evaluator complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="evaluator"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="califications" type="{http://controller.una.ac.cr/}calification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="evaluated" type="{http://controller.una.ac.cr/}evaluated" minOccurs="0"/&gt;
 *         &lt;element name="evaluator" type="{http://controller.una.ac.cr/}user" minOccurs="0"/&gt;
 *         &lt;element name="feedback" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "evaluator", propOrder = {
    "califications",
    "evaluated",
    "evaluator",
    "feedback",
    "id",
    "role",
    "version"
})
public class Evaluator {

    @XmlElement(nillable = true)
    protected List<Calification> califications;
    protected Evaluated evaluated;
    protected User evaluator;
    protected String feedback;
    protected Long id;
    protected String role;
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
     * Obtiene el valor de la propiedad evaluated.
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
     * Define el valor de la propiedad evaluated.
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
     * Obtiene el valor de la propiedad evaluator.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getEvaluator() {
        return evaluator;
    }

    /**
     * Define el valor de la propiedad evaluator.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setEvaluator(User value) {
        this.evaluator = value;
    }

    /**
     * Obtiene el valor de la propiedad feedback.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * Define el valor de la propiedad feedback.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeedback(String value) {
        this.feedback = value;
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
     * Obtiene el valor de la propiedad role.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Define el valor de la propiedad role.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
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