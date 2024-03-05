package gui.test;

import gui.Confirm;
import gui.Tria;
import processing.core.PApplet;

public class TriaTest extends PApplet {

    // Elements de la Interfície Gràfica (Tria)

    // Tria de 3 opcions
    Tria c;

    // Dimensions del Confirm
    float compW = 800;
    float compH = 340;

    // Textos del Confirm
    String title = "Canvia de Color!";
    String message = "Tria el nou color de fons";


    // Color de fons
    int bgColor;

    public static void main(String[] args) {
        PApplet.main("gui.test.TriaTest", args);
    }

    public void settings(){
        size(1200, 600);
        smooth(10);
    }

    public void setup(){

        // Color de fons
        bgColor = color(255);

        // Creació del Tria
        c = new Tria(this, title, message, 100, 100, compW, compH);
        c.setTextButtons("Vermell","Verd","Blau");


    }

    public void draw() {

        // Fons de la finestra
        background(bgColor);

        // Dibuixa el Confirm
        c.display(this);

        // Actualitza forma del cursor
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if((c.b1.mouseOverButton(p5) && c.b1.isEnabled()) ||
                (c.b2.mouseOverButton(p5) && c.b2.isEnabled()) ||
                (c.b3.mouseOverButton(p5) && c.b3.isEnabled())){
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

        if(c.b1.mouseOverButton(this) && c.b1.isEnabled()){
            c.setVisible(false);
            bgColor = color(255, 0, 0);
        }
        else if(c.b2.mouseOverButton(this) && c.b2.isEnabled()){
            c.setVisible(false);
            bgColor = color(0, 255, 0);
        }
        else if(c.b3.mouseOverButton(this) && c.b3.isEnabled()){
            c.setVisible(false);
            bgColor = color(0, 0, 255);
        }
        else {
            c.setVisible(true);
        }

    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
