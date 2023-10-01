package cr.ac.una.evacomuna.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import cr.ac.una.evacomunaws.controller.FinalCalificationController;
import cr.ac.una.evacomunaws.controller.FinalCalificationController_Service;
import cr.ac.una.evacomuna.dto.FinalCalificationDto;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;

/**
 * 
 * @author arayaroma
 */
public class FinalCalificationService {

	FinalCalificationController_Service service;
	FinalCalificationController port;

	/**
	 * Default instance of the service
	 */
	public FinalCalificationService() {
		service = new FinalCalificationController_Service();
		port = service.getFinalCalificationControllerPort();
	}

	/**
	 * Create a new finalCalification
	 * 
	 * @param finalCalificationDto finalCalification to create
	 * @return ResponseWrapper with the response of the request
	 */
	public ResponseWrapper createFinalCalification(cr.ac.una.evacomuna.dto.FinalCalificationDto finalCalificationDto) {
		try {
			cr.ac.una.evacomunaws.controller.ResponseWrapper response = port
					.createFinalCalification(finalCalificationDto.getDto());
			cr.ac.una.evacomunaws.controller.FinalCalificationDto finalCalification = (cr.ac.una.evacomunaws.controller.FinalCalificationDto) response
					.getData();
			finalCalificationDto = new FinalCalificationDto(finalCalification);
			return new cr.ac.una.evacomuna.util.ResponseWrapper(
					ResponseCode.OK.getCode(),
					ResponseCode.OK,
					"FinalCalification created successfully",
					finalCalificationDto.convertFromGeneratedToDTO(finalCalification, finalCalificationDto));
		} catch (Exception e) {
			return new ResponseWrapper(
					ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
					ResponseCode.INTERNAL_SERVER_ERROR,
					"Error creating finalCalification",
					null);
		}
	}

	/**
	 * Get a finalCalification by id
	 * 
	 * @param id of the finalCalification
	 * @return ResponseWrapper with the response of the request
	 */
	public ResponseWrapper getFinalCalificationById(Long id) {
		try {
			cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getFinalCalificationById(id);
			cr.ac.una.evacomunaws.controller.FinalCalificationDto finalCalification = (cr.ac.una.evacomunaws.controller.FinalCalificationDto) response
					.getData();
			FinalCalificationDto finalCalificationDto = new FinalCalificationDto(finalCalification);
			return new ResponseWrapper(
					ResponseCode.OK.getCode(),
					ResponseCode.OK,
					"FinalCalification found",
					finalCalificationDto.convertFromGeneratedToDTO(finalCalification, finalCalificationDto));
		} catch (Exception e) {
			return new ResponseWrapper(
					ResponseCode.NOT_FOUND.getCode(),
					ResponseCode.NOT_FOUND,
					"FinalCalification not found",
					null);
		}
	}

	/**
	 * Get a finalCalification by note
	 * 
	 * @param id of the finalCalification
	 * @return ResponseWrapper with the response of the request
	 */
	public ResponseWrapper getFinalCalificationByNote(Long id) {
		try {
			cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getFinalCalificationNote(id);
			cr.ac.una.evacomunaws.controller.FinalCalificationDto finalCalification = (cr.ac.una.evacomunaws.controller.FinalCalificationDto) response
					.getData();
			FinalCalificationDto finalCalificationDto = new FinalCalificationDto(finalCalification);
			return new ResponseWrapper(
					ResponseCode.OK.getCode(),
					ResponseCode.OK,
					"FinalCalification found",
					finalCalificationDto.convertFromGeneratedToDTO(finalCalification, finalCalificationDto));
		} catch (Exception e) {
			return new ResponseWrapper(
					ResponseCode.NOT_FOUND.getCode(),
					ResponseCode.NOT_FOUND,
					"FinalCalification not found",
					null);
		}
	}

