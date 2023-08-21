package cr.ac.una.controller;

import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.services.User;
import cr.ac.una.services.impl.UserDto;
import cr.ac.una.util.Message;
import cr.ac.una.util.MessageType;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    private TextField txfEmailForgotYourPassword;
    @FXML
    private TextField txfUser;
    @FXML
    private ComboBox<String> cbRoleRegister;
    @FXML
    private HBox loginView;
    @FXML
    private HBox registerView;
    @FXML
    private HBox forgotYourPasswordView;
    @FXML
    private ImageView imgPhoto;

    private User userService = new User();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Cut over the photo to make a circula effect
        imgPhoto.setClip(new Circle(imgPhoto.getFitWidth() / 2, imgPhoto.getFitHeight() / 2, 75));
    }

    @FXML
    private void forgotPassword(MouseEvent event) {
        forgotYourPasswordView.toFront();
    }

    @FXML
    private void logIn(ActionEvent event) {

    }

    @FXML
    private void signUp(MouseEvent event) {
        registerView.toFront();
    }

    @FXML
    private void backToLogin(MouseEvent event) {
        cleanFieldsRegisterView();
        cleanFieldsForgotYourPasswordView();
        loginView.toFront();
    }

    @FXML
    private void registerUser(ActionEvent event) {
        String userName = txfUserRegister.getText(), password = txfPasswordRegister.getText(), ced = txfCedRegister.getText(), name = txfNameRegister.getText(), lastName = txfLastNameRegister.getText(), secondLastName = txfSecondLastNameRegister.getText(), phoneNumber = txfPhoneNumberRegister.getText(), email = txfEmailRegister.getText(), role = cbRoleRegister.getValue();
        if (userName.isBlank() || password.isBlank() || ced.isBlank() || name.isBlank() || lastName.isBlank() || secondLastName.isBlank() || phoneNumber.isBlank() || email.isBlank() || role == null) {
            Message.showNotification("UPS", MessageType.ERROR, "You must to fill all the fields");
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
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            imgPhoto.setImage(new Image(selectedFile.toURI().toString()));
        }
    }

    @FXML
    private void requestPasswordReset(ActionEvent event) {
        String email = txfEmailForgotYourPassword.getText();
        if (email.isBlank()) {
            Message.showNotification("UPS", MessageType.ERROR, "You must to write a valid email");
            return;
        }
        //send request here
    }

    private void cleanFieldsRegisterView() {
        imgPhoto.setImage(new Image(App.class.getResource("/cr/ac/una/evacomuna/img/usuario.png").toString()));
        txfCedRegister.setText("");
        txfEmailRegister.setText("");
        txfPasswordRegister.setText("");
        txfNameRegister.setText("");
        txfSecondLastNameRegister.setText("");
        txfLastNameRegister.setText("");
        txfUserRegister.setText("");
        txfPhoneNumberRegister.setText("");
        cbRoleRegister.setValue(null);
    }

    private void cleanFieldsForgotYourPasswordView() {
        txfEmailForgotYourPassword.setText("");
    }

}
