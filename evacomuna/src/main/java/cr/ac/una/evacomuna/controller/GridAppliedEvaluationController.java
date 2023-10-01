package cr.ac.una.evacomuna.controller;

import cr.ac.una.evacomuna.components.ImageCheck;
import cr.ac.una.evacomuna.components.PaneContainer;
import cr.ac.una.evacomuna.dto.CalificationDto;
import cr.ac.una.evacomuna.dto.EvaluatedDto;
import cr.ac.una.evacomuna.dto.EvaluationDto;
import cr.ac.una.evacomuna.dto.EvaluatorDto;
import cr.ac.una.evacomuna.dto.FinalCalificationDto;
import cr.ac.una.evacomuna.dto.SkillDto;
import cr.ac.una.evacomuna.dto.UserDto;
import cr.ac.una.evacomuna.util.CalificationCode;
import cr.ac.una.evacomuna.util.ExcelGenerator;
import cr.ac.una.evacomuna.util.Roles;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author arayaroma
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
    private Button btnSaveChanges;
    @FXML
    private Label lblFinalCalification;
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

    @FXML
    private void btnGenerateExcelAction(ActionEvent event) {
        generateExcel();

    }

    private void generateExcel() {
        ExcelGenerator excelGenerator = new ExcelGenerator(evaluatedBuffer, evaluationBuffer);
        excelGenerator.generateExcelReport();
    }

    private void loadGridPaneSkills() {
        addDiagonalRow();
        addSkills();
        addResult();
        addFeedback();
    }

    public void initializeView(EvaluatedDto evaluatedDto, EvaluationDto evaluationDto) {
        userDto = evaluatedDto.getEvaluated();
        evaluationBuffer = evaluationDto;
        evaluatedBuffer = evaluatedDto;
        loadGridPaneSkills();
        cleanLabels();
        loadLabels();
        loadFeedbackComments();
        loadCalifications();
        loadChecks();
        loadPrivileges();
    }

    private void loadPrivileges() {
        if (userDto.getIsAdmin().equals("N")) {
            btnSaveChanges.setVisible(false);
        }
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
            lb_evaluationPeriod
                    .setText(evaluationBuffer.getInitialPeriod() + " - " + evaluationBuffer.getFinalPeriod());
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

    private List<CalificationDto> getCalificationsBySkill(List<EvaluatorDto> evaluatorDtos, SkillDto skillDto) {
        return evaluatorDtos
                .stream()
                .flatMap(evaluator -> evaluator.getCalifications()
                        .stream()
                        .filter(calification -> calification.getSkill().getID() == skillDto.getID())
                        .map(t -> t))
                .collect(Collectors.toList());
    }

    private Long countTotalCalifictionsOverActualPositionBySkill(Long actualPosition, List<EvaluatorDto> evaluatorDtos,
            SkillDto skillDto) {
        List<CalificationDto> calificationDtos = getCalificationsBySkill(evaluatorDtos, skillDto);
        Long upperTotal = calificationDtos
                .stream()
                .filter(t -> CalificationCode.parseStringToCode(t.getCalification()) > actualPosition)
                .count();
        return upperTotal;
    }

    private Long countTotalCalifictionsLowerActualPositionBySkill(Long actualPosition, List<EvaluatorDto> evaluatorDtos,
            SkillDto skillDto) {
        List<CalificationDto> calificationDtos = getCalificationsBySkill(evaluatorDtos, skillDto);
        Long lowerTotal = calificationDtos
                .stream()
                .filter(t -> CalificationCode.parseStringToCode(t.getCalification()) < actualPosition)
                .count();
        return lowerTotal;
    }

    private Long countTotalCalifictionsActualPositionBySkill(Long actualPosition, List<EvaluatorDto> evaluatorDtos,
            SkillDto skillDto) {
        List<CalificationDto> calificationDtos = getCalificationsBySkill(evaluatorDtos, skillDto);
        Long actualTotal = calificationDtos
                .stream()
                .filter(t -> CalificationCode.parseStringToCode(t.getCalification()) == actualPosition)
                .count();
        return actualTotal;
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

    // private booleanIs
    private void loadCalifications() {
        List<FinalCalificationDto> finalCalifications = new ArrayList<>();
        if (evaluatedBuffer != null) {
            finalCalifications.addAll(evaluatedBuffer.getFinalCalifications());
        }
        int sumFinalCalifications = 0;
        for (FinalCalificationDto finalCalificationDto : finalCalifications) {
            Integer totalSupervisors = countTotalEvaluatorsByRoleAndSkill(Roles.SUPERVISOR,
                    finalCalificationDto.getSkill());
            Integer totalPeers = countTotalEvaluatorsByRoleAndSkill(Roles.PEER, finalCalificationDto.getSkill());
            Integer totalSelf = countTotalEvaluatorsByRoleAndSkill(Roles.SELF, finalCalificationDto.getSkill());
            Integer totalClients = countTotalEvaluatorsByRoleAndSkill(Roles.CLIENT, finalCalificationDto.getSkill());
            finalCalificationDto.setData(ImageCheck.createImageCheck());

            VBox vBox = new VBox(new Label("SUPER: " + totalSupervisors.toString()),
                    new Label("PEER: " + totalPeers.toString()),
                    new Label("SELF: " + totalSelf.toString()),
                    new Label("CLIENT: " + totalClients.toString()));

            Long upper = countTotalCalifictionsOverActualPositionBySkill(finalCalificationDto.getFinalNote(),
                    evaluatedBuffer.getEvaluators(), finalCalificationDto.getSkill());
            Long lower = countTotalCalifictionsLowerActualPositionBySkill(finalCalificationDto.getFinalNote(),
                    evaluatedBuffer.getEvaluators(), finalCalificationDto.getSkill());
            Long total = countTotalCalifictionsActualPositionBySkill(finalCalificationDto.getFinalNote(),
                    evaluatedBuffer.getEvaluators(), finalCalificationDto.getSkill());
            Label label = new Label();
            label.getStyleClass().add("title");
            if (upper > lower && upper > total) {
                label.setText("+");
            } else if (lower > upper && lower > total) {
                label.setText("-");
            } else if (lower > 0 && upper == 0) {
                label.setText("-");
            } else if (upper > 0 && lower == 0) {
                label.setText("+");
            }
            vBox.setAlignment(Pos.CENTER);

            VBox vBoxCheck = new VBox(finalCalificationDto.getData(), label);
            if (label.getText().isBlank()) {
                vBoxCheck.getChildren().remove(label);
            }
            vBoxCheck.setAlignment(Pos.CENTER);
            HBox hBox = new HBox();
            if (userDto.getIsAdmin().equals("Y")) {
                hBox.getChildren().addAll(vBoxCheck, vBox);
            } else {
                hBox.getChildren().addAll(vBoxCheck);
            }
            hBox.setSpacing(10);
            hBox.setAlignment(Pos.CENTER);
            finalCalificationDto.setContainer(hBox);
            String calification = CalificationCode.parseCodeToString(finalCalificationDto.getFinalNote());
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
                sumFinalCalifications += finalCalificationDto.getFinalNote().intValue();
                // //Load Results here
            }
            // finalCalificationDto.get
        }

        ImageView check = ImageCheck.createImageCheck();
        VBox checkVbox = new VBox(check);
        checkVbox.setAlignment(Pos.CENTER);
        lblFinalCalification.setText("Final Calification: " + String.valueOf((sumFinalCalifications / skills.size())));
        gp_table.add(checkVbox, skills.size() + 1, (sumFinalCalifications / skills.size()));

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
