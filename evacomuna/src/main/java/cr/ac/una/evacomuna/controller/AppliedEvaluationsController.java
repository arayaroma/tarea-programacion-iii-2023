package cr.ac.una.evacomuna.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import cr.ac.una.evacomuna.dto.EvaluatedDto;
import cr.ac.una.evacomuna.dto.EvaluationDto;
import cr.ac.una.evacomuna.dto.EvaluatorDto;
import cr.ac.una.evacomuna.dto.FinalCalificationDto;
import cr.ac.una.evacomuna.util.Data;
import cr.ac.una.evacomuna.util.ResponseWrapper;
import cr.ac.una.evacomuna.components.PaneContainer;
import cr.ac.una.evacomuna.dto.SkillDto;
import cr.ac.una.evacomuna.dto.UserDto;
import cr.ac.una.evacomuna.services.EvaluatedService;
import cr.ac.una.evacomuna.services.EvaluationService;
import cr.ac.una.evacomuna.services.EvaluatorService;
import cr.ac.una.evacomuna.services.SkillService;
import cr.ac.una.evacomuna.services.UserService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import java.util.stream.Collectors;

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
    private VBox gpContainer;

    private SkillService skillService;
    private UserService userService;
    private EvaluatedService evaluatedService;
    private EvaluationService evaluationService;
    private EvaluatorService evaluatorService;

    private List<SkillDto> skills;

    private UserDto userDto;
    private EvaluatedDto evaluatedDto;
    private EvaluationDto evaluationDto;
    private EvaluatorDto evaluatorDto;

    ColumnConstraints columnConstraints = new ColumnConstraints(150);

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        skillService = new SkillService();
        userService = new UserService();
        evaluatedService = new EvaluatedService();
        evaluationService = new EvaluationService();
        evaluatorService = new EvaluatorService();
        skills = new ArrayList<>();
        loadGridPaneSkills();
        addScrollPane(gp_table);
        cleanLabels();
        loadLabels();
        loadFeedbackComments();
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
        gp_table.addRow(0, rowContainer);
        gp_table.getColumnConstraints().add(columnConstraints);
    }

    private List<SkillDto> getSkills() {
        evaluatedDto = getEvaluated();
        List<SkillDto> list = new ArrayList<>();
        for (FinalCalificationDto finalCalificationDto : evaluatedDto.getFinalCalifications()) {
            System.out.println(finalCalificationDto.getSkill().toString());
            list.add(finalCalificationDto.getSkill());
        }
        return list;
    }

    private void addSkills() {
        skills = getSkills();
        for (int i = 0; i < skills.size(); i++) {
            SkillDto skill = skills.get(i);
            skill.getChildren().add(createHeader(skill.getName()));
            skill.getStyleClass().add("gp-header");
            gp_table.addRow(0, skill);
            gp_table.getColumnConstraints().add(columnConstraints);
        }
    }

    private void addResult() {
        PaneContainer rowContainer = new PaneContainer();
        rowContainer.getChildren().add(
                createHeader("Result"));
        rowContainer.getStyleClass().add("gp-header");
        gp_table.addRow(0, rowContainer);
    }

    private void addFeedback() {
        PaneContainer rowContainer = new PaneContainer();
        rowContainer.getChildren().add(
                createHeader("Feedback"));
        rowContainer.getStyleClass().add("gp-header");
        gp_feedback.addRow(0, rowContainer);
    }

    private void addScrollPane(GridPane gp) {
        ScrollPane scrollPane = new ScrollPane(gp);
        scrollPane.setFitToHeight(true);
        scrollPane.setPrefWidth(gp.getWidth());
        gpContainer.getChildren().add(scrollPane);
    }

    private Node createHeader(String name) {
        return new Label(name);
    }

    private void loadLabels() {
        ResponseWrapper response = userService.getUserById(Data.getUserLogged().getId());
        userDto = (UserDto) response.getData();
        lb_evaluatorName.setText(userDto.getName() + " " + userDto.getLastname() + " " + userDto.getSecondLastname());
        // System.out.println("HERE! " + userDto.getPosition().getName());
        // lb_evaluatorPosition.setText(userDto.getPosition());
        lb_evaluationPeriod.setText(getEvaluation().getInitialPeriod() + " - " + getEvaluation().getFinalPeriod());
        lb_evaluationApplicationDate.setText(getEvaluation().getApplicationDate().toString());
    }

    private void loadFeedbackComments() {
        evaluatedDto = getEvaluated();
        List<String> feedbackCommentsList = new ArrayList<>();
        evaluatedDto.getEvaluators().forEach(e -> {
            EvaluatorDto evaluatorDto = (EvaluatorDto) e;
            String feedbackComments = evaluatorDto.getFeedback();
            feedbackCommentsList.add(feedbackComments);
        });

        for (int i = 0; i < feedbackCommentsList.size(); i++) {
            String feedbackComment = feedbackCommentsList.get(i);
            PaneContainer rowContainer = new PaneContainer();
            rowContainer.getChildren().add(
                    createHeader(feedbackComment));
            gp_feedback.addColumn(0, rowContainer);
        }

    }

    private EvaluatedDto getEvaluated() {
        ResponseWrapper evaluatedResponse = evaluatedService.getEvaluatedById(Data.getUserLogged().getId());
        EvaluatedDto evaluatedDto = (EvaluatedDto) evaluatedResponse.getData();
        return (EvaluatedDto) evaluatedResponse.getData();
    }

    private EvaluationDto getEvaluation() {
        evaluatedDto = getEvaluated();
        ResponseWrapper evaluationResponse = evaluationService.getEvaluationById(evaluatedDto.getEvaluation().getId());
        return (EvaluationDto) evaluationResponse.getData();
    }

}
