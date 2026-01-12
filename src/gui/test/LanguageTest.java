package gui.test;

import gui.Button;
import gui.LanguagesInfo;
import gui.Tria;
import processing.core.PApplet;

public class LanguageTest extends PApplet {

    // Elements de la Interfície Gràfica (Button)

    // Botons
    Button b1, b2, b3;
    LanguagesInfo languagesInfo;

    // Tria de 3 opcions (idiomes)
    Tria c;

    // Dimensions dels botons
    float buttonWidth = 300;
    float buttonHeight = 50;

    // Color de fons
    int bgColor;

    public static void main(String[] args) {
        PApplet.main("gui.test.LanguageTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        // Color de fons
        bgColor = color(255);

        // Creació dels botons
        b1 = new Button(this, "TEXT_B1", 250, 500, buttonWidth, buttonHeight);
        b2 = new Button(this, "TEXT_B2", 250, 600, buttonWidth, buttonHeight);
        b3 = new Button(this, "TEXT_B3", 250, 700, buttonWidth, buttonHeight);

        languagesInfo = new LanguagesInfo(this, "languages.txt");
        languagesInfo.setLanguage(languagesInfo.ENGLISH);
        updateTranslations();

        // Creació del Tria
        c = new Tria(this, "Idioma", "Tria el teu idioma: ", 100, 50, 600, 340);
        c.setTextButtons("ENG","SPA","CAT");

    }

    public void updateTranslations(){
        b1.setTextBoto(languagesInfo.getTranslation("TXT_B1"));
        b2.setTextBoto(languagesInfo.getTranslation("TXT_B2"));
        b3.setTextBoto(languagesInfo.getTranslation("TXT_B3"));
    }

    public void draw() {

        // Fons de la finestra
        background(bgColor);

        // Dibuixa els botons
        b1.display(this);
        b2.display(this);
        b3.display(this);

        // Dibuixa el tria
        c.display(this);

        // Actualitza forma del cursor
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if(b1.mouseOverButton(p5) || b2.mouseOverButton(p5) || b3.mouseOverButton(p5) ||
        c.b1.mouseOverButton(p5) || c.b2.mouseOverButton(p5) || c.b3.mouseOverButton(p5)){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        c.setVisible(true);
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){

        if(c.b1.mouseOverButton(this) && c.b1.isEnabled()){
            c.setVisible(false);
            languagesInfo.setLanguage(languagesInfo.ENGLISH);
            updateTranslations();
        }
        else if(c.b2.mouseOverButton(this) && c.b2.isEnabled()){
            c.setVisible(false);
            languagesInfo.setLanguage(languagesInfo.SPANISH);
            updateTranslations();
        }
        else if(c.b3.mouseOverButton(this) && c.b3.isEnabled()){
            c.setVisible(false);
            languagesInfo.setLanguage(languagesInfo.CATALAN);
            updateTranslations();
        }

    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
