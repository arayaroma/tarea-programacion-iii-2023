package cr.ac.una.util;

import cr.ac.una.services.impl.*;

public class RequestExample {
    public static void request() {
        UserService userService = new UserService();
        UserServiceImpl port = userService.getUserServiceImplPort();

        UserDto userDto = new UserDto();
        userDto.setEmail("darayaroma@gmail.com");
        userDto.setId(0L);
        userDto.setIdentification("901140423");
        userDto.setIsActive("Y");
        userDto.setLandlineNumber("86420240");
        userDto.setLastname("Araya");
        userDto.setName("Daniel");
        userDto.setPassword("arayaroma");
        userDto.setPhoneNumber("86420240");
        userDto.setPosition(null);
        userDto.setProfilePhoto(null);
        userDto.setSecondLastname("Roman");
        userDto.setUsername("arayaroma");

        port.createUser(userDto);
        System.out.println(userDto.toString());
    }
}
