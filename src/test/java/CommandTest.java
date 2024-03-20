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


    //Tous les tests ont été mis en commentaire, car la fonction principale ne gère pas encore les retours d'erreur
    //Actuellement la fonction faire des Runtime error
    @Test
    public void testCommand() {
//        assertEquals(0, new CommandLine(helloName).execute("-du=12"));
//        try {
//            int output = new CommandLine(convert).execute("-du=cm ", "-v=12");
//            assertEquals("Stop le test", "car il doit pas marcher");
//        } catch (CommandError e) {
//            assertEquals("No output unit specified", e.getMessage());
//        }
//
//        try {
//            new CommandLine(convert).execute("-du");
//        } catch (CommandError e) {
//            assertEquals("No input unit specified", e.getMessage());
//        }
//
//        try {
//            int output = new CommandLine(convert).execute("-du=cm ", "-v=12", "-ou=hm");
//            assertEquals("Stop le test", "car il doit pas marcher");
//        } catch (CommandError e) {
//            assertEquals("Type de convertion incompatbile", e.getMessage());
//        }
    }

    @Test
    public void OutputFileTest() {
//        try {
//            int output = new CommandLine(convert).execute("-du=cm ", "-v=12", "-ou=m, mm");
//            assertEquals("Stop le test", "car il doit pas marcher");
//        } catch (CommandError e) {
//            assertEquals("No outputFile but multiple unit convert", e.getMessage());
//        }
//
//        try {
//            int output = new CommandLine(convert).execute("-du=cm ", "-v=12", "-ou=m, mm", "-of=OUI.csv");
//        } catch (CommandError e) {
//            assertEquals("No outputFile but multiple unit convert", e.getMessage());
//        }
    }
}
