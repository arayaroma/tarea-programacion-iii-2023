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
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            evaluationService = new Evaluation();
            //initilizeLists();
            users = Utilities.loadUsers();
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
            if (evaluatorBuffer != null) {
                listEvaluatorsFix.getItems().remove(evaluatorBuffer);
                listEvaluatorsFix.getItems().add(evaluatorBuffer);
                finalEvaluatedBuffer.getEvaluators().add(evaluatorBuffer);
//                for (EvaluatedDto i : evaluatedDtos) {
//                    if (i.getEvaluated() == finalEvaluatedBuffer.getEvaluated()) {
//                        i.getEvaluators().add(eva);
//                        break;
//                    }
//                }
                //evaluatedDtos.get(index).getEvaluators().add(new EvaluatorWrapper(evaluatorBuffer).getDto());
            }
        } else {
            Message.showNotification("Alert", MessageType.INFO, "You must to choose a Evaluated to set the evaluators");
        }
    }

    @FXML
    private void btnDeleteEvaluator(ActionEvent event) {
        if (finalEvaluatorBuffer != null) {
            finalEvaluatedBuffer.getEvaluators().remove(finalEvaluatorBuffer);
            listEvaluatorsFix.getItems().remove(finalEvaluatorBuffer);
            //evaluatedDtos.remove(finalEvaluatedBuffer);

        }
    }

    @FXML
    private void btnAddEvaluated(ActionEvent event) {
        if (evaluatedBuffer != null) {
            listEvaluatedFix.getItems().remove(evaluatedBuffer);
            listEvaluatedFix.getItems().add(evaluatedBuffer);
            //evaluatedDtos.add(new EvaluatedWrapper(evaluatedBuffer).getDto());
        }
    }

    @FXML
    private void btnDeleteEvaluated(ActionEvent event) {
        if (finalEvaluatedBuffer != null) {
            listEvaluatedFix.getItems().remove(finalEvaluatedBuffer);
        }
    }

    @FXML
    private void searchByRoleAction(ActionEvent event) {
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
    private void deleteEvaluationAction(ActionEvent event) {
        if (evaluationBuffer != null) {
            for (EvaluatedDto evaluatedDto : evaluationBuffer.getEvaluated()) {
                for (EvaluatorDto evaluatorDto : evaluatedDto.getEvaluators()) {
                    evaluatorService.deleteEvaluatorById(evaluatorDto.getId());
                }
                evaluatedService.deleteEvaluatedById(evaluatedDto.getId());
            }
            ResponseWrapper response = evaluationService.deleteEvaluationById(evaluationBuffer.getId());
            System.out.println(response.getMessage());
            Message.showNotification(response.getCode().name(), MessageType.INFO, response.getMessage());
        }

    }

    @FXML
    private void createEvaluationAction(ActionEvent event) {
    }

    @FXML
    private void saveChangesAction(ActionEvent event) {
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
                i.setEvaluation(new EvaluationWrapper(evaluationDto).getDto());
                response = evaluatedService.createEvaluated(i);
                if (response.getCode() == ResponseCode.OK) {
                    //Create Evaluator
                    EvaluatedDto evaluatedDtoSaved = (EvaluatedDto) response.getData();
                    System.out.println(response.getMessage());
                    for (EvaluatorDto evaluator : i.getEvaluators()) {
                        evaluator.setEvaluated(new EvaluatedWrapper(evaluatedDtoSaved).getDto());
                        evaluator.setRole("PEER");
                        response = evaluatorService.createEvaluator(evaluator);
                        if (response.getCode() == ResponseCode.OK) {
                            allIsSaved = true;
                        }
                    }
                }
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
    private void searchByIdentification(KeyEvent event) {
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

            listEvaluated.getItems().addAll(users.stream().map(t -> new EvaluatedWrapper(t).getDto()).collect(Collectors.toList()));
            listEvaluators.getItems().addAll(users.stream().map(t -> new EvaluatorWrapper(t).getDto()).collect(Collectors.toList()));
        }
    }

    public void cleanView() {
        cbState.getItems().clear();
        cbRoles.getItems().clear();
        cbEvaluations.getItems().clear();
        listEvaluated.getItems().clear();
        listEvaluators.getItems().clear();
        listEvaluatorsFix.getItems().clear();
        listEvaluatedFix.getItems().clear();
    }

    public void loadFields(EvaluationDto evaluationDto) {
        txfNameEvaluation.setText(evaluationDto.getName());
        dpAplicationDate.setValue(LocalDate.parse((evaluationDto.getApplicationDate())));
        dpEndDate.setValue(LocalDate.parse((evaluationDto.getFinalPeriod())));
        dpStartDate.setValue(LocalDate.parse((evaluationDto.getInitialPeriod())));
//        listEvaluated.getItems().clear();
        //evaluationDto.getEvaluated().forEach(t->lis);
        listEvaluatedFix.getItems().clear();
        listEvaluatedFix.getItems().addAll(evaluationDto.getEvaluated());

//        evaluationDto.getEvaluated().forEach(t -> listEvaluated.getItems().add(t));
        //evaluationDto.getEvaluated().forEach(t->listEvaluatorsFix.getItems().addAll(t.getEvaluators()));
        //   evaluationDto.getEvaluated().forEach(t->);
//        evaluationDto.getEvaluated().forEach(t -> t.getEvaluators().forEach(s -> listEvaluators.getItems().add(s.getEvaluator())));
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
                    listEvaluatorsFix.getItems().clear();
                    newValue.getEvaluators().forEach(t -> listEvaluatorsFix.getItems().add(t));
                });
        listEvaluatorsFix.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    finalEvaluatorBuffer = newValue;
                });
    }

}
