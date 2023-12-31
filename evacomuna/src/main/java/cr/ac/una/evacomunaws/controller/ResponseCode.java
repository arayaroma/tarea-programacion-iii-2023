
package cr.ac.una.evacomunaws.controller;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responseCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="responseCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OK"/&gt;
 *     &lt;enumeration value="CREATED"/&gt;
 *     &lt;enumeration value="NO_CONTENT"/&gt;
 *     &lt;enumeration value="MOVED_PERMANENTLY"/&gt;
 *     &lt;enumeration value="FOUND"/&gt;
 *     &lt;enumeration value="BAD_REQUEST"/&gt;
 *     &lt;enumeration value="UNAUTHORIZED"/&gt;
 *     &lt;enumeration value="FORBIDDEN"/&gt;
 *     &lt;enumeration value="NOT_FOUND"/&gt;
 *     &lt;enumeration value="METHOD_NOT_ALLOWED"/&gt;
 *     &lt;enumeration value="PROXY_AUTHENTICATION_REQUIRED"/&gt;
 *     &lt;enumeration value="REQUEST_TIMEOUT"/&gt;
 *     &lt;enumeration value="CONFLICT"/&gt;
 *     &lt;enumeration value="IM_A_TEAPOT"/&gt;
 *     &lt;enumeration value="UNPROCESSABLE_CONTENT"/&gt;
 *     &lt;enumeration value="TOO_MANY_REQUESTS"/&gt;
 *     &lt;enumeration value="INTERNAL_SERVER_ERROR"/&gt;
 *     &lt;enumeration value="NOT_IMPLEMENTED"/&gt;
 *     &lt;enumeration value="BAD_GATEWAY"/&gt;
 *     &lt;enumeration value="SERVICE_UNAVAILABLE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "responseCode")
@XmlEnum
public enum ResponseCode {

    OK,
    CREATED,
    NO_CONTENT,
    MOVED_PERMANENTLY,
    FOUND,
    BAD_REQUEST,
    UNAUTHORIZED,
    FORBIDDEN,
    NOT_FOUND,
    METHOD_NOT_ALLOWED,
    PROXY_AUTHENTICATION_REQUIRED,
    REQUEST_TIMEOUT,
    CONFLICT,
    IM_A_TEAPOT,
    UNPROCESSABLE_CONTENT,
    TOO_MANY_REQUESTS,
    INTERNAL_SERVER_ERROR,
    NOT_IMPLEMENTED,
    BAD_GATEWAY,
    SERVICE_UNAVAILABLE;

    public String value() {
        return name();
    }

    public static ResponseCode fromValue(String v) {
        return valueOf(v);
    }

}
