package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.CharacteristicDto;
import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.SkillDto;
import cr.ac.una.evacomuna.dto.CharacteristicWrapper;
import cr.ac.una.evacomuna.dto.SkillWrapper;
import cr.ac.una.evacomuna.services.Characteristic;
import cr.ac.una.evacomuna.services.Skill;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.Utilities;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    private HBox registerSkillsView;
    @FXML
    private ComboBox<String> cbSkillsView;
    @FXML
    private ListView<CharacteristicDto> listCharacteristicsMainSkillView;
    @FXML
    private ListView<CharacteristicDto> listCharacteristicsRegisterSkillView;

    @FXML
    private TextField txfSkillNameRegister;
    @FXML
    private TextField txfCharacteristic;
    @FXML
    private ComboBox<String> cbStateSkillRegisterView;

    // SERVICES
    Skill skillService;
    Characteristic characteristicService;
    // BUFFERS
    SkillDto skillBufferMainView;
    CharacteristicDto characteristicViewBuffer;
    // FLAGS
    boolean isEditingSkill = false;
    // LISTS
    ObservableList<CharacteristicDto> characteristicDtos;
    ObservableList<SkillDto> skillsDtos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            skillService = new Skill();
            characteristicService = new Characteristic();
            initializeLists();
            initializeSkillMainView();
            cbSkillsView.setOnKeyReleased(t -> searchSkillInput(t));
            txfCharacteristic.setOnKeyReleased(t -> {
                if (t.getCode() == KeyCode.ENTER) {
                    btnAddCharacteristicToSkill(null);
                }
            });
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void btnNewSkill(ActionEvent event) {
        registerSkillsView.toFront();
        skillBufferMainView = null;
        isEditingSkill = false;
        initializeSkillsRegisterView();
    }

    private void searchSkillInput(KeyEvent event) {
        if (event.getCode().isLetterKey()) {
            String nameToSearch = cbSkillsView.getEditor().getText();
            if (nameToSearch != null) {
                cbSkillsView.getItems().clear();
                if (nameToSearch.length() > 2) {
                    cbSkillsView.getItems().addAll(skillsDtos.stream().filter(t -> t.getName().contains(nameToSearch)).map(t -> t.getName()).collect(Collectors.toList()));
                    return;
                }
                cbSkillsView.getItems().addAll(Utilities.mapListToObsevableString(skillsDtos));
                cbSkillsView.show();
            }
        }
    }

    @FXML
    private void selectSkill(ActionEvent event) {
        String nameSkill = cbSkillsView.getValue();
        if (nameSkill != null) {
            skillBufferMainView = (SkillDto) skillService.getSkillByName(nameSkill).getData();
            if (skillBufferMainView != null) {
                listCharacteristicsMainSkillView.getItems().clear();
                skillBufferMainView.getCharacteristics()
                        .forEach(t -> listCharacteristicsMainSkillView.getItems().add(t));
            }
        }
    }

    @FXML
    private void btnEditSkill(ActionEvent event) {
        if (skillBufferMainView != null) {
            registerSkillsView.toFront();
            txfSkillNameRegister.setText(skillBufferMainView.getName());
            cbStateSkillRegisterView.setValue(skillBufferMainView.getState());
            isEditingSkill = true;
            cleanFieldsSkillRegisterView();
            initializeSkillsRegisterView();

        }
    }

    @FXML
    private void btnDeleteSkill(ActionEvent event) {
        if (skillBufferMainView != null) {
            if (skillBufferMainView.getCharacteristics() != null) {
                skillBufferMainView.getCharacteristics().forEach(t -> characteristicService.deleteCharacteristicById(t.getId()));
            }
            ResponseWrapper response = skillService.deleteSkillsById(skillBufferMainView.getId());
            Message.showNotification(response.getCode().name(), response.getCode() == ResponseCode.OK ? MessageType.INFO : MessageType.ERROR, response.getMessage());
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
        String characteristicName = txfCharacteristic.getText();
        if (!characteristicName.isBlank()) {
            CharacteristicWrapper characteristicWrapper = new CharacteristicWrapper(characteristicName, null, null);
            listCharacteristicsRegisterSkillView.getItems().add(characteristicWrapper.getDto());
            txfCharacteristic.setText("");
        }
    }

    @FXML
    private void btnRemoveCharacteristicOfSkill(ActionEvent event) {
        if (characteristicViewBuffer != null) {
            if (characteristicViewBuffer.getId() != null) {
                characteristicService.deleteCharacteristicById(characteristicViewBuffer.getId());
            }
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

                ResponseWrapper response = isEditingSkill ? skillService.updateSkills(skillDto) : skillService.createSkill(skillDto);
                if (response.getCode() == ResponseCode.OK) {
                    skillDto = (SkillDto) response.getData();
                    SkillWrapper newSkillWrapper = new SkillWrapper(skillDto.getName(), skillDto.getState(), skillDto.getId());

                    for (CharacteristicDto i : listCharacteristicsRegisterSkillView.getItems()) {
                        if (i.getId() == null) {
                            i.setSkill(newSkillWrapper.getDto());
                            characteristicService.createCharacteristic(i);
                        }
                    }
                    Message.showNotification("Succeed", MessageType.INFO, response.getMessage());
                    cleanFieldsSkillRegisterView();
                    mainSkillsView.toFront();
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
        cbStateSkillRegisterView.getItems().addAll("ACTIVE", "INACTIVE");
        if (skillBufferMainView != null && skillBufferMainView.getCharacteristics() != null) {
            txfSkillNameRegister.setText(skillBufferMainView.getName());
            cbStateSkillRegisterView.setValue(skillBufferMainView.getState());
            skillBufferMainView.getCharacteristics().forEach(t -> listCharacteristicsRegisterSkillView.getItems().add(t));

        }
    }

    private void initializeSkillMainView() {
        skillsDtos = Utilities.loadSkills();
        cbSkillsView.setValue(null);
        cbSkillsView.setItems(Utilities.mapListToObsevableString(skillsDtos));
        listCharacteristicsMainSkillView.getItems().clear();

    }

    private void cleanFieldsSkillRegisterView() {
        txfSkillNameRegister.setText("");
        cbStateSkillRegisterView.setValue(null);
        listCharacteristicsRegisterSkillView.getItems().clear();
        txfCharacteristic.setText("");
        cbStateSkillRegisterView.getItems().clear();
    }

    private void initializeLists() {
        // CELLSFACTORIES
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
        // LISTENERS
        listCharacteristicsRegisterSkillView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    characteristicViewBuffer = newValue;

                });
    }

}
