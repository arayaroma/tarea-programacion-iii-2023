package cr.ac.una.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txfUser;
    @FXML
    private PasswordField txfPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void forgotPassword(MouseEvent event) {
    }

    @FXML
    private void logIn(ActionEvent event) {
    }

    @FXML
    private void signUp(MouseEvent event) {
    }
    
}
