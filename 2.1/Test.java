public class Test {
    public static void main(String[] args) {
        Universe universe = new Universe(0);
        universe.add(0, 0, 0, 0, 0, 0, 1.989e30); // солнце
        universe.add(147098290e3, 0, 0, 0, 30270, 0, 5.972e24); // земля
        universe.dump("plot.dat", false);
        for (int i = 0; i < 1*24*365; ++i) { // год
            universe.recalcCoords(60*60); // час
            universe.dump("plot.dat", true);
        }
    }
};
