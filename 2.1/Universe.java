import java.util.Random;
import java.io.*;
import java.lang.Math;
import java.util.ArrayList;

public class Universe {

    public class Point {
        private double x;
        private double y;
        private double z;

        public Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double calcDist(Point p) {
            return Math.sqrt(Math.pow(this.x - p.x, 2)
                             + Math.pow(this.y - p.y, 2)
                             + Math.pow(this.z - p.z, 2));
        }

        public String toString() {
            return x + " " + y + " " + z;
        }

        public double getR() {
            return Math.sqrt(Math.pow(this.x, 2)
                             + Math.pow(this.y, 2)
                             + Math.pow(this.z, 2));
        }

        public void add(Point p) {
            this.x += p.x;
            this.y += p.y;
            this.z += p.z;
        }

        public void mult(double m) {
            this.x *= m;
            this.y *= m;
            this.z *= m;
        }
    }

    public class Particle {
        private double m;
        private Point pos;
        private Point v;
        private static ArrayList<Particle> particles = new ArrayList<Particle>();

        public Particle(double x, double y, double z, double vx, double vy, double vz, double m) {
            this.pos = new Point(x, y, z);
            this.v = new Point(vx, vy, vz);
            this.m = m;
            particles.add(this);
        }

        public static void recalcAllCoords(double time) {
            Point[] forces = new Point[particles.size()];
            for (int i = 0; i < particles.size(); ++i) {
                forces[i] = particles.get(i).calcOverallF();
            }
            for (int i = 0; i < particles.size(); ++i) {
                particles.get(i).recalcCoords(time, forces[i]);
            }
        }

        public String toString() {
            return m + " " + pos + " " + v;
        }

        private Point calcF(Particle p) {
            final double G = 6.673e-11;
            double r = this.pos.calcDist(p.pos);
            double modF = G * this.m * p.m / (r*r);
            Point F = new Point(p.pos.x - this.pos.x,
                                p.pos.y - this.pos.y,
                                p.pos.z - this.pos.z);
            F.mult(modF / F.getR());
            return F;
        }

        private Point calcOverallF() {
            Point F = new Point(0, 0, 0);
            for (Particle p : particles) {
                if (p != this) {
                    F.add(this.calcF(p));
                }
            }
            return F;
        }

        public void recalcCoords(double time, Point F) {
            Point a = F;
            a.mult(1 / this.m);
            this.pos.x += v.x * time + a.x * time*time / 2;
            this.pos.y += v.y * time + a.y * time*time / 2;
            this.pos.z += v.z * time + a.z * time*time / 2;
            this.v.x += a.x * time;
            this.v.y += a.y * time;
            this.v.z += a.z * time;
        }
    };

    private ArrayList<Particle> particles;

    public Universe() {
        particles = new ArrayList<Particle>();
    }

    public Universe(int n) {
        particles = new ArrayList<Particle>();
        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            particles.add(new Particle(random.nextDouble(0.1),
                                       random.nextDouble(0.1),
                                       random.nextDouble(0.1),
                                       0,
                                       0,
                                       0,
                                       1e6));
        }
    }

    public void add(double x, double y, double z, double vx, double vy, double vz, double m) {
        particles.add(new Particle(x, y, z, vx, vy, vz, m));
    }

    public int getCount() {
        return particles.size();
    }

    public Point calcAverageDirectionVector() {
        Point ans = new Point(0, 0, 0);
        for (Particle particle : particles) {
            ans.x += particle.v.x;
            ans.y += particle.v.y;
            ans.z += particle.v.z;
        }
        ans.x /= this.getCount();
        ans.y /= this.getCount();
        ans.z /= this.getCount();
        return ans;
    }

    public static void recalcCoords(double time) {
        Particle.recalcAllCoords(time);
    }

    public void dump(String path, boolean append) {
        try {
            FileWriter file = new FileWriter(path, append);
            for (Particle particle : this.particles) {
                file.write(particle.pos + " ");
            }
            file.write("\n");
            file.flush();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
};
