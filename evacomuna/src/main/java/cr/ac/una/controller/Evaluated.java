
package cr.ac.una.controller;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para evaluated complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="evaluated"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="evaluated" type="{http://controller.una.ac.cr/}user" minOccurs="0"/&gt;
 *         &lt;element name="evaluation" type="{http://controller.una.ac.cr/}evaluation" minOccurs="0"/&gt;
 *         &lt;element name="evaluators" type="{http://controller.una.ac.cr/}evaluator" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="finalCalifications" type="{http://controller.una.ac.cr/}finalCalification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="finalNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
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
@XmlType(name = "evaluated", propOrder = {
    "evaluated",
    "evaluation",
    "evaluators",
    "finalCalifications",
    "finalNote",
    "id",
    "version"
})
public class Evaluated {

    protected User evaluated;
    protected Evaluation evaluation;
    @XmlElement(nillable = true)
    protected List<Evaluator> evaluators;
    @XmlElement(nillable = true)
    protected List<FinalCalification> finalCalifications;
    protected String finalNote;
    protected Long id;
    protected Long version;

    /**
     * Obtiene el valor de la propiedad evaluated.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getEvaluated() {
        return evaluated;
    }

    /**
     * Define el valor de la propiedad evaluated.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setEvaluated(User value) {
        this.evaluated = value;
    }

    /**
     * Obtiene el valor de la propiedad evaluation.
     * 
     * @return
     *     possible object is
     *     {@link Evaluation }
     *     
     */
    public Evaluation getEvaluation() {
        return evaluation;
    }

    /**
     * Define el valor de la propiedad evaluation.
     * 
     * @param value
     *     allowed object is
     *     {@link Evaluation }
     *     
     */
    public void setEvaluation(Evaluation value) {
        this.evaluation = value;
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
     * {@link Evaluator }
     * 
     * 
     */
    public List<Evaluator> getEvaluators() {
        if (evaluators == null) {
            evaluators = new ArrayList<Evaluator>();
        }
        return this.evaluators;
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
     * Obtiene el valor de la propiedad finalNote.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalNote() {
        return finalNote;
    }

    /**
     * Define el valor de la propiedad finalNote.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalNote(String value) {
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
