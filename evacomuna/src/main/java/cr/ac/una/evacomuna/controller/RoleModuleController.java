package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.CharacteristicDto;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.evacomuna.services.Characteristic;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
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
    private TextField txfRoleNameRegister;
    @FXML
    private ComboBox<?> cbRolesSkillsRegister;
    @FXML
    private Button btnAddSkill;
    @FXML
    private ListView<?> listRolesRegister;
    @FXML
    private Button btnDeleteSkill;
    @FXML
    private ListView<?> listSkillsMain;
    @FXML
    private HBox registerRolesView;
    @FXML
    private HBox mainRoleView;
    @FXML
    private HBox mainSkillsView;
    @FXML
    private ListView<?> listCharacteristics;
    @FXML
    private HBox registerSkillsView;
    @FXML
    private TextField txfSkillNameRegister;
    @FXML
    private Button btnAddCharacteristic;
    @FXML
    private ListView<?> listCharacteristicsRegister;
    @FXML
    private HBox mainCharacteristicsView;
    @FXML
    private ListView<CharacteristicDto> listCharactersitic;
    @FXML
    private TextField txfCharacteristic;

    Characteristic characteristicService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Load lists
        try {
            characteristicService = new Characteristic();
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
    private void btnNewSkill(ActionEvent event) {
    }

    @FXML
    private void btnEditSkill(ActionEvent event) {
    }

    @FXML
    private void btnDeleteSkill(ActionEvent event) {
    }

    @FXML
    private void btnBackToSkillMain(ActionEvent event) {
    }

    @FXML
    private void btnDeleteCharacteristic(ActionEvent event) {
    }

    @FXML
    private void btnNewCharactersitic(ActionEvent event) {
        try {
            String name = txfCharacteristic.getText();
            if (name.isEmpty()) {
                return;
            }
            CharacteristicDto characteristicDto = new CharacteristicDto();
            characteristicDto.setName(name);
            characteristicDto.setId(Long.valueOf(1));
            ResponseWrapper response = characteristicService.createCharacteristic(characteristicDto);
            Message.showNotification("Data", MessageType.INFO, response.getMessage());
            System.out.println(response.getMessage());
//            listCharacteristics.set
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void btnEditCharacteristic(ActionEvent event) {
    }
    

}
