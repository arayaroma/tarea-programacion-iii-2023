package cr.ac.una.controller;

import cr.ac.una.evacomuna.App;
import cr.ac.una.services.impl.UserDto;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class WorkersModuleController implements Initializable {
    
    @FXML
    private ImageView searchWorker;
    @FXML
    private VBox workersContainer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.setWorkersModuleController(this);
        List<UserDto> users = new ArrayList();
        for (int i = 0; i < 50; i++) {
            try {
                FXMLLoader loader = App.getFXMLLoader("Worker");
                workersContainer.getChildren().add(loader.load());
                WorkerController controller = loader.getController();
                controller.setData(getUser());
                users.add(getUser());
                
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    
    @FXML
    private void newWorker(ActionEvent event) {
    }
    
    public UserDto getUser() {
        UserDto user = new UserDto();
        user.setName("Esteban");
        user.setLastname("Najera");
        user.setIdentification("118650568");
        user.setUsername("enajera");
        user.setPhoneNumber("61918721");
        return user;
    }
    
}
