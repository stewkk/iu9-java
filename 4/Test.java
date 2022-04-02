public class Test {
    public static void main(String[] args ) {
        {
            StringBuilder str = new StringBuilder("a213aa bb22 11cc dd 10   0  111 sss 123  ");
            IntegerList integers = new IntegerList(str);
            for (String num : integers) {
                System.out.print(num + " ");
            }
            System.out.println("");
            str.insert(0, "  123 ");
            for (String num : integers) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
        {
            StringBuilder str = new StringBuilder("");
            IntegerList integers = new IntegerList(str);
            for (String num : integers) {
                System.out.print(num + " ");
            }
            System.out.println("");
            str.insert(0, "  123 ");
            for (String num : integers) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }
}
