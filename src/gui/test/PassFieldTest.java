package gui.test;

import gui.PassField;
import gui.TextField;
import processing.core.PApplet;

public class PassFieldTest extends PApplet {

    // Elements de la Interfície Gràfica (PassField)
    PassField pf1;

    public static void main(String[] args) {
        PApplet.main("gui.test.PassFieldTest", args);
    }

    public void settings(){
        size(800, 800);        // Pantalla HD
        smooth(10);
    }

    public void setup(){
        // Crea el PassField
        pf1 = new PassField(this, 200, 200, 400, 40);
    }

    public void draw(){
        background(255);
        fill(0); textSize(28);

        // Dibuixa els TextFields

        text("PASSWORD: ", 200, 180);
        pf1.display(this);

        // Si el login és correcte
        if (comprovaLogin()) {
            text("PASSWORD OK!", 200, 100);
        }
    }


    boolean comprovaLogin() {
        return ( pf1.text.equals("12345"));
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        // Comprova i actualitza l'escriptura dins els TextFields
        pf1.keyPressed(key, keyCode);
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        // Comprova si pitjam amb el mouse sobre els TextFields
        pf1.isPressed(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
