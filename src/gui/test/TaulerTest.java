package gui.test;

import gui.escacs.Tauler;
import processing.core.PApplet;

public class TaulerTest extends PApplet {

    // Elements de la Interfície Gràfica (Tauler)
    // Tauler d'escacs
    Tauler t;

    public static void main(String[] args) {
        PApplet.main("gui.test.TaulerTest", args);
    }

    public void settings(){
        size(900, 900);
        smooth(10);
    }

    public void setup(){
        // Constructor del tauler
        int marge = 50;
        t = new Tauler(this, marge, marge, width-2*marge);
        t.setImatges(this);
        t.colocaFigures();
    }

    public void draw(){

        background(155);

        // Dibuixa el tauler
        t.display(this);

    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(key=='m' || key=='M'){
            // Aplica la jugada seleccionada
            t.mouJugada();
        }
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        // Selecciona caselles del tauler
        t.casellaMouse(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
