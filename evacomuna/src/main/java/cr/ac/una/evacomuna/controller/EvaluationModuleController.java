package cr.ac.una.evacomuna.controller;

import cr.ac.una.evacomuna.dto.CalificationDto;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;
import cr.ac.una.evacomuna.dto.UserDto;
import cr.ac.una.evacomuna.dto.EvaluatedDto;
import cr.ac.una.evacomuna.dto.EvaluationDto;
import cr.ac.una.evacomuna.dto.EvaluatorDto;
import cr.ac.una.evacomuna.dto.FinalCalificationDto;
import cr.ac.una.evacomuna.dto.PositionDto;
import cr.ac.una.evacomuna.dto.SkillDto;
import cr.ac.una.evacomuna.services.EvaluatedService;
import cr.ac.una.evacomuna.services.EvaluationService;
import cr.ac.una.evacomuna.services.EvaluatorService;
import cr.ac.una.evacomuna.services.FinalCalificationService;
import cr.ac.una.evacomuna.services.PositionService;
import cr.ac.una.evacomuna.services.SkillService;
import cr.ac.una.evacomuna.util.CalificationCode;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.ObservableListParser;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class EvaluationModuleController implements Initializable {
    
    @FXML
    private Button btnCreate;
    @FXML
    private Button btnSave;
    @FXML
    private TextField txfNameEvaluation;
    @FXML
    private DatePicker dpStartDate;
    @FXML
    private DatePicker dpEndDate;
    @FXML
    private DatePicker dpAplicationDate;
    @FXML
    private ComboBox<String> cbState;
    @FXML
    private ComboBox<String> cbEvaluations;
    @FXML
    private ComboBox<String> cbRoles;
    @FXML
    private TextField txfSearchEvaluators;
    @FXML
    private ListView<EvaluatorDto> listEvaluators;
    @FXML
    private ListView<EvaluatorDto> listEvaluatorsFix;
    @FXML
    private ListView<EvaluatedDto> listEvaluated;
    @FXML
    private ListView<EvaluatedDto> listEvaluatedFix;
    @FXML
    private ToggleGroup role;
    private EvaluationService evaluationService;
    private EvaluationDto evaluationBuffer;
    private EvaluatedDto evaluatedBuffer;
    private EvaluatorDto evaluatorBuffer;
    private EvaluatedDto finalEvaluatedBuffer;
    private EvaluatorDto finalEvaluatorBuffer;
    private List<UserDto> users;
    private ObservableList<EvaluationDto> evaluationDtos;
    private PositionService roleService = new PositionService();
    private EvaluatedService evaluatedService = new EvaluatedService();
    private EvaluatorService evaluatorService = new EvaluatorService();
    private SkillService skillService = new SkillService();
    private FinalCalificationService finalCalificationService = new FinalCalificationService();
    private List<EvaluatorDto> evaluatorDtos = new ArrayList<>();
    private List<EvaluatedDto> evaluatedDtos = new ArrayList<>();
    
    private String roleBuffer;
    @FXML
    private RadioButton rbSelf;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            evaluationService = new EvaluationService();
            // initilizeLists();
            users = ObservableListParser.loadUsers();
            btnSave.setDisable(true);
            // initializeView();
            initializeView();
        } catch (Exception e) {
            
            System.out.println(e.toString());
        }
        initilizeLists();
        
    }
    
    @FXML
    private void btnAddEvaluator(ActionEvent event) {
        if (roleBuffer == null) {
            Message.showNotification("Wait", MessageType.INFO, "You must to set a role");
            return;
        }
        if (finalEvaluatedBuffer != null) {
            if (evaluatorBuffer != null && !listEvaluatorsFix.getItems().stream()
                    .anyMatch(t -> t.getId() != null && t.getEvaluator().getId() == evaluatorBuffer.getId())) {
                listEvaluatorsFix.getItems().remove(evaluatedBuffer);
                setRole(evaluatorBuffer);
                listEvaluatorsFix.getItems().add(evaluatorBuffer);
                finalEvaluatedBuffer.getEvaluators().add(evaluatorBuffer);
            }
        } else {
            Message.showNotification("Alert", MessageType.INFO, "You must to choose a Evaluated to set the evaluators");
        }
    }
    
    @FXML
    private void btnDeleteEvaluator(ActionEvent event) {
        if (finalEvaluatorBuffer != null) {
            if (evaluationBuffer != null) {
                ResponseWrapper responseWrapper = evaluatorService.deleteEvaluatorById(finalEvaluatorBuffer);
                System.out.println(responseWrapper.getMessage());
            }
            finalEvaluatedBuffer.getEvaluators().remove(finalEvaluatorBuffer);
            listEvaluatorsFix.getItems().remove(finalEvaluatorBuffer);
            
        }
    }
    
    @FXML
    private void btnAddEvaluated(ActionEvent event) {
        if (evaluatedBuffer != null && !listEvaluatedFix.getItems().stream()
                .anyMatch(t -> t.getId() != null && t.getEvaluated().getId() == evaluatedBuffer.getId())) {
            listEvaluatedFix.getItems().remove(evaluatedBuffer);
            listEvaluatedFix.getItems().add(evaluatedBuffer);
        }
    }
    
    @FXML
    private void btnDeleteEvaluated(ActionEvent event) {
        if (finalEvaluatedBuffer != null) {
            if (evaluationBuffer != null) {
                deleteEvaluated(finalEvaluatedBuffer);
            }
            listEvaluatedFix.getItems().remove(finalEvaluatedBuffer);
            listEvaluatorsFix.getItems().clear();
            
        }
    }
    
    @FXML
    private void searchByRoleAction(ActionEvent event) {
        String name = cbRoles.getValue();
        if (name != null) {
            PositionDto role = (PositionDto) roleService.getPositionByName(name).getData();
            if (role != null && role.getUsers() != null) {
                listEvaluated.getItems().clear();
                listEvaluated.getItems().addAll(role.getUsers().stream().map(t -> new EvaluatedDto(t))
                        .collect(Collectors.toList()));
            }
        }
    }
    
    @FXML
    private void deleteEvaluationAction(ActionEvent event) {
        if (evaluationBuffer != null) {
            boolean evaluatedDeleted = true;
            for (EvaluatedDto evaluatedDto : evaluationBuffer.getEvaluated()) {
                evaluatedDeleted = deleteEvaluated(evaluatedDto);
                if (!evaluatedDeleted) {
                    break;
                }
            }
            if (evaluatedDeleted) {
                ResponseWrapper response = evaluationService.deleteEvaluationById(evaluationBuffer.getId());
                System.out.println(response.getMessage());
                if (response.getCode() == ResponseCode.OK) {
                    cleanView();
                    initializeView();
                }
                Message.showNotification(response.getCode().name(), MessageType.INFO, response.getMessage());
            } else {
                Message.showNotification("Error", MessageType.ERROR, "Error removing evaluated");
            }
        }
    }
    
    @FXML
    private void createEvaluationAction(ActionEvent event) {
        if (evaluationBuffer != null) {
            if (Message.showConfirmationAlert("Clean", Alert.AlertType.CONFIRMATION,
                    "Do you wish clean the fields?") == ButtonType.OK) {
                cleanView();
                initializeView();
            }
            return;
        }
        String name = txfNameEvaluation.getText(), state = cbState.getValue();
        LocalDate initialDate = dpStartDate.getValue(), endingDate = dpEndDate.getValue(),
                aplicationDate = dpAplicationDate.getValue();
        if (name.isBlank() || state == null || initialDate == null || endingDate == null || aplicationDate == null) {
            Message.showNotification("Ups", MessageType.INFO, "All the fields are required");
            return;
        }
        // Create Evaluation
        EvaluationDto evaluationDto = new EvaluationDto(null, name, aplicationDate, initialDate, endingDate,
                state);
        ResponseWrapper response = evaluationService.createEvaluation(evaluationDto);
        boolean allIsSaved = false;
        if (response.getCode() == ResponseCode.OK) {
            // Create evaluated
            evaluationDto = (EvaluationDto) response.getData();
            for (EvaluatedDto i : listEvaluatedFix.getItems()) {
                allIsSaved = createEvaluated(i, evaluationDto);
            }
        }
        if (allIsSaved) {
            Message.showNotification("OK", MessageType.INFO, "Evaluation successfully created");
            cleanView();
            initializeView();
            return;
        }
        Message.showNotification("ERROR", MessageType.INFO, "Error creating evaluation");
    }
    
    @FXML
    private void saveChangesAction(ActionEvent event) {
        String name = txfNameEvaluation.getText(), state = cbState.getValue();
        LocalDate initialDate = dpStartDate.getValue(), endingDate = dpEndDate.getValue(),
                aplicationDate = dpAplicationDate.getValue();
        if (name.isBlank() || state == null || initialDate == null || endingDate == null || aplicationDate == null) {
            Message.showNotification("Ups", MessageType.INFO, "All the fields are required");
            return;
        }
        EvaluationDto evaluationDto;
        // Create Evaluation
        evaluationBuffer.setApplicationDate(aplicationDate);
        evaluationBuffer.setFinalPeriod(endingDate);
        evaluationBuffer.setInitialPeriod(initialDate);
        evaluationBuffer.setName(name);
        evaluationBuffer.setState(state);
        generateFinalCalifications(evaluationBuffer);
        ResponseWrapper response = evaluationService.updateEvaluation(evaluationBuffer);
        if (response.getCode() == ResponseCode.OK) {
            evaluationDto = (EvaluationDto) response.getData();
            for (EvaluatedDto i : listEvaluatedFix.getItems()) {
                createEvaluated(i, evaluationDto);
            }
            cleanView();
            initializeView();
        }
        Message.showNotification(response.getCode().name(), MessageType.INFO, response.getMessage());
    }
    
    @FXML
    private void searchByIdentification(KeyEvent event) {
        String identificationToSearch = txfSearchEvaluators.getText();
        listEvaluators.getItems().clear();
        if (identificationToSearch.length() > 2) {
            listEvaluators.getItems()
                    .addAll(evaluatorDtos.stream()
                            .filter(t -> t.getEvaluator().getIdentification().contains(identificationToSearch))
                            .collect(Collectors.toList()));
            return;
        }
        listEvaluators.getItems().addAll(evaluatorDtos);
    }
    
    @FXML
    private void selectEvaluation(ActionEvent event) {
        String name = cbEvaluations.getValue();
        if (name != null) {
            evaluationBuffer = (EvaluationDto) evaluationService.getEvaluationByName(name).getData();
            if (evaluationBuffer != null) {
                loadFields(evaluationBuffer);
            }
        }
    }
    
    @FXML
    private void searchEvaluationInput(KeyEvent event) {
        if (event.getCode().isLetterKey()) {
            String nameToSearch = cbEvaluations.getEditor().getText();
            if (nameToSearch != null) {
                cbEvaluations.getItems().clear();
                if (nameToSearch.length() > 2) {
                    cbEvaluations.getItems()
                            .addAll(evaluationDtos.stream().filter(t -> t.getName().contains(nameToSearch))
                                    .map(t -> t.getName()).collect(Collectors.toList()));
                    return;
                }
                cbEvaluations.getItems().addAll(ObservableListParser.mapListToObsevableString(evaluationDtos));
                cbEvaluations.show();
            }
        }
    }
    
    public void initializeView() {
        cbState.getItems().addAll("UNDER CONSTRUCTION", "IN APPLICATION", "UNDER REVIEW", "COMPLETED");
        cbRoles.getItems().addAll(ObservableListParser.mapListToObsevableString(ObservableListParser.loadPositions()));
        evaluationDtos = ObservableListParser.loadEvaluations();
        cbEvaluations.getItems().addAll(ObservableListParser.mapListToObsevableString(evaluationDtos));
        if (users != null) {
            evaluatorDtos = users.stream().map(t -> new EvaluatorDto(t)).collect(Collectors.toList());
            evaluatedDtos = users.stream().map(t -> new EvaluatedDto(t)).collect(Collectors.toList());
            listEvaluated.getItems().addAll(evaluatedDtos);
            listEvaluators.getItems().addAll(evaluatorDtos);
        }
    }
    
    public void cleanView() {
        cbState.getItems().clear();
        cbRoles.getItems().clear();
        txfNameEvaluation.setText("");
        txfSearchEvaluators.setText("");
        cbState.setValue(null);
        dpAplicationDate.setValue(null);
        dpEndDate.setValue(null);
        dpStartDate.setValue(null);
        cbEvaluations.getItems().clear();
        listEvaluated.getItems().clear();
        listEvaluators.getItems().clear();
        listEvaluatorsFix.getItems().clear();
        listEvaluatedFix.getItems().clear();
        evaluationBuffer = null;
        btnSave.setDisable(true);
        btnCreate.setText("Create Evaluation");
    }
    
    public void loadFields(EvaluationDto evaluationDto) {
        txfNameEvaluation.setText(evaluationDto.getName());
        dpAplicationDate.setValue(evaluationDto.getApplicationDate());
        dpEndDate.setValue(evaluationDto.getFinalPeriod());
        dpStartDate.setValue(evaluationDto.getInitialPeriod());
        cbState.setValue(evaluationDto.getState());
        btnSave.setDisable(false);
        listEvaluatedFix.getItems().clear();
        listEvaluatedFix.getItems().addAll(evaluationDto.getEvaluated());
        btnCreate.setText("+New Evaluation");
    }
    
    public void initilizeLists() {
        listEvaluated.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                EvaluatedDto evaluatedDto = (EvaluatedDto) item;
                if (evaluatedDto != null) {
                    UserDto user = evaluatedDto.getEvaluated();
                    setText(empty || item == null ? null
                            : user.getIdentification() + ": " + user.getName() + " " + user.getLastname());
                } else {
                    setText(null);
                }
            }
        });
        listEvaluators.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                EvaluatorDto evaluatorDto = (EvaluatorDto) item;
                if (evaluatorDto != null) {
                    UserDto user = evaluatorDto.getEvaluator();
                    setText(empty || item == null ? null
                            : user.getIdentification() + ": " + user.getName() + " " + user.getLastname());
                } else {
                    setText(null);
                }
                
            }
        });
        listEvaluatedFix.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                EvaluatedDto evaluatedDto = (EvaluatedDto) item;
                if (evaluatedDto != null) {
                    UserDto user = evaluatedDto.getEvaluated();
                    setText(empty || item == null ? null
                            : user.getIdentification() + ": " + user.getName() + " " + user.getLastname());
                } else {
                    setText(null);
                }
            }
        });
        listEvaluatorsFix.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                EvaluatorDto evaluatorDto = (EvaluatorDto) item;
                if (evaluatorDto != null) {
                    UserDto user = evaluatorDto.getEvaluator();
                    setText(empty || item == null ? null
                            : user.getIdentification() + ": " + user.getName() + " " + user.getLastname() + " (" + evaluatorDto.getRole() + ")");
                } else {
                    setText(null);
                }
            }
        });
        // LISTENERS
        listEvaluated.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    evaluatedBuffer = newValue;
                });
        listEvaluators.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    evaluatorBuffer = newValue;
                    if (isTheSameUserEvaluator(evaluatorBuffer)) {
                        rbSelf.setSelected(true);
                        role.getToggles().forEach(t -> {
                            if (t instanceof RadioButton) {
                                ((RadioButton) t).setDisable(true);
                            }
                        });
                    } else {
                        rbSelf.setSelected(false);
                        role.getToggles().forEach(t -> {
                            if (t instanceof RadioButton) {
                                ((RadioButton) t).setDisable(false);
                                if (((RadioButton) t).getText().equals("SELF")) {
                                    ((RadioButton) t).setDisable(true);
                                }
                            }
                        });
                    }
                });
        listEvaluatedFix.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    finalEvaluatedBuffer = newValue;
                    if (finalEvaluatedBuffer != null) {
                        listEvaluatorsFix.getItems().clear();
                        if (newValue.getEvaluators() != null) {
                            newValue.getEvaluators().forEach(t -> listEvaluatorsFix.getItems().add(t));
                        }
                    }
                });
        listEvaluatorsFix.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    finalEvaluatorBuffer = newValue;
                });
        role.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue instanceof RadioButton) {
                RadioButton selectedRadioButton = (RadioButton) newValue;
                roleBuffer = selectedRadioButton.getText();
            }
        });
    }
    
    public boolean deleteEvaluated(EvaluatedDto evaluated) {
        ResponseWrapper response = null;
        boolean evaluatorsDeleted = true;
        boolean evaluatedDeleted = true;
        for (EvaluatorDto evaluatorDto : evaluated.getEvaluators()) {
            response = evaluatorService.deleteEvaluatorById(evaluatorDto);
            evaluatorsDeleted = response.getCode() == ResponseCode.OK;
        }
        if (evaluatorsDeleted) {
            response = evaluatedService.deleteEvaluatedById(evaluated.getId());
            evaluatedDeleted = response.getCode() == ResponseCode.OK;
            return evaluatorsDeleted;
        } else {
            Message.showNotification("Error", MessageType.ERROR, "Error removing evaluators: " + response.getMessage());
        }
        return evaluatorsDeleted;
    }
    
    public boolean createEvaluated(EvaluatedDto evaluated, EvaluationDto evaluationDto) {
        ResponseWrapper response = null;
        boolean allIsSaved = false;
        evaluated.setEvaluation(evaluationDto);
        if (evaluated.getId() == null) {
            response = evaluatedService.createEvaluated(evaluated);
        }
        if (response == null || response.getCode() == ResponseCode.OK) {
            // Create Evaluator
            EvaluatedDto evaluatedDtoSaved = response == null ? evaluated : (EvaluatedDto) response.getData();
            for (EvaluatorDto evaluator : evaluated.getEvaluators()) {
                evaluator.setEvaluated(evaluatedDtoSaved);
                if (evaluator.getId() == null) {
                    response = evaluatorService.createEvaluator(evaluator);
                    if (response.getCode() == ResponseCode.OK) {
                        allIsSaved = true;
                    }
                }
            }
        }
        return allIsSaved;
    }
    
    private void setRole(EvaluatorDto evaluatorDto) {
        if (!isTheSameUserEvaluator(evaluatorDto)) {
            evaluatorDto.setRole(roleBuffer);
            return;
        }
        evaluatorDto.setRole("SELF");
    }
    
    private boolean isTheSameUserEvaluator(EvaluatorDto evaluator) {
        if (finalEvaluatedBuffer != null && evaluator != null) {
            return finalEvaluatedBuffer.getEvaluated().getId().equals(evaluator.getEvaluator().getId());
        }
        return false;
    }
    
