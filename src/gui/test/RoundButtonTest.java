package gui.test;

import gui.Button;
import gui.RoundButton;
import processing.core.PApplet;
import processing.core.PImage;

public class RoundButtonTest extends PApplet {

    // Elements de la Interfície Gràfica (RoundButton)

    // Components de la GUI
    RoundButton b1, b2;

    // Imatges de la GUI
    PImage icona1, icona2;

    // COlor de fons
    int bgColor;

    public static void main(String[] args) {
        PApplet.main("gui.test.ButtonTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        // Color de fons
        bgColor = color(255);

        this.setMedia(this);  // Carrega les imatges

        // Inicialització de components (botons)
        b1 = new RoundButton(this, icona1, 150, 500, 60);
        b2 = new RoundButton(this, icona2, 150, 800, 60);

        bgColor = color(100);

    }

    // Carrega els elements multimedia que utilitzen els components del GUI
    public void setMedia(PApplet p5){
        icona1 = p5.loadImage("data/bulbOn.png");
        icona2 = p5.loadImage("data/bulbOff.png");
    }

    public void draw() {

        // Fons de la finestra
        background(bgColor);

        // Dibuixa els botons
        b1.display(this);
        b2.display(this);

        // Actualitza forma del cursor
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if(b1.mouseOverButton(p5) || b2.mouseOverButton(p5) || b3.mouseOverButton(p5)){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){

        if(b1.mouseOverButton(this)){
            bgColor = color(255, 0, 0);
        }
        else if(b2.mouseOverButton(this)){
            bgColor = color(0, 255, 0);
        }
        else if(b3.mouseOverButton(this)){
            bgColor = color(0, 0, 255);
        }

    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
