package cr.ac.una.evacomuna.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import cr.ac.una.evacomuna.dto.EvaluatedDto;
import cr.ac.una.evacomuna.dto.EvaluationDto;
import cr.ac.una.evacomuna.dto.EvaluatorDto;
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
    private VBox gpContainer;
    @FXML
    private ComboBox<String> cbEvaluated;

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
        evaluatedService = new EvaluatedService();
        evaluationService = new EvaluationService();
        evaluatorService = new EvaluatorService();
        skills = new ArrayList<>();
        loadGridPaneSkills();
        addScrollPane(gp_table);
        loadChoiceBox();
        cleanLabels();
        // loadLabels();
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

    private void addSkills() {
        skills = getSkillsWrapper(getSkills());
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
        gp_table.getColumnConstraints().add(columnConstraints);
    }

    private void addFeedback() {
        PaneContainer rowContainer = new PaneContainer();
        rowContainer.getChildren().add(
                createHeader("Feedback"));
        rowContainer.getStyleClass().add("gp-header");
        gp_table.addRow(0, rowContainer);
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

    @SuppressWarnings("unchecked")
    private List<SkillDto> getSkills() {
        List<SkillDto> listDto = new ArrayList<>();
        ResponseWrapper response = skillService.getSkills();
        listDto = (List<SkillDto>) response.getData();
        return listDto;
    }

    private List<SkillDto> getSkillsWrapper(List<SkillDto> skills) {
        return skills
                .stream()
                .map(s -> new SkillDto(s.getName()))
                .collect(Collectors.toList());
    }

    private void loadChoiceBox() {
        cbEvaluated.setPromptText("tremendo");
        getEvaluator();

    }

    private void loadLabels() {
        // evaluationDto = getEvaluation(evaluatedDto);
        String evaluatorName = evaluatorDto.getEvaluator().getName();
        System.out.println(evaluatorName);
        // lb_evaluatorName.setText(evaluatorName);
        // lb_evaluatorPosition.setText(evaluatorDto.getEvaluator().getPosition().getName());
        // lb_evaluationPeriod.setText(evaluationDto.getInitialPeriod() +
        // evaluationDto.getFinalPeriod());
        // lb_evaluationApplicationDate.setText(evaluationDto.getApplicationDate());
    }

    private EvaluatedDto getEvaluator() {
        ResponseWrapper response = userS
        System.out.println(response.getMessage());
        return evaluatedDto;
    }


}
