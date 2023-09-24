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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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

    private Skill skillService;
    private List<SkillWrapper> skills;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        skillService = new Skill();
        skills = new ArrayList<>();
        loadGridPaneSkills();
    }

    /**
     * FIXME: Fix this method to load the skills from the database
     * and show them in the gridpane
     */
    private void loadGridPaneSkills() {
        skills = getSkills()
        .stream()
        .map(s -> new SkillWrapper(s.getName()))
        .collect(Collectors.toList());
      

        SkillWrapper skill;
        RowConstraints rowConstraints;
        for (int i = 0; i < skills.size(); i++) {
            skill = skills.get(i);
        }
    }

    private List<SkillDto> getSkills() {
        ResponseWrapper response = skillService.getSkills();
        if (response.getCode() == ResponseCode.OK) {
            System.out.println(response.getData());
            ListWrapper wrapper = (ListWrapper) response.getData();
            List<SkillDto> skills = new ArrayList<>();
            for (Object i : wrapper.getElement()) {
                if (i instanceof SkillDto) {
                    skills.add((SkillDto) i);
                }
            }
            return skills;
        }
        return null;
    }

    private Label createHeader(String name) {
        Label label = new Label(name);
        return label;
    }

}