//    private Long calculateNCalifications(SkillDto skill, List<EvaluatorDto> evaluatorDtos) {
//        Long nCalifications = Long.valueOf(0);
//        nCalifications = evaluatorDtos.stream().map(evaluatorDto -> evaluatorDto.getCalifications().stream().filter(calification -> calification.getSkill().getID() == skill.getID())).count();
//        return nCalifications;
//    }
    
    private void generateFinalCalifications(EvaluationDto evaluation) {
        Map<Long, Long> calificationBySkill = new HashMap<>();
          //Map<Long, Long> calificationBySkill = new HashMap<>();
        if (evaluation != null && evaluation.getState().equals("UNDER REVIEW")) {
            for (EvaluatedDto evaluatedDto : evaluation.getEvaluated()) {
                if (evaluatedDto.getFinalCalifications() != null && evaluatedDto.getFinalCalifications().isEmpty()) {
                    for (EvaluatorDto evaluatorDto : evaluatedDto.getEvaluators()) {
                        for (CalificationDto calificationDto : evaluatorDto.getCalifications()) {
                            fillCalificationBySkill(calificationBySkill, calificationDto.getSkill(), calificationDto);
                        }
                    }
                    for (Map.Entry<Long, Long> entry : calificationBySkill.entrySet()) {
                        FinalCalificationDto finalCalificationDto = new FinalCalificationDto();
                        Long average = entry.getValue() / evaluatedDto.getEvaluators().size();
                        //nCalification = calculateNCalifications(evaluated, evaluatorDtos)
                        finalCalificationDto.setAverage(average);
                        finalCalificationDto.setFinalNote(average);
                        finalCalificationDto.setSkill((SkillDto) skillService.getSkillById(entry.getKey()).getData());
                        finalCalificationDto.setEvaluated(evaluatedDto);
                        ResponseWrapper responseWrapper = finalCalificationService.createFinalCalification(finalCalificationDto);
                        if (responseWrapper.getCode() != ResponseCode.OK) {
                            Message.showNotification("ERROR", MessageType.ERROR, responseWrapper.getMessage());
                            return;
                        }
                    }
                    calificationBySkill.clear();
                }
            }
        }
    }
    
    private void fillCalificationBySkill(Map<Long, Long> map, SkillDto skill, CalificationDto calificationDto) {

        //
        Long valueCalification = CalificationCode.parseStringToCode(calificationDto.getCalification());
        if (!map.containsKey(skill.getID())) {
            map.put(skill.getID(), valueCalification);
            return;
        }
        
        Long newValue = map.get(skill.getID());
        map.replace(skill.getID(), newValue + valueCalification);
    }
    
}
