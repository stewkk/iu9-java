import java.util.Scanner;

import parser.Parser;

public class Test {
    public static void main(String[] args) {
        try (Scanner stdin = new Scanner(System.in).useDelimiter("\\Z")) {
            String text;
            if (stdin.hasNext()) {
                text = stdin.next();
            } else {
                text = "";
            }
            Parser parser = new Parser(text);
            parser.parse();
        } catch (Parser.SyntaxError e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
