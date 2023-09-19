package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.UserDto;
import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.services.User;
import cr.ac.una.evacomuna.util.Data;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.Utilities;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class WorkersModuleController implements Initializable {

    @FXML
    private ComboBox<String> cbSearchParameter;
    @FXML
    private TextField txfSearch;
    @FXML
    private Button btnEdit;

    @FXML
    private TableView<UserDto> tblUsersView;
    @FXML
    private TableColumn<UserDto, String> tcIdentification;
    @FXML
    private TableColumn<UserDto, String> tcUser;
    @FXML
    private TableColumn<UserDto, String> tcName;
    @FXML
    private TableColumn<UserDto, String> tcLastName;
    @FXML
    private TableColumn<UserDto, String> tcPhone;
    @FXML
    private TableColumn<UserDto, String> tcRole;

    private static List<UserDto> users = new ArrayList<>();
    private UserDto userBuffer;
    private User userService = new User();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        users = Utilities.loadUsers();
        App.setWorkersModuleController(this);
        btnEdit.setDisable(true);
        initilizeLists();
        loadWorkers(users);
        cbSearchParameter.getItems().addAll("Name", "Last Name", "Second Last Name", "Identification", "Role");
        txfSearch.setOnKeyPressed(t -> {
            if (t.getCode() == KeyCode.ENTER) {
                searchWorker(null);
            }
        });

    }

    @FXML
    private void newWorker(ActionEvent event) {
        userBuffer = null;
        App.getMainController().editWorker();
    }

    @FXML
    private void searchWorker(MouseEvent event) {
        String key = txfSearch.getText(), parameterKey = cbSearchParameter.getValue();

        if (key.isBlank() || parameterKey == null) {
            users = Utilities.loadUsers();
            loadWorkers(users);
            return;
        }
        loadWorkers(filterUsers(users, parameterKey, key));
    }

    @FXML
    private void editWorker(ActionEvent event) throws IOException {
        if (userBuffer != null) {
            Data.setUserModified(userBuffer);
            App.getMainController().editWorker();
        }
    }

    @FXML
    private void deleteWorker(ActionEvent event) {
        if (userBuffer != null) {
            if (Message.showConfirmationAlert("Are you sure?", Alert.AlertType.CONFIRMATION, "Are you sure that you want to delete this user?") == ButtonType.OK) {
                ResponseWrapper response = userService.deleteUser(userBuffer.getId());
                if (response.getCode() == ResponseCode.OK) {
                    tblUsersView.getItems().remove(userBuffer);
                }
            }
        }
    }

    public void loadWorkers(List<UserDto> users) {

        tblUsersView.getItems().clear();
        if (users != null) {
            tblUsersView.getItems().addAll(users);
        }
    }

    private List<UserDto> filterUsers(List<UserDto> users, String parameter, String key) {
        List<UserDto> usersFiltered = new ArrayList<>();
        if (users != null) {
            switch (parameter) {
                case "Name":
                    usersFiltered = users
                            .stream()
                            .filter(user -> user.getName().contains(key))
                            .collect(Collectors.toList());
                    break;
                case "Last Name":
                    usersFiltered = users
                            .stream()
                            .filter(user -> user.getLastname().contains(key))
                            .collect(Collectors.toList());
                    break;
                case "Second Last Name":
                    usersFiltered = users.stream()
                            .filter(user -> user.getSecondLastname().contains(key))
                            .collect(Collectors.toList());
                    break;
                case "Identification":
                    usersFiltered = users.stream()
                            .filter(user -> user.getIdentification().contains(key))
                            .collect(Collectors.toList());
                    break;
                case "Role":
                    usersFiltered = users.stream()
                            .filter(user -> user.getPosition().getName().contains(key))
                            .collect(Collectors.toList());
                    break;

            }
        }
        return usersFiltered;
    }

    private void initilizeLists() {
        tcIdentification.setCellValueFactory(new PropertyValueFactory<>("identification"));
        tcUser.setCellValueFactory(new PropertyValueFactory<>("username"));
        tcLastName.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        tcRole.setCellValueFactory(cellData -> {
            UserDto user = cellData.getValue();
            String roleName = (user.getPosition() != null) ? user.getPosition().getName() : "-";
            return new SimpleStringProperty(roleName);
        });
        tblUsersView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    userBuffer = newValue;
                    if (userBuffer != null) {
                        btnEdit.setDisable(false);
                        return;
                    }
                    btnEdit.setDisable(true);

                });

    }

}
