package lab2;

import java.io.Serializable;
import java.util.ArrayList;

public class Table implements Serializable {
    private ArrayList<Row> rows = new ArrayList<>();

    public Table() {}

    public Table(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public void  addRow(Row row) {
        this.rows.add(row);
   }

    public void nullTable() {
        this.rows = null;
    }

    public int getSize() {
        return rows.size();
    }
}
