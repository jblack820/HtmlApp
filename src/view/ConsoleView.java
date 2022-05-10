package view;

import controller.Controller;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author takacs.gergely
 */
public class ConsoleView implements View {

    @Override
    public void show(String solution) {
        PrintStream out = null;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println(solution);
    }
    
    
    
}
