package cr.ac.una.controller;

import java.io.IOException;
import cr.ac.una.services.UserService;
import cr.ac.una.util.HtmlFileReader;
import cr.ac.una.util.ResponseCode;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 
 * @author arayaroma
 */
@WebServlet("/Activation")
public class ActivationServlet extends HttpServlet {

    @EJB
    UserService userService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String hash = request.getParameter("hash");

        try {
            ResponseWrapper activationResponse = userService.activateUser(id, hash);
            if (activationResponse != null &&
                    activationResponse.getCode().getCode() == ResponseCode.OK.getCode()) {
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter()
                        .write(HtmlFileReader.readHtml("activation-success.html"));

            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter()
                        .write(HtmlFileReader.readHtml("activation-failure.html"));
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter()
                    .write(HtmlFileReader.readHtml("activation-failure.html"));
        }
    }
}