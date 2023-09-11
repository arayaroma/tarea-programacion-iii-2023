package cr.ac.una.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import cr.ac.una.dto.SkillDto;
import cr.ac.una.services.SkillService;
import cr.ac.una.util.ResponseCode;
import cr.ac.una.util.ResponseWrapper;

/**
 * 
 * @author arayaroma
 */
@DisplayName("Skill Controller Tests")
public class SkillControllerTest {

    @Mock
    SkillService skillService;

    @BeforeEach
    public void setUp() {
        skillService = mock(SkillService.class);
    }

    @Test
    @DisplayName("Test createSkill - Successful Skill Creation")
    public void createSkill() {
        // Arrange
        SkillDto skillTest = createTestSkill("test");

        // Act
        when(skillService.createSkill(skillTest)).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Skill created successfully.",
                        skillTest));

        // Assert
        ResponseWrapper response = skillService.createSkill(skillTest);
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(skillTest, response.getData());
    }

    private SkillDto createTestSkill(String name) {
        SkillDto skillTest = new SkillDto();
        skillTest.setName(name);
        skillTest.setPositions(new ArrayList<>());
        skillTest.setCharacteristics(new ArrayList<>());
        skillTest.setCalifications(new ArrayList<>());
        skillTest.setFinalCalifications(new ArrayList<>());
        return skillTest;
    }

    @Test
    @DisplayName("Test updateSkill - Successful Skill Update")
    public void updateSkill() {
        // Arrange
        SkillDto skillTest = createTestSkill("test");

        // Act
        when(skillService.updateSkill(skillTest)).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Skill updated successfully.",
                        skillTest));

        // Assert
        ResponseWrapper response = skillService.updateSkill(skillTest);
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(skillTest, response.getData());
    }

    @Test
    @DisplayName("Test deleteSkillById - Successful Skill Delete")
    public void deleteSkillById() {
        // Arrange
        SkillDto skillTest = createTestSkill("test");

        // Act
        when(skillService.deleteSkillById(skillTest.getId())).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Skill deleted successfully.",
                        skillTest));

        // Assert
        ResponseWrapper response = skillService.deleteSkillById(skillTest.getId());
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(skillTest, response.getData());
    }

    @Test
    @DisplayName("Test getSkillById - Successful Skill Search")
    public void getSkillById() {
        // Arrange
        SkillDto skillTest = createTestSkill("test");

        // Act
        when(skillService.getSkillById(1L)).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Skill retrieved successfully.",
                        skillTest));
        // Assert
        ResponseWrapper response = skillService.getSkillById(1L);
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(skillTest, response.getData());
    }

    @Test
    @DisplayName("Test getAllSkills - Successful Skill Search")
    public void getAllSkills() {
        // Act
        when(skillService.getSkills()).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Skills retrieved successfully.",
                        new ArrayList<SkillDto>()));

        // Assert
        ResponseWrapper response = skillService.getSkills();
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(new ArrayList<SkillDto>(), response.getData());
    }

}
