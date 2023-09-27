package cr.ac.una.evacomunaws.services;

import cr.ac.una.evacomunaws.dto.SkillDto;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 * 
 * @author arayaroma
 */
@Local
public interface SkillService {

    ResponseWrapper createSkill(SkillDto skillDto);

    ResponseWrapper updateSkill(SkillDto skillDto);

    ResponseWrapper getSkillById(Long id);

    ResponseWrapper getSkillByName(String name);
    
    ResponseWrapper getSkillByLikeName(String name);

    ResponseWrapper getSkills();

    ResponseWrapper getCharacteristicsBySkillId(Long id);

    ResponseWrapper getCalificationsBySkillId(Long id);

    ResponseWrapper getFinalCalificationsBySkillId(Long id);

    ResponseWrapper getPositionsBySkillId(Long id);

    ResponseWrapper deleteSkillById(Long id);

    ResponseWrapper deleteSkillByName(String name);

    ResponseWrapper deleteAllSkills();

}
