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
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class WorkersModuleController implements Initializable {

    private static List<WorkerController> workerControllers = new ArrayList();

    @FXML
    private ImageView searchWorker;
    @FXML
    private VBox workersContainer;

    public static void addWorkerController(WorkerController controller) {
        WorkersModuleController.workerControllers.add(controller);
    }

    public static List<WorkerController> getWorkerControllers() {
        return workerControllers;
    }

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
        App.getMainController().newWorker();
    }

    public UserDto getUser() {
        UserDto user = new UserDto();
        user.setName("Esteban");
        user.setLastname("Najera");
        user.setIdentification("118650568");
        user.setUsername("enajera");
        user.setPhoneNumber("61918721");
        user.setSecondLastname("Morales");
        user.setEmail("estebannajera42@gmail.com");
        user.setPassword("123");
        return user;
    }

    //WorkerController ACTIONS
    public void deleteWorker(Node node) {
        workersContainer.getChildren().remove(node);
    }

    public void editWorker(UserDto user, WorkerController controller) {
        App.getMainController().editWorker(user, controller);
    }

}
