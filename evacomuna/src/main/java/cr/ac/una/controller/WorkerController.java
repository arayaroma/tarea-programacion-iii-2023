package cr.ac.una.controller;

import cr.ac.una.services.impl.UserDto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    private void editWorker(ActionEvent event) {
    }
    
    @FXML
    private void deleteWorker(ActionEvent event) {
    }
    
    public void setData(UserDto user) {
        lblUserName.setText(user.getUsername());
        lblCed.setText(user.getIdentification());
        lblName.setText(user.getName());
        lblPhoneNumber.setText(user.getPhoneNumber());
        lblLastName.setText(user.getLastname());
    }
}
