package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.EvaluatorController;
import cr.ac.una.controller.EvaluatorController_Service;
import cr.ac.una.controller.EvaluatorDto;
import cr.ac.una.controller.ResponseWrapper;

/**
 *
 * @author estebannajera
 */
public class Evaluator {

    private EvaluatorController port;
    private EvaluatorController_Service service;

    public Evaluator() {
        service = new EvaluatorController_Service();
        port = service.getEvaluatorControllerPort();
    }

    public ResponseWrapper createEvaluator(EvaluatorDto evaluatorDto) {
        return port.createEvaluator(evaluatorDto);
    }

    public ResponseWrapper updateEvaluator(EvaluatorDto evaluatorDto) {
        return port.updateEvaluator(evaluatorDto);
    }

    public ResponseWrapper updateEvaluatorById(Long id) {
        return port.deleteEvaluatorById(id);
    }
}
