package cr.ac.una.evacomuna.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class RoleModuleController implements Initializable {

    @FXML
    private StackPane parent;
    @FXML
    private HBox registerView;
    @FXML
    private HBox mainView;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void btnNewRole(ActionEvent event) {
        registerView.toFront();
    }

    @FXML
    private void btnBackToMain(ActionEvent event) {
        mainView.toFront();
    }

    @FXML
    private void btnEditRole(ActionEvent event) {
        registerView.toFront();
    }

    @FXML
    private void btnDeleteRole(ActionEvent event) {
    }

    @FXML
    private void cbRoles(ActionEvent event) {
    }

}
