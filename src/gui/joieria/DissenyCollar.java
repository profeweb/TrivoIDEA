package gui.joieria;

import processing.core.PApplet;

public class DissenyCollar extends PApplet {

    // Variable de classe Collar
    Collar c;

    public static void main(String[] args) {
        PApplet.main("gui.joieria.DissenyCollar", args);
    }

    public void settings(){
        size(1200, 800);
        smooth(10);
    }

    public void setup(){
        // Constructor de Collar (de màxim 10 ornaments)
        c = new Collar(10, width/2, height/2, 200, 300);
    }

    public void draw() {
        // Fons de la finestra
        background(255);

        // Dibuix del Collar
        c.display(this);

    }

    public Ornament creaOrnamentAleatori(){
        int numRandom = floor(random(3));
        switch (numRandom){
            case 0: return new OrnamentCercle(width/2, height/2, 50, color(255, 0, 0));
            case 1: return new OrnamentTriangle(width/2, height/2, 50, color(0, 255, 0));
            case 2: return new OrnamentEstrella(width/2, height/2, 50, color(255, 0, 255), 50, 8);
            default: return new Ornament(width/2, height/2, 50, color(100));
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(key=='a' || key=='A'){
            Ornament o = creaOrnamentAleatori();
            c.addOrnament(o);
        }
        else if(key=='r' || key=='R'){
            c.resetOrnaments();
        }
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){
        c.checkDragged(this);
    }

    public void mouseDragged(){
        c.checkDragged(this);
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }
}
