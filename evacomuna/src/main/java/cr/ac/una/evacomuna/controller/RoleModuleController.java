package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.CharacteristicDto;
import cr.ac.una.controller.ListWrapper;
import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.SkillDto;
import cr.ac.una.evacomuna.services.Characteristic;
import cr.ac.una.evacomuna.services.Skill;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventDispatchChain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

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
    private ComboBox<SkillDto> cbSkillsView;
    @FXML
    private ComboBox<SkillDto> cbRolesSkillsRegister;
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
    private HBox registerSkillsView;
    @FXML
    private TextField txfSkillNameRegister;
    @FXML
    private Button btnAddCharacteristic;
    @FXML
    private HBox mainCharacteristicsView;
    @FXML
    private TextField txfCharacteristic;
    @FXML
    private ListView<?> listCharacteristicsMainSkillView;
    @FXML
    private ListView<?> listCharacteristicsRegisterSkillView;
    @FXML
    private ListView<CharacteristicDto> listCharactersiticView;

    Characteristic characteristicService;
    Skill skillService;
    CharacteristicDto characteristicViewBuffer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Load lists
        try {
            characteristicService = new Characteristic();
            intializeLists();
            listCharactersiticView.setItems(loadCharacteristics());
            cbRolesSkillsRegister.setItems(loadSkills());
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
        if (characteristicViewBuffer != null) {
            ResponseWrapper response = characteristicService.deleteCharacteristicById(characteristicViewBuffer.getId());
            if (response.getCode() == ResponseCode.OK) {
                Message.showNotification("Succeed", MessageType.INFO, "The Characteristic was removed succesfully");
                listCharactersiticView.setItems(loadCharacteristics());
                cleanFieldsCharacteristicView();
            } else {
                Message.showNotification("Error", MessageType.ERROR, "Error: " + response.getMessage());
            }
        }
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
            ResponseWrapper response = characteristicService.createCharacteristic(characteristicDto);
            Message.showNotification("Data", MessageType.INFO, response.getMessage());
            listCharactersiticView.setItems(loadCharacteristics());
            cleanFieldsCharacteristicView();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void btnEditCharacteristic(ActionEvent event) {
        String newName = txfCharacteristic.getText();
        if (characteristicViewBuffer != null && !newName.isBlank()) {
            characteristicViewBuffer.setName(newName);
            ResponseWrapper response = characteristicService.updateCharacteristics(characteristicViewBuffer);
            if (response.getCode() == ResponseCode.OK) {
                listCharactersiticView.setItems(loadCharacteristics());
                cleanFieldsCharacteristicView();
            }
        }
    }

    @FXML
    private void searchSkillInput(InputMethodEvent event) {

    }

    @FXML
    private void selectSkill(ActionEvent event) {

    }

    private ObservableList<CharacteristicDto> loadCharacteristics() {
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

    private void intializeLists() {
        //CELLS FACTORIES
        listCharactersiticView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(CharacteristicDto item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getName());
            }
        });
        cbSkillsView.setCellFactory((param) -> new ListCell<>() {
            @Override
            protected void updateItem(SkillDto item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getName());
            }
        });
        listCharactersiticView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            characteristicViewBuffer = newValue;
            if (characteristicViewBuffer != null) {
                txfCharacteristic.setText(characteristicViewBuffer.getName());
            }
        });
    }

    private void cleanFieldsCharacteristicView() {
        txfCharacteristic.setText("");
        characteristicViewBuffer = null;
    }

    private ObservableList<SkillDto> loadSkills() {
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

}
