package cr.ac.una.evacomuna.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import cr.ac.una.evacomuna.dto.EvaluatedDto;
import cr.ac.una.evacomuna.dto.EvaluationDto;
import cr.ac.una.evacomuna.dto.EvaluatorDto;
import cr.ac.una.evacomuna.dto.FinalCalificationDto;
import cr.ac.una.evacomuna.util.CalificationCode;
import cr.ac.una.evacomuna.util.Data;
import cr.ac.una.evacomuna.util.ResponseWrapper;
import cr.ac.una.evacomuna.util.Roles;
import cr.ac.una.evacomuna.components.ImageCheck;
import cr.ac.una.evacomuna.components.PaneContainer;
import cr.ac.una.evacomuna.dto.SkillDto;
import cr.ac.una.evacomuna.dto.UserDto;
import cr.ac.una.evacomuna.services.EvaluatedService;
import cr.ac.una.evacomuna.services.EvaluationService;
import cr.ac.una.evacomuna.services.UserService;
import cr.ac.una.evacomuna.util.ObservableListParser;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/**
 *
 * @author arayaroma
 */
public class AppliedEvaluationsController implements Initializable {

    @FXML
    private Label lb_evaluatorName;
    @FXML
    private Label lb_evaluatorPosition;
    @FXML
    private Label lb_evaluationPeriod;
    @FXML
    private Label lb_evaluationApplicationDate;
    @FXML
    private CheckBox cb_peer;
    @FXML
    private CheckBox cb_supervisor;
    @FXML
    private CheckBox cb_self;
    @FXML
    private CheckBox cb_client;
    @FXML
    private GridPane gp_table;
    @FXML
    private GridPane gp_feedback;
    @FXML
    private HBox gp_container;
    @FXML
    private ComboBox<String> cbEvaluations;
    @FXML
    private TextField txfFinalCalification;
    @FXML
    private Button btnSaveChanges;
    @FXML
    private ComboBox<String> cbAllEvaluations;
    @FXML
    private ListView<EvaluatedDto> listEvaluated;

    private UserService userService;
    private EvaluatedService evaluatedService;
    private EvaluationService evaluationService;

    private List<SkillDto> skills;
    private double calificationCalculated = 0;
    private UserDto userDto;
    private EvaluatedDto evaluatedDto;
    private EvaluationDto evaluationBuffer;
    //private EvaluationDto evaluationDto;

    Integer totalSupervisors = 0, totalPeers = 0, totalSelf = 0, totalClients = 0;

