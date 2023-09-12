package cr.ac.una.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import cr.ac.una.dto.CharacteristicDto;
import cr.ac.una.dto.SkillDto;
import cr.ac.una.services.CharacteristicService;
import cr.ac.una.util.ResponseCode;
import cr.ac.una.util.ResponseWrapper;

/**
 * 
 * @author arayaroma
 */
@DisplayName("Characteristic Controller Tests")
public class CharacteristicControllerTest {
    @Mock
    CharacteristicService characteristicService;

    @BeforeEach
    public void setUp() {
        characteristicService = mock(CharacteristicService.class);
    }

    @Test
    @DisplayName("Test createCharacteristic - Successful Characteristic Creation")
    public void createCharacteristic() {
        // Arrange
        CharacteristicDto characteristicTest = createTestCharacteristic("test");

        // Act
        when(characteristicService.createCharacteristic(characteristicTest)).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Characteristic created successfully.",
                        characteristicTest));

        // Assert
        ResponseWrapper response = characteristicService.createCharacteristic(characteristicTest);
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(characteristicTest, response.getData());
    }

    private CharacteristicDto createTestCharacteristic(String name) {
        CharacteristicDto characteristicTest = new CharacteristicDto();
        characteristicTest.setName(name);
        return characteristicTest;
    }

    @Test
    @DisplayName("Test updateCharacteristic - Successful Characteristic Update")
    public void updateCharacteristic() {
        // Arrange
        CharacteristicDto characteristicTest = createTestCharacteristic("test");

        // Act
        when(characteristicService.updateCharacteristic(characteristicTest)).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Characteristic updated successfully.",
                        characteristicTest));

        // Assert
        ResponseWrapper response = characteristicService.updateCharacteristic(characteristicTest);
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(characteristicTest, response.getData());
    }

    @Test
    @DisplayName("Test getCharacteristicById - Successful Characteristic Search")
    public void getCharacteristicById() {
        // Arrange
        CharacteristicDto characteristicTest = createTestCharacteristic("test");

        // Act
        when(characteristicService.getCharacteristicById(1L)).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Characteristic retrieved successfully.",
                        characteristicTest));
        // Assert
        ResponseWrapper response = characteristicService.getCharacteristicById(1L);
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(characteristicTest, response.getData());
    }

    @Test
    @DisplayName("Test getCharacteristicByName - Successful Characteristic Search")
    public void getCharacteristicByName() {
        // Arrange
        CharacteristicDto characteristicTest = createTestCharacteristic("test");

        // Act
        when(characteristicService.getCharacteristicByName("test")).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Characteristic retrieved successfully.",
                        characteristicTest));
        // Assert
        ResponseWrapper response = characteristicService.getCharacteristicByName("test");
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(characteristicTest, response.getData());
    }

    @Test
    @DisplayName("Test getCharacteristics - Successful Characteristic Search")
    public void getCharacteristics() {
        // Act
        when(characteristicService.getCharacteristics()).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Characteristics retrieved successfully.",
                        new ArrayList<CharacteristicDto>()));
        // Assert
        ResponseWrapper response = characteristicService.getCharacteristics();
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(new ArrayList<CharacteristicDto>(), response.getData());
    }

    @Test
    @DisplayName("Test deleteCharacteristicById - Successful Characteristic Deletion")
    public void deleteCharacteristicById() {
        // Act
        when(characteristicService.deleteCharacteristicById(1L)).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Characteristic deleted successfully.",
                        null));
        // Assert
        ResponseWrapper response = characteristicService.deleteCharacteristicById(1L);
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(null, response.getData());
    }

    @Test
    @DisplayName("Test deleteCharacteristicByName - Successful Characteristic Deletion")
    public void deleteCharacteristicByName() {
        // Act
        when(characteristicService.deleteCharacteristicByName("test")).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Characteristic deleted successfully.",
                        null));
        // Assert
        ResponseWrapper response = characteristicService.deleteCharacteristicByName("test");
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(null, response.getData());
    }

    @Test
    @DisplayName("Test deleteAllCharacteristics - Successful Characteristic Deletion")
    public void deleteAllCharacteristics() {
        // Act
        when(characteristicService.deleteAllCharacteristics()).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Characteristics deleted successfully.",
                        null));
        // Assert
        ResponseWrapper response = characteristicService.deleteAllCharacteristics();
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(null, response.getData());
    }
}
