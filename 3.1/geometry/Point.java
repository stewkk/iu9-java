package geometry;

import static java.lang.Math.*;

public class Point {
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point add(Point p) {
        return new Point(this.x + p.x, this.y + p.y);
    }

    public Point sub(Point p) {
        return new Point(this.x - p.x, this.y - p.y);
    }

    public Point mult(double k) {
        return new Point(this.x * k, this.y * k);
    }

    public static boolean isEqual(Point a, Point b) {
        return abs(a.x - b.x) < Constants.EPS && abs(a.y - b.y) < Constants.EPS;
    }

    public double getR() {
        return pow(pow(this.x, 2) + pow(this.y, 2), 0.5);
    }

    public static double getDist(Point a, Point b) {
        return pow(pow(a.x - b.x, 2) + pow(a.y - b.y, 2), 0.5);
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
