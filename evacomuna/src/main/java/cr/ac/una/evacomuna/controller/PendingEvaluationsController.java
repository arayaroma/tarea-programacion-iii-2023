package cr.ac.una.evacomuna.controller;

import cr.ac.una.evacomuna.dto.EvaluatedDto;
import cr.ac.una.evacomuna.dto.EvaluationDto;
import cr.ac.una.evacomuna.dto.EvaluatorDto;
import cr.ac.una.evacomuna.dto.PositionDto;
import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.components.ImageCheck;
import cr.ac.una.evacomuna.dto.CalificationDto;
import cr.ac.una.evacomuna.dto.SkillDto;
import cr.ac.una.evacomuna.services.CalificationService;
import cr.ac.una.evacomuna.services.EvaluationService;
import cr.ac.una.evacomuna.services.EvaluatorService;
import cr.ac.una.evacomuna.services.PositionService;
import cr.ac.una.evacomuna.util.Data;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.ObservableListParser;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.Predicate;
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
    private List<SkillDto> skills;
    private List<CalificationDto> calificationWrappers;
    private EvaluationService evaluationService;
    private EvaluatedDto evaluatedBuffer;
    private PositionService positionService;
    private EvaluatorDto evaluatorBuffer;
    private CalificationService calificationService;
    private EvaluatorService evaluatorService;
    private ObservableList<EvaluationDto> evaluationDtos = FXCollections.observableArrayList();
    boolean isEditing = false;
    private PositionDto positionBuffer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        skills = new ArrayList<>();
        calificationWrappers = new ArrayList<>();
        evaluationService = new EvaluationService();
        positionService = new PositionService();
        evaluationDtos = ObservableListParser.loadEvaluations();
        calificationService = new CalificationService();
        evaluatorService = new EvaluatorService();
        initializeView();
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
                                .anyMatch(
                                        evaluator -> evaluator.getEvaluator().getId() == Data.getUserLogged().getId()))
                        .collect(Collectors.toList()));
            }
        }
    }

    @FXML
    private void sendEvaluation(ActionEvent event) {
        if (calificationWrappers.size() != skills.size()) {
            Message.showNotification("Wait", MessageType.INFO, "There are still skills to evaluate.");
            return;
        }
        evaluatorBuffer.setFeedback(txaFeedBack.getText());
        evaluatorBuffer.setEvaluated(evaluatedBuffer);
        boolean allIsSaved;
        evaluatorBuffer.getCalifications().clear();
        for (CalificationDto i : calificationWrappers) {
            ResponseWrapper response = isEditing ? calificationService.updateCalification(i)
                    : calificationService.createCalification(i);
            allIsSaved = response.getCode() == ResponseCode.OK;
            if (!allIsSaved) {
                Message.showNotification("Error", MessageType.ERROR, response.getMessage());
                return;
            }
        }

        cr.ac.una.evacomuna.util.ResponseWrapper response = isEditing
                ? evaluatorService.updateEvaluator(evaluatorBuffer)
                : evaluatorService.updateEvaluator(evaluatorBuffer);
        if (response.getCode() == ResponseCode.OK) {
            initializeView();
        }
        Message.showNotification(response.getCode().name(), MessageType.INFO, response.getMessage());
        System.out.println(response.getMessage());
    }

    private void loadEvaluator() {
        if (evaluatedBuffer != null) {
            for (EvaluatorDto evaluatorDto : evaluatedBuffer.getEvaluators()) {
                if (Objects.equals(evaluatorDto.getEvaluator().getId(), Data.getUserLogged().getId())) {
                    evaluatorBuffer = evaluatorDto;
                    return;
                }
            }
        }
    }

    private List<EvaluationDto> filterEvaluations(List<EvaluationDto> evaluationDtos) {
        Predicate<EvaluationDto> hasEvaluator = evaluationDto -> evaluationDto.getEvaluated().stream()
                .anyMatch(evaluatedDto -> evaluatedDto.getEvaluators().stream()
                        .anyMatch(t -> t.getEvaluator().getId() == Data.getUserLogged().getId()));
        List<EvaluationDto> evaluationDtosFiltered = evaluationDtos.stream()
                .filter(hasEvaluator.and(evaluation -> evaluation.getState().equals("IN APPLICATION")))
                .collect(Collectors.toList());
        return evaluationDtosFiltered;
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

                        CalificationDto calificationWrapper = new CalificationDto(col, row, newCheck);
                        Node note = getNodeInGrid(0, col);
                        Node skill = getNodeInGrid(row, 0);
                        if (note != null && skill != null) {
                            calificationWrapper.setCalification(((Label) note).getText());
                            calificationWrapper.setSkill(skills.get(skills.indexOf(skill)));
                            calificationWrapper.setEvaluator(evaluatorBuffer);
                            for (CalificationDto calificationDto : calificationWrappers) {
                                if (calificationDto.getSkill().getID() == calificationWrapper.getSkill().getID()) {
                                    calificationWrapper.setVersion(calificationDto.getVersion());
                                    calificationWrapper.setId(calificationDto.getID());
                                }
                            }
                            System.out.println(
                                    calificationWrappers.removeIf(calification -> calification.getSkill().getID()
                                            .equals(calificationWrapper.getSkill().getID())));
                            calificationWrappers.add(calificationWrapper);
                            gridEvaluation.add(newCheck, col, row);
                            success = true;
                        }
                    }
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });
    }

    private Node getNodeInGrid(Integer row, Integer col) {
        for (Node node : gridEvaluation.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    private void verifyCalificationPosition(int row, int col) {
        for (CalificationDto i : calificationWrappers) {
            if (i.getX() != col && i.getY() == row) {
                System.out.println(gridEvaluation.getChildren().remove(i.getData()));
            }
        }
    }

    private void initializeGrid() {

        ImageView check = ImageCheck.createImageCheck();
        intializeDragAndDrop(check);
        gridEvaluation.addRow(0, check, createHeader("Exceptional"), createHeader("Above Expectations"),
                createHeader("Expectations"), createHeader("Under expectations"));
        gridEvaluation.setAlignment(Pos.CENTER);
        gridEvaluation.setVgap(10);
        gridEvaluation.setHgap(10);
        gridEvaluation.setGridLinesVisible(true);
        RowConstraints rowConstraints = new RowConstraints(50);
        rowConstraints.setValignment(VPos.CENTER);
        gridEvaluation.getRowConstraints().add(rowConstraints);
    }

    private List<SkillDto> loadSkills() {
        if (positionBuffer != null) {
            return positionBuffer.getSkills().stream().map(t -> new SkillDto(t.getDto()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private boolean isEditingEvaluated(EvaluatedDto evaluatedDto) {
        return evaluatedDto.getEvaluators().stream()
                .anyMatch(evaluator -> evaluator.getFeedback() != null
                && !evaluator.getFeedback().isEmpty()
                && evaluator.getEvaluator().getId() == Data.getUserLogged().getId()) ? true : false;
    }

    private void initializeList() {
        listEvaluated.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                String completed = "";
                if (item != null) {

                    isEditing = isEditingEvaluated((EvaluatedDto) item);

                    if (isEditing) {
                        completed = " (COMPLETED)";
                    }
                }

                setText(empty || item == null ? null
                        : ((EvaluatedDto) item).getEvaluated().getName() + " "
                                + ((EvaluatedDto) item).getEvaluated().getSecondLastname() + completed);
            }
        });
        // LISTENERS
        listEvaluated.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    evaluatedBuffer = newValue;
                    if (evaluatedBuffer != null) {

                        //Load skills by position evaluated
                        positionBuffer = (PositionDto) positionService
                                .getPositionByName(evaluatedBuffer.getEvaluated().getPosition().getName()).getData();
                        if (positionBuffer != null) {
                            lblNameEvaluated.setText("Name: " + evaluatedBuffer.getEvaluated().getName() + " "
                                    + evaluatedBuffer.getEvaluated().getLastname());
                            lblRoleEvaluated.setText("Position: " + positionBuffer.getName());
                            cleanGrid();
                            skills.addAll(loadSkills());
                            loadSkillsInGrid();
                        }
                        // Load califications
                        loadEvaluator();
                        isEditing = isEditingEvaluated(evaluatedBuffer);
                        if (evaluatorBuffer != null) {
                            calificationWrappers.clear();
                            evaluatorBuffer.getCalifications().forEach(c -> calificationWrappers.add(c));
                            loadCalificationsInGrid();
                            txaFeedBack.setText(evaluatorBuffer.getFeedback());
                        }
                    }
                });
    }

    private void loadCalificationsInGrid() {

        for (CalificationDto calificationWrapper : calificationWrappers) {
            calificationWrapper.setData(ImageCheck.createImageCheck());
            Integer row = 0, col = 0;
            row = GridPane.getRowIndex(getSkillWrapperById(calificationWrapper.getSkill()));

            for (Node node : gridEvaluation.getChildren()) {
                if (node instanceof Label) {
                    if (((Label) node).getText().equals(calificationWrapper.getCalification())) {
                        col = GridPane.getColumnIndex(node);
                        break;
                    }
                }
            }
            if (col != null && row != null) {
                calificationWrapper.setX(col);
                calificationWrapper.setY(row);
                gridEvaluation.add(calificationWrapper.getData(), calificationWrapper.getX(),
                        calificationWrapper.getY());
            }
        }

    }

    private SkillDto getSkillWrapperById(SkillDto skillDto) {
        for (SkillDto i : skills) {
            if (i.getID() == skillDto.getID()) {
                return i;
            }
        }
        return new SkillDto();
    }

    private void loadSkillsInGrid() {
        RowConstraints rowConstraints;
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHalignment(HPos.CENTER);
        for (int i = 0; i < skills.size(); i++) {
            SkillDto skill = skills.get(i);
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

    private void initializeView() {
        cleanGrid();
        txaFeedBack.setText("");
        evaluationDtos = FXCollections.observableArrayList(filterEvaluations(evaluationDtos));
        cbPendingEvaluations.getItems().clear();
        listEvaluated.getItems().clear();
        cbPendingEvaluations.getItems().addAll(ObservableListParser.mapListToObsevableString(evaluationDtos));
    }

}
