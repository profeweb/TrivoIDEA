package gui.test;

import gui.Confirm;
import gui.PopUp;
import processing.core.PApplet;

public class PopUpTest extends PApplet {

    // Elements de la Interfície Gràfica (PopUp)

    // PopUp
    PopUp p;

    // Dimensions del PopUp
    float popW = 600, popH = 340;

    // Textos del PopUp
    String title = "Error!";
    String message = "Error en la connexió a la BBDD.";

    // Color de fons
    int bgColor;

    public static void main(String[] args) {
        PApplet.main("gui.test.PopUpTest", args);
    }

    public void settings(){
        size(1200, 600);
        smooth(10);
    }

    public void setup(){

        // Color de fons
        bgColor = color(255);

        // Creació del PopUp
        p = new PopUp(this, title, message, 100, 100, popW, popH);

    }

    public void draw() {

        // Fons de la finestra
        background(bgColor);

        // Dibuixa el Confirm
        p.display(this);

        // Actualitza forma del cursor
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if((p.bAceptar.mouseOverButton(this) && p.bAceptar.isEnabled())){
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

        if(p.bAceptar.mouseOverButton(this) && p.bAceptar.isEnabled()){
            p.setVisible(false);
        }
        else {
            p.setVisible(true);
        }

    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
