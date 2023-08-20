package cr.ac.una.services.impl;

import cr.ac.una.dto.PositionDto;
import cr.ac.una.repositories.PositionRepository;
import cr.ac.una.services.PositionService;
import cr.ac.una.util.Response;
import cr.ac.una.util.ResponseCode;
import jakarta.inject.Inject;
import jakarta.jws.WebService;

@WebService(serviceName = "PositionService")
public class PositionServiceImpl implements PositionService {

    @Inject
    private PositionRepository positionRepository;

    @Override
    public Response createPosition(PositionDto position) {
        try {
            positionRepository.createPosition(position);
            return new Response(true,
                    ResponseCode.OK,
                    "Position created successfully.",
                    position);
        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while creating position.",
                    null);
        }
    }

    @Override
    public Response getPositionById(Long id) {
        try {
            Response response = positionRepository.getPositionById(id);
            if (response.getState()) {
                return new Response(true,
                        ResponseCode.OK,
                        "Position retrieved successfully.",
                        response.getData());
            } else {
                return new Response(false,
                        ResponseCode.NOT_FOUND,
                        "Position not found.",
                        null);
            }
        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while getting position by ID.",
                    null);
        }
    }

    @Override
    public Response updatePositionById(Long id, PositionDto position) {
        try {
            Response response = positionRepository.getPositionById(id);
            if (response.getState()) {
                positionRepository.updatePositionById(id, position);
                return new Response(true,
                        ResponseCode.OK,
                        "Position updated successfully.",
                        position);
            } else {
                return new Response(false,
                        ResponseCode.NOT_FOUND,
                        "Position not found.",
                        null);
            }
        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while updating position by ID.",
                    null);
        }
    }

    @Override
    public Response deletePositionById(Long id) {
        try {
            Response response = positionRepository.getPositionById(id);
            if (response.getState()) {
                positionRepository.deletePositionById(id);
                return new Response(true,
                        ResponseCode.OK,
                        "Position deleted successfully.",
                        null);
            } else {
                return new Response(false,
                        ResponseCode.NOT_FOUND,
                        "Position not found.",
                        null);
            }
        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting position by ID.",
                    null);
        }
    }
}
