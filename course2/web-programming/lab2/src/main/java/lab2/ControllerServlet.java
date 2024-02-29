package lab2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends MyServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log("controller.doPost");
        if (request.getParameter("r") != null &&
            request.getParameter("y") != null &&
            request.getParameter("x") != null) request.getRequestDispatcher("/checker").forward(request, response);
        else if (request.getParameter("query") != null) {
            request.getRequestDispatcher(request.getParameter("query")).forward(request, response);
        }
        else {
            request.getRequestDispatcher("/lab2-1.0-SNAPSHOT/").forward(request, response);
        }
    }
}