	/**
	 * Get a finalCalification by average
	 * 
	 * @param id of the finalCalification
	 * @return ResponseWrapper with the response of the request
	 */
	public ResponseWrapper getFinalCalificationByAverage(Long id) {
		try {
			cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getAverage(id);
			cr.ac.una.evacomunaws.controller.FinalCalificationDto finalCalification = (cr.ac.una.evacomunaws.controller.FinalCalificationDto) response
					.getData();
			FinalCalificationDto finalCalificationDto = new FinalCalificationDto(finalCalification);
			return new ResponseWrapper(
					ResponseCode.OK.getCode(),
					ResponseCode.OK,
					"FinalCalification found",
					finalCalificationDto.convertFromGeneratedToDTO(finalCalification, finalCalificationDto));
		} catch (Exception e) {
			return new ResponseWrapper(
					ResponseCode.NOT_FOUND.getCode(),
					ResponseCode.NOT_FOUND,
					"FinalCalification not found",
					null);
		}
	}

	/**
	 * Get a list of finalCalifications
	 * 
	 * @return ResponseWrapper with the response of the request
	 */
	public ResponseWrapper getAllFinalCalifications() {
		try {
			cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getAllFinalCalification();
			cr.ac.una.evacomunaws.controller.ListWrapper listWrapper = (cr.ac.una.evacomunaws.controller.ListWrapper) response
					.getData();
			List<cr.ac.una.evacomunaws.controller.FinalCalificationDto> listGenerated = new ArrayList<>();
			List<FinalCalificationDto> listDto = listWrapper
					.getElement()
					.stream()
					.filter(i -> i instanceof cr.ac.una.evacomunaws.controller.FinalCalificationDto)
					.map(i -> {
						cr.ac.una.evacomunaws.controller.FinalCalificationDto finalCalificationDto = (cr.ac.una.evacomunaws.controller.FinalCalificationDto) i;
						listGenerated.add(finalCalificationDto);
						FinalCalificationDto finalCalificationDtoClient = new FinalCalificationDto(
								finalCalificationDto);
						return finalCalificationDtoClient.convertFromGeneratedToDTO(finalCalificationDto,
								finalCalificationDtoClient);
					})
					.collect(Collectors.toList());

			return new ResponseWrapper(
					ResponseCode.OK.getCode(),
					ResponseCode.OK,
					"FinalCalifications found",
					listDto);
		} catch (Exception e) {
			return new ResponseWrapper(
					ResponseCode.NOT_FOUND.getCode(),
					ResponseCode.NOT_FOUND,
					"FinalCalifications not found",
					null);
		}
	}

	/**
	 * Update a finalCalification
	 * 
	 * @param finalCalificationDto finalCalification to update
	 * @return ResponseWrapper with the response of the request
	 */
	public ResponseWrapper updateFinalCalification(cr.ac.una.evacomuna.dto.FinalCalificationDto finalCalificationDto) {
		try {
			cr.ac.una.evacomunaws.controller.ResponseWrapper response = port
					.updateFinalCalification(finalCalificationDto.getDto());
			cr.ac.una.evacomunaws.controller.FinalCalificationDto finalCalification = (cr.ac.una.evacomunaws.controller.FinalCalificationDto) response
					.getData();
			finalCalificationDto = new FinalCalificationDto(finalCalification);
			return new ResponseWrapper(
					ResponseCode.OK.getCode(),
					ResponseCode.OK,
					"FinalCalification updated successfully",
					finalCalificationDto.convertFromGeneratedToDTO(finalCalification, finalCalificationDto));
		} catch (Exception e) {
			return new ResponseWrapper(
					ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
					ResponseCode.INTERNAL_SERVER_ERROR,
					"Error updating finalCalification",
					null);
		}
	}

	/**
	 * Delete a finalCalification
	 * 
	 * @param id of the finalCalification to delete
	 * @return ResponseWrapper with the response of the request
	 */
	public ResponseWrapper deleteFinalCalificationById(Long id) {
		try {
			cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.deleteFinalCalificationById(id);
			return new ResponseWrapper(
					ResponseCode.OK.getCode(),
					ResponseCode.OK,
					"FinalCalification deleted successfully",
					response.getData());
		} catch (Exception e) {
			return new ResponseWrapper(
					ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
					ResponseCode.INTERNAL_SERVER_ERROR,
					"Error deleting finalCalification",
					null);
		}
	}
}
