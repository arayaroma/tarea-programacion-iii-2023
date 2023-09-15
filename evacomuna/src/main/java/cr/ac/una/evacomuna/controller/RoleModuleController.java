package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.PositionDto;
import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.SkillDto;
import cr.ac.una.evacomuna.services.Position;
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
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class RoleModuleController implements Initializable {

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
    //BUFFERS
    SkillDto bufferSkill;
    PositionDto bufferRole;
    //SERVICES
    Skill skillService;
    Position roleService;
    //LISTS
    ObservableList<SkillDto> skillDtos;
    ObservableList<PositionDto> roleDtos;
    //FLAGS
    boolean isEditingRole = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            skillService = new Skill();
            roleService = new Position();
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
            roleService.deleteRoleById(bufferRole.getId());
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
        if (name != null && !name.isBlank()) {
            bufferRole = (PositionDto) roleService.getRoleByName(name).getData();
            listSkillsMain.getItems().clear();
            if (bufferRole != null && bufferRole.getSkills() != null) {
                bufferRole.getSkills().forEach(t -> listSkillsMain.getItems().add(t));
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
                ResponseWrapper response = isEditingRole ? roleService.updateRole(role) : roleService.createRole(role);
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
        //CELLSFACTORIES
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
        skillDtos = Utilities.loadSkills();
        cbStateRegister.getItems().addAll("ACTIVE", "INACTIVE");
        cbRolesSkillsRegister.setItems(Utilities.mapListToObsevableString(skillDtos));
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
        roleDtos = Utilities.loadRoles();
        cbRoles.setItems(Utilities.mapListToObsevableString(roleDtos));
    }

}
