package lab2;

import java.io.Serializable;

public class Row implements Serializable {
    private double x;
    private double y;
    private double r;
    private boolean result;
    private String localTime;
    private double executionTime;

    public Row(double x, double y, double r, String localTime, double executionTime, boolean result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.localTime = localTime;
        this.executionTime = executionTime;
        this.result = result;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getR() {
        return r;
    }
    public boolean isResult() {
        return result;
    }
    public String getLocalTime() {
        return localTime;
    }
    public double getExecutionTime() {
        return executionTime;
    }

}