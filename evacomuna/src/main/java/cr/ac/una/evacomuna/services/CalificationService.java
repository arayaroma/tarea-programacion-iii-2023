package cr.ac.una.evacomuna.services;

import java.util.ArrayList;
import java.util.stream.Collectors;
import cr.ac.una.evacomunaws.controller.CalificationController;
import cr.ac.una.evacomunaws.controller.CalificationController_Service;
import cr.ac.una.evacomuna.dto.CalificationDto;
import cr.ac.una.evacomuna.util.ResponseWrapper;
import cr.ac.una.evacomunaws.controller.ResponseCode;

/**
 *
 * @author arayaroma
 */
public class CalificationService {

    CalificationController_Service service;
    CalificationController port;

    /**
     * Default instance of the service
     */
    public CalificationService() {
        service = new CalificationController_Service();
        port = service.getCalificationControllerPort();
    }

    /**
     * Create a new calification
     *
     * @param calificationDto calification to create
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper createCalification(CalificationDto calificationDto) {
        try {
            cr.ac.una.evacomunaws.controller.CalificationDto entity = calificationDto.getDto();
            entity = calificationDto.convertFromDTOToGenerated(calificationDto, entity);
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.createCalification(entity);
            cr.ac.una.evacomunaws.controller.CalificationDto calification = (cr.ac.una.evacomunaws.controller.CalificationDto) response
                    .getData();
            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.OK.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.OK,
                    "Calification created successfully",
                    new CalificationDto(calification));
        } catch (Exception e) {
            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating calification",
                    null);
        }
    }

    /**
     * Get a calification by id
     *
     * @param id of the calification
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getCalificationById(Long id) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getCalificationById(id);
            cr.ac.una.evacomunaws.controller.CalificationDto calification = (cr.ac.una.evacomunaws.controller.CalificationDto) response
                    .getData();
            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.OK.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.OK,
                    "Calification found",
                    new CalificationDto(calification));
        } catch (Exception e) {
            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.NOT_FOUND.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.NOT_FOUND,
                    "Error getting calification",
                    null);
        }
    }

    /**
     * Get calification note
     *
     * @param id of the calification
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getCalificationNoteById(Long id) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getCalificationNote(id);
            cr.ac.una.evacomunaws.controller.CalificationDto calification = (cr.ac.una.evacomunaws.controller.CalificationDto) response
                    .getData();
            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.OK.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.OK,
                    "Calification found",
                    new CalificationDto(calification));
        } catch (Exception e) {
            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.NOT_FOUND.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.NOT_FOUND,
                    "Error getting calification",
                    null);
        }
    }

    /**
     * Get all califications
     *
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getAllCalification() {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getAllCalification();
            cr.ac.una.evacomunaws.controller.ListWrapper listWrapper = (cr.ac.una.evacomunaws.controller.ListWrapper) response.getData();
            java.util.List<cr.ac.una.evacomunaws.controller.CalificationDto> listGenerated = new ArrayList<>();
            java.util.List<CalificationDto> listDto = listWrapper
                    .getElement()
                    .stream()
                    .filter(i -> i instanceof cr.ac.una.evacomunaws.controller.CalificationDto)
                    .map(i -> {
                        cr.ac.una.evacomunaws.controller.CalificationDto calificationDto = (cr.ac.una.evacomunaws.controller.CalificationDto) i;
                        listGenerated.add(calificationDto);
                        CalificationDto calificationDtoClient = new CalificationDto(calificationDto);
                        return calificationDtoClient.convertFromGeneratedToDTO(calificationDto, calificationDtoClient);
                    })
                    .collect(Collectors.toList());

            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.OK.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.OK,
                    "Califications found",
                    listDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error getting califications",
                    null);
        }
    }

    /**
     * Update a calification
     *
     * @param calificationDto calification to update
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper updateCalification(CalificationDto calificationDto) {
        try {
            cr.ac.una.evacomunaws.controller.CalificationDto entity = calificationDto.getDto();
            entity = calificationDto.convertFromDTOToGenerated(calificationDto, entity);
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.updateCalification(entity);
            cr.ac.una.evacomunaws.controller.CalificationDto calification = (cr.ac.una.evacomunaws.controller.CalificationDto) response
                    .getData();
            calificationDto = new CalificationDto(calification);
            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.OK.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.OK,
                    "Calification updated successfully",
                    calificationDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating calification",
                    null);
        }
    }

    /**
     * Delete a calification
     *
     * @param id of the calification
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper deleteCalificationById(Long id) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.deleteCalificationById(id);
            if (response.getCode() == ResponseCode.OK) {
                return new ResponseWrapper(
                        cr.ac.una.evacomuna.util.ResponseCode.OK.getCode(),
                        cr.ac.una.evacomuna.util.ResponseCode.OK,
                        "Calification deleted successfully",
                        response.getData());
            }
            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error removing calification: " + response.getMessage(),
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error removing calification",
                    null);
        }
    }

}
