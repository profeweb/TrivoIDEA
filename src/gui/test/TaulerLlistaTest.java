package gui.test;

import gui.ListItem;
import gui.OrderedListItems;
import gui.escacs.Tauler;
import processing.core.PApplet;

public class TaulerLlistaTest extends PApplet {

    // Elements de la Interfície Gràfica (Tauler)
    // Tauler d'escacs
    Tauler t;

    OrderedListItems ol;

    public static void main(String[] args) {
        PApplet.main("gui.test.TaulerLlistaTest", args);
    }

    public void settings(){
        size(1200, 900);
        smooth(10);
    }

    public void setup(){
        // Constructor del tauler
        int marge = 50;
        t = new Tauler(this, marge, marge, 800);
        t.setImatges(this);
        t.colocaFigures();

        // Crea la llista de moviments
        ol = new OrderedListItems();
    }

    public void draw(){

        background(155);

        // Dibuixa el tauler
        t.display(this);

        // Dibuixa la llista de moviments
        ol.display(this, 900, 50, 280, 800);

    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(key=='m' || key=='M'){
            // Aplica la jugada seleccionada
            String sMou = t.getMoviment();
            ol.addItem(new ListItem(sMou));
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
