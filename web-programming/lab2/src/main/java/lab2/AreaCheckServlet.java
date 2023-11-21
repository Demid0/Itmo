package lab2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static lab2.AreaFunctions.checkArea;

public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log("areaChecker.doPost");
        float x = Float.parseFloat(request.getParameter("x"));
        float y = Float.parseFloat(request.getParameter("y"));
        float r = Float.parseFloat(request.getParameter("r"));
        String currentTime = "";
        String executionTime = "";
        boolean hit = checkArea(x, y, r);
        Row newRow = new Row(x, y, r, currentTime, executionTime, hit);
        Table table = (Table) request.getSession().getAttribute("table");
        if (table == null) {
            table = new Table();
        }
        table.addRow(newRow);
        request.getSession().setAttribute("table", table);
        response.sendRedirect("/lab2-1.0-SNAPSHOT/");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log("areaChecker.doGet");
        request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
