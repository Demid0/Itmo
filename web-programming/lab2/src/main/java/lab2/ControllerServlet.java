package lab2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log("controller.doPost");
        if (request.getParameter("r") != null &&
            request.getParameter("y") != null &&
            request.getParameter("x") != null) request.getRequestDispatcher("/checker").forward(request, response);
        else request.getRequestDispatcher("/err").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log("controller.doGet");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }


}