package gui.test;

import gui.Button;
import processing.core.PApplet;

public class ButtonTest extends PApplet {

    // Elements de la Interfície Gràfica (Button)

    // Botons
    Button b1, b2, b3;

    // Dimensions dels botons
    float buttonWidth = 300;
    float buttonHeight = 50;

    // Color de fons
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

        // Creació del Tria
        b1 = new Button(this, "RED", 200, 200, buttonWidth, buttonHeight);
        b2 = new Button(this, "GREEN", 200, 400, buttonWidth, buttonHeight);
        b3 = new Button(this, "BLUE", 200, 600, buttonWidth, buttonHeight);

    }

    public void draw() {

        // Fons de la finestra
        background(bgColor);

        // Dibuixa els botons
        b1.display(this);
        b2.display(this);
        b3.display(this);

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
