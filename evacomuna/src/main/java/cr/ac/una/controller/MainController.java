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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class MainController implements Initializable {

    @FXML
    private ImageView imgProfilePhoto;
    @FXML
    private VBox changePasswordView;
    @FXML
    private PasswordField txfNewPassword;
    @FXML
    private PasswordField txfPasswordConfirm;
    @FXML
    private Label lblChangePasswordInfo;
    @FXML
    private VBox menuPane;
    @FXML
    private StackPane mainScreen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.setMainController(this);
        //Cut over the photo to make a circula effect
        imgProfilePhoto.setClip(new Circle(imgProfilePhoto.getFitWidth() / 2, imgProfilePhoto.getFitHeight() / 2, 40));
        if (Data.isPasswordChanged()) {
            changePasswordView.setVisible(true);
            menuPane.setDisable(true);
            return;
        }
        changePasswordView.setVisible(false);
        menuPane.setDisable(false);
    }

    @FXML
    private void btnWorkersModule(ActionEvent event) {
        try {
            FXMLLoader loader = App.getFXMLLoader("WorkersModule");
            mainScreen.getChildren().clear();
            mainScreen.getChildren().add(loader.load());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    @FXML
    private void btnEvaluationModule(ActionEvent event) {
        mainScreen.getChildren().clear();
    }

    @FXML
    private void btnGeneralInformationModule(ActionEvent event) {
        mainScreen.getChildren().clear();
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        App.setRoot("Login");
    }

    @FXML
    private void discardChangesNewPassword(ActionEvent event) throws IOException {
        App.setRoot("Login");
    }

    @FXML
    private void submitChangesNewPassword(ActionEvent event) {
        Message.showNotification("Succeed", MessageType.INFO, "Your password have been changed succesfully");
        //send request here
        changePasswordView.setVisible(false);
        menuPane.setDisable(false);
        Data.setPasswordChanged(false);
    }

    @FXML
    private void passwordsEquals(KeyEvent event) {
        if (txfNewPassword.getText().equals(txfPasswordConfirm.getText()) && !txfNewPassword.getText().isBlank()) {
            lblChangePasswordInfo.setText("The password and confirm is equals");
            lblChangePasswordInfo.getStyleClass().remove("error-color-label");
            lblChangePasswordInfo.getStyleClass().add("confirm-color-label");

        } else if (txfNewPassword.getText().isBlank() && txfPasswordConfirm.getText().isBlank()) {
            lblChangePasswordInfo.setText("");
        } else {
            lblChangePasswordInfo.setText("New password and confirm is not equals");
            lblChangePasswordInfo.getStyleClass().remove("confirm-color-label");
            lblChangePasswordInfo.getStyleClass().add("error-color-label");
        }
    }

}
