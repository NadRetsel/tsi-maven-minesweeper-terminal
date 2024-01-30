import org.example.*;
import org.junit.jupiter.api.*;
public class TestGrid {

    @Test
    public void TestGetCell() {
        int rows = 10;
        int columns = 10;
        Grid grid = new Grid(10, 10);

        for (int y = 0; y < rows; ++y) {
            for (int x = 0; x < columns; ++x) {
                Assertions.assertEquals(grid.GetCell(x,y), grid.grid_of_cells[x][y], "GetCell gets different cell");

                Cell cell = grid.GetCell(x, y);

                Assertions.assertEquals(cell.GetX(), x, "x = " + x + " expected");
                Assertions.assertEquals(cell.GetY(), y, "y = " + y + " expected");
            }
        }
    }
}