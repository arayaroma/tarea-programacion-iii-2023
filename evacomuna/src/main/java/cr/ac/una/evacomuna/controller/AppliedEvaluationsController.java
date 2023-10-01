package cr.ac.una.evacomuna.controller;

import cr.ac.una.evacomuna.App;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import cr.ac.una.evacomuna.dto.EvaluatedDto;
import cr.ac.una.evacomuna.dto.EvaluationDto;
import cr.ac.una.evacomuna.util.Data;
import cr.ac.una.evacomuna.dto.UserDto;
import cr.ac.una.evacomuna.services.EvaluatedService;
import cr.ac.una.evacomuna.services.EvaluationService;
import cr.ac.una.evacomuna.services.UserService;
import cr.ac.una.evacomuna.util.ObservableListParser;
import java.io.IOException;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.VBox;

/**
 *
 * @author arayaroma
 */
public class AppliedEvaluationsController implements Initializable {

    @FXML
    private ComboBox<String> cbEvaluations;
    @FXML
    private ComboBox<String> cbAllEvaluations;
    @FXML
    private ListView<EvaluatedDto> listEvaluated;

    @FXML
    private VBox container;
    private UserService userService;
    private EvaluatedService evaluatedService;
    private EvaluationService evaluationService;
    private double calificationCalculated = 0;
    private UserDto userDto;
    private EvaluatedDto evaluatedBuffer;
    private EvaluationDto evaluationBuffer;

    Integer totalSupervisors = 0, totalPeers = 0, totalSelf = 0, totalClients = 0;

    ColumnConstraints columnConstraints = new ColumnConstraints(150);

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        userService = new UserService();
        evaluatedService = new EvaluatedService();
        evaluationService = new EvaluationService();
        // skills = new ArrayList<>();
        userDto = Data.getUserLogged();
        cbEvaluations.getItems().addAll(ObservableListParser.mapListToObsevableString(
                FXCollections.observableArrayList(filterEvaluations(ObservableListParser.loadEvaluations()))));
        cbAllEvaluations.getItems().addAll(ObservableListParser.mapListToObsevableString(
                FXCollections.observableArrayList(ObservableListParser.loadEvaluations())));
        initializeList();
        loadPrivileges();

    }

    private void loadGrid() {
        try {
            FXMLLoader loader = App.getFXMLLoader("GridAppliedEvaluation");
            container.getChildren().clear();
            container.getChildren().add(loader.load());
            GridAppliedEvaluationController controller = loader.getController();
            controller.initializeView(evaluatedBuffer, evaluationBuffer, userDto.getIsAdmin().equals("Y"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private void loadPrivileges() {
        if (userDto.getIsAdmin().equals("N")) {
            listEvaluated.setVisible(false);
            cbAllEvaluations.setVisible(false);
        }
    }

    private void initializeList() {
        listEvaluated.setCellFactory((param) -> new ListCell<EvaluatedDto>() {
            @Override
            protected void updateItem(EvaluatedDto item, boolean empty) {
                super.updateItem(item, empty);

                setText(empty || item == null ? null
                        : item.getEvaluated().getName() + " "
                                + item.getEvaluated().getSecondLastname());

            }
        });
        // LISTENERS
        listEvaluated.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        evaluatedBuffer = newValue;
                        // Load grid here
                        loadGrid();
                    }
                });
    }

    private void calculateCalification() {

    }

    @FXML
    private void selectEvaluation(ActionEvent event) {
        String name = cbEvaluations.getValue();
        if (name != null) {
            evaluationBuffer = (EvaluationDto) evaluationService.getEvaluationByName(name).getData();
            if (evaluationBuffer != null) {
                evaluatedBuffer = loadEvaluatedByEvaluation(evaluationBuffer);
                // Load grid here
                loadGrid();
            }
        }
    }

    @FXML
    private void selectAllEvaluation(ActionEvent event) {// Arreglar para que se carguen las calificaciones finales
                                                         // desde el usuario admin
        String name = cbAllEvaluations.getValue();
        if (name != null) {
            evaluationBuffer = (EvaluationDto) evaluationService.getEvaluationByName(name).getData();
            if (evaluationBuffer != null) {
                listEvaluated.getItems().clear();
                listEvaluated.getItems().addAll(evaluationBuffer.getEvaluated());
                // Load grid here
                loadGrid();
            }
        }

    }

    private EvaluatedDto loadEvaluatedByEvaluation(EvaluationDto evaluationDto) {
        if (evaluationDto != null) {
            for (EvaluatedDto i : evaluationDto.getEvaluated()) {
                if (Objects.equals(i.getEvaluated().getId(), userDto.getId())) {
                    return i;
                }
            }
        }
        return null;
    }

    private List<EvaluationDto> filterEvaluations(List<EvaluationDto> evaluationDtos) {
        Predicate<EvaluationDto> hasEvaluated = evaluationDto -> evaluationDto.getEvaluated()
                .stream()
                .anyMatch(evaluatedDto -> evaluatedDto.getEvaluated().getId() == userDto.getId());
        List<EvaluationDto> evaluationDtosFiltered = evaluationDtos.stream()
                .filter(hasEvaluated.and(evaluation -> evaluation.getState().equals("COMPLETED")
                        || evaluation.getState().equals("UNDER REVIEW")))
                .collect(Collectors.toList());
        return evaluationDtosFiltered;
    }

}
