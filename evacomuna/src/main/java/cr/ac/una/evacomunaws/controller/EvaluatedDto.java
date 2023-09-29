
package cr.ac.una.evacomunaws.controller;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for evaluatedDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="evaluatedDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="evaluated" type="{http://controller.evacomunaws.una.ac.cr/}userDto" minOccurs="0"/&gt;
 *         &lt;element name="evaluation" type="{http://controller.evacomunaws.una.ac.cr/}evaluationDto" minOccurs="0"/&gt;
 *         &lt;element name="evaluators" type="{http://controller.evacomunaws.una.ac.cr/}evaluatorDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="finalCalifications" type="{http://controller.evacomunaws.una.ac.cr/}finalCalificationDto" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "evaluatedDto", propOrder = {
    "evaluated",
    "evaluation",
    "evaluators",
    "finalCalifications",
    "finalNote",
    "id",
    "version"
})
public class EvaluatedDto {

    protected UserDto evaluated;
    protected EvaluationDto evaluation;
    @XmlElement(nillable = true)
    protected List<EvaluatorDto> evaluators;
    @XmlElement(nillable = true)
    protected List<FinalCalificationDto> finalCalifications;
    protected String finalNote;
    protected Long id;
    protected Long version;

    /**
     * Gets the value of the evaluated property.
     * 
     * @return
     *     possible object is
     *     {@link UserDto }
     *     
     */
    public UserDto getEvaluated() {
        return evaluated;
    }

    /**
     * Sets the value of the evaluated property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserDto }
     *     
     */
    public void setEvaluated(UserDto value) {
        this.evaluated = value;
    }

    /**
     * Gets the value of the evaluation property.
     * 
     * @return
     *     possible object is
     *     {@link EvaluationDto }
     *     
     */
    public EvaluationDto getEvaluation() {
        return evaluation;
    }

    /**
     * Sets the value of the evaluation property.
     * 
     * @param value
     *     allowed object is
     *     {@link EvaluationDto }
     *     
     */
    public void setEvaluation(EvaluationDto value) {
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
     * {@link FinalCalificationDto }
     * 
     * 
     */
    public List<FinalCalificationDto> getFinalCalifications() {
        if (finalCalifications == null) {
            finalCalifications = new ArrayList<FinalCalificationDto>();
        }
        return this.finalCalifications;
    }

    /**
     * Gets the value of the finalNote property.
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
     * Sets the value of the finalNote property.
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
