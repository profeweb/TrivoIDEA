package gui.test;

import gui.escacs.MovimentValid;
import gui.escacs.Posicion;
import gui.escacs.Tauler;
import processing.core.PApplet;

public class MovimentsTaulerTest extends PApplet {

    // Elements de la Interfície Gràfica (Tauler)
    // Tauler d'escacs
    Tauler t;
    MovimentValid moviments;
    Tauler.Escac figura;
    Posicion posicio;

    public static void main(String[] args) {
        PApplet.main("gui.test.MovimentsTaulerTest", args);
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

        t.buidaTauler();

        figura = Tauler.Escac.TORRE_B;
        posicio = new Posicion(2, 4);
        t.colocaFigura(posicio.getFila(), posicio.getColumna(), figura);

        moviments = new MovimentValid(t, figura, posicio);
        moviments.calculaPosicions();

    }

    public void draw(){

        background(155);

        // Dibuixa el tauler
        t.display(this);
        moviments.display(this);

    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(key=='p' || key=='p'){
            figura = Tauler.Escac.PEO_B;
            t.buidaTauler();
            t.colocaFigura(posicio.getFila(), posicio.getColumna(), figura);
            moviments = new MovimentValid(t, figura, posicio);
            moviments.calculaPosicions();
        }
        else if(key=='a' || key=='A'){
            figura = Tauler.Escac.ALFIL_B;
            t.buidaTauler();
            t.colocaFigura(posicio.getFila(), posicio.getColumna(), figura);
            moviments = new MovimentValid(t, figura, posicio);
            moviments.calculaPosicions();
        }
        else if(key=='t' || key=='T'){
            figura = Tauler.Escac.TORRE_B;
            t.buidaTauler();
            t.colocaFigura(posicio.getFila(), posicio.getColumna(), figura);
            moviments = new MovimentValid(t, figura, posicio);
            moviments.calculaPosicions();
        }
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
