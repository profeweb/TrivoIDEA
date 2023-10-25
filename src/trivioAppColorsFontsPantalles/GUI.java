package trivioAppColorsFontsPantalles;

import processing.core.PApplet;

import static trivioAppColorsFonts.Mides.*;
import static trivioAppLayout.Layout.*;

public class GUI {

    // Enumerat de les Pantalles de l'App
    public enum PANTALLA {INICIAL, DETALLS, ABOUT};
    // Pantalla Actual
    public PANTALLA pantallaActual;

    // Colors i Fonts de l'APP
    Colors appColors;
    Fonts fontsApp;

    // Constructor de la GUI
    public GUI(PApplet p5){
        pantallaActual = PANTALLA.INICIAL;
        appColors = new Colors(p5);   // Constructor dels colors de l'App
        fontsApp = new Fonts(p5);     // Constructor de les fonts de l'App
    }


    // PANTALLES DE LA GUI

    public void dibuixaPantallaInicial(PApplet p5){

        p5.background(55);
        dibuixaLogo(p5);
        dibuixaSideBar(p5);
        dibuixaBanner(p5);
        dibuixaColumnes123(p5);
    }

    public void dibuixaPantallaAbout(PApplet p5){
        p5.background(55);
        dibuixaLogo(p5);
        dibuixaSideBar(p5);
        dibuixaBanner(p5);
        dibuixaColumna1(p5);
    }

    public void dibuixaPantallaDetalls(PApplet p5){
        p5.background(55);
        dibuixaLogo(p5);
        dibuixaSideBar(p5);
        dibuixaBanner(p5);
        dibuixaColumnes12(p5);
    }


    // ZONES DE LA GUI

    public void dibuixaLogo(PApplet p5){
        p5.fill(appColors.getSecondColor());
        p5.rect(marginH, marginV, logoWidth, logoHeight);
        p5.fill(0); p5.textFont(fontsApp.getFirstFont()); p5.textSize(midaTitol);
        p5.text("LOGO", marginH + logoWidth/2, marginV + logoHeight/2);
    }

    public void dibuixaSideBar(PApplet p5){
        // Zona Sidebar ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(appColors.getSecondColor());
        p5.rect(marginH, 2*marginV + logoHeight, sidebarWidth, sidebarHeight);
        p5.fill(0); p5.textFont(fontsApp.getSecondFont()); p5.textSize(midaSubtitol);
        p5.text("SIDEBAR", marginH + sidebarWidth/2, marginV + logoHeight + sidebarHeight/2);
    }

    public void dibuixaBanner(PApplet p5){
        p5.fill(appColors.getColorAt(4));
        p5.rect(2*marginH + logoWidth, marginV, bannerWidth, bannerHeight);
        p5.fill(0); p5.textFont(fontsApp.getSecondFont()); p5.textSize(midaTitol);
        p5.text("PANTALLA " +  pantallaActual + "("+pantallaActual.ordinal() +")", marginH + logoWidth + bannerWidth/2, marginV + bannerHeight/2);
    }

    public void dibuixaColumna1(PApplet p5){
        // Zona Columnes 1, 2 i 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(appColors.getThirdColor());
        p5.rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, 3*columnWidth + 2*marginH, columnHeight);
        p5.fill(0); p5.textFont(fontsApp.getThirdFont()); p5.textSize(midaParagraf);
        p5.text("COLUMN 1", 2*marginH + sidebarWidth + 3*columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);
    }

    public void dibuixaColumnes12(PApplet p5){
        // Zona Columnes 1, 2 i 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(appColors.getThirdColor());
        p5.rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0); p5.textFont(fontsApp.getThirdFont()); p5.textSize(midaParagraf);
        p5.text("COLUMN 1", 2*marginH + sidebarWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        p5.fill(appColors.getThirdColor());
        p5.rect(3*marginH + sidebarWidth + columnWidth, 2*marginV + bannerHeight, 2*columnWidth + marginH, columnHeight);
        p5.fill(0); p5.textFont(fontsApp.getThirdFont()); p5.textSize(midaParagraf);
        p5.text("COLUMN 2", 3*marginH + sidebarWidth + 2*columnWidth, 2*marginV + bannerHeight + columnHeight/2);
    }

    public void dibuixaColumnes123(PApplet p5){
        // Zona Columnes 1, 2 i 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(appColors.getThirdColor());
        p5.rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0); p5.textFont(fontsApp.getThirdFont()); p5.textSize(midaParagraf);
        p5.text("COLUMN 1", 2*marginH + sidebarWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        p5.fill(appColors.getThirdColor());
        p5.rect(3*marginH + sidebarWidth + columnWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0); p5.textFont(fontsApp.getThirdFont()); p5.textSize(midaParagraf);
        p5.text("COLUMN 2", 3*marginH + sidebarWidth + columnWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        p5.fill(appColors.getThirdColor());
        p5.rect(4*marginH + sidebarWidth + 2*columnWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0); p5.textFont(fontsApp.getThirdFont()); p5.textSize(midaParagraf);
        p5.text("COLUMN 3", 4*marginH + sidebarWidth + 2*columnWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);
    }
}
