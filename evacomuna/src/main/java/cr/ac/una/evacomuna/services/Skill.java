package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.*;

/**
 *
 * @author estebannajera
 */
public class Skill {

    private SkillController_Service service;
    private SkillController port;

    public Skill() {
        service = new SkillController_Service();
        port = service.getSkillControllerPort();

    }

    public ResponseWrapper getSkills() {
        return port.getSkills();
    }

    public ResponseWrapper updateSkills(SkillDto skillDto) {
        return port.updateSkill(skillDto);
    }

    public ResponseWrapper deleteSkillsById(Long Id) {
        return port.deleteSkillById(Id);
    }

    public ResponseWrapper getSkillByName(String name) {
        return port.getSkillByName(name);
    }

    public ResponseWrapper createSkill(SkillDto skillDto) {
        return port.createSkill(skillDto);
    }
//    public  ResponseWrapper getSkill
}
