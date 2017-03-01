package Model;

public class WebConstants
{
    private String title;
    private String charset = "utf-8";
    private String lang = "en";
    private String metaData = "";
    private String footer = "";

    public WebConstants(String title, String charset, String lang)
    {
        this.title = title;
        this.charset = charset;
        this.lang = lang;
    }
    public WebConstants(String title)
    {
        this.title = title;
    }

    public String getHtmlHead()
    {
        return "<!DOCTYPE html>\n" +
                "<html lang=\""+lang+"\">\n" +
                " <head>\n" +
                "<link rel=\"stylesheet\" href=\"css/uikit.min.css\" />\n" +
                "        <script src=\"js/jquery.js\"></script>\n" +
                "        <script src=\"js/uikit.min.js\"></script>" +
                "  <meta charset=\"" + charset + "\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
                metaData + "\n" +
                "  <title>" + title + "</title>\n" +
                " </head> \n" +
                " <body>";
    }

    public String getFooter()
    {
        return " <footer>\n" +
                "    " + footer + "\n" +
                "               <div class=\"uk-background-muted uk-padding uk-panel\">\n" +
                "                   <hr class=\"uk-divider-icon\">" +
                "                   <p class=\"uk-text-small\">Created by <a href=\"https://ramizdemiurge.github.io/\">Ramiz Abdullayev</a>. Licensed under <a href=\"http://www.apache.org/licenses/LICENSE-2.0\">Apache License Version 2.0</a></p>"+
                "               </div>\n" +
                "       </footer>\n" +
                "   </body> \n" +
                "</html>";
    }

    public void addMetaData(String metaData)
    {
        this.metaData += metaData;
    }
    public void addFooter(String footer)
    {
        this.footer += footer;
    }

}
