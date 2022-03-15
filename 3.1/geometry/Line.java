package geometry;

import java.lang.Math;

public class Line {
    public final double a;
    public final double b;
    public final double c;

    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isIn(Point p) {
        return Math.abs(a*p.x + b*p.y + c) < Constants.EPS;
    }

    public Point getProjection(Point p) {
        Point n = new Point(a, b);
        n = n.mult(Math.abs(a*p.x + b*p.y + c) / (Math.pow(a, 2) + Math.pow(b, 2)));
        Point res = p.add(n);
        if (this.isIn(res)) {
            return res;
        }
        return p.sub(n);
    }

    public double getR(Point p) {
        return Math.abs(a*p.x + b*p.y + c) / Math.pow(Math.pow(a, 2) + Math.pow(b, 2), 0.5);
    }
}
