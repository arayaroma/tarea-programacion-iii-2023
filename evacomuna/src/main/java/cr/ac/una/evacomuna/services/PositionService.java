package cr.ac.una.evacomuna.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import cr.ac.una.evacomunaws.controller.PositionController;
import cr.ac.una.evacomunaws.controller.PositionController_Service;
import cr.ac.una.evacomuna.dto.PositionDto;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public class PositionService {

    private PositionController_Service service;
    private PositionController port;

    /**
     * Default instance of the service
     */
    public PositionService() {
        service = new PositionController_Service();
        port = service.getPositionControllerPort();

    }

    /**
     * Creates a new position
     *
     * @param position to create
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper createPosition(PositionDto position) {
        try {
            cr.ac.una.evacomunaws.controller.PositionDto entity = position.getDto();
            entity = position.convertFromDTOToGenerated(position, entity);
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.createPosition(entity);
            cr.ac.una.evacomunaws.controller.PositionDto positionDto = (cr.ac.una.evacomunaws.controller.PositionDto) response
                    .getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position created successfully",
                    new PositionDto(positionDto));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating position",
                    null);
        }
    }

    /**
     * Get all positions
     *
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getPositions() {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getPositions();
            cr.ac.una.evacomunaws.controller.ListWrapper listWrapper = (cr.ac.una.evacomunaws.controller.ListWrapper) response
                    .getData();
            List<cr.ac.una.evacomunaws.controller.PositionDto> listGenerated = new ArrayList<>();
            List<PositionDto> listDto = listWrapper
                    .getElement()
                    .stream()
                    .filter(i -> i instanceof cr.ac.una.evacomunaws.controller.PositionDto)
                    .map(i -> {
                        cr.ac.una.evacomunaws.controller.PositionDto position = (cr.ac.una.evacomunaws.controller.PositionDto) i;
                        listGenerated.add(position);
                        PositionDto positionDto = new PositionDto(position);
                        return positionDto.convertFromGeneratedToDTO(position, positionDto);
                    })
                    .collect(Collectors.toList());

            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Positions found successfully",
                    listDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Positions not found",
                    null);
        }
    }

    /**
     * Get position by name
     *
     * @param name of the position
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getPositionByName(String name) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getPositionByName(name);
            cr.ac.una.evacomunaws.controller.PositionDto position = (cr.ac.una.evacomunaws.controller.PositionDto) response
                    .getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position found successfully",
                    new PositionDto(position).convertFromGeneratedToDTO(position, new PositionDto(position)));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Position not found",
                    null);
        }
    }

    /**
     * Get position by id
     *
     * @param id of the position
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper updatePositionById(Long id) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.updatePositionById(id);
            if (response.getCode() == cr.ac.una.evacomunaws.controller.ResponseCode.OK) {
                cr.ac.una.evacomunaws.controller.PositionDto position = (cr.ac.una.evacomunaws.controller.PositionDto) response
                        .getData();
                return new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Position found successfully",
                        new PositionDto(position));
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Error updating position: " + response.getMessage(),
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Position not found",
                    null);
        }
    }

    /**
     * Update a position
     *
     * @param position to update
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper updatePosition(PositionDto position) {
        try {
            cr.ac.una.evacomunaws.controller.PositionDto entity = position.getDto();
            entity = position.convertFromDTOToGenerated(position, entity);

            // positionDto = position.convertFromDTOToGenerated(position,
            // positionDto);//ERROR AQUI. NO CONVIERTE LAS LISTAS
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.updatePosition(entity);
            entity = (cr.ac.una.evacomunaws.controller.PositionDto) response.getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position updated successfully",
                    position.convertFromGeneratedToDTO(entity, position));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating position",
                    null);
        }
    }

    /**
     * Delete a position by id
     *
     * @param id of the position
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper deletePositionById(Long id) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.deletePositionById(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position deleted successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error deleting position",
                    null);
        }
    }

}
