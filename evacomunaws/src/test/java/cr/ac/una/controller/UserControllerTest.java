package cr.ac.una.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cr.ac.una.dto.UserDto;
import cr.ac.una.services.UserService;
import cr.ac.una.util.ResponseCode;
import cr.ac.una.util.ResponseWrapper;

/**
 * 
 * @author arayaroma
 */

@DisplayName("User Controller Tests")
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Disabled
    @DisplayName("Test activateUser - Successful User Activation")
    public void activateUser() {
        // Arrange
        Long userId = 2L;
        UserDto userDto = new UserDto();
        userDto.setId(userId);

        // Act
        when(userService.getUserById(userId)).thenReturn(new ResponseWrapper(
                ResponseCode.OK.getCode(),
                ResponseCode.OK,
                "User activated successfully.",
                userDto));

        // Assert
    }

    @Test
    @DisplayName("Test createUser - Successful User Creation")
    public void createUser() {
        // Arrange
        UserDto userTest = createTestUser();

        // Act
        when(userService.createUser(userTest)).thenReturn(
                new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "User created successfully.",
                        userTest));

        // Assert
        ResponseWrapper response = userService.createUser(userTest);
        assertNotNull(response);
        assertEquals(ResponseCode.OK.getCode(), response.getStatus());
        assertEquals(userTest, response.getData());
    }

    private UserDto createTestUser() {
        UserDto userTest = new UserDto();
        userTest.setUsername("test");
        userTest.setPassword("test");
        userTest.setName("test");
        userTest.setLastname("test");
        userTest.setIdentification("test");
        userTest.setEmail("test@test.com");
        userTest.setLandlineNumber("00000000");
        userTest.setPhoneNumber("00000000");
        userTest.setIsActive("N");
        userTest.setIsAdmin("N");
        userTest.setPasswordChanged("N");
        userTest.setActivationCode("");
        userTest.setProfilePhoto(null);
        userTest.setVersion(1L);
        return userTest;
    }

}
