package lab2;

import java.io.Serializable;
import java.util.ArrayList;

public class Table implements Serializable {
    private ArrayList<Row> rows = new ArrayList<>();

    public Table() {}

    public ArrayList<Row> getRows() {
        return rows;
    }
    public void  addRow(Row row) {
        this.rows.add(row);
   }
    public void clearTable() { this.rows = new ArrayList<>(); }

}