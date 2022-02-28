
public class Particle {
    private double m;
    private Point pos;
    private Point v;

    public Particle() {
        this.pos = new Point(Math.random(), Math.random(), Math.random());
        this.v = new Point(Math.random(), Math.random(), Math.random());
    }

    public Point getV() {
        return this.v;
    }

    public Point getPos() {
        return this.pos;
    }

    public void calcCoordsWithTime(double time) {
        this.pos.setCoord(
                          pos.getX() + v.getX() * time,
                          pos.getY() + v.getY() * time,
                          pos.getZ() + v.getZ() * time);
    }
};
