
public class Universe {

    public class Point {
        private String name;
        private double x;
        private double y;
        private double z;
        private static int n;
        public static int val;

        public Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public void setCoord(double varX, double varY, double varZ)
        {
            this.x=varX;
            this.y=varY;
            this.z=varZ;
        }

        public String toString() {
            return x + " " + y + " " + z;
        }
    }


    public class Particle {
        private double m;
        private Point pos;
        private Point v;

        public Particle(double x, double y, double z, double vx, double vy, double vz) {
            this.pos = new Point(x, y, z);
            this.v = new Point(vx, vy, vz);
        }

        public void calcCoordsWithTime(double time) {
            this.pos.setCoord(
                              pos.x + v.x * time,
                              pos.y + v.y * time,
                              pos.z + v.z * time);
        }
    };

    private Particle[] particles;
    private int count;

    public Universe() {
        // this.particles = new Particle[] { new Particle(1, 0, 0, 1, 0, 0), new Particle(0, 1, 0, 0, 1, 0), new Particle(-1, 0, 0, -1, 0, 0), new Particle(0, -1, 0, 0, -1, 0) };
        this.particles = new Particle[] { new Particle(1, 0, 0, 1, 0, 0), new Particle(0, 1, 0, 0, 1, 0), new Particle(-1, 0, 0, 0, 0, 0), new Particle(0, -1, 0, 0, -1, 0) };
        this.count = particles.length;
    }

    public Point calcAverageDirectionVector() {
        Point ans = new Point(0, 0, 0);
        for (Particle particle : particles) {
            ans.x += particle.v.x;
            ans.y += particle.v.y;
            ans.z += particle.v.z;
        }
        ans.x /= this.count;
        ans.y /= this.count;
        ans.z /= this.count;
        return ans;
    }
};
