package controller;

import config.Configuration;
import model.HtmlFactory;
import view.View;
/**
 *
 * @author Takács Gergely
 */
public class Controller {

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void setupConfig(String[] args) {
        Configuration.setupConfiguration(args);
        Configuration.checkCommandLineOptions();
    }

    public void displayHtml() {
        view.show(HtmlFactory.createHtml(Configuration.name, Configuration.email, Configuration.PROJECT_LINK));
    }
}
