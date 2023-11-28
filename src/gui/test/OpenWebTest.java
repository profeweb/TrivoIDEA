package gui.test;

import gui.Button;
import gui.CheckBox;
import gui.OpenWeb;
import processing.core.PApplet;

import java.awt.*;

public class OpenWebTest extends PApplet {

    // Elements de la Interfície Gràfica (OpenWeb)

    OpenWeb ow;

    // Variables Button
    Button b1, b2;

    // Dimensions dels botons
    float buttonW = 300, buttonH = 100;


    public static void main(String[] args) {
        PApplet.main("gui.test.OpenWebTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        // Creació del mecanisme d'OpenWeb
        ow = new OpenWeb(Desktop.getDesktop());

        // Creació dels botons
        b1 = new Button(this, "IES MANACOR", width/3, height/5, buttonW, buttonH);
        b2 = new Button(this, "GOOGLE", width/3, 3*height/5, buttonW, buttonH);
    }

    public void draw() {

        // Fons de la finestra
        background(255);

        // Dibuixa els botons
        b1.display(this);
        b2.display(this);

        // Actualitza forma del cursor
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if(b1.mouseOverButton(p5)|| b2.mouseOverButton(p5)){
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

        if(b1.mouseOverButton(this) && b1.isEnabled()){
            ow.openWebPage("http://www.iesmanacor.cat");
        }
        else if(b2.mouseOverButton(this) && b2.isEnabled()){
            ow.openWebPage("http://www.google.com");
        }
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
