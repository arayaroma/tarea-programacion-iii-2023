package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.UserDto;
import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.services.User;
import cr.ac.una.evacomuna.util.Data;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class LoginController implements Initializable {

    @FXML
    private PasswordField txfPassword;
    @FXML
    private TextField txfEmailForgotYourPassword;
    @FXML
    private TextField txfUser;
    @FXML
    private HBox loginView;
    @FXML
    private HBox forgotYourPasswordView;
    @FXML
    private StackPane mainScreen;

    private Parent registerView;
    private User userService;
    private String adminUser = "admin";
    private String adminPassword = "admin";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userService = new User();
        App.setLoginController(this);
        txfPassword.setOnKeyPressed((event) -> keyLoginHandler(event));
        txfUser.setOnKeyPressed((event) -> keyLoginHandler(event));
    }

    @FXML
    private void forgotPassword(MouseEvent event) {
        forgotYourPasswordView.toFront();
    }

    @FXML
    private void logIn(ActionEvent event) {
        try {
            
            String user = txfUser.getText(), password = txfPassword.getText();
            if (user.isBlank() || password.isBlank()) {
                Message.showNotification("Ups", MessageType.INFO, "All the fields are required");
                return;
            }
            if(user.equals(adminUser) && password.equals(adminPassword)){
                App.setRoot("Main");
                Data.setHasPrivileges(true);
                return;
            }
            ResponseWrapper responseWrapper = userService.getByUserAndPassword(user, password);
            if (responseWrapper.getCode() == ResponseCode.OK) {
                UserDto userDto = (UserDto) responseWrapper.getData();
                if (userDto.getIsActive().equals("N")) {
                    Message.showNotification("Uh Oh", MessageType.INFO, "Your user is not already active, please verify your email");
                    return;
                }
                Data.setUserLogged(userDto);
                App.setRoot("Main");
            } else {
                Message.showNotification("Error", MessageType.ERROR, responseWrapper.getMessage());
            }
            System.out.println(responseWrapper.getMessage());
        } catch (Exception ex) {

            System.out.println(ex.toString());
        }
    }

    @FXML
    private void signUp(MouseEvent event) {
        try {
            FXMLLoader loader = App.getFXMLLoader("RegisterWorker");
            registerView = loader.load();
            mainScreen.getChildren().add(registerView);
            registerView.toFront();
            App.getRegisterWorkerController().initializeView(true, null);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void backToLogin(MouseEvent event) {
        cleanFieldsForgotYourPasswordView();
        loginView.toFront();
    }

    @FXML
    private void requestPasswordReset(ActionEvent event) {
        String email = txfEmailForgotYourPassword.getText();
        if (email.isBlank()) {
            Message.showNotification("UPS", MessageType.ERROR, "You must to write a valid email");
            return;
        }
        //send request new password here
        Data.setPasswordChanged(true);

        ResponseWrapper response = userService.recoverPassword(email);
        Message.showNotification("Info", MessageType.INFO, "Request sent");
        loginView.toFront();

    }

    private void cleanFieldsForgotYourPasswordView() {
        txfEmailForgotYourPassword.setText("");
    }

    private void keyLoginHandler(KeyEvent ev) {
        if (ev.getCode() == KeyCode.ENTER) {
            logIn(null);
        }
    }

}
