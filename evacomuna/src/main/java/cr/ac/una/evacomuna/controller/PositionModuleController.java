package cr.ac.una.evacomuna.controller;

import cr.ac.una.evacomuna.dto.PositionDto;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;
import cr.ac.una.evacomuna.dto.SkillDto;
import cr.ac.una.evacomuna.services.PositionService;
import cr.ac.una.evacomuna.services.SkillService;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.ObservableListParser;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class PositionModuleController implements Initializable {

    @FXML
    private HBox registerRolesView;
    @FXML
    private TextField txfRoleNameRegister;
    @FXML
    private ComboBox<String> cbRolesSkillsRegister;
    @FXML
    private ComboBox<String> cbRoles;
    @FXML
    private ComboBox<String> cbStateRegister;
    @FXML
    private HBox mainRoleView;
    @FXML
    private ListView<SkillDto> listSkillsMain;
    @FXML
    private ListView<SkillDto> listSkillsRegister;
    // BUFFERS
    SkillDto bufferSkill;
    PositionDto bufferRole;
    // SERVICES
    SkillService skillService;
    PositionService positionService;
    // LISTS
    ObservableList<SkillDto> skillDtos;
    ObservableList<PositionDto> positionDtos;
    // FLAGS
    boolean isEditingRole = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            skillService = new SkillService();
            positionService = new PositionService();
            initializeLists();
            initializeMainView();
        } catch (Exception e) {
            System.out.println("Exception while loading RoleModuleController: " + e.toString());
        }

    }

    @FXML
    private void btnBackToMainRole(ActionEvent event) {
        mainRoleView.toFront();
        cleanRegisterView();
    }

    @FXML
    private void btnNewRole(ActionEvent event) {
        registerRolesView.toFront();
        isEditingRole = false;
        bufferRole = null;
        initializeRegisterView();
    }

    @FXML
    private void btnEditRole(ActionEvent event) {
        if (bufferRole != null) {
            registerRolesView.toFront();
            isEditingRole = true;
            initializeRegisterView();
            txfRoleNameRegister.setText(bufferRole.getName());
            cbStateRegister.setValue(bufferRole.getState());
        }
    }

    @FXML
    private void btnDeleteRole(ActionEvent event) {
        if (bufferRole != null) {
            positionService.deletePositionById(bufferRole.getId());
            initializeMainView();
        }
    }

    @FXML
    private void btnDeleteSkill(ActionEvent event) {
        if (bufferSkill != null) {
            listSkillsRegister.getItems().remove(bufferSkill);
        }
    }

    @FXML
    private void btnAddSkill(ActionEvent event) {
        String name = cbRolesSkillsRegister.getValue();
        if (name != null) {
            SkillDto skillDto = (SkillDto) skillService.getSkillByName(name).getData();
            if (skillDto != null) {
                listSkillsRegister.getItems().removeIf(t -> t.getId().equals(skillDto.getId()));
                listSkillsRegister.getItems().add(skillDto);
            }
        }
    }

    @FXML
    private void selectRole(ActionEvent event) {
        String name = cbRoles.getValue();
        if (name != null) {
            bufferRole = (PositionDto) positionService.getPositionByName(name).getData();
            listSkillsMain.getItems().clear();
            if (bufferRole != null && bufferRole.getSkills() != null) {
                bufferRole.getSkills().forEach(t -> listSkillsMain.getItems().add(t));
            }
        }
    }

    @FXML
    private void searchRoleInput(KeyEvent event) {
        if (event.getCode().isLetterKey()) {
            String nameToSearch = cbRoles.getEditor().getText();
            if (nameToSearch != null) {
                cbRoles.getItems().clear();
                if (nameToSearch.length() > 2) {
                    cbRoles.getItems().addAll(positionDtos.stream().filter(t -> t.getName().contains(nameToSearch))
                            .map(t -> t.getName()).collect(Collectors.toList()));
                    return;
                }
                cbRoles.getItems().addAll(ObservableListParser.mapListToObsevableString(positionDtos));
                cbRoles.show();
            }
        }
    }

    @FXML
    private void btnSaveRole(ActionEvent event) {
        try {
            String name = txfRoleNameRegister.getText();
            String state = cbStateRegister.getValue();
            if (!name.isBlank() && state != null) {
                PositionDto role;
                if (!isEditingRole) {
                    role = new PositionDto();
                } else {
                    role = bufferRole;
                }
                role.setName(name);
                role.setState(state);
                role.getSkills().clear();
                for (SkillDto i : listSkillsRegister.getItems()) {
                    role.getSkills().add(i);
                }
                ResponseWrapper response = isEditingRole ? positionService.updatePosition(role)
                        : positionService.createPosition(role);
                if (response.getCode() == ResponseCode.OK) {
                    Message.showNotification("Succeed", MessageType.INFO, response.getMessage());
                    cleanRegisterView();
                    mainRoleView.toFront();
                    initializeMainView();
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

    private void initializeLists() {
        // CELLSFACTORIES
        listSkillsMain.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : ((SkillDto) item).getName());
            }
        });
        listSkillsRegister.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : ((SkillDto) item).getName());
            }
        });
        listSkillsRegister.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            bufferSkill = newValue;
        });

    }

    private void initializeRegisterView() {
        skillDtos = ObservableListParser.loadSkills();
        cbStateRegister.getItems().addAll("ACTIVE", "INACTIVE");
        cbRolesSkillsRegister.setItems(ObservableListParser.mapListToObsevableString(skillDtos));
        if (bufferRole != null && bufferRole.getSkills() != null) {
            bufferRole.getSkills().forEach(t -> listSkillsRegister.getItems().add(t));
        }
    }

    private void cleanRegisterView() {
        txfRoleNameRegister.setText("");
        cbStateRegister.getItems().clear();
        cbStateRegister.setValue(null);
        cbRolesSkillsRegister.setValue(null);
        listSkillsRegister.getItems().clear();

    }

    private void initializeMainView() {
        positionDtos = ObservableListParser.loadPositions();
        cbRoles.setItems(ObservableListParser.mapListToObsevableString(positionDtos));
    }

}
