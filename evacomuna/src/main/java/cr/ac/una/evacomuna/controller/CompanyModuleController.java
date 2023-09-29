package cr.ac.una.evacomuna.controller;

import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.dto.GeneralInformationDto;
import cr.ac.una.evacomuna.services.GeneralInformationService;
import cr.ac.una.evacomuna.util.FileLoader;
import cr.ac.una.evacomuna.util.ImageLoader;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author estebannajera
 * @author arayaroma
 */
public class CompanyModuleController implements Initializable {

    @FXML
    private HBox parent;
    @FXML
    private ImageView imgPhoto;
    @FXML
    private TextField txfCompanyName;
    @FXML
    private TextField txfEmail;
    @FXML
    private Label lblURLTemplate;
    private File imgBuffer;
    private String htmlBuffer;
    private GeneralInformationService companyService;
    private GeneralInformationDto companyBuffer;
    private boolean isEditing = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        imgPhoto.setClip(new Circle(imgPhoto.getFitWidth() / 2, imgPhoto.getFitHeight() / 2, 75));
        companyService = new GeneralInformationService();
        companyBuffer = (GeneralInformationDto) companyService.getGeneralInformation().getData();
        if (companyBuffer.getId() != null) {
            isEditing = true;
        }
        initializeView();
    }

    @FXML
    private void selectPhotoProfile(ActionEvent event) {
        File selectedFile = ImageLoader.selectFile("Image files", "*.jpg", "*.png", "*.jpeg");
        if (selectedFile != null) {
            imgPhoto.setImage(new Image(selectedFile.toURI().toString()));
            imgBuffer = selectedFile;
        }
    }

    @FXML
    private void saveChanges(ActionEvent event) throws URISyntaxException {
        String email = txfEmail.getText(), name = txfCompanyName.getText();
        if (email.isBlank() || name.isBlank() || htmlBuffer == null || htmlBuffer.isBlank() && !isEditing) {
            Message.showNotification("Ups", MessageType.INFO, "All the fields are required");
            return;
        }
        GeneralInformationDto generalInformationDto = new GeneralInformationDto();
        if (isEditing) {
            generalInformationDto = companyBuffer;
        }
        generalInformationDto.setEmail(email);
        generalInformationDto.setHtmltemplate(htmlBuffer);
        generalInformationDto.setName(name);
        if (imgBuffer != null) {
            generalInformationDto.setPhoto(ImageLoader.imageToByteArray(imgBuffer));
        } else if (!isEditing) {
            generalInformationDto.setPhoto(ImageLoader.imageToByteArray(new File(App.class.getResource("/cr/ac/una/evacomuna/img/default_profile_photo.png").toURI().toString())));
        }
        
        ResponseWrapper response = isEditing ? companyService.updateGeneralInformation(generalInformationDto) : companyService.createGeneralInformation(generalInformationDto);
        if (response.getCode() == ResponseCode.OK) {
            Message.showNotification("Succeed", MessageType.INFO, response.getMessage());
            return;
        }
        Message.showNotification("Error", MessageType.ERROR, response.getMessage());
    }

    @FXML
    private void chooseHTMLTemplateAction(ActionEvent event) {
        File selectedFile = FileLoader.selectFile("HTML File", "*.html");
        if (selectedFile != null) {
            lblURLTemplate.setText(selectedFile.toURI().toString());
            htmlBuffer = FileLoader.fileToString(selectedFile);
        }
    }

    private void initializeView() {
        if (companyBuffer != null) {
            txfCompanyName.setText(companyBuffer.getName());
            txfEmail.setText(companyBuffer.getEmail());
            imgPhoto.setImage(ImageLoader.setImage(companyBuffer.getPhoto()));
            htmlBuffer = companyBuffer.getHtmltemplate();
            lblURLTemplate.setText("Template Loaded");
        }
    }

}
