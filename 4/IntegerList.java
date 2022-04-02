import java.util.Iterator;

public class IntegerList implements Iterable<String> {
    private StringBuilder str;

    public IntegerList(StringBuilder str) {
        this.str = str;
    }

    public Iterator<String> iterator() {
        return new IntegerIterator();
    }

    class IntegerIterator implements Iterator<String> {
        private int pos;
        private String nextInteger;

        private void spaces() {
            while (pos < str.length() && str.charAt(pos) == ' ') {
                pos++;
            }
        }

        private String word() {
            int start = pos;
            boolean isInteger = true;
            while (pos < str.length() && str.charAt(pos) != ' ') {
                if (!Character.isDigit(str.charAt(pos))) {
                    isInteger = false;
                }
                pos++;
            }
            if (isInteger) {
                return str.substring(start, pos);
            }
            return "";
        }

        private String findNext() {
            while (pos < str.length()) {
                spaces();
                String res = word();
                if (res != "") {
                    return res;
                }
            }
            return "";
        }

        public IntegerIterator() {
            pos = 0;
            nextInteger = findNext();
        }

        public boolean hasNext() {
            return nextInteger != "";
        }

        public String next() {
            String tmp = nextInteger;
            nextInteger = findNext();
            return tmp;
        }
    }
}
