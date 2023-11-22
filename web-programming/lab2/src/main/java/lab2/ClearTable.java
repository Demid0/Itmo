package lab2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ClearTable extends MyServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Table table = (Table) request.getSession().getAttribute("table");
        table.clearTable();
        request.getSession().setAttribute("table", table);
    }
}
