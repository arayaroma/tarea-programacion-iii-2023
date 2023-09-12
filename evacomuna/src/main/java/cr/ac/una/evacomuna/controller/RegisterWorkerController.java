package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.PositionDto;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.UserDto;
import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.services.Position;
import cr.ac.una.evacomuna.services.User;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.Utilities;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
    private TextField txfLandLineNumberRegister;
    @FXML
    private ComboBox<String> cbRoleRegister;

    @FXML
    private HBox parent;

    private User userService;
    private Position roleService;

    private boolean isFromLogin;

    private UserDto userModified;
    private WorkerController controlerUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        App.setRegisterWorkerController(this);
        userService = new User();
        roleService = new Position();
        // Cut over the photo to make a circula effect
        imgPhoto.setClip(new Circle(imgPhoto.getFitWidth() / 2, imgPhoto.getFitHeight() / 2, 75));
        ObservableList<PositionDto> roleDtos = Utilities.loadRoles();
        roleDtos.stream().forEach(t -> cbRoleRegister.getItems().add(t.getName()));
    }

    @FXML
    private void selectPhotoProfile(ActionEvent event) {
        File selectedFile = Utilities.selectFile("Image files", "*.jpg", "*.png", "*.jpeg");
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
            ResponseWrapper response;
            Image image = imgPhoto.getImage();
            String userName = txfUserRegister.getText(), password = txfPasswordRegister.getText(),
                    ced = txfCedRegister.getText(), name = txfNameRegister.getText(),
                    lastName = txfLastNameRegister.getText(), secondLastName = txfSecondLastNameRegister.getText(),
                    phoneNumber = txfPhoneNumberRegister.getText(), email = txfEmailRegister.getText(),
                    role = cbRoleRegister.getValue(), landLineNumber = txfLandLineNumberRegister.getText();
            if (userName.isBlank() || password.isBlank() || ced.isBlank() || name.isBlank() || lastName.isBlank()
                    || secondLastName.isBlank() || phoneNumber.isBlank() || landLineNumber.isBlank() || email.isBlank() || role == null || image == null) {
                Message.showNotification("UPS", MessageType.ERROR, "You must to fill all the fields");
                return;
            }
            UserDto userDto = createUser(userName, password, name, lastName, secondLastName, ced,
                    email, phoneNumber, landLineNumber, role);
            userDto.setProfilePhoto(Utilities.imageToByte(image));
            if (userModified == null) {
                response = userService.createUser(userDto);

            } else {
                userDto.setId(userModified.getId());
                userDto.setPosition(userModified.getPosition());
                userDto.setIsAdmin(userModified.getIsAdmin());

                controlerUser.setData(userDto);
                response = userService.updateUser(userDto);

            }
            System.out.println(response.getMessage());
            Message.showNotification(response.getCode().name(), MessageType.INFO, response.getMessage());
            backToLogin(null);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public UserDto createUser(String... args) {
        UserDto user = new UserDto();
        user.setUsername(args[0]);
        user.setPassword(args[1]);
        user.setName(args[2]);
        user.setLastname(args[3]);
        user.setSecondLastname(args[4]);
        user.setIdentification(args[5]);
        user.setEmail(args[6]);
        user.setPhoneNumber(args[7]);
        user.setLandlineNumber(args[8]);
        user.setIsActive("N");
        user.setIsAdmin("N");
        user.setPasswordChanged("N");
        PositionDto roleDto = (PositionDto) roleService.getRoleByName(args[9]).getData();
        user.setPosition(roleDto);
        return user;
    }

    public void initializeView(boolean isFromLogin, UserDto user, WorkerController controller) {
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
