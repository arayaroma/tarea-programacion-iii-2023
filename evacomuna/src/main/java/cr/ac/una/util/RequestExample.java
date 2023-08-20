package cr.ac.una.util;

import cr.ac.una.dto.UserDto;
import cr.ac.una.services.impl.*;

public class RequestExample {
    public static void request() {
        User_Service userService = new User_Service();
        UserServiceImpl port = userService.getUserServiceImplPort();

        UserDto userDto = new UserDto("darayaroma@gmail.com",
                0L, "901140423", "Y", "Y", "86420240", "Araya", "Daniel",
                "arayaroma", "86420240", null, null, "Roman", "arayaroma");
        User user = userDto.toUser(userDto);

        port.createUser(user);
        System.out.println(user.toString());
    }
}
