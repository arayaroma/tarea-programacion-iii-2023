package cr.ac.una.evacomuna.controller;

import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.dto.CharacteristicDto;
import cr.ac.una.evacomuna.services.CharacteristicService;
import cr.ac.una.evacomuna.services.SkillService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

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

    // SERVICES
    SkillService skillService;
    CharacteristicService characteristicService;
    // BUFFERS
    CharacteristicDto characteristicBuffer;
    // CONTROLLERS
    // SkillModuleController skillModuleController;
    // CharacteristicModuleController characteristicModuleController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            characteristicService = new CharacteristicService();
            skillService = new SkillService();
            tabRole(null);
        } catch (Exception e) {

            System.out.println(e.toString());
        }
    }

    @FXML
    private void tabRole(Event event) {
        try {
            FXMLLoader loader = App.getFXMLLoader("PositionModule");
            parentRole.setContent(loader.load());
            // rol = loader.getController();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void tabSkills(Event event) {
        try {
            FXMLLoader loader = App.getFXMLLoader("SkillModule");
            parentSkill.setContent(loader.load());
            // skillModuleController = loader.getController();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

}
