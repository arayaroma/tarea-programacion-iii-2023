package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.GeneralInformationDto;
import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.evacomuna.services.Company;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.Utilities;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author estebannajera
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
    private TextField txfPhoneNumber;
    @FXML
    private TextArea txaDescription;
    @FXML
    private Label lblURLTemplate;
    private File fileBuffer;
    private File htmlBuffer;
    private Company companyService;
    private GeneralInformationDto companyBuffer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        imgPhoto.setClip(new Circle(imgPhoto.getFitWidth() / 2, imgPhoto.getFitHeight() / 2, 75));
        companyService = new Company();
        companyBuffer = (GeneralInformationDto) companyService.getGeneralInformation().getData();
        initializeView();
    }

    @FXML
    private void selectPhotoProfile(ActionEvent event) {
        File selectedFile = Utilities.selectFile("Image files", "*.jpg", "*.png", "*.jpeg");
        if (selectedFile != null) {
            imgPhoto.setImage(new Image(selectedFile.toURI().toString()));
            fileBuffer = selectedFile;
        }
    }

    @FXML
    private void saveChanges(ActionEvent event) {
        String email = txfEmail.getText(), name = txfCompanyName.getText(), description = txaDescription.getText(), phoneNumber = txfPhoneNumber.getText();

        String html = htmlBuffer != null ? Utilities.FileToString(htmlBuffer) : "";

        if (email.isBlank() || name.isBlank() || phoneNumber.isBlank() || description.isBlank()) {
            Message.showNotification("Ups", MessageType.INFO, "All the fields are required");
        }
        if (companyBuffer == null && (htmlBuffer == null || fileBuffer == null)) {
            Message.showNotification("Ups", MessageType.INFO, "You must to select the necesary files");
            return;
        }
        GeneralInformationDto generalInformationDto;
        if (companyBuffer == null) {
            generalInformationDto = new GeneralInformationDto();
        } else {
            generalInformationDto = companyBuffer;
        }
        generalInformationDto.setName(name);

        if (companyBuffer != null) {
            if (htmlBuffer != null) {
                generalInformationDto.setHtmltemplate(html);
            }
            if (fileBuffer != null) {
                generalInformationDto.setPhoto(Utilities.imageToByte(fileBuffer));
            }
        } else {
            generalInformationDto.setHtmltemplate(html);
            generalInformationDto.setPhoto(Utilities.imageToByte(fileBuffer));
        }
        generalInformationDto.setEmail(email);
        ResponseWrapper response = companyBuffer == null ? companyService.createGeneralInformation(generalInformationDto) : companyService.updateGeneralInformation(generalInformationDto);
        if (response.getCode() == ResponseCode.OK) {
            Message.showNotification("Succeed", MessageType.INFO, response.getMessage());
            return;
        }
        Message.showNotification("Error", MessageType.ERROR, response.getMessage());

    }

    @FXML
    private void chooseHTMLTemplateAction(ActionEvent event) {
        File selectedFile = Utilities.selectFile("HTML File", "*.html");
        if (selectedFile != null) {
            lblURLTemplate.setText(selectedFile.toURI().toString());
            htmlBuffer = selectedFile;
        }
    }

    private void initializeView() {
        if (companyBuffer != null) {
            txfCompanyName.setText(companyBuffer.getName());
            txfEmail.setText(companyBuffer.getEmail());
            imgPhoto.setImage(new Image(Utilities.byteToImage(companyBuffer.getPhoto())));
            lblURLTemplate.setText("Template Loaded");
//            lblURLTemplate.setText(value);
//            txfPhoneNumber.setText(companyBuffer.get);
//            txaDescription.setText(companyBuffer.get);
        }
    }

}
