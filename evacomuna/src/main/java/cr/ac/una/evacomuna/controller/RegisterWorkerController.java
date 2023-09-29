package cr.ac.una.evacomuna.controller;

import cr.ac.una.evacomuna.dto.PositionDto;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;
import cr.ac.una.evacomuna.dto.UserDto;
import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.services.PositionService;
import cr.ac.una.evacomuna.services.UserService;
import cr.ac.una.evacomuna.util.Data;
import cr.ac.una.evacomuna.util.ImageLoader;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.ObservableListParser;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author estebannajera
 * @author arayaroma
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

    private File bufferFileImage;
    private UserService userService;
    private PositionService roleService;

    private boolean isFromLogin;

    private UserDto userModified;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.setRegisterWorkerController(this);
        userService = new UserService();
        roleService = new PositionService();
        // Cut over the photo to make a circula effect
        imgPhoto.setClip(new Circle(imgPhoto.getFitWidth() / 2, imgPhoto.getFitHeight() / 2, 75));
        ObservableList<PositionDto> roleDtos = ObservableListParser.loadPositions();
        roleDtos.stream().forEach(t -> cbRoleRegister.getItems().add(t.getName()));
        userModified = Data.getUserModified();
        if (userModified != null) {
            initializeView(false, userModified);
        }
    }

    /**
     * Modularizing the app. Changed the method to use the ImageLoader class
     * instead of the Utilities class.
     *
     * @param event when the user clicks on the image
     */
    @FXML
    private void selectPhotoProfile(ActionEvent event) {
        File selectedFile = ImageLoader.selectFile("Image files", "*.jpg", "*.png", "*.jpeg");
        if (selectedFile != null) {
            imgPhoto.setImage(ImageLoader.setImage(selectedFile));
            bufferFileImage = selectedFile;
        }
    }

    /**
     * Must be a enum with the fxml files names
     *
     * @param event when the user clicks on the back button
     * @throws IOException can't load the fxml file
     */
    @FXML
    private void backToLogin(MouseEvent event) throws IOException {
        if (isFromLogin) {
            App.setRoot("Login");
            return;
        }
        App.getMainController().removeMainView(parent);
        App.getWorkersModuleController().loadWorkers(ObservableListParser.loadUsers());
    }

    /**
     * Not validating if the bufferFileImage is null, because the user can
     * register without a profile photo and the default photo will be setted,
     * then the user can change the photo later.
     *
     * @return
     */
    private Boolean areFieldsEmpty() {
        return txfUserRegister.getText().isBlank() || txfPasswordRegister.getText().isBlank()
                || txfCedRegister.getText().isBlank() || txfNameRegister.getText().isBlank()
                || txfLastNameRegister.getText().isBlank() || txfSecondLastNameRegister.getText().isBlank()
                || txfPhoneNumberRegister.getText().isBlank() || txfLandLineNumberRegister.getText().isBlank()
                || txfEmailRegister.getText().isBlank() || cbRoleRegister.getValue() == null;
    }

    /**
     * Changed the method to use the ImageLoader class instead of the Utilities
     * class.
     *
     * @param event when the user clicks on the register button
     */
    @FXML
    private void registerUser(ActionEvent event) {
        try {
            ResponseWrapper response;
            String userName = txfUserRegister.getText(),
                    password = txfPasswordRegister.getText(),
                    ced = txfCedRegister.getText(),
                    name = txfNameRegister.getText(),
                    lastName = txfLastNameRegister.getText(),
                    secondLastName = txfSecondLastNameRegister.getText(),
                    phoneNumber = txfPhoneNumberRegister.getText(),
                    email = txfEmailRegister.getText(),
                    role = cbRoleRegister.getValue(),
                    landLineNumber = txfLandLineNumberRegister.getText();
            if (areFieldsEmpty()) {
                Message.showNotification("UPS", MessageType.ERROR, "You must to fill all the fields");
                return;
            }
            UserDto userDto = createUser(
                    ImageLoader.imageToByteArray(bufferFileImage),
                    userName,
                    password,
                    name,
                    lastName,
                    secondLastName,
                    ced,
                    email,
                    phoneNumber,
                    landLineNumber,
                    role);
            if (userModified == null) {
                response = userService.createUser(userDto);
            } else {
                userDto.setId(userModified.getId());
                userDto.setIsAdmin(userModified.getIsAdmin());
                userDto.setVersion(userModified.getVersion());
                userDto.setIsActive(userModified.getIsActive());
                userDto.setPasswordChanged(userModified.getPasswordChanged());
                userDto.setActivationCode(userModified.getActivationCode());
                if (userDto.getProfilePhoto() == null) {
                    userDto.setProfilePhoto(userModified.getProfilePhoto());
                }
                response = userService.updateUser(userDto);
            }
            if (response.getCode() == ResponseCode.OK) {
                Message.showNotification(response.getCode().name(), MessageType.INFO, response.getMessage());
                backToLogin(null);
            } else {
                Message.showNotification(response.getCode().name(), MessageType.ERROR, response.getMessage());
            }
            System.out.println(response.getMessage());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Added the profile photo to the userDto
     *
     * @param profilePhoto the profile photo of the user
     * @param args the user data
     * @return the new object UserDto with the loaded data
     */
    private UserDto createUser(byte[] profilePhoto, String... args) {
        UserDto user = new UserDto();
        if (userModified == null && bufferFileImage == null) {
            profilePhoto = ImageLoader
                    .imageToByteArray(new File("src/main/resources/cr/ac/una/evacomuna/img/default_profile_photo.png"));
            user.setProfilePhoto(profilePhoto);
        } else if (bufferFileImage != null) {
            user.setProfilePhoto(profilePhoto);
        }
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
        user.setPosition((PositionDto) roleService.getPositionByName(args[9]).getData());
        return user;
    }

    /**
     *
     * @param isFromLogin if the user is from the login view
     * @param user the user to show in the view
     */
    public void initializeView(boolean isFromLogin, UserDto user) {
        this.isFromLogin = isFromLogin;
        cbRoleRegister.setItems(ObservableListParser.mapListToObsevableString(ObservableListParser.loadPositions()));

        if (user != null) {
            userModified = user;
            if (userModified.getProfilePhoto() != null) {
                imgPhoto.setImage(ImageLoader.setImage(user.getProfilePhoto()));
            }
            txfUserRegister.setText(user.getUsername());
            txfPasswordRegister.setText(user.getPassword());
            txfCedRegister.setText(user.getIdentification());
            txfEmailRegister.setText(user.getEmail());
            txfNameRegister.setText(user.getName());
            txfLastNameRegister.setText(user.getLastname());
            txfSecondLastNameRegister.setText(user.getSecondLastname());
            txfPhoneNumberRegister.setText(user.getPhoneNumber());
            txfLandLineNumberRegister.setText(user.getLandlineNumber());
            cbRoleRegister.setValue(user.getPosition().getName());
        }
    }

}
