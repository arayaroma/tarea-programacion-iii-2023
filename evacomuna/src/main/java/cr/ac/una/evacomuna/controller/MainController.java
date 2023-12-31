package cr.ac.una.evacomuna.controller;

import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;
import cr.ac.una.evacomuna.dto.UserDto;
import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.services.UserService;
import cr.ac.una.evacomuna.components.Animations;
import cr.ac.una.evacomuna.util.Data;
import cr.ac.una.evacomuna.util.ImageLoader;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

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
    @FXML
    private StackPane parent;

    @FXML
    private Button btnWorkersModule;
    @FXML
    private Button btnGeneralInformationModule;
    @FXML
    private Button btnRoleModule;

    private UserDto userLogged;
    private UserService userService;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            App.setMainController(this);
            userService = new UserService();
            userLogged = Data.getUserLogged();
            // Cut over the photo to make a circula effect
            if (userLogged != null) {
                if (userLogged.getProfilePhoto() != null) {
                    imgProfilePhoto
                            .setClip(new Circle(imgProfilePhoto.getFitWidth() / 2, imgProfilePhoto.getFitHeight() / 2,
                                    40));
                    imgProfilePhoto.setImage(ImageLoader.setImage(userLogged.getProfilePhoto()));
                }
                if (userLogged.getPasswordChanged().equals("Y")) {
                    changePasswordView.setVisible(true);
                    menuPane.setDisable(true);
                    return;
                }
            }
            changePasswordView.setVisible(false);
            menuPane.setDisable(false);
            loadPrivileges();
        } catch (Exception e) {
            System.out.println("Error while loading MainController: " + e.getMessage());
        }
    }

    @FXML
    private void btnWorkersModule(ActionEvent event) {
        try {
            FXMLLoader loader = App.getFXMLLoader("WorkersModule");
            mainScreen.getChildren().clear();
            mainScreen.getChildren().add(loader.load());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btnEvaluationModule(ActionEvent event) {
        try {
            mainScreen.getChildren().clear();
            FXMLLoader loader = App.getFXMLLoader("ContainerEvaluations");
            mainScreen.getChildren().add(loader.load());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btnGeneralInformationModule(ActionEvent event) {
        try {
            mainScreen.getChildren().clear();
            FXMLLoader loader = App.getFXMLLoader("CompanyModule");
            mainScreen.getChildren().add(loader.load());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btnRoleModule(ActionEvent event) {
        try {
            mainScreen.getChildren().clear();
            FXMLLoader loader = App.getFXMLLoader("ContainerModule");
            mainScreen.getChildren().add(loader.load());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void btnPendingsEvaluation(ActionEvent event) {
        try {
            mainScreen.getChildren().clear();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        Animations.translateTransition(parent, Duration.seconds(0.5), 1, -parent.getWidth(), 0, t -> {
            try {
                App.setRoot("Login");
                Data.setUserModified(null);
                Data.setUserLogged(null);
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).play();
    }

    @FXML
    private void discardChangesNewPassword(ActionEvent event) throws IOException {
        App.setRoot("Login");
    }

    @FXML
    private void submitChangesNewPassword(ActionEvent event) {
        String password = txfNewPassword.getText(), confirmPassword = txfPasswordConfirm.getText();
        if (password.isBlank() || !password.equals(confirmPassword)) {
            Message.showNotification("Warning", MessageType.INFO, "You must to write a same password");
            return;
        }
        ResponseWrapper response = userService.changePassword(userLogged.getId(), userLogged.getPassword(), password);
        if (response.getCode() == ResponseCode.OK) {
            Message.showNotification("Succeed", MessageType.INFO, "Your password have been changed succesfully");
            // send request here
            changePasswordView.setVisible(false);
            menuPane.setDisable(false);
            Data.setPasswordChanged(false);
            return;
        }
        Message.showNotification("Internal Error", MessageType.ERROR, response.getMessage());
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

    @FXML
    private void editMyUserAction(MouseEvent event) {
        if (userLogged != null) {
            Data.setUserModified(userLogged);
            App.getMainController().editWorker();
        }
    }

    public void editWorker() {
        try {
            FXMLLoader loader = App.getFXMLLoader("RegisterWorker");
            parent.getChildren().add(loader.load());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void removeMainView(Node node) {
        parent.getChildren().remove(node);
    }

    private void loadPrivileges() {
        if (!userLogged.getIsAdmin().equals("Y")) {
            btnRoleModule.setVisible(false);
            // btnGeneralInformationModule.setVisible(false);
            btnWorkersModule.setVisible(false);
        }
    }

}
