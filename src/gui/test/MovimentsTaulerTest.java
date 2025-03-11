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

        // Col·loca la figura en el tauler a la posició indicada
        figura = Tauler.Escac.TORRE_B;
        posicio = new Posicion(2, 4);
        t.colocaFigura(posicio.getFila(), posicio.getColumna(), figura);

        // Calcula els moviments vàlids de la figura en el tauler
        moviments = new MovimentValid(t, figura, posicio);
        moviments.calculaPosicions();

    }

    public void draw(){

        background(155);

        // Dibuixa el tauler
        t.display(this);

        // Dibuixa els moviments sobre el tauler
        moviments.display(this);

    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(key=='p' || key=='p'){
            // Per un PEÓ
            figura = Tauler.Escac.PEO_B;
            t.buidaTauler();
            t.colocaFigura(posicio.getFila(), posicio.getColumna(), figura);
            moviments = new MovimentValid(t, figura, posicio);
            moviments.calculaPosicions();
        }
        else if(key=='a' || key=='A'){
            // Per un ALFIL
            figura = Tauler.Escac.ALFIL_B;
            t.buidaTauler();
            t.colocaFigura(posicio.getFila(), posicio.getColumna(), figura);
            moviments = new MovimentValid(t, figura, posicio);
            moviments.calculaPosicions();
        }
        else if(key=='t' || key=='T'){
            // Per una TORRE
            figura = Tauler.Escac.TORRE_B;
            t.buidaTauler();
            t.colocaFigura(posicio.getFila(), posicio.getColumna(), figura);
            moviments = new MovimentValid(t, figura, posicio);
            moviments.calculaPosicions();
        }
        else if(key=='c' || key=='C'){
            // Per una CAVALL
            figura = Tauler.Escac.CAVALL_B;
            t.buidaTauler();
            t.colocaFigura(posicio.getFila(), posicio.getColumna(), figura);
            moviments = new MovimentValid(t, figura, posicio);
            moviments.calculaPosicions();
        }
        else if(key=='k' || key=='K'){
            // Per una REI
            figura = Tauler.Escac.REI_B;
            t.buidaTauler();
            t.colocaFigura(posicio.getFila(), posicio.getColumna(), figura);
            moviments = new MovimentValid(t, figura, posicio);
            moviments.calculaPosicions();
        }
        else if(key=='q' || key=='Q'){
            // Per una REINA
            figura = Tauler.Escac.REINA_B;
            t.buidaTauler();
            t.colocaFigura(posicio.getFila(), posicio.getColumna(), figura);
            moviments = new MovimentValid(t, figura, posicio);
            moviments.calculaPosicions();
        }
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        int f = (int) random(0, 8);
        int c = (int) random(0, 8);
        posicio.setFila(f);
        posicio.setColumna(c);
        t.buidaTauler();
        t.colocaFigura(posicio.getFila(), posicio.getColumna(), figura);
        moviments = new MovimentValid(t, figura, posicio);
        moviments.calculaPosicions();
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
