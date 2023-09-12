package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.CharacteristicDto;
import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.SkillDto;
import cr.ac.una.evacomuna.dto.SkillWrapper;
import cr.ac.una.evacomuna.services.Characteristic;
import cr.ac.una.evacomuna.services.Skill;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.Utilities;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class SkillModuleController implements Initializable {

    @FXML
    private HBox mainSkillsView;
    @FXML
    private ComboBox<String> cbSkillsView;
    @FXML
    private ListView<CharacteristicDto> listCharacteristicsMainSkillView;
    @FXML
    private HBox registerSkillsView;
    @FXML
    private TextField txfSkillNameRegister;
    @FXML
    private ComboBox<String> cbStateSkillRegisterView;
    @FXML
    private ComboBox<String> cbCharacteristicsSkillRegisterView;
    @FXML
    private ListView<CharacteristicDto> listCharacteristicsRegisterSkillView;
    //SERVICES
    Skill skillService;
    Characteristic characteristicService;
    //BUFFERS
    SkillDto skillBufferMainView;
    CharacteristicDto characteristicViewBuffer;
    //FLAGS
    boolean isEditingSkill = false;
    //LISTS
    ObservableList<CharacteristicDto> characteristicDtos;
    ObservableList<SkillDto> skillsDtos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        skillService = new Skill();
        characteristicService = new Characteristic();
        initializeLists();
        initializeSkillMainView();
    }

    @FXML
    private void btnNewSkill(ActionEvent event) {
        registerSkillsView.toFront();
        initializeSkillsRegisterView();
    }

    @FXML
    private void searchSkillInput(InputMethodEvent event) {
    }

    @FXML
    private void selectSkill(ActionEvent event) {
        String nameSkill = cbSkillsView.getValue();
        if (nameSkill != null) {
            skillBufferMainView = (SkillDto) skillService.getSkillByName(nameSkill).getData();
            listCharacteristicsMainSkillView.getItems().clear();
            skillBufferMainView.getCharacteristics().forEach(t -> listCharacteristicsMainSkillView.getItems().add(t));
        }
    }

    @FXML
    private void btnEditSkill(ActionEvent event) {
        if (skillBufferMainView != null) {
            registerSkillsView.toFront();
            txfSkillNameRegister.setText(skillBufferMainView.getName());
            cbStateSkillRegisterView.setValue(skillBufferMainView.getState());
            isEditingSkill = true;
            initializeSkillsRegisterView();
        }
    }

    @FXML
    private void btnDeleteSkill(ActionEvent event) {
        if (skillBufferMainView != null) {
            skillService.deleteSkillsById(skillBufferMainView.getId());
            initializeSkillMainView();
        }
    }

    @FXML
    private void btnBackToSkillMain(ActionEvent event) {
        mainSkillsView.toFront();
        cleanFieldsSkillRegisterView();
        initializeSkillMainView();
    }

    @FXML
    private void btnAddCharacteristicToSkill(ActionEvent event) {
        String characteristic = cbCharacteristicsSkillRegisterView.getValue();
        if (characteristic != null) {
            CharacteristicDto characteristicDto = (CharacteristicDto) characteristicService.getCharacteristicByName(characteristic).getData();
            if (characteristicDto != null) {
                listCharacteristicsRegisterSkillView.getItems().removeIf(t -> t.getId().equals(characteristicDto.getId()));
                listCharacteristicsRegisterSkillView.getItems().add(characteristicDto);
            }
        }
    }

    @FXML
    private void btnRemoveCharacteristicOfSkill(ActionEvent event) {
        if (characteristicViewBuffer != null) {
            listCharacteristicsRegisterSkillView.getItems().remove(characteristicViewBuffer);
        }
    }

    @FXML
    private void btnSaveSkill(ActionEvent event) {
        try {
            String name = txfSkillNameRegister.getText();
            String state = cbStateSkillRegisterView.getValue();
            if (!name.isBlank() && state != null) {
                SkillDto skillDto;
                if (!isEditingSkill) {
                    skillDto = new SkillDto();
                } else {
                    skillDto = skillBufferMainView;
                }

                skillDto.setName(name);
                skillDto.setState(state);
                skillDto.getCharacteristics().clear();
                SkillWrapper skillEntity = new SkillWrapper(skillDto.getName(), skillDto.getState(), skillDto.getId());
                for (CharacteristicDto i : listCharacteristicsRegisterSkillView.getItems()) {
                    i.setSkill(skillEntity.getDto());
                    ResponseWrapper r = characteristicService.updateCharacteristics(i);
                    System.out.println(r);
                }
                ResponseWrapper response = isEditingSkill ? skillService.updateSkills(skillDto) : skillService.createSkill(skillDto);
                if (response.getCode() == ResponseCode.OK) {
                    Message.showNotification("Succeed", MessageType.INFO, response.getMessage());
                    cleanFieldsSkillRegisterView();
                    mainSkillsView.toFront();
                    isEditingSkill = false;
                    initializeSkillMainView();
                } else {
                    Message.showNotification("Error", MessageType.ERROR, response.getMessage());
                    System.out.println(response.getMessage());
                }
            } else {
                Message.showNotification("Warning", MessageType.INFO, "All the fields are required");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void initializeSkillsRegisterView() {
        characteristicDtos = Utilities.loadCharacteristics();
        cbCharacteristicsSkillRegisterView.setItems(Utilities.mapListToObsevableString(characteristicDtos));
        cbStateSkillRegisterView.getItems().addAll("ACTIVE", "INACTIVE");
    }

    private void initializeSkillMainView() {
        skillsDtos = Utilities.loadSkills();
        cbSkillsView.setItems(Utilities.mapListToObsevableString(skillsDtos));
    }

    private void cleanFieldsSkillRegisterView() {
        txfSkillNameRegister.setText("");
        cbStateSkillRegisterView.setValue(null);
        listCharacteristicsRegisterSkillView.getItems().clear();
        cbCharacteristicsSkillRegisterView.setValue(null);
        cbStateSkillRegisterView.getItems().clear();
    }

    private void initializeLists() {
        //CELLSFACTORIES
        listCharacteristicsMainSkillView.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : ((CharacteristicDto) item).getName());
            }
        });
        listCharacteristicsRegisterSkillView.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : ((CharacteristicDto) item).getName());
            }
        });
        //LISTENERS
        listCharacteristicsRegisterSkillView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            characteristicViewBuffer = newValue;
        });
    }

}
