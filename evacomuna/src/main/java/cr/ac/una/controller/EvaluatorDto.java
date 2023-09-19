
package cr.ac.una.controller;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para evaluatorDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="evaluatorDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="evaluated" type="{http://controller.una.ac.cr/}evaluatedDto" minOccurs="0"/&gt;
 *         &lt;element name="evaluator" type="{http://controller.una.ac.cr/}userDto" minOccurs="0"/&gt;
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
@XmlType(name = "evaluatorDto", propOrder = {
    "evaluated",
    "evaluator",
    "feedback",
    "id",
    "role",
    "version"
})
public class EvaluatorDto {

    protected EvaluatedDto evaluated;
    protected UserDto evaluator;
    protected String feedback;
    protected Long id;
    protected String role;
    protected Long version;

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
