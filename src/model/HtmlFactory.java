package model;

import config.Configuration;

/**
 *
 * @author takacs.gergely
 */
public class HtmlFactory {

    public static final StringBuilder HTML_BUILDER = new StringBuilder();

    public static String createHtml(String name, String email, String projectLink) {
        createBase();
        addHeadWithTitle("Teszt Feladat");
        addBody();
        addHeader("Teszt feladat");
        addParagraph(getNewHRef(projectLink, "Megoldás"));
        addParagraph("A feladat elkészítőjének adatai");
        addTable("1px solid black", name, email);
        addHref(getNewHRef("http://lpsolutions.hu", "L&P Solutions"));
        return HTML_BUILDER.toString();
    }

    //<editor-fold defaultstate="collapsed" desc="HREF">
    public static void addHref(String href) {
        if (Configuration.isHrefToBePrinted) {
            addNeWElementToBody(href);
        }
    }

    public static String getNewHRef(String link, String text) {
        if (Configuration.isHrefToBePrinted) {
            return new StringBuilder().append("<a href=\"").append(link).append("\">").append(text).append("</a>").toString();
        } else {
            return "";
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HEADER">
    private static String getNewHeader(String text) {
        return new StringBuilder().append("<h1>").append(text).append("</h1>").toString();
    }

    public static void addHeader(String text) {
        if (Configuration.isHeaderToBePrinted) {
            addNeWElementToBody(getNewHeader(text));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HEAD">
    public static void addHeadWithTitle(String title) {
        HtmlFactory.HTML_BUILDER.insert(getInsertionPointBefore("</html>"), getNewHead(title));
    }

    private static String getNewHead(String title) {
        return new StringBuilder().append(Configuration.TAB_SPACE).append("<head>").append(Configuration.NEWLINE).append(Configuration.getTabs(2)).append("<title>").append(title).append("</title>").append(Configuration.NEWLINE).append(Configuration.TAB_SPACE).append("</head>").toString();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="PARAGRAPH">
    private static String getNewParagraph(String text) {
        return new StringBuilder().append("<p>").append(text).append("</p>").toString();
    }

    public static void addParagraph(String text) {
        if (Configuration.isParagraphToBePrinted) {
            addNeWElementToBody(getNewParagraph(text));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="BASE">
    public static void createBase() {
        HtmlFactory.HTML_BUILDER.append("<!DOCTYPE html>\n<html>\n</html>");
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="BODY">
    public static void addBody() {
        HtmlFactory.HTML_BUILDER.insert(getInsertionPointBefore("</html>"), getNewBody());
    }

    private static String getNewBody() {
        return new StringBuilder().append(Configuration.NEWLINE).append(Configuration.TAB_SPACE).append("<body>").append(Configuration.NEWLINE).append(Configuration.TAB_SPACE).append("</body>").append(Configuration.NEWLINE).toString();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="TABLE">
    public static void addTable(String style, String nameData, String emailData) {
        if (Configuration.isTableToBePrinted) {
            addNeWElementToBody(getNewTable(style, nameData, emailData));
        }
    }

    private static String getNewTable(String style, String nameData, String emailData) {
        return new StringBuilder().append("<table border=\"").append(style).append("\">").append(getTr("Név", nameData)).append(getTr("Elérhetőség", emailData)).append(Configuration.NEWLINE).append(Configuration.getTabs(2)).append("</table>").toString();
    }

    private static StringBuilder getTr(String data1, String data2) {
        if (Configuration.isTrToBePrinted) {
            return new StringBuilder().append(Configuration.NEWLINE).append(Configuration.getTabs(3)).append("<tr>").append(getTd(data1, data2)).append(Configuration.NEWLINE).append(Configuration.getTabs(3)).append("</tr>");
        } else {
            return new StringBuilder("");
        }
    }

    private static StringBuilder getTd(String data1, String data2) {
        if (Configuration.isTdToBePrinted) {
            return new StringBuilder().append(Configuration.NEWLINE).append(Configuration.getTabs(4)).append("<td>").append(data1).append("<td>").append(Configuration.NEWLINE).append(Configuration.getTabs(4)).append("<td>").append(data2).append("<td>");
        } else {
            return new StringBuilder("");
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ADD_NEW_ELEMENT">
    private static void addNeWElementToBody(String element) {
        HtmlFactory.HTML_BUILDER.insert(getInsertionPointBefore("</body>"), getNewElement(element));
    }
    
    public static String getNewElement(String element) {
        return new StringBuilder()
                .append(Configuration.getTabs(1)).append(element)
                .append(Configuration.NEWLINE).append(Configuration.getTabs(1))
                .toString();
    }
    
    private static int getInsertionPointBefore(String tag) {
        return HtmlFactory.HTML_BUILDER.toString().indexOf(tag) - Configuration.NEWLINE.length() + 1;
    }
//</editor-fold>
}