    ColumnConstraints columnConstraints = new ColumnConstraints(150);

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        userService = new UserService();
        evaluatedService = new EvaluatedService();
        evaluationService = new EvaluationService();
        skills = new ArrayList<>();
        userDto = Data.getUserLogged();
        cbEvaluations.getItems().addAll(ObservableListParser.mapListToObsevableString(
                FXCollections.observableArrayList(filterEvaluations(ObservableListParser.loadEvaluations()))));
        cbAllEvaluations.getItems().addAll(ObservableListParser.mapListToObsevableString(
                FXCollections.observableArrayList(ObservableListParser.loadEvaluations())));
        initializeList();
        loadPrivileges();

    }

    private void initializeList() {
        listEvaluated.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);

                if (item != null) {
                    setText(empty || item == null ? null
                            : ((EvaluatedDto) item).getEvaluated().getName() + " "
                            + ((EvaluatedDto) item).getEvaluated().getSecondLastname());
                }
            }
        });
        // LISTENERS
        listEvaluated.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    evaluatedDto = newValue;
                    // clearView();
                    initializeView();
                });
    }

    private void initializeView() {
        loadGridPaneSkills();
        cleanLabels();
        loadLabels();
        loadFeedbackComments();
        loadCalifications();
        loadChecks();
    }

    private void calculateCalification() {

    }

    @FXML
    private void selectEvaluation(ActionEvent event) {
        String name = cbEvaluations.getValue();
        if (name != null) {
            evaluationBuffer = (EvaluationDto) evaluationService.getEvaluationByName(name).getData();
            if (evaluationBuffer != null) {
                evaluatedDto = loadEvaluatedByEvaluation(evaluationBuffer);
                // clearView();
                initializeView();
            }
        }
    }

    @FXML
    private void selectAllEvaluation(ActionEvent event) {//Arreglar para que se carguen las calificaciones finales desde el usuario admin
        String name = cbAllEvaluations.getValue();
        if (name != null) {
            evaluationBuffer = (EvaluationDto) evaluationService.getEvaluationByName(name).getData();
            if (evaluationBuffer != null) {
                listEvaluated.getItems().clear();
                listEvaluated.getItems().addAll(evaluationBuffer.getEvaluated());
                initializeView();
            }
        }

    }

    @FXML
    private void btnSaveChangesAction(ActionEvent event) {
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

    private void cleanLabels() {
        lb_evaluatorName.setText("");
        lb_evaluatorPosition.setText("");
        lb_evaluationPeriod.setText("");
        lb_evaluationApplicationDate.setText("");
    }

    private void loadGridPaneSkills() {

        addDiagonalRow();
        addSkills();
        addResult();
        addFeedback();
    }

    private void addDiagonalRow() {
        PaneContainer rowContainer = new PaneContainer();
        rowContainer.getChildren().add(
                createHeader("Supervisor, Peer,\nClient, Self"));
        rowContainer.getStyleClass().add("gp-header");
        gp_table.add(rowContainer, 0, 0);
        //gp_table.getColumnConstraints().add(columnConstraints);
    }

    private List<SkillDto> getSkills() {
        List<SkillDto> list = new ArrayList<>();
        if (evaluatedDto != null) {
            for (FinalCalificationDto finalCalificationDto : evaluatedDto.getFinalCalifications()) {
                list.removeIf(t -> Objects.equals(t.getID(), finalCalificationDto.getSkill().getID()));
                list.add(finalCalificationDto.getSkill());
            }
        }
        return list;
    }

    private void addResult() {
        PaneContainer rowContainer = new PaneContainer();
        rowContainer.getChildren().add(
                createHeader("Result"));
        rowContainer.getStyleClass().add("gp-header");
        gp_table.addRow(0, rowContainer);
    }

    private void addSkills() {
        skills = getSkills();
        for (int i = 0; i < skills.size(); i++) {
            SkillDto skill = skills.get(i);
            skill.getChildren().add(createHeader(skill.getName()));
            skill.getStyleClass().add("gp-header");
            gp_table.add(skill, i + 1, 0);
            gp_table.getColumnConstraints().add(columnConstraints);
        }
    }

    private void addFeedback() {
        PaneContainer rowContainer = new PaneContainer();
        rowContainer.getChildren().add(
                createHeader("Feedback"));
        rowContainer.getStyleClass().add("gp-header");
        gp_feedback.add(rowContainer, 0, 0);
    }

    private Node createHeader(String name) {
        return new Label(name);
    }

    private void loadLabels() {
        lb_evaluatorName.setText(userDto.getName() + " " + userDto.getLastname() + " " + userDto.getSecondLastname());
        lb_evaluatorPosition.setText(userDto.getPosition().getName());

        if (evaluationBuffer != null) {
            lb_evaluationPeriod.setText(evaluationBuffer.getInitialPeriod() + " - " + evaluationBuffer.getFinalPeriod());
            lb_evaluationApplicationDate.setText(evaluationBuffer.getApplicationDate().toString());
        }
    }

    private void setChecksUnmodifiable() {
        cb_supervisor.addEventFilter(MouseEvent.ANY, MouseEvent::consume);
        cb_peer.addEventFilter(MouseEvent.ANY, MouseEvent::consume);
        cb_self.addEventFilter(MouseEvent.ANY, MouseEvent::consume);
        cb_client.addEventFilter(MouseEvent.ANY, MouseEvent::consume);
    }

    private void loadChecks() {
        setChecksUnmodifiable();
        if (evaluatedDto != null) {
            evaluatedDto.getEvaluators()
                    .stream()
                    .forEach(e -> {
                        EvaluatorDto evaluatorDto = (EvaluatorDto) e;
                        if (evaluatorDto.getRole().equals(Roles.SUPERVISOR.toString())) {
                            cb_supervisor.setSelected(true);
                        }
                        if (evaluatorDto.getRole().equals(Roles.PEER.toString())) {
                            cb_peer.setSelected(true);
                        }
                        if (evaluatorDto.getRole().equals(Roles.SELF.toString())) {
                            cb_self.setSelected(true);
                        }
                        if (evaluatorDto.getRole().equals(Roles.CLIENT.toString())) {
                            cb_client.setSelected(true);
                        }
                    });
        }
    }

    private Integer countTotalEvaluatorsByRoleAndSkill(Roles role, SkillDto skill) {
        Integer count = 0;
        for (FinalCalificationDto finalCalificationDto : evaluatedDto.getFinalCalifications()) {
            if (finalCalificationDto.getSkill().getName().equals(skill.getName())) {
                count = count + (int) evaluatedDto.getEvaluators()
                        .stream()
                        .filter(e -> ((EvaluatorDto) e).getRole().equals(role.toString()))
                        .count();
            }
        }
        return count;
    }

    private void loadCalifications() {
        List<FinalCalificationDto> finalCalifications = new ArrayList<>();
        if (evaluatedDto != null) {
            finalCalifications.addAll(evaluatedDto.getFinalCalifications());
        }
        for (FinalCalificationDto finalCalificationDto : finalCalifications) {
            totalSupervisors = countTotalEvaluatorsByRoleAndSkill(Roles.SUPERVISOR, finalCalificationDto.getSkill());
            totalPeers = countTotalEvaluatorsByRoleAndSkill(Roles.PEER, finalCalificationDto.getSkill());
            totalSelf = countTotalEvaluatorsByRoleAndSkill(Roles.SELF, finalCalificationDto.getSkill());
            totalClients = countTotalEvaluatorsByRoleAndSkill(Roles.CLIENT, finalCalificationDto.getSkill());
            finalCalificationDto.setData(ImageCheck.createImageCheck());
            VBox vBox = new VBox(new Label("SUPER: " + totalSupervisors.toString()),
                    new Label("PEER: " + totalPeers.toString()),
                    new Label("SELF: " + totalSelf.toString()),
                    new Label("CLIENT: " + totalClients.toString()));
            vBox.setAlignment(Pos.CENTER);
            HBox hBox = new HBox(finalCalificationDto.getData(), vBox);
            hBox.setSpacing(10);
            hBox.setAlignment(Pos.CENTER);
            finalCalificationDto.setContainer(hBox);
            String calification = CalificationCode.parseCodeToString(finalCalificationDto.getFinalNote(), true);
            String skill = finalCalificationDto.getSkill().getName();
            Integer row = null, col = null;

            for (Node node : gp_table.getChildren()) {
                if (node instanceof Label) {
                    if (((Label) node).getText().equalsIgnoreCase(calification.trim())) {
                        row = GridPane.getRowIndex(node);
                        break;
                    }
                }
            }
            for (Node node : gp_table.getChildren()) {
                if (node instanceof SkillDto) {
                    if (((SkillDto) node).getName().equalsIgnoreCase(skill.trim())) {
                        col = GridPane.getColumnIndex(node);
                        break;
                    }
                }
            }
            if (col != null && row != null) {
                gp_table.add(finalCalificationDto.getContainer(), col, row);
                //Load Results here
                TextField textField = new TextField(String.valueOf(finalCalificationDto.getFinalNote()));
                textField.getStyleClass().add("rows-titles");
                Node node = getNodeInGrid(row, skills.size() + 1);
                if (node != null && node instanceof TextField) {
                    if(userDto.getIsAdmin().equals("N")){
                        textField.setDisable(true);
                    }
                    textField.setText(String.valueOf(Long.valueOf(((TextField) node).getText()) + finalCalificationDto.getFinalNote()));
                    gp_table.getChildren().remove(node);
                }
                gp_table.add(textField, skills.size() + 1, row);
            }
        }
    }

    private RowConstraints getRowConstraints() {
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(USE_COMPUTED_SIZE);
        rowConstraints.setMinHeight(10);
        rowConstraints.setMaxHeight(USE_COMPUTED_SIZE);
        return rowConstraints;
    }

//    private void clearView() {
//        clearFeedbackComments();
//        gp_table.getChildren().clear();
//        gp_container.getChildren().remove(gp_table);
//        gp_table = new GridPane();
//        createGrid();
//
//    }
    private void clearFeedbackComments() {
        gp_feedback.getChildren().clear();
        addFeedback();
    }

    private void loadFeedbackComments() {
        List<String> feedbackCommentsList = new ArrayList<>();
        if (evaluatedDto != null) {
            evaluatedDto.getEvaluators().forEach(e -> {
                EvaluatorDto evaluatorDto = (EvaluatorDto) e;
                String feedbackComments = evaluatorDto.getFeedback();
                feedbackCommentsList.add(feedbackComments);
            });
        }

        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.getStyleClass().add("containerComments");

        for (int i = 0; i < feedbackCommentsList.size(); i++) {
            String feedbackComment = feedbackCommentsList.get(i);
            vBox.getChildren().add(createHeader(feedbackComment));
        }
        gp_feedback.add(vBox, 0, 1);
    }

    private List<EvaluationDto> filterEvaluations(List<EvaluationDto> evaluationDtos) {
        Predicate<EvaluationDto> hasEvaluated = evaluationDto -> evaluationDto.getEvaluated().stream()
                .anyMatch(evaluatedDto -> evaluatedDto.getEvaluated().getId() == userDto.getId());
        List<EvaluationDto> evaluationDtosFiltered = evaluationDtos.stream()
                .filter(hasEvaluated.and(evaluation -> evaluation.getState().equals("COMPLETED") || evaluation.getState().equals("UNDER REVIEW")))
                .collect(Collectors.toList());
        return evaluationDtosFiltered;
    }

    private Node getNodeInGrid(Integer row, Integer col) {
        for (Node node : gp_table.getChildren()) {
            System.out.println("COLUNM: " + GridPane.getColumnIndex(node));
            System.out.println("ROW: " + GridPane.getRowIndex(node));
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    private void loadPrivileges() {
        if (userDto.getIsAdmin().equals("N")) {
            listEvaluated.setVisible(false);
            cbAllEvaluations.setVisible(false);
            btnSaveChanges.setVisible(false);
            txfFinalCalification.setDisable(true);
        }
    }
}
