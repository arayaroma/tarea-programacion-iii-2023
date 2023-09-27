package cr.ac.una.evacomunaws.controller;

import cr.ac.una.evacomunaws.dto.SkillDto;
import cr.ac.una.evacomunaws.services.SkillService;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 *
 * @author arayaroma
 */
@WebService(serviceName = "SkillController")
public class SkillController {

    @EJB
    SkillService skillService;

    @WebMethod(operationName = "createSkill")
    public ResponseWrapper createSkill(SkillDto skillDto) {
        return skillService.createSkill(skillDto);
    }

    @WebMethod(operationName = "updateSkill")
    public ResponseWrapper updateSkill(SkillDto skillDto) {
        return skillService.updateSkill(skillDto);
    }

    @WebMethod(operationName = "getSkillById")
    public ResponseWrapper getSkillById(Long id) {
        return skillService.getSkillById(id);
    }

    @WebMethod(operationName = "getSkillByName")
    public ResponseWrapper getSkillByName(String name) {
        return skillService.getSkillByName(name);
    }

    @WebMethod(operationName = "getSkillByLikeName")
    public ResponseWrapper getSkillByLikeName(String name) {
        return skillService.getSkillByLikeName(name);
    }

    @WebMethod(operationName = "getSkills")
    public ResponseWrapper getSkills() {
        return skillService.getSkills();
    }

    @WebMethod(operationName = "deleteSkillById")
    public ResponseWrapper deleteSkillById(Long id) {
        return skillService.deleteSkillById(id);
    }

    @WebMethod(operationName = "deleteSkillByName")
    public ResponseWrapper deleteSkillByName(String name) {
        return skillService.deleteSkillByName(name);
    }

    @WebMethod(operationName = "deleteAllSkills")
    public ResponseWrapper deleteAllSkills() {
        return skillService.deleteAllSkills();
    }
}
