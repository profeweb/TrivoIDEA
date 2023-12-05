package gui.test;

import gui.Mosaic;
import processing.core.PApplet;

public class MosaicTest extends PApplet {

    // Variable de Mosaic
    Mosaic m;

    // Noms de les imatges
    String[] noms = {"camera.png", "cocktail.png", "maleta.png", "map.png", "xoquins.png", "mascara.png", "patos.png"};

    public static void main(String[] args) {
        PApplet.main("gui.test.MosaicTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){
        // Inicialitza el mosaic
        m = new Mosaic(50,50,700,600, 3, 3);
        // Assigna les imatges al mosaic
        m.setImages(this, noms);

    }

    public void draw() {
        // Fons de la finestra
        background(255);

        // Dibuixa el mosaic
        m.display(this);

    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){
        // Comprovar si clicam sobre les imatges del mosaic
        m.checkImgs(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }
}
