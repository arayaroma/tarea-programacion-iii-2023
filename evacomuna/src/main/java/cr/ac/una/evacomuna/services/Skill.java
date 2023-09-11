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

}
