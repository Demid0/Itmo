package lab2;

import java.io.Serializable;

public class Row implements Serializable {
    private double x;
    private double y;
    private double r;
    private boolean result;

    private String localTime;
    private double executionTime;

    public Row() {}

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

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public double getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(double executionTime) {
        this.executionTime = executionTime;
    }

}
