package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.*;

/**
 *
 * @author estebannajera
 */
public class Position {

    private PositionController_Service service;
    private PositionController port;

    public Position() {
        service = new PositionController_Service();
        port = service.getPositionControllerPort();

    }

    public ResponseWrapper getRoles() {
        return port.getPositions();

    }

    public ResponseWrapper updateRoleById(Long id) {
        return port.updatePositionById(id);
    }

    public ResponseWrapper deleteRoleById(Long id) {
        return port.deletePositionById(id);
    }

    public ResponseWrapper createRole(PositionDto role) {
        return port.createPosition(role);
    }
//    public ResponseWrapper getRoleByName(String name) {
//        return port.getPositionById(Long.MIN_VALUE)
//    }
//
//    public ResponseWrapper deleteSkillsById(Long Id) {
//        return port.deleteSkillById(Id);
//    }
//
//    public ResponseWrapper getSkillByName(String name) {
//        return port.getSkillByName(name);
//    }
//
//    public ResponseWrapper createSkill(SkillDto skillDto) {
//        return port.createSkill(skillDto);
//    }
}
