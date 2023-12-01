package lab2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ClearTable extends MyServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Table table = (Table) request.getSession().getAttribute("table");
        table.clearTable();
        request.getSession().setAttribute("table", table);
    }
}
