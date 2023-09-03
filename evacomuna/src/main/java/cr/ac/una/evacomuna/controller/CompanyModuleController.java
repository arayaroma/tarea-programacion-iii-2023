package cr.ac.una.evacomuna.controller;

import cr.ac.una.evacomuna.util.Utilities;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    private ComboBox<?> cbHTMLTemplates;
    @FXML
    private Label lblURLTemplate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void selectPhotoProfile(ActionEvent event) {
        File selectedFile = Utilities.selectFile("Image files", "*.jpg", "*.png", "*.jpeg");
        if (selectedFile != null) {
            imgPhoto.setImage(new Image(selectedFile.toURI().toString()));
        }
    }

    @FXML
    private void saveChanges(ActionEvent event) {
    }

    @FXML
    private void chooseHTMLTemplateAction(ActionEvent event) {
        File selectedFile = Utilities.selectFile("HTML File", "*.html");
        if (selectedFile != null) {
            lblURLTemplate.setText(selectedFile.toURI().toString());
        }
    }

}
