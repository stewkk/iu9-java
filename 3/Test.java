import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int n = 4;
        BoolMatrix[] matrices = new BoolMatrix[n];
        for (int i = 0; i < n; ++i) {
            matrices[i] = new BoolMatrix(3, 4);
        }

        System.out.println("До сортировки:");
        for (BoolMatrix matrix : matrices) {
            System.out.println(matrix);
        }

        Arrays.sort(matrices);

        System.out.println("Отсортированные:");
        for (BoolMatrix matrix : matrices) {
            System.out.println(matrix);
        }
    }
};
