package cr.ac.una.controller;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 4.0.2
<<<<<<< HEAD
 * 2023-09-21T16:57:55.240-06:00
=======
 * 2023-09-21T16:07:46.040-06:00
>>>>>>> 75c34e1 ([GEN-CLASSES])
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://controller.una.ac.cr/", name = "SkillController")
@XmlSeeAlso({ObjectFactory.class})
public interface SkillController {

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/SkillController/getSkillsRequest", output = "http://controller.una.ac.cr/SkillController/getSkillsResponse")
    @RequestWrapper(localName = "getSkills", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetSkills")
    @ResponseWrapper(localName = "getSkillsResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetSkillsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getSkills()
;

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/SkillController/createSkillRequest", output = "http://controller.una.ac.cr/SkillController/createSkillResponse")
    @RequestWrapper(localName = "createSkill", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreateSkill")
    @ResponseWrapper(localName = "createSkillResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreateSkillResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper createSkill(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.controller.SkillDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/SkillController/getSkillByNameRequest", output = "http://controller.una.ac.cr/SkillController/getSkillByNameResponse")
    @RequestWrapper(localName = "getSkillByName", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetSkillByName")
    @ResponseWrapper(localName = "getSkillByNameResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetSkillByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getSkillByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/SkillController/getSkillByIdRequest", output = "http://controller.una.ac.cr/SkillController/getSkillByIdResponse")
    @RequestWrapper(localName = "getSkillById", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetSkillById")
    @ResponseWrapper(localName = "getSkillByIdResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetSkillByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getSkillById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/SkillController/deleteSkillByNameRequest", output = "http://controller.una.ac.cr/SkillController/deleteSkillByNameResponse")
    @RequestWrapper(localName = "deleteSkillByName", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteSkillByName")
    @ResponseWrapper(localName = "deleteSkillByNameResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteSkillByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper deleteSkillByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/SkillController/deleteAllSkillsRequest", output = "http://controller.una.ac.cr/SkillController/deleteAllSkillsResponse")
    @RequestWrapper(localName = "deleteAllSkills", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteAllSkills")
    @ResponseWrapper(localName = "deleteAllSkillsResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteAllSkillsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper deleteAllSkills()
;

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/SkillController/updateSkillRequest", output = "http://controller.una.ac.cr/SkillController/updateSkillResponse")
    @RequestWrapper(localName = "updateSkill", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdateSkill")
    @ResponseWrapper(localName = "updateSkillResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdateSkillResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper updateSkill(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.controller.SkillDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/SkillController/getSkillByLikeNameRequest", output = "http://controller.una.ac.cr/SkillController/getSkillByLikeNameResponse")
    @RequestWrapper(localName = "getSkillByLikeName", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetSkillByLikeName")
    @ResponseWrapper(localName = "getSkillByLikeNameResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetSkillByLikeNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getSkillByLikeName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/SkillController/deleteSkillByIdRequest", output = "http://controller.una.ac.cr/SkillController/deleteSkillByIdResponse")
    @RequestWrapper(localName = "deleteSkillById", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteSkillById")
    @ResponseWrapper(localName = "deleteSkillByIdResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteSkillByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper deleteSkillById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );
}
