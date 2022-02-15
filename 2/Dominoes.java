import java.util.Iterator;

public class Dominoes implements Iterable<DominoTile> {
    private DominoTile head;
    private DominoTile tail;

    public Dominoes() {
        head = tail = null;
    }

    public void addFront(DominoTile toAdd) throws DominoesException {
        if (head == null) {
            head = toAdd;
            tail = toAdd;
        } else {
            head.connectLeft(toAdd);
            head = toAdd;
        }
    }

    public void addBack(DominoTile toAdd) throws DominoesException {
        if (head == null) {
            head = toAdd;
            tail = toAdd;
        } else {
            tail.connectRight(toAdd);
            tail = toAdd;
        }
    }

    public Iterator<DominoTile> iterator() {
        return new DominoesIterator(this);
    }

    class DominoesIterator implements Iterator<DominoTile> {
        private DominoTile current;

        public DominoesIterator(Dominoes list) {
            current = list.head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public DominoTile next() {
            DominoTile data = current;
            current = current.getNext();
            return data;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    };

    public String toString() {
        String res = "";
        for (DominoTile tile : this) {
            res += tile + " ";
        }
        return res.stripTrailing();
    }

    public boolean isEmpty() {
        return head == null;
    }
};
