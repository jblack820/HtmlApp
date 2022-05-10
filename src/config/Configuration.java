package config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author takacs.gergely
 */
public class Configuration {

    public static boolean isParagraphToBePrinted = true;
    public static boolean isTdToBePrinted = true;
    public static boolean isHrefToBePrinted = true;
    public static boolean isTableToBePrinted = true;
    public static boolean isHeaderToBePrinted = true;
    public static boolean isTrToBePrinted = true;
    public static final List<String> ARGS_LIST = new ArrayList();    
    public static String TAB_SPACE = "     ";    
    public static final String NEWLINE = "\n";
    public static String email;
    public static String name;
    public static final String PROJECT_LINK = "https://github.com/jblack820/HtmlApp";


    public static void checkCommandLineOptions() {
        if (ARGS_LIST.contains("noheader")) {
            Configuration.isHeaderToBePrinted = false;
        }
        if (ARGS_LIST.contains("nopar")) {
            Configuration.isParagraphToBePrinted = false;
        }
        if (ARGS_LIST.contains("nohref")) {
            Configuration.isHrefToBePrinted = false;
        }
        if (ARGS_LIST.contains("notable")) {
            Configuration.isTableToBePrinted = false;
        }
        if (ARGS_LIST.contains("notr")) {
            Configuration.isTrToBePrinted = false;
        }
        if (ARGS_LIST.contains("notd")) {
            Configuration.isTdToBePrinted = false;
        }
    }

    public static void setupConfiguration(String[] args) {            
        ARGS_LIST.addAll(Arrays.asList(args));
        name = Configuration.ARGS_LIST.size() > 0 ? Configuration.ARGS_LIST.get(0) : "nincs megadva";
        email = Configuration.ARGS_LIST.size() > 1 ? Configuration.ARGS_LIST.get(1) : "nincs megadva";
    }

    public static String getTabs(int tabCount) {
        StringBuilder tabBuilder = new StringBuilder();
        for (int i = 0; i < tabCount; i++) {
            tabBuilder.append(Configuration.TAB_SPACE);
        }
        return tabBuilder.toString();
    }

}
