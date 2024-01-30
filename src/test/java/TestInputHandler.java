import org.example.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
public class TestInputHandler {

    @Test
    public void TestInputInteger(){
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("Test\n5".getBytes());
        System.setIn(in);

        InputHandler input_handler = new InputHandler(in);
        Assertions.assertEquals(5, input_handler.InputInteger(""), "5 should be expected");

        in = new ByteArrayInputStream("Test\n0\n10\n5".getBytes());
        input_handler = new InputHandler(in);
        Assertions.assertEquals(5, input_handler.InputInteger("", 4, 6), "5 should be expected");
    }
}
