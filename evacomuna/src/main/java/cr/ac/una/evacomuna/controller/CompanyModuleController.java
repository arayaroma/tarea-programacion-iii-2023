package cr.ac.una.evacomuna.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TextField txfDescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    private void saveChanges(ActionEvent event) {
        //Register the data
    }

}
