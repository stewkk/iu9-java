package geometry;

import java.lang.Math;

public class Circle {
    public final Point center;
    public final double radius;

    public static enum IntersectionType {
        OVERLAP,
        INTERSECTION,
        ABSENCE,
        TOUCH;
    }

    public static class Intersection {
        public final Point first;
        public final Point second;
        public final IntersectionType type;

        public Intersection(IntersectionType type) {
            this.type = type;
            this.first = new Point(-1, -1);
            this.second = new Point(-1, -1);
        }

        public Intersection(IntersectionType type, Point first, Point second) {
            this.type = type;
            this.first = first;
            this.second = second;
        }
    }

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public static Intersection getIntersection(Circle first, Circle second) {
        if (Point.isEqual(first.center, second.center)) {
            if (Math.abs(first.radius - second.radius) < Constants.EPS) {
                return new Circle.Intersection(Circle.IntersectionType.OVERLAP);
            }
            return new Circle.Intersection(Circle.IntersectionType.ABSENCE);
        }
        double a = 2 * first.center.x - 2 * second.center.x;
        double b = 2 * first.center.y - 2 * second.center.y;
        double c = Math.pow(second.center.x, 2) + Math.pow(second.center.y, 2) - Math.pow(second.radius, 2)
            - Math.pow(first.center.x, 2) - Math.pow(first.center.y, 2) + Math.pow(first.radius, 2);
        System.out.println(a + " " + b + " " + c);
        Line l = new Line(a, b, c);
        double h = l.getR(first.center);
        if (h > first.radius) {
            return new Circle.Intersection(Circle.IntersectionType.ABSENCE);
        }
        Point s = l.getProjection(first.center);
        Point q = new Point(-l.b, l.a);
        q = q.mult(Math.pow(Math.pow(first.radius, 2) - Math.pow(h, 2), 0.5) / q.getR());
        if (Math.abs(h - first.radius) < Constants.EPS) {
            return new Circle.Intersection(Circle.IntersectionType.TOUCH, s.add(q), new Point(-1, -1));
        }
        return new Circle.Intersection(Circle.IntersectionType.INTERSECTION, s.add(q), s.sub(q));
    }
}
