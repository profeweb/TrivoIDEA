package trivioAppColorsFonts;

import processing.core.PApplet;

import static trivioAppColorsFonts.Layout.*;
import static trivioAppColorsFonts.Mides.*;

public class Trivio004 extends PApplet {

    Colors appColors;   // Colors de l'App
    Fonts fontsApp;     // Tipografies de l'App

    public static void main(String[] args) {
        PApplet.main("trivioAppColorsFonts.Trivio004", args);
    }

    public void settings(){
        //fullScreen();                       // Pantalla completa
        size(1920, 1080);        // Pantalla HD
        smooth(10);
    }

    public void setup(){
        noStroke();                         // Sense bordes
        textAlign(CENTER); textSize(18);   // Alineació i mida del text

        appColors = new Colors(this);   // Constructor dels colors de l'App
        fontsApp = new Fonts(this);     // Constructor de les fonts de l'App
    }

    public void draw(){

        // Dibuixa el fons (gris)
        background(55);    // Color de fons

        // Zona Principal +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        fill(appColors.getFirstColor());
        rect(marginH, marginV, width - marginH*2, height - marginV*2);

        // Zona Logo ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        fill(appColors.getSecondColor());
        rect(marginH, marginV, logoWidth, logoHeight);
        fill(0);textFont(fontsApp.getFirstFont()); textSize(midaTitol);
        text("LOGO", marginH + logoWidth/2, marginV + logoHeight/2);

        // Zona Sidebar ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        fill(appColors.getSecondColor());
        rect(marginH, 2*marginV + logoHeight, sidebarWidth, sidebarHeight);
        fill(0); textFont(fontsApp.getSecondFont()); textSize(midaSubtitol);
        text("SIDEBAR", marginH + sidebarWidth/2, marginV + logoHeight + sidebarHeight/2);

        // Zona Banner +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        fill(appColors.getColorAt(4));
        rect(2*marginH + logoWidth, marginV, bannerWidth, bannerHeight);
        fill(0); textFont(fontsApp.getSecondFont()); textSize(midaTitol);
        text("BANNER", marginH + logoWidth + bannerWidth/2, marginV + bannerHeight/2);


        // Zona Columnes 1, 2 i 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        fill(appColors.getThirdColor());
        rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        fill(0); textFont(fontsApp.getThirdFont()); textSize(midaParagraf);
        text("COLUMN 1", 2*marginH + sidebarWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        fill(appColors.getThirdColor());
        rect(3*marginH + sidebarWidth + columnWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        fill(0); textFont(fontsApp.getThirdFont()); textSize(midaParagraf);
        text("COLUMN 2", 3*marginH + sidebarWidth + columnWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        fill(appColors.getThirdColor());
        rect(4*marginH + sidebarWidth + 2*columnWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        fill(0); textFont(fontsApp.getThirdFont()); textSize(midaParagraf);
        text("COLUMN 3", 4*marginH + sidebarWidth + 2*columnWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        println("KEY PRESSED");
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        println("X: "+mouseX+", Y:"+mouseY);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
