public class DominoTile {
    private int firstNumber;
    private int secondNumber;
    private DominoTile next;
    private DominoTile previous;

    public DominoTile(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        next = previous = null;
    }

    public DominoTile getNext() {
        return next;
    }

    public DominoTile getPrevious() {
        return previous;
    }

    public String toString() {
        return new String(Character.toChars(0x1F031 + firstNumber * 7 + secondNumber));
    }

    public void rotate() {
        int temp = firstNumber;
        firstNumber = secondNumber;
        secondNumber = temp;
    }

    public void connectLeft(DominoTile tile) throws DominoesException {
        if (firstNumber == tile.firstNumber) {
            tile.rotate();
        }
        if (tile.secondNumber != firstNumber) {
            throw new DominoesException();
        }
        tile.next = this;
        this.previous = tile;
    }

    public void connectRight(DominoTile tile) throws DominoesException  {
        if (secondNumber == tile.secondNumber) {
            tile.rotate();
        }
        if (secondNumber != tile.firstNumber) {
            throw new DominoesException();
        }
        tile.previous = this;
        this.next = tile;
    }
};
