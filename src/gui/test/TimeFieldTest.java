package gui.test;

import gui.TextField;
import gui.TimeField;
import processing.core.PApplet;

public class TimeFieldTest extends PApplet {

    // Elements de la Interfície Gràfica (TimeField)
    TimeField tf;

    public static void main(String[] args) {
        PApplet.main("gui.test.TimeFieldTest", args);
    }

    public void settings(){
        size(800, 800);        // Pantalla HD
        smooth(10);
    }

    public void setup(){
        // Creació del camp de temps
        tf = new TimeField(this, 260, 103, 300, 50);
    }

    public void draw(){
        background(255);
        fill(0); textSize(28);

        // Dibuixa el camp de temps
        tf.display(this);
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        // Comprova i actualitza l'escriptura dins el TimeField
        tf.keyPressed(this, key, (int)keyCode);
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        // Comprova si pitjam amb el mouse sobre el TimeField
        tf.isPressed(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
