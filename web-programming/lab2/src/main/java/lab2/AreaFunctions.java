package lab2;

public class AreaFunctions {
    static boolean checkArea(float x, float y, float r) {
        return isRectangle(x, y, r) || isCircle(x, y, r) || isTriangle(x, y, r);
    }

    private static boolean isRectangle(float x, float y, float r) {
        return -r/2 <= x && x <= 0 && -r <= y && y <= 0;
    }

    private static boolean isCircle(float x, float y, float r) {
        return x <= 0 && y >= 0 && x*x + y*x <= r*r/4;
    }

    private static boolean isTriangle(float x, float y, float r) {
        return x >= 0 && y >= 0 && y <= r - x;
    }
}
