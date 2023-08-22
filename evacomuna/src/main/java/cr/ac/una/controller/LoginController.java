package cr.ac.una.controller;

import cr.ac.una.evacomuna.App;
import cr.ac.una.util.Data;
import cr.ac.una.util.Message;
import cr.ac.una.util.MessageType;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.setLoginController(this);
    }

    @FXML
    private void forgotPassword(MouseEvent event) {
        forgotYourPasswordView.toFront();
    }

    @FXML
    private void logIn(ActionEvent event) throws IOException {
        String user = txfUser.getText(), password = txfPassword.getText();
        //User verification here
        App.setRoot("Main");
    }

    @FXML
    private void signUp(MouseEvent event) {
        try {
            FXMLLoader loader = App.getFXMLLoader("RegisterWorker");
            registerView = loader.load();
            mainScreen.getChildren().add(registerView);
            registerView.toFront();
            App.getRegisterWorkerController().initializeView(true, null, null);
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
        Message.showNotification("Info", MessageType.INFO, "Request sent");
        loginView.toFront();

    }

    private void cleanFieldsForgotYourPasswordView() {
        txfEmailForgotYourPassword.setText("");
    }

}
