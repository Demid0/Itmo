package lab2;

import java.io.Serializable;

public class Row implements Serializable {
    private float x;
    private float y;
    private float r;
    private boolean result;

    private String localTime;
    private String executionTime;

    public Row() {}

    public Row(float x, float y, float r, String localTime, String executionTime, boolean result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.localTime = localTime;
        this.executionTime = executionTime;
        this.result = result;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
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

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

}
