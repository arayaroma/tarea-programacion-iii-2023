package cr.ac.una.evacomuna.services;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.stream.Collectors;
import cr.ac.una.controller.CalificationController;
import cr.ac.una.controller.CalificationController_Service;
import cr.ac.una.evacomuna.dto.CalificationDto;
import cr.ac.una.evacomuna.util.ResponseWrapper;

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
=======
import cr.ac.una.controller.CalificationController_Service;
import cr.ac.una.controller.CalificationController;
import cr.ac.una.controller.CalificationDto;
import cr.ac.una.controller.ResponseWrapper;

/**
 *
 * @author estebannajera
 */
public class CalificationService {

    private CalificationController_Service service;
    private CalificationController port;

>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
    public CalificationService() {
        service = new CalificationController_Service();
        port = service.getCalificationControllerPort();
    }

<<<<<<< HEAD
    /**
     * Create a new calification
     * 
     * @param calificationDto calification to create
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper createCalification(CalificationDto calificationDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.createCalification(calificationDto.getDto());
            cr.ac.una.controller.CalificationDto calification = (cr.ac.una.controller.CalificationDto) response
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
            cr.ac.una.controller.ResponseWrapper response = port.getCalificationById(id);
            cr.ac.una.controller.CalificationDto calification = (cr.ac.una.controller.CalificationDto) response
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
            cr.ac.una.controller.ResponseWrapper response = port.getCalificationNote(id);
            cr.ac.una.controller.CalificationDto calification = (cr.ac.una.controller.CalificationDto) response
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
            cr.ac.una.controller.ResponseWrapper response = port.getAllCalification();
            cr.ac.una.controller.ListWrapper listWrapper = (cr.ac.una.controller.ListWrapper) response.getData();
            java.util.List<cr.ac.una.controller.CalificationDto> listGenerated = new ArrayList<>();
            java.util.List<CalificationDto> listDto = listWrapper
                    .getElement()
                    .stream()
                    .filter(i -> i instanceof cr.ac.una.controller.CalificationDto)
                    .map(i -> {
                        cr.ac.una.controller.CalificationDto calificationDto = (cr.ac.una.controller.CalificationDto) i;
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
            cr.ac.una.controller.ResponseWrapper response = port.updateCalification(calificationDto.getDto());
            cr.ac.una.controller.CalificationDto calification = (cr.ac.una.controller.CalificationDto) response
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
            cr.ac.una.controller.ResponseWrapper response = port.deleteCalificationById(id);
            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.OK.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.OK,
                    "Calification deleted successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    cr.ac.una.evacomuna.util.ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    cr.ac.una.evacomuna.util.ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error deleting calification",
                    null);
        }
    }

}
=======
    public ResponseWrapper createCalification(CalificationDto calificationDto) {
        return port.createCalification(calificationDto);
    }

    public ResponseWrapper updateCalification(CalificationDto calificationDto) {
        return port.updateCalification(calificationDto);
    }

    public ResponseWrapper deleteByIdCalification(Long id) {
        return port.deleteCalificationById(id);
    }

    public ResponseWrapper getCalifications() {
        return port.getAllCalification();
    }

}
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
