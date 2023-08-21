package cr.ac.una.controller;

import cr.ac.una.evacomuna.services.User;
import cr.ac.una.services.impl.UserDto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class LoginController implements Initializable {

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
    private TextField txfEmailRegister;
    @FXML
    private TextField txfCedRegister;
    @FXML
    private TextField txfSecondLastNameRegister;
    @FXML
    private TextField txfPhoneNumberRegister;
    @FXML
    private TextField txfUser;
    @FXML
    private ComboBox<String> cbRoleRegister;
    @FXML
    private HBox loginView;
    @FXML
    private HBox registerView;
    @FXML
    private ImageView imgPhoto;

    private User userService = new User();

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
    private void registerUser(ActionEvent event) {
        String userName = txfUserRegister.getText(), password = txfPasswordRegister.getText(), ced = txfCedRegister.getText(), name = txfNameRegister.getText(), lastName = txfLastNameRegister.getText(), secondLastName = txfSecondLastNameRegister.getText(), phoneNumber = txfPhoneNumberRegister.getText(), email = txfEmailRegister.getText(), role = cbRoleRegister.getValue();
        if (userName.isBlank() || password.isBlank() || ced.isBlank() || name.isBlank() || lastName.isBlank() || secondLastName.isBlank() || phoneNumber.isBlank() || email.isBlank() || role.isBlank()) {
            System.out.println("You must to fill all the fields");
            return;
        }
        UserDto user = new UserDto();
        user.setEmail(email);
        user.setIdentification(ced);
        user.setSecondLastname(secondLastName);
        user.setName(name);
        user.setLastname(lastName);
        user.setPassword(password);
        user.setUsername(userName);
        user.setPhoneNumber(phoneNumber);
        userService.createUser(user);
    }

    @FXML
    private void selectPhotoProfile(ActionEvent event) {
    }

}
