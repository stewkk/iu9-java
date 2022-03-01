import java.util.Random;

public class BoolMatrix implements Comparable<BoolMatrix> {
    private final int n;
    private final int m;
    private int countEqual;
    private byte[][] matrix;

    private byte[][] generateRandomMatrix() {
        byte[][] res = new byte[n][m];
        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                res[i][j] = (random.nextBoolean() ? (byte)1 : (byte)0);
            }
        }
        return res;
    }

    public BoolMatrix(int n, int m) {
        this.n = n;
        this.m = m;
        this.matrix = generateRandomMatrix();
        this.countEqual = countEqualRows() + countEqualColoumns();
    }

    @Override
    public String toString() {
        String res = "Одинаковых строк/столбцов: " + countEqual + "\n";
        for (byte[] row : this.matrix) {
            for (byte el : row) {
                res += el + " ";
            }
            res += "\n";
        }
        return res;
    }

    @Override
    public int compareTo(BoolMatrix obj) {
        return this.countEqual - obj.countEqual;
    }

    private int countEqualRows() {
        int ans = 0;
        BoolArrayMultiset set = new BoolArrayMultiset();
        for (byte[] row : this.matrix) {
            int count = set.insert(row);
            if (count == 2) {
                ans += 2;
            } else if (count > 2) {
                ans++;
            }
        }
        return ans;
    }

    private int countEqualColoumns() {
        int ans = 0;
        BoolArrayMultiset set = new BoolArrayMultiset();
        for (int j = 0; j < m; ++j) {
            byte[] coloumn = new byte[n];
            for (int i = 0; i < n; ++i) {
                coloumn[i] = this.matrix[i][j];
            }
            int count = set.insert(coloumn);
            if (count == 2) {
                ans += 2;
            } else if (count > 2) {
                ans++;
            }
        }
        return ans;
    }
};

class BoolArrayMultiset {
    private class Node {
        private Node[] next;
        private int count;

        Node() {
            this.count = 0;
            this.next = new Node[] {null, null};
        }
    };

    private Node root;

    public BoolArrayMultiset() {
        this.root = new Node();
    }

    public int insert(byte[] array) {
        Node node = this.root;
        for (byte el : array) {
            if (node.next[el] == null) {
                node.next[el] = new Node();
            }
            node = node.next[el];
        }
        node.count++;
        return node.count;
    }
};
