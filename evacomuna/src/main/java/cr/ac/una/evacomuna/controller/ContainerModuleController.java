package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.CharacteristicDto;

import cr.ac.una.controller.SkillDto;
import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.services.Characteristic;
import cr.ac.una.evacomuna.services.Skill;

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

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class ContainerModuleController implements Initializable {

    @FXML
    private TabPane parent;
    @FXML
    private Tab parentRole;
    @FXML
    private Tab parentSkill;
    @FXML
    private Tab parentCharacteristic;

    //SERVICES
    Skill skillService;
    Characteristic characteristicService;
    //BUFFERS
    CharacteristicDto characteristicBuffer;
    //CONTROLLERS
//    SkillModuleController skillModuleController;
//    CharacteristicModuleController characteristicModuleController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            characteristicService = new Characteristic();
            skillService = new Skill();
            tabRole(null);
        } catch (Exception e) {
            
            System.out.println(e.toString());
        }
    }

    @FXML
    private void tabRole(Event event) {
        try {
            FXMLLoader loader = App.getFXMLLoader("RoleModule");
            parentRole.setContent(loader.load());
//            rol = loader.getController();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void tabSkills(Event event) {
        try {
            FXMLLoader loader = App.getFXMLLoader("SkillModule");
            parentSkill.setContent(loader.load());
//            skillModuleController = loader.getController();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void tabCharacteristics(Event event) {
        try {
            FXMLLoader loader = App.getFXMLLoader("CharacteristicModule");
            parentCharacteristic.setContent(loader.load());
//            characteristicModuleController = loader.getController();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
