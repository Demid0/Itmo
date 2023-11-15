package lab2;

import java.time.ZonedDateTime;

public class Row {
    private final float x;
    private final float y;
    private final float r;
    private final boolean result;
    private final ZonedDateTime currentTime;
    private final float executionTime;

    public Row(float x, float y, float r, boolean result, ZonedDateTime currentTime, float executionTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        this.currentTime = currentTime;
        this.executionTime = executionTime;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public float getExecutionTime() {
        return executionTime;
    }

    public ZonedDateTime getCurrentTime() {
        return currentTime;
    }

    public boolean getResult() {
        return result;
    }
}
