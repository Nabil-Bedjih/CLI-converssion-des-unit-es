import org.example.CommandError;
import org.example.Convert;
import org.junit.Before;
import org.junit.Test;
import picocli.CommandLine;

import static org.junit.Assert.assertEquals;

public class CommandTest {
    private Convert convert;


    @Before
    public void setUp() {
        convert = new Convert();
    }

    @Test
    public void testCommand() {
//        assertEquals(0, new CommandLine(helloName).execute("-du=12"));
        try {
            int output = new CommandLine(convert).execute("-du=cm ", "-v=12");
        } catch (CommandError e) {
            assertEquals("No output unit specified", e.getMessage());
        }

        try {
            new CommandLine(convert).execute("-cu=EUR");
        } catch (CommandError e) {
            assertEquals("No input unit specified", e.getMessage());
        }

        try {
            int output = new CommandLine(convert).execute("-du=cm ", "-v=12", "-ou=hm");
        } catch (CommandError e) {
            assertEquals("Type de convertion incompatbile", e.getMessage());
        }
    }

    @Test
    public void OutputFileTest() {
        try {
            int output = new CommandLine(convert).execute("-du=cm ", "-v=12", "-ou=m, mm");
        } catch (CommandError e) {
            assertEquals("No outputFile but multiple unit convert", e.getMessage());
        }

        try {
            int output = new CommandLine(convert).execute("-du=cm ", "-v=12", "-ou=m, mm");
        } catch (CommandError e) {
            assertEquals("No outputFile but multiple unit convert", e.getMessage());
        }
    }
}
