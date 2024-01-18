package gui.test;

import gui.ArrayButtons;
import gui.BarsDiagram;
import processing.core.PApplet;

public class ArrayButtonTest extends PApplet {

    // Elements de la Interfície Gràfica (ArrayButton)

    ArrayButtons buttons;
    boolean cursorHand = false;

    // Dimensions dels botons
    float buttonW = 50;

    // Espai entre els botons
    float buttonS = 5;

    // Color de fons de l'App
    int bgColor = color(255);


    public static void main(String[] args) {
        PApplet.main("gui.test.ArrayButtonTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        // Creació de l'Array de 10 Botons
        buttons = new ArrayButtons(this, 10, 100, height/2, buttonW, buttonS);

    }

    public void draw() {
        // Fons de la finestra
        background(bgColor);

        // Dibuixa els botons
        buttons.display(this);

        // Indica la pàgina actual
        fill(0); textAlign(CENTER); textSize(28);
        text("PÀGINA: "+ buttons.getCurrentButton(), width/2, 200);

        // Actualitza forma del cursor
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5) {
        if (buttons.checkMouseOver(p5)) {
            cursor(HAND);
        } else {
            cursor(ARROW);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){
        buttons.checkMousePressed(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}

