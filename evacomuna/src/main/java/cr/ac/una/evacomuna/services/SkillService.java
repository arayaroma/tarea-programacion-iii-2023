package cr.ac.una.evacomuna.services;

import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;
import java.util.ArrayList;
import java.util.List;
import cr.ac.una.evacomunaws.controller.SkillController;
import cr.ac.una.evacomunaws.controller.SkillController_Service;
import cr.ac.una.evacomuna.dto.SkillDto;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public class SkillService {

    private SkillController_Service service;
    private SkillController port;

    /**
     * Default instance of the service
     */
    public SkillService() {
        service = new SkillController_Service();
        port = service.getSkillControllerPort();

    }

    /**
     * Create a skill
     *
     * @param skillDto skill to create
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper createSkill(SkillDto skillDto) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.createSkill(skillDto.getDto());
            if (response.getCode() == cr.ac.una.evacomunaws.controller.ResponseCode.OK) {
                cr.ac.una.evacomunaws.controller.SkillDto skill = (cr.ac.una.evacomunaws.controller.SkillDto) response
                        .getData();
                return new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Skill created successfully",
                        new SkillDto(skill));
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Error creating skill: " + response.getMessage(),
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating skill: " + e.getMessage(),
                    null);
        }
    }

    /**
     * Get a skill by name
     *
     * @param name of the skill
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getSkillByName(String name) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getSkillByName(name);
            cr.ac.una.evacomunaws.controller.SkillDto skill = (cr.ac.una.evacomunaws.controller.SkillDto) response
                    .getData();
            SkillDto skillDto = new SkillDto(skill);

            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Skill found successfully",
                    skillDto.convertFromGeneratedToDTO(skill, skillDto));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Skill not found",
                    null);
        }
    }

    public ResponseWrapper getSkillById(Long id) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getSkillById(id);
            cr.ac.una.evacomunaws.controller.SkillDto skill = (cr.ac.una.evacomunaws.controller.SkillDto) response
                    .getData();
            SkillDto skillDto = new SkillDto(skill);

            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Skill found successfully",
                    skillDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Skill not found",
                    null);
        }
    }

    /**
     * Get a skill by like name
     *
     * @param name of the skill
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getSkillByLikeName(String name) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getSkillByLikeName(name);
            cr.ac.una.evacomunaws.controller.SkillDto skill = (cr.ac.una.evacomunaws.controller.SkillDto) response
                    .getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Skill found successfully",
                    new SkillDto(skill));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Skill not found",
                    null);
        }
    }

    /**
     * Get all skills
     *
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getSkills() {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getSkills();
            cr.ac.una.evacomunaws.controller.ListWrapper skills = (cr.ac.una.evacomunaws.controller.ListWrapper) response
                    .getData();
            List<cr.ac.una.evacomunaws.controller.SkillDto> skillsDto = new ArrayList<>();
            List<SkillDto> skillsDtoClient = new ArrayList<>();
            for (Object i : skills.getElement()) {
                if (i instanceof cr.ac.una.evacomunaws.controller.SkillDto) {
                    skillsDto.add((cr.ac.una.evacomunaws.controller.SkillDto) i);
                }
            }
            for (cr.ac.una.evacomunaws.controller.SkillDto i : skillsDto) {
                SkillDto userDto = new SkillDto(i);
                skillsDtoClient.add(userDto.convertFromGeneratedToDTO(i, userDto));
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Skills found successfully",
                    skillsDtoClient);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Skills not found",
                    null);
        }
    }

    /**
     * Update a skill
     *
     * @param skillDto skill to update
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper updateSkills(SkillDto skillDto) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.updateSkill(skillDto.getDto());
            cr.ac.una.evacomunaws.controller.SkillDto skill = (cr.ac.una.evacomunaws.controller.SkillDto) response
                    .getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Skill updated successfully",
                    new SkillDto(skill));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating skill",
                    null);
        }
    }

    /**
     * Delete a skill by id
     *
     * @param Id of the skill
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper deleteSkillsById(Long Id) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.deleteSkillById(Id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Skill deleted successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Skill not found",
                    null);
        }
    }

}
