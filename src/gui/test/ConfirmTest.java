package gui.test;

import gui.Confirm;
import gui.Counter;
import processing.core.PApplet;
import processing.core.PImage;

public class ConfirmTest extends PApplet {

    // Elements de la Interfície Gràfica (Confirm)

    // Confirm
    Confirm c;

    // Dimensions del Confirm
    float compW = 600, compH = 340;

    // Textos del Confirm
    String title = "Confirma!";
    String message = "Vols canviar el color de fons?";

    // Color de fons
    int bgColor;

    public static void main(String[] args) {
        PApplet.main("gui.test.ConfirmTest", args);
    }

    public void settings(){
        size(1200, 600);
        smooth(10);
    }

    public void setup(){

        // Color de fons
        bgColor = color(255);

        // Creació del Confirm
        c = new Confirm(this, title, message, 100, 100, compW, compH);

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
        if((c.bAceptar.mouseOverButton(this) && c.bAceptar.isEnabled()) ||
                (c.bCancelar.mouseOverButton(this) && c.bCancelar.isEnabled())){
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

        if(c.bAceptar.mouseOverButton(this) && c.bAceptar.isEnabled()){
            c.setVisible(false);
            bgColor = color(random(255), random(255), random(255));
        }
        else if(c.bCancelar.mouseOverButton(this) && c.bCancelar.isEnabled()){
            c.setVisible(false);
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
