package cr.ac.una.util;

import cr.ac.una.services.*;

public class RequestExample {
    public static void request() {
        User_Service userService = new User_Service();
        UserServiceImpl port = userService.getUserServiceImplPort();
        GetUser request = new GetUser();
        request.setArg0(1);

        User user = port.getUser(1);
        System.out.println("UserID: " + user.getId() + "Name: " + user.getName());
    }
}
