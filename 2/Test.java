import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        Dominoes dominoes = new Dominoes();
        boolean isTilesMatch = true;

        while (true) {
            System.out.print("\033\143");
            System.out.println("Текущее состояние списка:");
            if (dominoes.isEmpty()) {
                System.out.println("Список пуст");
            } else {
                System.out.println(dominoes);
            }
            System.out.println("");
            System.out.println("Доступные команды:");
            System.out.println("\"1 n n\" - добавить доминошку с ребрами n|n слева");
            System.out.println("\"2 n n\" - добавить доминошку с ребрами n|n справа");
            System.out.println("\"0\" - завершить программу");
            System.out.println("");

            if (isTilesMatch) {
                System.out.print("Введите команду: ");
            } else {
                System.out.print("Грани не совпадают, введите новую команду: ");
                isTilesMatch = true;
            }

            int command = stdin.nextInt();

            if (command == 1) {
                int first = stdin.nextInt();
                int second = stdin.nextInt();
                try {
                    dominoes.addFront(new DominoTile(first, second));
                }
                catch (DominoesException e) {
                    isTilesMatch = false;
                }
            } else if (command == 2) {
                int first = stdin.nextInt();
                int second = stdin.nextInt();
                try {
                    dominoes.addBack(new DominoTile(first, second));
                }
                catch (DominoesException e) {
                    isTilesMatch = false;
                }
            } else {
                break;
            }
        }
    }
};
