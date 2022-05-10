package app;

import controller.Controller;
import view.ConsoleView;

/**
 *
 * @author Takács Gergely
 */
public class Main {
    
    public static void main(String[] args) {        
        Controller controller = new Controller(new ConsoleView());
        controller.setupConfig(args);
        controller.displayHtml();
    }
}
