import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DominoesTest {
    @Test
    public void dominoTileToString() {
        DominoTile tile = new DominoTile(1, 2);
        String string = tile.toString();
        assertEquals("🀺", string);
    }

    @Test
    public void dominoesToString() throws DominoesException {
        Dominoes list = new Dominoes();
        list.addBack(new DominoTile(1, 1));
        list.addBack(new DominoTile(1, 2));

        String string = list.toString();

        assertEquals("🀹 🀺", string);
    }
};
