package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.PositionDto;
import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.dto.SkillWrapper;
import cr.ac.una.evacomuna.services.Position;
import cr.ac.una.evacomuna.util.Utilities;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    // @FXML
    // private ImageView imgCheck;
    @FXML
    private TextArea txaFeedBack;

    private List<SkillWrapper> skills;
    private List<Node> evaluation;
    @FXML
    private ComboBox<String> cbPendingEvaluations;
    Position roleService;
    @FXML
    private HBox gridContainer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        skills = new ArrayList<>();
        evaluation = new ArrayList<>();
        roleService = new Position();
        cbPendingEvaluations.getItems().addAll(Utilities.mapListToObsevableString(Utilities.loadPositions()));
        initializeGrid();
    }

    @FXML
    private void selectEvaluation(ActionEvent event) {
        cleanGrid();
        String name = cbPendingEvaluations.getValue();
        if (name != null) {
            PositionDto roleDto = (PositionDto) roleService.getRoleByName(name).getData();
            if (roleDto != null) {
                skills = roleDto.getSkills().stream().map(t -> new SkillWrapper(t.getName()))
                        .collect(Collectors.toList());
                loadSkillsInGrid();
            }
        }
    }

    @FXML
    private void sendEvaluation(ActionEvent event) {
    }

    private void initializeGrid() {
        ImageView check = new ImageView(App.class.getResource("/cr/ac/una/evacomuna/img/comprobar.png").toString());
        check.setPreserveRatio(false);
        check.setSmooth(false);
        check.setFitHeight(30);
        check.setFitWidth(30);
        check.getStyleClass().add("check");
        gridEvaluation.addRow(0, check, createHeader("Excepcional"), createHeader("Por encima de las expectativas"),
                createHeader("Cumple las expectativas"), createHeader("Por debajo de las expectativas"));
        ColumnConstraints constraints = new ColumnConstraints();
        constraints.setHalignment(HPos.CENTER);
        gridEvaluation.getColumnConstraints().add(constraints);
    }

    private void loadSkillsInGrid() {
        RowConstraints rowConstraints;
        ColumnConstraints columnConstraints;
        SkillWrapper skill;
        for (int i = 0; i < skills.size(); i++) {
            skill = skills.get(i);
            skill.getChildren().add(createHeader(skill.getName()));
            rowConstraints = new RowConstraints(50);
            gridEvaluation.getRowConstraints().add(rowConstraints);
            gridEvaluation.add(skill, 0, i + 1);

        }
    }

    private Label createHeader(String name) {
        Label label = new Label(name);
        label.getStyleClass().addAll("h2", "labelGrid", "mw-10");
        return label;
    }

    private void fillGrid() {
        // int column = gridEvaluation.getColumnCount();
        // int row = gridEvaluation.getRowCount();
        // Pane pane;
        // for (int i = 1; i < column; i++) {
        // for (int j = 1; j < row; j++) {
        // pane = new Pane();
        // evaluation.add(pane);
        // pane.getStyleClass().add("pane-content");
        // gridEvaluation.add(pane, i, j);
        // }
        // }
    }

    private void cleanGrid() {
        gridEvaluation = new GridPane();
        gridEvaluation.getStyleClass().add("bg-blue");
        gridContainer.getChildren().clear();
        gridContainer.getChildren().add(gridEvaluation);
        initializeGrid();
        skills.clear();
        evaluation.clear();

    }
}
