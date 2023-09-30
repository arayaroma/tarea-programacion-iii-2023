package cr.ac.una.evacomuna.controller;

import cr.ac.una.evacomuna.components.ImageCheck;
import cr.ac.una.evacomuna.components.PaneContainer;
import cr.ac.una.evacomuna.dto.EvaluatedDto;
import cr.ac.una.evacomuna.dto.EvaluationDto;
import cr.ac.una.evacomuna.dto.EvaluatorDto;
import cr.ac.una.evacomuna.dto.FinalCalificationDto;
import cr.ac.una.evacomuna.dto.SkillDto;
import cr.ac.una.evacomuna.dto.UserDto;
import cr.ac.una.evacomuna.util.CalificationCode;
import cr.ac.una.evacomuna.util.Data;
import cr.ac.una.evacomuna.util.Roles;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class GridAppliedEvaluationController implements Initializable {

    @FXML
    private VBox parent;
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
    private HBox gp_container;
    @FXML
    private GridPane gp_table;
    @FXML
    private GridPane gp_feedback;
    @FXML
    private TextField txfFinalCalification;
    @FXML
    private Button btnSaveChanges;

    private UserDto userDto;
    private List<SkillDto> skills;
    private EvaluatedDto evaluatedBuffer;
    private EvaluationDto evaluationBuffer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void btnSaveChangesAction(ActionEvent event) {
    }

    private void loadGridPaneSkills() {
        addDiagonalRow();
        addSkills();
        addResult();
        addFeedback();
    }

    public void initializeView(EvaluatedDto evaluatedDto, EvaluationDto evaluationDto) {
        userDto = Data.getUserLogged();
        evaluationBuffer = evaluationDto;
        evaluatedBuffer = evaluatedDto;
        loadGridPaneSkills();
        cleanLabels();
        loadLabels();
        loadFeedbackComments();
        loadCalifications();
        loadChecks();
    }

    private void cleanLabels() {
        lb_evaluatorName.setText("");
        lb_evaluatorPosition.setText("");
        lb_evaluationPeriod.setText("");
        lb_evaluationApplicationDate.setText("");
    }

    private void addDiagonalRow() {
        PaneContainer rowContainer = new PaneContainer();
        rowContainer.getChildren().add(
                createHeader("Supervisor, Peer,\nClient, Self"));
        rowContainer.getStyleClass().add("gp-header");
        gp_table.add(rowContainer, 0, 0);
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
        }
    }

    private List<SkillDto> getSkills() {
        List<SkillDto> list = new ArrayList<>();
        if (evaluatedBuffer != null) {
            for (FinalCalificationDto finalCalificationDto : evaluatedBuffer.getFinalCalifications()) {
                list.removeIf(t -> Objects.equals(t.getID(), finalCalificationDto.getSkill().getID()));
                list.add(finalCalificationDto.getSkill());
            }
        }
        return list;
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
        if (evaluatedBuffer != null) {
            evaluatedBuffer.getEvaluators()
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
        for (FinalCalificationDto finalCalificationDto : evaluatedBuffer.getFinalCalifications()) {
            if (finalCalificationDto.getSkill().getName().equals(skill.getName())) {
                count = count + (int) evaluatedBuffer.getEvaluators()
                        .stream()
                        .filter(e -> ((EvaluatorDto) e).getRole().equals(role.toString()))
                        .count();
            }
        }
        return count;
    }

    private void loadCalifications() {
        List<FinalCalificationDto> finalCalifications = new ArrayList<>();
        if (evaluatedBuffer != null) {
            finalCalifications.addAll(evaluatedBuffer.getFinalCalifications());
        }
        for (FinalCalificationDto finalCalificationDto : finalCalifications) {
            Integer totalSupervisors = countTotalEvaluatorsByRoleAndSkill(Roles.SUPERVISOR, finalCalificationDto.getSkill());
            Integer totalPeers = countTotalEvaluatorsByRoleAndSkill(Roles.PEER, finalCalificationDto.getSkill());
            Integer totalSelf = countTotalEvaluatorsByRoleAndSkill(Roles.SELF, finalCalificationDto.getSkill());
            Integer totalClients = countTotalEvaluatorsByRoleAndSkill(Roles.CLIENT, finalCalificationDto.getSkill());
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
                    if (userDto.getIsAdmin().equals("N")) {
                        textField.setDisable(true);
                    }
                    textField.setText(String.valueOf(Long.valueOf(((TextField) node).getText()) + finalCalificationDto.getFinalNote()));
                    gp_table.getChildren().remove(node);
                }
                gp_table.add(textField, skills.size() + 1, row);
            }
        }
    }

    private void loadFeedbackComments() {
        List<String> feedbackCommentsList = new ArrayList<>();
        if (evaluatedBuffer != null) {
            evaluatedBuffer.getEvaluators().forEach(e -> {
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
}
