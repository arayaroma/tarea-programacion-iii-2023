package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.EvaluatedDto;
import cr.ac.una.controller.EvaluationDto;
import cr.ac.una.controller.PositionDto;
import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.dto.CalificationWrapper;
import cr.ac.una.evacomuna.dto.SkillWrapper;
import cr.ac.una.evacomuna.services.Evaluation;
import cr.ac.una.evacomuna.services.Position;
import cr.ac.una.evacomuna.util.Data;
import cr.ac.una.evacomuna.util.Utilities;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class PendingEvaluationsController implements Initializable {

    @FXML
    private VBox parent;
    @FXML
    private Label lblNameEvaluated;
    @FXML
    private Label lblRoleEvaluated;
    @FXML
    private GridPane gridEvaluation;
    @FXML
    private TextArea txaFeedBack;
    @FXML
    private ComboBox<String> cbPendingEvaluations;
    @FXML
    private HBox gridContainer;
    @FXML
    private ListView<EvaluatedDto> listEvaluated;
    private List<SkillWrapper> skills;
    private List<CalificationWrapper> calificationWrappers;
    private Evaluation evaluationService;
    private EvaluatedDto evaluatedBuffer;
    private Position positionService;

    int colGridEvent = 0;
    int rowGridEvent = 0;
    private ObservableList<EvaluationDto> evaluationDtos = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        skills = new ArrayList<>();
        calificationWrappers = new ArrayList<>();
        evaluationService = new Evaluation();
        positionService = new Position();
        evaluationDtos = Utilities.loadEvaluations();
        List<EvaluationDto> evaluationDtosFiltered = evaluationDtos.stream()
                .filter(evaluationDto -> evaluationDto.getEvaluated().stream()
                .anyMatch(evaluatedDto -> evaluatedDto.getEvaluators().stream()
                .anyMatch(t -> t.getEvaluator().getId() == Data.getUserLogged().getId())))
                .collect(Collectors.toList());
        cbPendingEvaluations.getItems().addAll(Utilities.mapListToObsevableString(FXCollections.observableArrayList(evaluationDtosFiltered)));
        initializeGrid();
        initializeList();
    }

    @FXML
    private void selectEvaluation(ActionEvent event) {
        String name = cbPendingEvaluations.getValue();
        if (name != null) {
            EvaluationDto evaluationDto = (EvaluationDto) evaluationService.getEvaluationByName(name).getData();
            if (evaluationDto != null) {
                listEvaluated.getItems().clear();
                listEvaluated.getItems().addAll(evaluationDto.getEvaluated().stream()
                        .filter(evaluated -> evaluated.getEvaluators().stream()
                        .anyMatch(evaluator -> evaluator.getEvaluator().getId() == Data.getUserLogged().getId())).collect(Collectors.toList()));
            }
        }
    }

    @FXML
    private void sendEvaluation(ActionEvent event) {
    }

    private void intializeDragAndDrop(Node node) {
        node.setOnDragDetected((event) -> {
            Dragboard dragboard = node.startDragAndDrop(TransferMode.MOVE);
            dragboard.setDragView(node.snapshot(null, null));
            ClipboardContent content = new ClipboardContent();
            content.putString("check");
            dragboard.setContent(content);
        });
        gridEvaluation.setOnDragOver(event -> {
            if (event.getGestureSource() != gridEvaluation && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });
        //CalificationWrapper calificationWrapper;
        gridEvaluation.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            boolean success = false;
            if (dragboard.hasString()) {
                if (node instanceof ImageView) {
                    ImageView newCheck = new ImageView(((ImageView) node).getImage());
                    newCheck.setFitWidth(30);
                    newCheck.setFitHeight(30);
                    Integer row = GridPane.getRowIndex((Node) event.getTarget());
                    Integer col = GridPane.getColumnIndex((Node) event.getTarget());
                    if (event.getTarget() != null && row != null && col != null && col != 0) {
                        verifyCalificationPosition(row, col);
                        gridEvaluation.add(newCheck, col, row);
                        CalificationWrapper calificationWrapper = new CalificationWrapper(col, row, newCheck);
                        calificationWrappers.add(calificationWrapper);
                        success = true;
                    }
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });
    }

    private void verifyCalificationPosition(int row, int col) {
        for (CalificationWrapper i : calificationWrappers) {
            if (i.getX() != col && i.getY() == row) {
                gridEvaluation.getChildren().remove(i.getData());
            }
        }
    }

    private void initializeGrid() {
        ImageView check = new ImageView(App.class.getResource("/cr/ac/una/evacomuna/img/comprobar.png").toString());
        intializeDragAndDrop(check);
        check.setPreserveRatio(false);
        check.setSmooth(false);
        check.setFitHeight(30);
        check.setFitWidth(30);
        check.getStyleClass().add("check");
        gridEvaluation.addRow(0, check, createHeader("Excepcional"), createHeader("Por encima de las expectativas"),
                createHeader("Cumple las expectativas"), createHeader("Por debajo de las expectativas"));
        gridEvaluation.setAlignment(Pos.CENTER);
        gridEvaluation.setVgap(10);
        gridEvaluation.setHgap(10);
        gridEvaluation.setGridLinesVisible(true);
        RowConstraints rowConstraints = new RowConstraints(50);
        rowConstraints.setValignment(VPos.CENTER);
        gridEvaluation.getRowConstraints().add(rowConstraints);
    }

    private void initializeList() {
        listEvaluated.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : ((EvaluatedDto) item).getEvaluated().getName() + " " + ((EvaluatedDto) item).getEvaluated().getSecondLastname());
            }
        });
        // LISTENERS
        listEvaluated.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    evaluatedBuffer = newValue;
                    if (evaluatedBuffer != null) {
                        PositionDto position = (PositionDto) positionService.getRoleByName(evaluatedBuffer.getEvaluated().getPosition().getName()).getData();
                        if (position != null) {
                            lblNameEvaluated.setText("Name: " + evaluatedBuffer.getEvaluated().getName() + " " + evaluatedBuffer.getEvaluated().getLastname());
                            lblRoleEvaluated.setText("Position: " + position.getName());
                            cleanGrid();
                            skills.addAll(position.getSkills().stream().map(t -> new SkillWrapper(t.getName())).collect(Collectors.toList()));
                            loadSkillsInGrid();
                        }
                    }
                });
    }

    private void loadSkillsInGrid() {
        RowConstraints rowConstraints;
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHalignment(HPos.CENTER);
        for (int i = 0; i < skills.size(); i++) {
            SkillWrapper skill = skills.get(i);
            skill.getChildren().add(createHeader(skill.getName()));
            rowConstraints = new RowConstraints(50);
            rowConstraints.setValignment(VPos.CENTER);
            gridEvaluation.getRowConstraints().add(rowConstraints);
            gridEvaluation.add(skill, 0, i + 1);

        }
        for (int i = 1; i < gridEvaluation.getRowCount(); i++) {
            for (int j = 1; j < gridEvaluation.getColumnCount(); j++) {
                if (i == 1 || i == 2 && j == 1) {
                    columnConstraints = new ColumnConstraints();
                    columnConstraints.setHalignment(HPos.CENTER);
                    gridEvaluation.getColumnConstraints().add(columnConstraints);
                }
                gridEvaluation.add(new Pane(), j, i);
            }
        }
    }

    private Label createHeader(String name) {
        Label label = new Label(name);
        label.getStyleClass().addAll("h2", "labelGrid", "mw-10");
        return label;
    }

    private void cleanGrid() {
        gridEvaluation = new GridPane();
        gridEvaluation.getStyleClass().add("bg-blue");
        gridContainer.getChildren().clear();
        gridContainer.getChildren().add(gridEvaluation);
        initializeGrid();
        skills.clear();

    }
}
