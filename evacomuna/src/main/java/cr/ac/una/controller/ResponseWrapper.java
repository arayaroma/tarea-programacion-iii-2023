
package cr.ac.una.controller;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responseWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responseWrapper"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="code" type="{http://controller.una.ac.cr/}responseCode" minOccurs="0"/&gt;
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseWrapper", propOrder = {
    "code",
    "data",
    "message",
    "status"
})
public class ResponseWrapper {

    @XmlSchemaType(name = "string")
    protected ResponseCode code;
    protected Object data;
    protected String message;
    protected Integer status;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCode }
     *     
     */
    public ResponseCode getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCode }
     *     
     */
    public void setCode(ResponseCode value) {
        this.code = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setData(Object value) {
        this.data = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

}
