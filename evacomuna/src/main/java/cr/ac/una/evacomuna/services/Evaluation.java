package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.EvaluationController;
import cr.ac.una.controller.EvaluationController_Service;
import cr.ac.una.controller.EvaluationDto;
import cr.ac.una.controller.ResponseWrapper;

/**
 *
 * @author estebannajera
 */
public class Evaluation {

    EvaluationController port;
    EvaluationController_Service service;

    public Evaluation() {
        service = new EvaluationController_Service();
        port = service.getEvaluationControllerPort();
    }

    public ResponseWrapper getEvaluations() {
        return port.getAllEvaluation();
    }

    public ResponseWrapper createEvaluation(EvaluationDto evaluationDto) {
        return port.createEvaluation(evaluationDto);
    }

    public ResponseWrapper updateEvaluation(EvaluationDto evaluationDto) {
        return port.updateEvaluation(evaluationDto);
    }

    public ResponseWrapper deleteEvaluationById(Long id) {
        return port.deleteEvaluationById(id);
    }

}
