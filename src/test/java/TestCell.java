import org.example.*;
import org.junit.jupiter.api.*;
public class TestCell {

    @Test
    public void TestCellCreation() {
        int rows = 10;
        int columns = 10;
        Grid grid = new Grid(10, 10);

        for (int y = 0; y < rows; ++y) {
            for (int x = 0; x < columns; ++x) {
                Cell cell = grid.GetCell(x, y);
                Assertions.assertEquals(x, cell.GetX(), "x = " + x + " expected");
                Assertions.assertEquals(y, cell.GetY(), "y = " + y + " expected");

                Assertions.assertFalse(cell.GetIsBomb(), "Cell is bomb already");
                Assertions.assertFalse(cell.GetIsFlagged(), "Cell is flagged already");
                Assertions.assertFalse(cell.GetIsMarked(), "Cell is marked already");

                Assertions.assertEquals(0, cell.GetBombsNear(), "Cell has bombs near");
            }
        }
    }
}