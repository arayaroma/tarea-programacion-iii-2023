package cr.ac.una.controller;

import cr.ac.una.dto.UserDto;
import cr.ac.una.evacomuna.App;
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
import javafx.scene.layout.HBox;
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

    @FXML
    private HBox parent;

    private UserDto userService = new UserDto();

    private boolean isFromLogin;

    private cr.ac.una.controller.UserDto userModified;
    private WorkerController controlerUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.setRegisterWorkerController(this);
        // Cut over the photo to make a circula effect
        imgPhoto.setClip(new Circle(imgPhoto.getFitWidth() / 2, imgPhoto.getFitHeight() / 2, 75));
    }

    @FXML
    private void selectPhotoProfile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            imgPhoto.setImage(new Image(selectedFile.toURI().toString()));
        }
    }

    @FXML
    private void backToLogin(MouseEvent event) throws IOException {
        if (isFromLogin) {
            App.setRoot("Login");
            return;
        }
        App.getMainController().removeMainView(parent);
    }

    @FXML
    private void registerUser(ActionEvent event) {
        try {
            String userName = txfUserRegister.getText(), password = txfPasswordRegister.getText(),
                    ced = txfCedRegister.getText(), name = txfNameRegister.getText(),
                    lastName = txfLastNameRegister.getText(), secondLastName = txfSecondLastNameRegister.getText(),
                    phoneNumber = txfPhoneNumberRegister.getText(), email = txfEmailRegister.getText(),
                    role = cbRoleRegister.getValue();
            if (userName.isBlank() || password.isBlank() || ced.isBlank() || name.isBlank() || lastName.isBlank()
                    || secondLastName.isBlank() || phoneNumber.isBlank() || email.isBlank() || role == null) {
                Message.showNotification("UPS", MessageType.ERROR, "You must to fill all the fields");
                return;
            }
            cr.ac.una.controller.UserDto user = createUser(userName, password, name, lastName, secondLastName, ced,
                    email, phoneNumber);
            if (userModified == null) {
                // userService.createUser(user);
                // return;
            } else {
                userModified = user;
                controlerUser.setData(userModified);
                // userService.updateUser(Long.MIN_VALUE, user)
            }
            backToLogin(null);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public cr.ac.una.controller.UserDto createUser(String... args) {
        cr.ac.una.controller.UserDto user = new cr.ac.una.controller.UserDto();
        user.setUsername(args[0]);
        user.setPassword(args[1]);
        user.setName(args[2]);
        user.setLastname(args[3]);
        user.setSecondLastname(args[4]);
        user.setIdentification(args[5]);
        user.setEmail(args[6]);
        user.setPhoneNumber(args[7]);
        return user;
    }

    public void initializeView(boolean isFromLogin, cr.ac.una.controller.UserDto user, WorkerController controller) {
        this.isFromLogin = isFromLogin;

        if (user != null) {
            userModified = user;
            controlerUser = controller;
            txfUserRegister.setText(user.getUsername());
            txfPasswordRegister.setText(user.getPassword());
            txfCedRegister.setText(user.getIdentification());
            txfEmailRegister.setText(user.getEmail());
            txfNameRegister.setText(user.getName());
            txfLastNameRegister.setText(user.getLastname());
            txfSecondLastNameRegister.setText(user.getSecondLastname());
            txfPhoneNumberRegister.setText(user.getPhoneNumber());
        }
    }

}
