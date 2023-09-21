package cr.ac.una.evacomuna.util;

import cr.ac.una.controller.CharacteristicDto;
import cr.ac.una.controller.EvaluationDto;
import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.SkillDto;
import cr.ac.una.evacomuna.services.Characteristic;
import cr.ac.una.evacomuna.services.Skill;
import java.io.File;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import cr.ac.una.controller.ListWrapper;
import cr.ac.una.controller.PositionDto;
import cr.ac.una.controller.UserDto;
import cr.ac.una.evacomuna.services.Evaluation;
import cr.ac.una.evacomuna.services.Position;
import cr.ac.una.evacomuna.services.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author estebannajera
 */
public class Utilities {

    static Skill skillService = new Skill();
    static Position roleService = new Position();
    static User userService = new User();
    static Evaluation evaluationService = new Evaluation();
    static Characteristic characteristicService = new Characteristic();

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
        ResponseWrapper response = evaluationService.getEvaluations();
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

    public static ObservableList<PositionDto> loadRoles() {
        ObservableList<PositionDto> positionDtos = FXCollections.observableArrayList();
        ResponseWrapper response = roleService.getRoles();
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

    public static void openPath(String ruta) {
        try {
            File file;
            file = new File(ruta);
            if (file.exists()) {
                Process proces = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + ruta);
                proces.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static String fileToString(File file) {
        try {
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static File selectFile(String nameFilter, String... filters) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(nameFilter, filters));
        return fileChooser.showOpenDialog(new Stage());
    }

}
