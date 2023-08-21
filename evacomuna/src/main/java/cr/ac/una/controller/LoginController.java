package cr.ac.una.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

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
    @FXML
    private TextField txfUserRegister;
    @FXML
    private TextField txfPasswordRegister;
    @FXML
    private TextField txfNameRegister;
    @FXML
    private TextField txfLastNameRegister;
    @FXML
    private TextField txfPhoneRegister;
    @FXML
    private TextField txfEmailRegister;
    @FXML
    private ComboBox<?> cbRoleRegister;
    @FXML
    private HBox loginView;
    @FXML
    private HBox registerView;
    @FXML
    private ImageView imgPhoto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void forgotPassword(MouseEvent event) {

    }

    @FXML
    private void logIn(ActionEvent event) {
    }

    @FXML
    private void signUp(MouseEvent event) {
        registerView.toFront();
    }

    @FXML
    private void backToLogin(ActionEvent event) {
        loginView.toFront();
    }

    @FXML
    private void choosePhotoProfile(ActionEvent event) {
    }

    @FXML
    private void registerUser(ActionEvent event) {
        String user = txfUserRegister.getText(), password = txfPasswordRegister.getText(), name = txfNameRegister.getText(), lastName = txfLastNameRegister.getText(), phoneNumber = txfPhoneRegister.getText(), email = txfEmailRegister.getText();
        if (user.isBlank() || password.isBlank() || name.isBlank() || lastName.isBlank() || phoneNumber.isBlank() || email.isBlank()) {
            System.out.println("You must to fill all the fields");
            return;
        }
        //Send a new User
    }

}
