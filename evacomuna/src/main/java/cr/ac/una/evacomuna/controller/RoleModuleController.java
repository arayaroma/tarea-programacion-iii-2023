package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.CharacteristicDto;
import cr.ac.una.controller.PositionDto;
import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.SkillDto;
import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.services.Characteristic;
import cr.ac.una.evacomuna.services.Skill;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.Utilities;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class RoleModuleController implements Initializable {

    @FXML
    private TabPane parent;
    @FXML
    private Tab parentRole;
    @FXML
    private Tab parentSkill;
    @FXML
    private Tab parentCharacteristic;
    @FXML
    private TextField txfRoleNameRegister;
    @FXML
    private ComboBox<String> cbRolesSkillsRegister;
    @FXML
    private Button btnAddSkill;
    @FXML
    private Button btnDeleteSkill;
    @FXML
    private ListView<PositionDto> listRolesRegister;
    @FXML
    private ListView<SkillDto> listSkillsMain;
    @FXML
    private HBox registerRolesView;
    @FXML
    private HBox mainRoleView;

    //SERVICES
    Skill skillService;
    Characteristic characteristicService;
    //BUFFERS
    CharacteristicDto characteristicBuffer;
    //CONTROLLERS
    SkillModuleController skillModuleController;
    CharacteristicModuleController characteristicModuleController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            characteristicService = new Characteristic();
            skillService = new Skill();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void btnNewRole(ActionEvent event) {

    }

    private void btnBackToMain(ActionEvent event) {

    }

    @FXML
    private void btnEditRole(ActionEvent event) {

    }

    @FXML
    private void btnDeleteRole(ActionEvent event) {
    }

    @FXML
    private void btnBackToMainRole(ActionEvent event) {

    }

    @FXML
    private void tabRole(Event event) {
        mainRoleView.toFront();
    }

    @FXML
    private void tabSkills(Event event) {
        try {
            FXMLLoader loader = App.getFXMLLoader("SkillModule");
            parentSkill.setContent(loader.load());
            skillModuleController = loader.getController();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void tabCharacteristics(Event event) {
        try {
            FXMLLoader loader = App.getFXMLLoader("CharacteristicModule");
            parentCharacteristic.setContent(loader.load());
            characteristicModuleController = loader.getController();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private ObservableList<String> mapListToObsevableString(ObservableList<?> list) {
        ObservableList<String> stringList = FXCollections.observableArrayList();
        list.stream().map((t) -> {
            if (t instanceof CharacteristicDto) {
                return ((CharacteristicDto) t).getName();
            }
            if (t instanceof SkillDto) {
                return ((SkillDto) t).getName();
            }
            return "";
        }).collect(Collectors.toList()).stream().forEach(t -> stringList.add(t));
        return stringList;
    }
}
