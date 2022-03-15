import java.util.Arrays;
import java.util.Random;
import geometry.*;

public class Test {
    public static void main(String[] args) {
        int n = 10;
        Random random = new Random();
        CirclePair[] pairs = new CirclePair[n];
        for (int i = 0; i < n; ++i) {
        pairs[i] = new CirclePair(new Circle(new Point(random.nextInt(5), random.nextInt(5)), random.nextInt(5)+1),
                                  new Circle(new Point(random.nextInt(5), random.nextInt(5)), random.nextInt(5)+1));
        }

        System.out.println("До сортировки:");
        for (CirclePair pair : pairs) {
            System.out.println(pair);
        }

        Arrays.sort(pairs);

        System.out.println("\n\nОтсортированные:");
        for (CirclePair pair : pairs) {
            System.out.println(pair);
        }
    }
}
