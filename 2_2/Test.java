public class Test {
    public static void main(String[] args) {
        // Universe universe = new Universe(0);
        // universe.add(1, 2, 0, 0, 10, 0, 1e5);
        // universe.add(4, 3, 0, 0, 0, 0, 3e12);
        // universe.dump("plot.dat", false);
        // for (int i = 0; i < 100000; ++i) {
        //     universe.recalcCoords(0.01);
        //     universe.dump("plot.dat", true);
        // }
        Universe universe = new Universe(0);
        universe.add(3, 3, 0, 0, 14, 4, 1e3);
        universe.add(4, 3, 0, 0, 0, 0, 3e12);
        universe.add(4, 40, 0, 0, 0, 0, 4e12);
        universe.add(4, 80, 0, 0, 0, 0, 3e12);
        universe.add(4, 120, 0, 0, 0, 0, 4e12);
        universe.add(4, 160, 0, 0, 0, 0, 3e12);
        universe.add(4, 200, 0, 0, 0, 0, 4e12);
        universe.dump("plot.dat", false);
        for (int i = 0; i < 1500; ++i) {
            universe.recalcCoords(0.01);
            universe.dump("plot.dat", true);
        }
        // Universe universe = new Universe(10);
        // universe.dump("plot.dat", false);
        // for (int i = 0; i < 100; ++i) {
        //     universe.recalcCoords(0.001);
        //     universe.dump("plot.dat", true);
        // }
    }
};
