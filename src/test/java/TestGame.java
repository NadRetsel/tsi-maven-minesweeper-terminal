import org.example.*;
import org.junit.jupiter.api.*;

public class TestGame {

    @Test
    public void TestPopulateGrid(){
        Game game = new Game(10, 10, 10);
        game.PopulateGrid(game.grid.GetCell(5,5));
        int count_bombs = CountBombs(game.grid.grid_of_cells);
        Assertions.assertEquals(count_bombs, 10, "10 bombs should be planted");

        game = new Game(10, 10, 0);
        game.PopulateGrid(game.grid.GetCell(5,5));
        count_bombs = CountBombs(game.grid.grid_of_cells);
        Assertions.assertEquals(count_bombs, 0, "0 bombs should be planted");

        try {
            game = new Game(10, 10, 1000);
            game.PopulateGrid(game.grid.GetCell(5,5));
            Assertions.fail("Too many bombs should not be planted");

        } catch (Exception ignored){ }

        /*
        try {
            game = new Game(10, 10, -1);
            game.PopulateGrid(game.grid.GetCell(5,5));
            Assertions.fail("Negative bombs should not be planted");

        } catch (Exception ignored){ }
        */
    }

    @Test
    public void TestRevealCell(){
        Game game = new Game(10, 10, 10);
        Cell cell = game.grid.GetCell(5,5);
        Assertions.assertFalse(cell.GetIsRevealed(), "Cell should be hidden at start");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.FlagCell(cell);
        Assertions.assertFalse(cell.GetIsRevealed(), "Cell should not be revealed by flagging");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.FlagCell(cell);
        game.FlagCell(cell);
        Assertions.assertFalse(cell.GetIsRevealed(), "Cell should not be revealed by unflagging");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.MarkCell(cell);
        Assertions.assertFalse(cell.GetIsRevealed(), "Cell should not be revealed by marking");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.MarkCell(cell);
        game.MarkCell(cell);
        Assertions.assertFalse(cell.GetIsRevealed(), "Cell should not be revealed by unmarking");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.RevealCell(cell);
        Assertions.assertTrue(cell.GetIsRevealed(), "Cell should be revealed by revealing");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.RevealCell(cell);
        game.RevealCell(cell);
        Assertions.assertTrue(cell.GetIsRevealed(), "Cell should still be revealed by reveal");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.RevealCell(cell);
        game.FlagCell(cell);
        Assertions.assertTrue(cell.GetIsRevealed(), "Cell should still be revealed by flagging");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.RevealCell(cell);
        game.MarkCell(cell);
        Assertions.assertTrue(cell.GetIsRevealed(), "Cell should still be revealed by marking");


    }

    @Test
    public void TestFlagCell(){
        Game game = new Game(10, 10, 10);
        Cell cell = game.grid.GetCell(5,5);
        Assertions.assertFalse(cell.GetIsFlagged(), "Cell should not be flagged at start");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.RevealCell(cell);
        Assertions.assertFalse(cell.GetIsFlagged(), "Cell should not be flagged by revealing");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.MarkCell(cell);
        Assertions.assertFalse(cell.GetIsFlagged(), "Cell should not be flagged by marking");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.MarkCell(cell);
        game.MarkCell(cell);
        Assertions.assertFalse(cell.GetIsFlagged(), "Cell should not be flagged by unmarking");


        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.FlagCell(cell);
        Assertions.assertTrue(cell.GetIsFlagged(), "Cell should be flagged by flagging");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.FlagCell(cell);
        game.FlagCell(cell);
        Assertions.assertFalse(cell.GetIsFlagged(), "Cell should not be flagged by unflagging");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.FlagCell(cell);
        game.RevealCell(cell);
        Assertions.assertTrue(cell.GetIsFlagged(), "Cell should still be flagged by reveal");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.FlagCell(cell);
        game.MarkCell(cell);
        Assertions.assertFalse(cell.GetIsFlagged(), "Cell should not be flagged by flagging then marking");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.FlagCell(cell);
        game.MarkCell(cell);
        game.MarkCell(cell);
        Assertions.assertFalse(cell.GetIsFlagged(), "Cell should not be flagged by flagging then unmarking");
    }

    @Test
    public void TestMarkCell(){
        Game game = new Game(10, 10, 10);
        Cell cell = game.grid.GetCell(5,5);
        Assertions.assertFalse(cell.GetIsMarked(), "Cell should not be marked at start");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.RevealCell(cell);
        Assertions.assertFalse(cell.GetIsMarked(), "Cell should not be marked by revealing");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.FlagCell(cell);
        Assertions.assertFalse(cell.GetIsMarked(), "Cell should not be marked by flagging");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.FlagCell(cell);
        game.FlagCell(cell);
        Assertions.assertFalse(cell.GetIsMarked(), "Cell should not be marked by unflagging");


        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.MarkCell(cell);
        Assertions.assertTrue(cell.GetIsMarked(), "Cell should be marked by marking");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.MarkCell(cell);
        game.RevealCell(cell);
        Assertions.assertTrue(cell.GetIsMarked(), "Cell should be marked by revealing");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.MarkCell(cell);
        game.FlagCell(cell);
        Assertions.assertFalse(cell.GetIsMarked(), "Cell should not be marked by marking then flagging");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.MarkCell(cell);
        game.MarkCell(cell);
        Assertions.assertFalse(cell.GetIsMarked(), "Cell should not be marked by unmarking");

        game = new Game(10, 10, 10);
        cell = game.grid.GetCell(5,5);
        game.MarkCell(cell);
        game.FlagCell(cell);
        game.FlagCell(cell);
        Assertions.assertFalse(cell.GetIsMarked(), "Cell should not be marked by marking then unflagging");
    }



    public int CountBombs(Cell[][] grid_of_cells){
        int count_bombs = 0;
        for(Cell[] cell_columns : grid_of_cells){
            for(Cell c : cell_columns){
                if(c.GetIsBomb()) ++count_bombs;
            }
        }
        return count_bombs;
    }
}
