package gui.test;

import gui.Calendari;
import gui.Setmanari;
import processing.core.PApplet;

public class SetmanariTest extends PApplet {

    // Elements de la Interfície Gràfica (Setmanari)

    // Variable de Setmanari
    Setmanari s;


    public static void main(String[] args) {
        PApplet.main("gui.test.SetmanariTest", args);
    }

    public void settings(){
        size(1200, 800);
        smooth(10);
    }

    public void setup(){
        // Crea el Setmanari
        s = new Setmanari(50,100,700,250);
    }

    public void draw() {

        // Color de la finestra
        background(200, 100, 100);

        // Dibuixa el calendari
        s.display(this);
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){

        // Comprovar si clicam sobre botons del Calendari
        s.checkButtons(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
