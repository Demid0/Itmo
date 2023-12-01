package lab2;

public class AreaFunctions {
    static boolean checkArea(double x, double y, double r) {
        return isRectangle(x, y, r) || isCircle(x, y, r) || isTriangle(x, y, r);
    }

    private static boolean isRectangle(double x, double y, double r) {
        return -r/2 <= x && x <= 0 && -r <= y && y <= 0;
    }

    private static boolean isCircle(double x, double y, double r) {
        return x <= 0 && y >= 0 && x*x + y*y <= r*r/4;
    }

    private static boolean isTriangle(double x, double y, double r) {
        return x >= 0 && y >= 0 && y <= r - x;
    }
}
