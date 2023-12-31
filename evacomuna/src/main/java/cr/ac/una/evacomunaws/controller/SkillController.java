package cr.ac.una.evacomunaws.controller;

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
 * 2023-10-02T16:14:21.422-06:00
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://controller.evacomunaws.una.ac.cr/", name = "SkillController")
@XmlSeeAlso({ObjectFactory.class})
public interface SkillController {

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/SkillController/createSkillRequest", output = "http://controller.evacomunaws.una.ac.cr/SkillController/createSkillResponse")
    @RequestWrapper(localName = "createSkill", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.CreateSkill")
    @ResponseWrapper(localName = "createSkillResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.CreateSkillResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper createSkill(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.evacomunaws.controller.SkillDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/SkillController/getSkillsRequest", output = "http://controller.evacomunaws.una.ac.cr/SkillController/getSkillsResponse")
    @RequestWrapper(localName = "getSkills", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetSkills")
    @ResponseWrapper(localName = "getSkillsResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetSkillsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getSkills()
;

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/SkillController/getSkillByIdRequest", output = "http://controller.evacomunaws.una.ac.cr/SkillController/getSkillByIdResponse")
    @RequestWrapper(localName = "getSkillById", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetSkillById")
    @ResponseWrapper(localName = "getSkillByIdResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetSkillByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getSkillById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/SkillController/getSkillByNameRequest", output = "http://controller.evacomunaws.una.ac.cr/SkillController/getSkillByNameResponse")
    @RequestWrapper(localName = "getSkillByName", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetSkillByName")
    @ResponseWrapper(localName = "getSkillByNameResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetSkillByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getSkillByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/SkillController/deleteSkillByIdRequest", output = "http://controller.evacomunaws.una.ac.cr/SkillController/deleteSkillByIdResponse")
    @RequestWrapper(localName = "deleteSkillById", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteSkillById")
    @ResponseWrapper(localName = "deleteSkillByIdResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteSkillByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper deleteSkillById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/SkillController/getSkillByLikeNameRequest", output = "http://controller.evacomunaws.una.ac.cr/SkillController/getSkillByLikeNameResponse")
    @RequestWrapper(localName = "getSkillByLikeName", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetSkillByLikeName")
    @ResponseWrapper(localName = "getSkillByLikeNameResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetSkillByLikeNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getSkillByLikeName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/SkillController/updateSkillRequest", output = "http://controller.evacomunaws.una.ac.cr/SkillController/updateSkillResponse")
    @RequestWrapper(localName = "updateSkill", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.UpdateSkill")
    @ResponseWrapper(localName = "updateSkillResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.UpdateSkillResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper updateSkill(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.evacomunaws.controller.SkillDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/SkillController/deleteSkillByNameRequest", output = "http://controller.evacomunaws.una.ac.cr/SkillController/deleteSkillByNameResponse")
    @RequestWrapper(localName = "deleteSkillByName", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteSkillByName")
    @ResponseWrapper(localName = "deleteSkillByNameResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteSkillByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper deleteSkillByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/SkillController/deleteAllSkillsRequest", output = "http://controller.evacomunaws.una.ac.cr/SkillController/deleteAllSkillsResponse")
    @RequestWrapper(localName = "deleteAllSkills", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteAllSkills")
    @ResponseWrapper(localName = "deleteAllSkillsResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteAllSkillsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper deleteAllSkills()
;
}
