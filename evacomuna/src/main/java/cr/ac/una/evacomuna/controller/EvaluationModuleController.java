package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.UserDto;
import cr.ac.una.evacomuna.dto.EvaluationWrapper;
import cr.ac.una.evacomuna.services.Evaluation;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.Utilities;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class EvaluationModuleController implements Initializable {

    @FXML
    private TabPane parent;
    @FXML
    private TextField txfNameEvaluation;
    @FXML
    private DatePicker dpStartDate;
    @FXML
    private DatePicker dpEndDate;
    @FXML
    private DatePicker dpAplicationDate;
    @FXML
    private ComboBox<String> cbState;
    @FXML
    private TextField txfSearchEvaluators;
    @FXML
    private ListView<UserDto> listEvaluators;
    @FXML
    private ListView<UserDto> listEvaluatorsFix;
    @FXML
    private ListView<UserDto> listEvaluated;
    @FXML
    private ListView<UserDto> listEvaluatedFix;
    @FXML
    private Tab appliedView;
    @FXML
    private Tab maintenanceView;

    private Evaluation evaluationService;
    private UserDto evaluatedBuffer;
    private UserDto evaluatorBuffer;
    private UserDto finalEvaluatedBuffer;
    private UserDto finalEvaluatorBuffer;
    private List<UserDto> users;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        evaluationService = new Evaluation();
        initilizeLists();
        users = Utilities.loadUsers();
        initializeView();

    }

    @FXML
    private void btnAddEvaluator(ActionEvent event) {
        if (evaluatorBuffer != null) {
            listEvaluatorsFix.getItems().remove(evaluatorBuffer);
            listEvaluatorsFix.getItems().add(evaluatorBuffer);
        }
    }

    @FXML
    private void btnDeleteEvaluator(ActionEvent event) {
        if (finalEvaluatorBuffer != null) {
            listEvaluatorsFix.getItems().remove(finalEvaluatorBuffer);
        }
    }

    @FXML
    private void btnAddEvaluated(ActionEvent event) {
        if (evaluatedBuffer != null) {
            listEvaluatedFix.getItems().remove(evaluatedBuffer);
            listEvaluatedFix.getItems().add(evaluatedBuffer);
        }
    }

    @FXML
    private void btnDeleteEvaluated(ActionEvent event) {
        if (finalEvaluatedBuffer != null) {
            listEvaluatedFix.getItems().remove(finalEvaluatedBuffer);
        }
    }

    @FXML
    private void searchByRoleAction(ActionEvent event) {
    }

    @FXML
    private void saveChangesAction(ActionEvent event) {
        String name = txfNameEvaluation.getText(), state = cbState.getValue();
        LocalDate initialDate = dpStartDate.getValue(), endingDate = dpEndDate.getValue(), aplicationDate = dpAplicationDate.getValue();
        if (name.isBlank() || state == null || initialDate == null || endingDate == null || aplicationDate == null) {
            Message.showNotification("Ups", MessageType.INFO, "All the fields are required");
            return;
        }

        EvaluationWrapper evaluationWrapper = new EvaluationWrapper(null, name, aplicationDate, initialDate, endingDate, state);
        ResponseWrapper response = evaluationService.createEvaluation(evaluationWrapper.getDto());
        if (response.getCode() == ResponseCode.OK) {
            //fixme: No implementado
        }
        System.out.println(response.getMessage());
    }

    @FXML
    private void searchByIdentification(KeyEvent event) {
    }

    public void initializeView() {
        cbState.getItems().addAll("UNDER CONSTRUCTION", " IN APPLICATION", "UNDER REVIEW", "COMPLETED");
        if (users != null) {
            listEvaluated.getItems().addAll(users);
            listEvaluators.getItems().addAll(users);
        }
    }

    public void initilizeLists() {
        listEvaluated.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                UserDto user = (UserDto) item;
                setText(empty || item == null ? null : user.getIdentification() + ": " + user.getName() + " " + user.getLastname() + " (" + user.getPosition().getName() + ")");
            }
        });
        listEvaluators.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                UserDto user = (UserDto) item;
                setText(empty || item == null ? null : user.getIdentification() + ": " + user.getName() + " " + user.getLastname() + " (" + user.getPosition().getName() + ")");
            }
        });
        listEvaluatedFix.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                UserDto user = (UserDto) item;
                setText(empty || item == null ? null : user.getIdentification() + ": " + user.getName() + " " + user.getLastname() + " (" + user.getPosition().getName() + ")");
            }
        });
        listEvaluatorsFix.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                UserDto user = (UserDto) item;
                setText(empty || item == null ? null : user.getIdentification() + ": " + user.getName() + " " + user.getLastname() + " (" + user.getPosition().getName() + ")");
            }
        });
        // LISTENERS
        listEvaluated.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    evaluatedBuffer = newValue;
                });
        listEvaluators.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    evaluatorBuffer = newValue;
                });
        listEvaluatedFix.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    finalEvaluatedBuffer = newValue;
                });
        listEvaluatorsFix.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    finalEvaluatorBuffer = newValue;
                });
    }

}
