/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.controller;

import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.services.User;
import cr.ac.una.services.impl.UserDto;
import cr.ac.una.util.Message;
import cr.ac.una.util.MessageType;
import java.io.File;
import java.io.IOException;
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
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class RegisterWorkerController implements Initializable {

    @FXML
    private ImageView imgPhoto;
    @FXML
    private TextField txfUserRegister;
    @FXML
    private PasswordField txfPasswordRegister;
    @FXML
    private TextField txfCedRegister;
    @FXML
    private TextField txfNameRegister;
    @FXML
    private TextField txfLastNameRegister;
    @FXML
    private TextField txfSecondLastNameRegister;
    @FXML
    private TextField txfEmailRegister;
    @FXML
    private TextField txfPhoneNumberRegister;
    @FXML
    private ComboBox<String> cbRoleRegister;

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
    private void selectPhotoProfile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            imgPhoto.setImage(new Image(selectedFile.toURI().toString()));
        }
    }

    @FXML
    private void backToLogin(MouseEvent event) throws IOException {
        App.setRoot("Login");
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

}
