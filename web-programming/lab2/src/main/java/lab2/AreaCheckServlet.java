package lab2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static lab2.AreaFunctions.checkArea;

public class AreaCheckServlet extends MyServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log("areaChecker.doPost");
        double start = System.currentTimeMillis();
        double x = Double.parseDouble(request.getParameter("x"));
        double y = Double.parseDouble(request.getParameter("y"));
        double r = Double.parseDouble(request.getParameter("r"));
        String currentTime = request.getParameter("currentTime");
        boolean hit = checkArea(x, y, r);
        log(x + " " + y + " " + r + " " + hit);
        Row newRow = new Row(x, y, r, currentTime, System.currentTimeMillis() - start, hit);
        Table table = (Table) request.getSession().getAttribute("table");
        if (table == null) {
            table = new Table();
        }
        table.addRow(newRow);
        request.getSession().setAttribute("table", table);
        request.getRequestDispatcher("/table.jsp").forward(request, response);
    }

}
