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
import cr.ac.una.evacomuna.services.FinalCalificationService;
import cr.ac.una.evacomuna.util.CalificationCode;
import cr.ac.una.evacomuna.util.ExcelGenerator;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;
import cr.ac.una.evacomuna.util.Roles;
import java.net.URL;
import java.text.DecimalFormat;
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
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
    @FXML
    private Label lblAverageCalification;
    private UserDto userDto;
    private List<SkillDto> skills;
    private EvaluatedDto evaluatedBuffer;
    private EvaluationDto evaluationBuffer;
    private FinalCalificationService finalCalificationService = new FinalCalificationService();
    private boolean hasPrivileges = false;
    private AppliedEvaluationsController appliedEvaluationsController;
    // private List<HBox> finalCalificationContainers;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void btnSaveChangesAction(ActionEvent event) {
        for (FinalCalificationDto finalCalificationDto : evaluatedBuffer.getFinalCalifications()) {
            finalCalificationDto.setEvaluated(new EvaluatedDto(evaluatedBuffer.getDto()));
            ResponseWrapper response = finalCalificationService.updateFinalCalification(finalCalificationDto);
            if (response.getCode() != ResponseCode.OK) {
                Message.showNotification("ERROR", MessageType.ERROR, response.getMessage());
                return;
            }
            System.out.println(response.getMessage());
        }
        appliedEvaluationsController.reloadGridCalification(evaluatedBuffer, evaluationBuffer);
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

    public void initializeView(EvaluatedDto evaluatedDto, EvaluationDto evaluationDto, boolean hasPrivileges,
            AppliedEvaluationsController appliedEvaluationsController) {
        userDto = evaluatedDto.getEvaluated();
        this.appliedEvaluationsController = appliedEvaluationsController;
        this.hasPrivileges = hasPrivileges;
        evaluationBuffer = evaluationDto;
        evaluatedBuffer = evaluatedDto;
        loadGridPaneSkills();
        cleanLabels();
        loadLabels();
        loadFeedbackComments();
        loadPanes();
        loadCalifications();
        loadChecks();

        loadPrivileges();
    }

    private void loadPrivileges() {
        if (!hasPrivileges) {
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
        gp_table.add(rowContainer, skills.size() + 1, 0);
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

    Node nodeDragguedBuffer = null;

    private void intializeDragAndDrop(Node node) {
        node.getStyleClass().add("drag");
        node.setOnDragDetected((event) -> {
            Dragboard dragboard = node.startDragAndDrop(TransferMode.MOVE);
            dragboard.setDragView(node.snapshot(null, null));
            ClipboardContent content = new ClipboardContent();
            content.putString("check");
            dragboard.setContent(content);
            nodeDragguedBuffer = node;
        });
        gp_table.setOnDragOver(event -> {
            if (event.getGestureSource() != gp_table && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });
        gp_table.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            boolean success = false;
            if (dragboard.hasString()) {
                // System.out.println(event.getTarget());
                Integer row = GridPane.getRowIndex((Node) event.getTarget());
                Integer col = GridPane.getColumnIndex((Node) event.getTarget());
                if (event.getTarget() != null && row != null && col != null && col != 0 && nodeDragguedBuffer != null
                        && row > 0) {
                    if (nodeDragguedBuffer instanceof FinalCalificationDto
                            && updateCalificationDraggued((FinalCalificationDto) nodeDragguedBuffer, row, col)) {
                        gp_table.getChildren().remove(nodeDragguedBuffer);
                        gp_table.add(nodeDragguedBuffer, col, row);
                        int sumFinalCalifications = 0;
                        for (FinalCalificationDto finalCalificationDto : evaluatedBuffer.getFinalCalifications()) {
                            sumFinalCalifications += finalCalificationDto.getFinalNote();
                        }
                        generateGeneralResult(sumFinalCalifications);
                    }
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });
    }

    private boolean updateCalificationDraggued(FinalCalificationDto finalCalificationDto, int row, int col) {
        Node skillNode = getNodeInGrid(0, col);
        if (skillNode instanceof SkillDto) {
            if (finalCalificationDto.getSkill().getID().equals(((SkillDto) skillNode).getID())) {
                finalCalificationDto.setFinalNote(Long.valueOf(row));
                return true;
            }
        }
        return false;
    }

    private void loadPanes() {
        for (int i = 0; i < gp_table.getColumnCount(); i++) {
            for (int j = 0; j < gp_table.getRowCount(); j++) {

                // if (getNodeInGrid(j, i) == null) {
                gp_table.add(new Pane(), i, j);
                // }
            }
        }
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

            VBox vBoxCheck = new VBox(ImageCheck.createImageCheck(), label);
            if (label.getText().isBlank()) {
                vBoxCheck.getChildren().remove(label);
            }
            vBoxCheck.setAlignment(Pos.CENTER);
            HBox hBox = new HBox();
            if (hasPrivileges) {
                hBox.getChildren().addAll(vBoxCheck, vBox);
                intializeDragAndDrop(finalCalificationDto);
            } else {
                hBox.getChildren().addAll(vBoxCheck);
            }
            hBox.setSpacing(10);
            hBox.setAlignment(Pos.CENTER);
            finalCalificationDto.getChildren().clear();
            finalCalificationDto.getChildren().add(hBox);

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
                finalCalificationDto.setId(finalCalificationDto.getID().toString());
                gp_table.add(finalCalificationDto, col, row);
                sumFinalCalifications += finalCalificationDto.getFinalNote().intValue();
            }
        }
        generateGeneralResult(sumFinalCalifications);
    }

    private void generateGeneralResult(int sumFinalCalifications) {
        cleanGeneralResult();
        ImageView check = ImageCheck.createImageCheck();
        VBox checkVbox = new VBox(check);
        checkVbox.setAlignment(Pos.CENTER);
        DecimalFormat format = new DecimalFormat("#.##");
        Double averageCalification = (double) sumFinalCalifications / (double) skills.size();
        Long rounding = Math.round(averageCalification);
        lblAverageCalification.setText("Average: " + format.format(averageCalification));
        lblFinalCalification
                .setText("Final Calification: " + format.format((double) (averageCalification * 100) / (double) 4));
        gp_table.add(checkVbox, skills.size() + 1, rounding.intValue());
    }

    private void cleanGeneralResult() {
        for (int i = 1; i < gp_table.getRowCount(); i++) {
            Node node = getNodeInGrid(i, skills.size() + 1);
            if (node != null) {
                gp_table.getChildren().remove(node);
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
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

}
