
package cr.ac.una.controller;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para evaluationDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="evaluationDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="applicationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="evaluated" type="{http://controller.una.ac.cr/}evaluatedDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="finalPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="initialPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "evaluationDto", propOrder = {
    "applicationDate",
    "evaluated",
    "finalPeriod",
    "id",
    "initialPeriod",
    "name",
    "state",
    "version"
})
public class EvaluationDto {

    protected String applicationDate;
    @XmlElement(nillable = true)
    protected List<EvaluatedDto> evaluated;
    protected String finalPeriod;
    protected Long id;
    protected String initialPeriod;
    protected String name;
    protected String state;
    protected Long version;

    /**
     * Obtiene el valor de la propiedad applicationDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationDate() {
        return applicationDate;
    }

    /**
     * Define el valor de la propiedad applicationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationDate(String value) {
        this.applicationDate = value;
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
     * Obtiene el valor de la propiedad finalPeriod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalPeriod() {
        return finalPeriod;
    }

    /**
     * Define el valor de la propiedad finalPeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalPeriod(String value) {
        this.finalPeriod = value;
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
     * Obtiene el valor de la propiedad initialPeriod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialPeriod() {
        return initialPeriod;
    }

    /**
     * Define el valor de la propiedad initialPeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialPeriod(String value) {
        this.initialPeriod = value;
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
     * Obtiene el valor de la propiedad state.
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
     * Define el valor de la propiedad state.
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
