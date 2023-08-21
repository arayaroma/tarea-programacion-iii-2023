package cr.ac.una.controller;



import cr.ac.una.evacomuna.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class MainController implements Initializable {

    @FXML
    private ImageView imgProfilePhoto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Cut over the photo to make a circula effect
        imgProfilePhoto.setClip(new Circle(imgProfilePhoto.getFitWidth() / 2, imgProfilePhoto.getFitHeight() / 2, 40));
    }    

    @FXML
    private void btnWorkersModule(ActionEvent event) {
    }

    @FXML
    private void btnEvaluationModule(ActionEvent event) {
    }

    @FXML
    private void btnGeneralInformationModule(ActionEvent event) {
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        App.setRoot("Login");
    }
    
}
