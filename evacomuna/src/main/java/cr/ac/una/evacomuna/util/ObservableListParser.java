package cr.ac.una.evacomuna.util;

import cr.ac.una.controller.CharacteristicDto;
import cr.ac.una.controller.EvaluationDto;
import cr.ac.una.controller.SkillDto;
import cr.ac.una.evacomuna.services.CharacteristicService;
import cr.ac.una.evacomuna.services.SkillService;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import cr.ac.una.controller.ListWrapper;
import cr.ac.una.controller.PositionDto;
import cr.ac.una.controller.UserDto;
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

    public static ObservableList<SkillDto> loadSkills() {
        ObservableList<SkillDto> skillsDto = FXCollections.observableArrayList();
        ResponseWrapper response = skillService.getSkills();
        if (response.getCode() == ResponseCode.OK) {
            ListWrapper wrapper = (ListWrapper) response.getData();
            for (Object i : wrapper.getElement()) {
                if (i instanceof SkillDto) {
                    skillsDto.add((SkillDto) i);
                }
            }
        }
        return skillsDto;
    }

    public static ObservableList<EvaluationDto> loadEvaluations() {
        ObservableList<EvaluationDto> evaluationDtos = FXCollections.observableArrayList();
        ResponseWrapper response = evaluationService.getAllEvaluation();
        if (response.getCode() == ResponseCode.OK) {
            ListWrapper wrapper = (ListWrapper) response.getData();
            for (Object i : wrapper.getElement()) {
                if (i instanceof EvaluationDto) {
                    evaluationDtos.add((EvaluationDto) i);
                }
            }
        }
        return evaluationDtos;
    }

    public static List<UserDto> loadUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        ResponseWrapper response = userService.getUsers();
        if (response.getCode() == ResponseCode.OK) {
            ListWrapper wrapper = (ListWrapper) response.getData();
            for (Object i : wrapper.getElement()) {
                if (i instanceof UserDto) {
                    userDtos.add((UserDto) i);
                }
            }
        }
        return userDtos;
    }

    public static ObservableList<PositionDto> loadPositions() {
        ObservableList<PositionDto> positionDtos = FXCollections.observableArrayList();
        ResponseWrapper response = roleService.getPositions();
        if (response.getCode() == ResponseCode.OK) {
            ListWrapper wrapper = (ListWrapper) response.getData();
            for (Object i : wrapper.getElement()) {
                if (i instanceof PositionDto) {
                    positionDtos.add((PositionDto) i);
                }
            }
        }
        return positionDtos;
    }

    public static ObservableList<CharacteristicDto> loadCharacteristics() {
        ObservableList<CharacteristicDto> characteristicDtosView = FXCollections.observableArrayList();
        ResponseWrapper response = characteristicService.getCharacteristics();
        if (response.getCode() == ResponseCode.OK) {
            ListWrapper listWrapper = (ListWrapper) response.getData();

            for (Object i : listWrapper.getElement()) {
                if (i instanceof CharacteristicDto) {
                    characteristicDtosView.add((CharacteristicDto) i);
                }
            }
        }
        return characteristicDtosView;
    }
}
