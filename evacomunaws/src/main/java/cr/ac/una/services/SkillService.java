package cr.ac.una.services;

import cr.ac.una.dto.SkillDto;
import cr.ac.una.util.ResponseWrapper;
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

    ResponseWrapper getSkills();

    ResponseWrapper deleteSkillById(Long id);

    ResponseWrapper deleteSkillByName(String name);

    ResponseWrapper deleteAllSkills();

}
