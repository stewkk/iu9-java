package geometry;

import java.lang.Math;

public class CirclePair implements Comparable<CirclePair> {
    private final Circle first;
    private final Circle second;
    private final double intersectionsDist;
    private final Circle.Intersection intersection;

    public CirclePair(Circle first, Circle second) {
        this.first = first;
        this.second = second;
        this.intersection = Circle.getIntersection(first, second);
        if (intersection.type == Circle.IntersectionType.OVERLAP
            || intersection.type == Circle.IntersectionType.TOUCH) {
            this.intersectionsDist = 0;
        } else if (intersection.type == Circle.IntersectionType.ABSENCE) {
            this.intersectionsDist = Constants.INF;
        } else {
            this.intersectionsDist = Point.getDist(intersection.first, intersection.second);
        }
    }

    @Override
    public int compareTo(CirclePair obj) {
        if (obj.intersection.type == Circle.IntersectionType.ABSENCE) {
            if (this.intersection.type == Circle.IntersectionType.ABSENCE) {
                return 0;
            }
            return -1;
        }
        if (Math.abs(this.intersectionsDist - obj.intersectionsDist) < Constants.EPS) {
            return 0;
        }
        if (this.intersectionsDist < obj.intersectionsDist) {
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Первая окружность:\n"
            + "Центр " + first.center + "\n"
            + "Радиус " + first.radius + "\n"
            + "Вторая окружность:\n"
            + "Центр " + second.center + "\n"
            + "Радиус " + second.radius + "\n"
            + "Расстояние между пересечениями: " + intersectionsDist + "\n"
            + "Пересечения: " + intersection.type + "(" + intersection.first + ") " + intersection.type + "(" + intersection.second + ")";
    }
}
