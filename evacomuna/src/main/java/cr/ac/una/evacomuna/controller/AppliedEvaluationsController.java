package cr.ac.una.evacomuna.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import cr.ac.una.controller.ListWrapper;
import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.SkillDto;
import cr.ac.una.evacomuna.dto.SkillWrapper;
import cr.ac.una.evacomuna.services.Skill;
import cr.ac.una.evacomuna.util.RowContainer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
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
    private VBox gpContainer;

    private Skill skillService;
    private List<SkillWrapper> skills;

    ColumnConstraints columnConstraints = new ColumnConstraints(150);

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        skillService = new Skill();
        skills = new ArrayList<>();
        loadGridPaneSkills();
        addScrollPane(gp_table);
    }

    private void loadGridPaneSkills() {
        addDiagonalRow();
        addSkills();
        addResult();
        addFeedback();
    }

    private void addDiagonalRow() {
        RowContainer rowContainer = new RowContainer();
        rowContainer.getChildren().add(
                createHeader("Supervisor, Peer,\nClient, Self"));
        rowContainer.getStyleClass().add("gp-header");
        gp_table.addRow(0, rowContainer);
        gp_table.getColumnConstraints().add(columnConstraints);
    }

    private void addSkills() {
        skills = getSkillsWrapper(getSkills());
        for (int i = 0; i < skills.size(); i++) {
            SkillWrapper skill = skills.get(i);
            skill.getChildren().add(createHeader(skill.getName()));
            skill.getStyleClass().add("gp-header");
            gp_table.addRow(0, skill);
            gp_table.getColumnConstraints().add(columnConstraints);
        }
    }

    private void addResult() {
        RowContainer rowContainer = new RowContainer();
        rowContainer.getChildren().add(
                createHeader("Result"));
        rowContainer.getStyleClass().add("gp-header");
        gp_table.addRow(0, rowContainer);
        gp_table.getColumnConstraints().add(columnConstraints);
    }

    private void addFeedback() {
        RowContainer rowContainer = new RowContainer();
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

    private List<SkillDto> getSkills() {
        ResponseWrapper response = skillService.getSkills();
        if (response.getCode() == ResponseCode.OK) {
            ListWrapper wrapper = (ListWrapper) response.getData();
            return wrapper.getElement().stream()
                    .filter(SkillDto.class::isInstance)
                    .map(SkillDto.class::cast)
                    .collect(Collectors.toList());
        }
        return null;
    }

    private List<SkillWrapper> getSkillsWrapper(List<SkillDto> skills) {
        return skills.stream()
                .map(s -> new SkillWrapper(s.getName()))
                .collect(Collectors.toList());
    }

}
