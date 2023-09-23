package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.EvaluatedController;
import cr.ac.una.controller.EvaluatedController_Service;
import cr.ac.una.controller.EvaluatedDto;
import cr.ac.una.controller.ResponseWrapper;

/**
 *
 * @author estebannajera
 */
public class Evaluated {

    private EvaluatedController port;
    private EvaluatedController_Service service;

    public Evaluated() {
        service = new EvaluatedController_Service();
        port = service.getEvaluatedControllerPort();
    }

    public ResponseWrapper createEvaluated(EvaluatedDto evaluatedDto) {
        return port.createEvaluated(evaluatedDto);
    }

    public ResponseWrapper updateEvaluated(EvaluatedDto evaluatedDto) {
        return port.updateEvaluated(evaluatedDto);
    }

    public ResponseWrapper deleteEvaluatedById(Long id) {
        return port.deleteEvaluatedById(id);
    }

}
