package cr.ac.una.evacomuna.util;

import cr.ac.una.evacomuna.dto.CharacteristicDto;
import cr.ac.una.evacomuna.dto.EvaluationDto;
import cr.ac.una.evacomuna.dto.SkillDto;
import cr.ac.una.evacomuna.dto.UserDto;
import cr.ac.una.evacomuna.services.CharacteristicService;
import cr.ac.una.evacomuna.dto.PositionDto;
import cr.ac.una.evacomuna.services.SkillService;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import cr.ac.una.evacomuna.services.EvaluationService;
import cr.ac.una.evacomuna.services.PositionService;
import cr.ac.una.evacomuna.services.UserService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public class ObservableListParser {

    static SkillService skillService = new SkillService();
    static PositionService roleService = new PositionService();
    static UserService userService = new UserService();
    static EvaluationService evaluationService = new EvaluationService();
    static CharacteristicService characteristicService = new CharacteristicService();

    public static ObservableList<String> mapListToObsevableString(ObservableList<?> list) {
        ObservableList<String> stringList = FXCollections.observableArrayList();
        list.stream().map((t) -> {
            if (t instanceof CharacteristicDto) {
                return ((CharacteristicDto) t).getName();
            }
            if (t instanceof SkillDto) {
                return ((SkillDto) t).getName();
            }
            if (t instanceof PositionDto) {
                return ((PositionDto) t).getName();
            }
            if (t instanceof EvaluationDto) {
                return ((EvaluationDto) t).getName();
            }
            return "";
        }).collect(Collectors.toList()).stream().forEach(t -> stringList.add(t));
        return stringList;
    }

    @SuppressWarnings("unchecked")
    public static ObservableList<SkillDto> loadSkills() {
        ObservableList<SkillDto> skillObservableDtos = FXCollections.observableArrayList();
        List<SkillDto> skillDtos = new ArrayList<>();
        ResponseWrapper response = skillService.getSkills();
        skillDtos = (List<SkillDto>) response.getData();
        skillObservableDtos.addAll(skillDtos);
        return skillObservableDtos;
    }

    @SuppressWarnings("unchecked")
    public static ObservableList<EvaluationDto> loadEvaluations() {
        ObservableList<EvaluationDto> evaluationObsevableDtos = FXCollections.observableArrayList();
        List<EvaluationDto> evaluationDtos = new ArrayList<>();
        ResponseWrapper response = evaluationService.getAllEvaluation();
        evaluationDtos = (List<EvaluationDto>) response.getData();
        evaluationObsevableDtos.addAll(evaluationDtos);
        return evaluationObsevableDtos;
    }

    @SuppressWarnings("unchecked")
    public static List<UserDto> loadUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        ResponseWrapper response = userService.getUsers();
        userDtos = (List<UserDto>) response.getData();
        return userDtos;
    }

    @SuppressWarnings("unchecked")
    public static ObservableList<PositionDto> loadPositions() {
        ObservableList<PositionDto> positionObservableDtos = FXCollections.observableArrayList();
        List<PositionDto> positionDtos = new ArrayList<>();
        ResponseWrapper response = roleService.getPositions();
        positionDtos = (List<PositionDto>) response.getData();
        positionObservableDtos.addAll(positionDtos);

        return positionObservableDtos;
    }

    @SuppressWarnings("unchecked")
    public static ObservableList<CharacteristicDto> loadCharacteristics() {
        ObservableList<CharacteristicDto> characteristicObservableDtos = FXCollections.observableArrayList();
        List<CharacteristicDto> characteristicDtos = new ArrayList<>();
        ResponseWrapper response = characteristicService.getCharacteristics();
        characteristicDtos = (List<CharacteristicDto>) response.getData();
        characteristicObservableDtos.addAll(characteristicDtos);
        return characteristicObservableDtos;
    }
}
