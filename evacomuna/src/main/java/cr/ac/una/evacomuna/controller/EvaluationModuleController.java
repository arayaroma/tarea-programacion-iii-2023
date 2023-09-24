package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.EvaluatedDto;
import cr.ac.una.controller.EvaluationDto;
import cr.ac.una.controller.EvaluatorDto;
import cr.ac.una.controller.PositionDto;
import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.UserDto;
import cr.ac.una.evacomuna.dto.EvaluatedWrapper;
import cr.ac.una.evacomuna.dto.EvaluationWrapper;
import cr.ac.una.evacomuna.dto.EvaluatorWrapper;
import cr.ac.una.evacomuna.services.Evaluated;
import cr.ac.una.evacomuna.services.Evaluation;
import cr.ac.una.evacomuna.services.Evaluator;
import cr.ac.una.evacomuna.services.Position;

import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.Utilities;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TextField;
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

    private Evaluation evaluationService;
    private EvaluationDto evaluationBuffer;
    private EvaluatedDto evaluatedBuffer;
    private EvaluatorDto evaluatorBuffer;
    private EvaluatedDto finalEvaluatedBuffer;
    private EvaluatorDto finalEvaluatorBuffer;
    private List<UserDto> users;
    private ObservableList<EvaluationDto> evaluationDtos;
    private Position roleService = new Position();
    private Evaluated evaluatedService = new Evaluated();
    private Evaluator evaluatorService = new Evaluator();
    private List<EvaluatorDto> evaluatorDtos = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            evaluationService = new Evaluation();
            //initilizeLists();
            users = Utilities.loadUsers();
            btnSave.setDisable(true);
            //initializeView();
            initializeView();
        } catch (Exception e) {

            System.out.println(e.toString());
        }
        initilizeLists();

    }

    @FXML
    private void btnAddEvaluator(ActionEvent event) {
        if (finalEvaluatedBuffer != null) {
            if (evaluatorBuffer != null && !listEvaluatorsFix.getItems().stream().anyMatch(t -> t.getId() != null && t.getEvaluator().getId() == evaluatorBuffer.getId())) {
                listEvaluatorsFix.getItems().remove(evaluatedBuffer);
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
                ResponseWrapper responseWrapper = evaluatorService.deleteEvaluatorById(finalEvaluatorBuffer.getId());
                System.out.println(responseWrapper.getMessage());
            }
            finalEvaluatedBuffer.getEvaluators().remove(finalEvaluatorBuffer);
            listEvaluatorsFix.getItems().remove(finalEvaluatorBuffer);

        }
    }

    @FXML
    private void btnAddEvaluated(ActionEvent event) {
        if (evaluatedBuffer != null && !listEvaluatedFix.getItems().stream().anyMatch(t -> t.getId() != null && t.getEvaluated().getId() == evaluatedBuffer.getId())) {

            //if(listEvaluatedFix.getItems().stream().anyMatch(t->t.getId() ==))
            listEvaluatedFix.getItems().remove(evaluatedBuffer);
            listEvaluatedFix.getItems().add(evaluatedBuffer);
        }
    }

    @FXML
    private void btnDeleteEvaluated(ActionEvent event
    ) {
        if (finalEvaluatedBuffer != null) {
            if (evaluationBuffer != null) {
                deleteEvaluated(finalEvaluatedBuffer);
            }
            listEvaluatedFix.getItems().remove(finalEvaluatedBuffer);
            listEvaluatorsFix.getItems().clear();

        }
    }

    @FXML
    private void searchByRoleAction(ActionEvent event
    ) {
        String name = cbRoles.getValue();
        if (name != null) {
            PositionDto role = (PositionDto) roleService.getRoleByName(name).getData();
            if (role != null && role.getUsers() != null) {
                listEvaluated.getItems().clear();
                listEvaluated.getItems().addAll(role.getUsers().stream().map(t -> new EvaluatedWrapper(t).getDto()).collect(Collectors.toList()));
            }
        }
    }

    @FXML
    private void deleteEvaluationAction(ActionEvent event
    ) {
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
    private void createEvaluationAction(ActionEvent event
    ) {
        if (evaluationBuffer != null) {
            if (Message.showConfirmationAlert("Clean", Alert.AlertType.CONFIRMATION, "Do you wish clean the fields?") == ButtonType.OK) {
                cleanView();
                initializeView();
            }
            return;
        }
        String name = txfNameEvaluation.getText(), state = cbState.getValue();
        LocalDate initialDate = dpStartDate.getValue(), endingDate = dpEndDate.getValue(), aplicationDate = dpAplicationDate.getValue();
        if (name.isBlank() || state == null || initialDate == null || endingDate == null || aplicationDate == null) {
            Message.showNotification("Ups", MessageType.INFO, "All the fields are required");
            return;
        }
        //Create Evaluation
        EvaluationWrapper evaluationWrapper = new EvaluationWrapper(null, name, aplicationDate, initialDate, endingDate, state);
        EvaluationDto evaluationDto = evaluationWrapper.getDto();
        ResponseWrapper response = evaluationService.createEvaluation(evaluationDto);
        boolean allIsSaved = false;
        if (response.getCode() == ResponseCode.OK) {
            //Create evaluated
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
    }

    @FXML
    private void saveChangesAction(ActionEvent event
    ) {
        String name = txfNameEvaluation.getText(), state = cbState.getValue();
        LocalDate initialDate = dpStartDate.getValue(), endingDate = dpEndDate.getValue(), aplicationDate = dpAplicationDate.getValue();
        if (name.isBlank() || state == null || initialDate == null || endingDate == null || aplicationDate == null) {
            Message.showNotification("Ups", MessageType.INFO, "All the fields are required");
            return;
        }
        EvaluationDto evaluationDto;
        //Create Evaluation
        evaluationBuffer.setApplicationDate(aplicationDate.toString());
        evaluationBuffer.setFinalPeriod(endingDate.toString());
        evaluationBuffer.setInitialPeriod(initialDate.toString());
        evaluationBuffer.setName(name);
        evaluationBuffer.setState(state);

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
            listEvaluators.getItems().addAll(evaluatorDtos.stream().filter(t -> t.getEvaluator().getIdentification().contains(identificationToSearch)).collect(Collectors.toList()));
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
    private void searchEvaluationInput(KeyEvent event
    ) {
        if (event.getCode().isLetterKey()) {
            String nameToSearch = cbEvaluations.getEditor().getText();
            if (nameToSearch != null) {
                cbEvaluations.getItems().clear();
                if (nameToSearch.length() > 2) {
                    cbEvaluations.getItems().addAll(evaluationDtos.stream().filter(t -> t.getName().contains(nameToSearch)).map(t -> t.getName()).collect(Collectors.toList()));
                    return;
                }
                cbEvaluations.getItems().addAll(Utilities.mapListToObsevableString(evaluationDtos));
                cbEvaluations.show();
            }
        }
    }

    public void initializeView() {
        cbState.getItems().addAll("UNDER CONSTRUCTION", "IN APPLICATION", "UNDER REVIEW", "COMPLETED");
        cbRoles.getItems().addAll(Utilities.mapListToObsevableString(Utilities.loadPositions()));
        evaluationDtos = Utilities.loadEvaluations();
        cbEvaluations.getItems().addAll(Utilities.mapListToObsevableString(evaluationDtos));
        if (users != null) {
            evaluatorDtos = users.stream().map(t -> new EvaluatorWrapper(t).getDto()).collect(Collectors.toList());
            listEvaluated.getItems().addAll(users.stream().map(t -> new EvaluatedWrapper(t).getDto()).collect(Collectors.toList()));
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
        dpAplicationDate.setValue(LocalDate.parse((evaluationDto.getApplicationDate())));
        dpEndDate.setValue(LocalDate.parse((evaluationDto.getFinalPeriod())));
        dpStartDate.setValue(LocalDate.parse((evaluationDto.getInitialPeriod())));
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
                    setText(empty || item == null ? null : user.getIdentification() + ": " + user.getName() + " " + user.getLastname());
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
                    setText(empty || item == null ? null : user.getIdentification() + ": " + user.getName() + " " + user.getLastname());
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
                    setText(empty || item == null ? null : user.getIdentification() + ": " + user.getName() + " " + user.getLastname());
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
                    setText(empty || item == null ? null : user.getIdentification() + ": " + user.getName() + " " + user.getLastname());
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
                });
        listEvaluatedFix.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    finalEvaluatedBuffer = newValue;
                    if (finalEvaluatedBuffer != null) {
                        listEvaluatorsFix.getItems().clear();
                        newValue.getEvaluators().forEach(t -> listEvaluatorsFix.getItems().add(t));
                    }
                });
        listEvaluatorsFix.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    finalEvaluatorBuffer = newValue;
                });
    }

    public boolean deleteEvaluated(EvaluatedDto evaluated) {
        ResponseWrapper response = null;
        boolean evaluatorsDeleted = true;
        boolean evaluatedDeleted = true;
        for (EvaluatorDto evaluatorDto : evaluated.getEvaluators()) {
            response = evaluatorService.deleteEvaluatorById(evaluatorDto.getId());
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
        evaluated.setEvaluation(new EvaluationWrapper(evaluationDto).getDto());
        if (evaluated.getId() == null) {
            response = evaluatedService.createEvaluated(evaluated);
        }
        if (response == null || response.getCode() == ResponseCode.OK) {
            //Create Evaluator
            EvaluatedDto evaluatedDtoSaved = response == null ? evaluated : (EvaluatedDto) response.getData();
            for (EvaluatorDto evaluator : evaluated.getEvaluators()) {
                evaluator.setEvaluated(new EvaluatedWrapper(evaluatedDtoSaved).getDto());
                evaluator.setRole("PEER");
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
        if (evaluatorDto.getEvaluator().getId() == evaluatorDto.getId()) {
            evaluatorDto.setRole("SELF");
        } else if (evaluatorDto.getEvaluator().getIsAdmin() == "Y") {
            evaluatorDto.setRole("SUPERVISOR");
        } else {
            evaluatorDto.setRole("PEER");
        }
    }

}
