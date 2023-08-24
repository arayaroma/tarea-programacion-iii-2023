package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.UserDto;
import cr.ac.una.evacomuna.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class WorkerController implements Initializable {

    @FXML
    private Label lblUserName;
    @FXML
    private Label lblCed;
    @FXML
    private Label lblName;
    @FXML
    private Label lblLastName;
    @FXML
    private Label lblPhoneNumber;
    @FXML
    private HBox parent;

    private UserDto worker;

    private String idController;

    public String getIdController() {
        return idController;
    }

    public void setIdController(String idController) {
        this.idController = idController;
    }

    public void setWorker(UserDto worker) {
        this.worker = worker;
    }

    public UserDto getWorker() {
        return worker;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WorkersModuleController.addWorkerController(this);
    }

    @FXML
    private void editWorker(ActionEvent event) {

        App.getWorkersModuleController().editWorker(worker, this);
    }

    @FXML
    private void deleteWorker(ActionEvent event) {
        App.getWorkersModuleController().deleteWorker(parent);
    }

    public void setData(UserDto user) {
        lblUserName.setText(user.getUsername());
        lblCed.setText(user.getIdentification());
        lblName.setText(user.getName());
        lblPhoneNumber.setText(user.getPhoneNumber());
        lblLastName.setText(user.getLastname());
        idController = user.getIdentification();
        worker = user;
    }
}
