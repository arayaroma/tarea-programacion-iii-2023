package cr.ac.una.controller;

import cr.ac.una.evacomuna.App;
import cr.ac.una.services.impl.UserDto;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class WorkersModuleController implements Initializable {

    private static List<WorkerController> workerControllers = new ArrayList();
    private static List<UserDto> users = new ArrayList();

    @FXML
    private VBox workersContainer;
    @FXML
    private ComboBox<String> cbSearchParameter;
    @FXML
    private TextField txfSearch;

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
        // Load the workers
        for (int i = 0; i < 10; i++) {
            users.add(getUser());
        }
        loadWorkers(users);
        fillSearchParameters("Name", "Last Name", "Second Last Name", "Phone", "Email", "Identification", "User Name");

    }

    @FXML
    private void newWorker(ActionEvent event) {
        App.getMainController().newWorker();
    }

    @FXML
    private void searchWorker(MouseEvent event) {
        String key = txfSearch.getText(), parameterKey = cbSearchParameter.getValue();

        if (key.isBlank() || parameterKey == null) {
            return;
        }
        users = filterUsers(users, parameterKey, key);
        workersContainer.getChildren().clear();
        loadWorkers(users);
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

    private void loadWorkers(List<UserDto> users) {
        try {
            workerControllers.clear();
            for (UserDto user : users) {
                FXMLLoader loader = App.getFXMLLoader("Worker");
                workersContainer.getChildren().add(loader.load());
                WorkerController controller = loader.getController();
                controller.setData(user);
                workerControllers.add(controller);
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    private List<UserDto> filterUsers(List<UserDto> users, String parameter, String key) {
        List<UserDto> usersFiltered = null;
        switch (parameter) {
            case "Name":
                users
                        .stream()
                        .filter(user -> user.getName().equals(key))
                        .collect(Collectors.toList());
                break;
            case "Last Name":
                usersFiltered = users
                        .stream()
                        .filter(user -> user.getLastname().equals(key))
                        .collect(Collectors.toList());
                break;
            case "Second Last Name":
                usersFiltered = users.stream()
                        .filter(user -> user.getSecondLastname().equals(key))
                        .collect(Collectors.toList());
                break;
            case "Email":
                usersFiltered = users.stream()
                        .filter(user -> user.getEmail().equals(key))
                        .collect(Collectors.toList());
                break;
            case "Phone":
                usersFiltered = users
                        .stream()
                        .filter(user -> user.getPhoneNumber().equals(key))
                        .collect(Collectors.toList());
                break;
            case "User Name":
                usersFiltered = users
                        .stream()
                        .filter(user -> user.getUsername().equals(key))
                        .collect(Collectors.toList());
                break;
        }
        return usersFiltered;
    }

    private void fillSearchParameters(String... args) {
        for (String i : args) {
            cbSearchParameter.getItems().add(i);
        }
    }

    // WorkerController ACTIONS
    public void deleteWorker(Node node) {
        workersContainer.getChildren().remove(node);
    }

    public void editWorker(UserDto user, WorkerController controller) {
        App.getMainController().editWorker(user, controller);
    }

}
