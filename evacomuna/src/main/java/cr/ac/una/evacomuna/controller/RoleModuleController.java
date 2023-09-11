package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.CharacteristicDto;
import cr.ac.una.controller.ListWrapper;
import cr.ac.una.controller.PositionDto;
import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.SkillDto;
import cr.ac.una.evacomuna.services.Characteristic;
import cr.ac.una.evacomuna.services.Skill;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    private ComboBox<String> cbSkillsView;
    @FXML
    private ComboBox<String> cbRolesSkillsRegister;
    @FXML
    private ComboBox<String> cbCharacteristicsSkillRegisterView;
    @FXML
    private ComboBox<String> cbStateSkillRegisterView;
    @FXML
    private Button btnAddSkill;
    @FXML
    private ListView<PositionDto> listRolesRegister;
    @FXML
    private Button btnDeleteSkill;
    @FXML
    private ListView<SkillDto> listSkillsMain;
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
    private HBox mainCharacteristicsView;
    @FXML
    private TextField txfCharacteristic;
    @FXML
    private ListView<CharacteristicDto> listCharacteristicsMainSkillView;
    @FXML
    private ListView<CharacteristicDto> listCharacteristicsRegisterSkillView;
    @FXML
    private ListView<CharacteristicDto> listCharactersiticView;

    //LISTS
    ObservableList<CharacteristicDto> characteristicDtos;
    ObservableList<SkillDto> skillsDtos;
    Characteristic characteristicService;
    Skill skillService;
    //Buffers
    CharacteristicDto characteristicViewBuffer;
    SkillDto skillBufferMainView;
    //FLAGS
    boolean isEditingSkill = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Load lists
        try {
            characteristicService = new Characteristic();
            skillService = new Skill();
            characteristicDtos = loadCharacteristics();
            skillsDtos = loadSkills();
            initializeComboBox();
            intializeLists();

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
        registerSkillsView.toFront();
    }

    @FXML
    private void btnEditSkill(ActionEvent event) {
        if (skillBufferMainView != null) {
            registerSkillsView.toFront();
            txfSkillNameRegister.setText(skillBufferMainView.getName());
            cbStateSkillRegisterView.setValue(skillBufferMainView.getState());
            isEditingSkill = true;

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
                skillDto.setDescription("nada");
                skillDto.getCharacteristics().clear();
                for (CharacteristicDto i : listCharacteristicsRegisterSkillView.getItems()) {
                    skillDto.getCharacteristics().add(i);
                }
                ResponseWrapper response = isEditingSkill ? skillService.updateSkills(skillDto) : skillService.createSkill(skillDto);
                if (response.getCode() == ResponseCode.OK) {
                    Message.showNotification("Succeed", MessageType.INFO, response.getMessage());
                    cleanFieldsSkillRegisterView();
                    System.out.println(response.getMessage());
                    if (isEditingSkill) {
                        mainSkillsView.toFront();
                        isEditingSkill = false;
                        initializeSkillMainView();
                    }
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
    private void btnBackToSkillMain(ActionEvent event) {
        mainSkillsView.toFront();
        cleanFieldsSkillRegisterView();
        initializeSkillMainView();
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
        String nameSkill = cbSkillsView.getValue();
        if (nameSkill != null) {
            skillBufferMainView = (SkillDto) skillService.getSkillByName(nameSkill).getData();;
        }
    }

    @FXML
    private void btnRemoveCharacteristicOfSkill(ActionEvent event) {
        if (characteristicViewBuffer != null) {
            listCharacteristicsRegisterSkillView.getItems().remove(characteristicViewBuffer);
        }
    }

    private void intializeLists() {
        /*CELLS FACTORIES*/
        setNodeCellFactory();
        /*FILL LISTS*/

        //Lists
        listCharactersiticView.setItems(characteristicDtos);
        /*LISTENERS*/
        listCharactersiticView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            characteristicViewBuffer = newValue;
            if (characteristicViewBuffer != null) {
                txfCharacteristic.setText(characteristicViewBuffer.getName());
            }
        });
        listCharacteristicsRegisterSkillView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            characteristicViewBuffer = newValue;
        });
    }

    private void initializeComboBox() {
        cbStateSkillRegisterView.getItems().addAll("ACTIVE", "INACTIVE");
        cbCharacteristicsSkillRegisterView.setItems(mapListToObsevableString(characteristicDtos));
        cbSkillsView.setItems(mapListToObsevableString(skillsDtos));
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

    private void setNodeCellFactory() {

        listCharactersiticView.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : ((CharacteristicDto) item).getName());
            }
        });
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
    }

    private void cleanFieldsCharacteristicView() {
        txfCharacteristic.setText("");
        characteristicViewBuffer = null;
    }

    private void cleanFieldsSkillRegisterView() {
        txfSkillNameRegister.setText("");
        cbStateSkillRegisterView.setValue(null);
        listCharacteristicsRegisterSkillView.getItems().clear();
        cbCharacteristicsSkillRegisterView.setValue(null);
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

    private void initializeSkillMainView() {
        skillsDtos = loadSkills();
        cbSkillsView.setItems(mapListToObsevableString(skillsDtos));
    }

}
