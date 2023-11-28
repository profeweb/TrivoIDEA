package gui.test;

import gui.BarsDiagram;
import gui.Carrousel;
import processing.core.PApplet;

public class CarrouselTest extends PApplet {

    // Elements de la Interfície Gràfica (Carrousel)
    // Variable Carrousel
    Carrousel c;

    // Noms de les imatges
    String[] noms = {"camera.png", "cocktail.png", "maleta.png", "map.png", "xoquins.png", "mascara.png", "patos.png"};


    public static void main(String[] args) {
        PApplet.main("gui.test.CarrouselTest", args);
    }

    public void settings(){
        size(1200, 800);
        smooth(10);
    }

    public void setup(){

        // Inicialitza el carrousel
        c = new Carrousel(50, 100, 900, 300, 3);
        // Assigna les imatges al carrousel
        c.setImages(this, noms);
        // Assigna les imatges dels botons al carrousel
        c.setButtons(this, "bPrev.png", "bNext.png");
    }

    public void draw() {
        // Fons de la finestra
        background(255);

        // Dibuixa el carrousel
        c.display(this);

        // Actualitza cursor
        updateCursor(this);
    }

    void updateCursor(PApplet p5){
        if(c.checkCursor(p5)){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        // Comprova si ptjam les tecles d'envant i enrera del carrousel
        if (keyCode==LEFT){
            c.prev();
        }
        else if(keyCode==RIGHT){
            c.next();
        }
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){
        // Comprova si clickam sobre els botons del carrousel
        c.checkButtons(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}

