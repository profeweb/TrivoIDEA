package gui;

import java.awt.Desktop;
import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;

public class OpenWeb {

    Desktop desktop;

    public OpenWeb(Desktop d){
        this.desktop = d;
    }

    public void openWebPage(String siteUrl) {
        try {
            URI site = new URI(siteUrl);
            if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(site);
            } else {
                System.out.println("App no suporta el navegador");
            }
        } catch(URISyntaxException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
