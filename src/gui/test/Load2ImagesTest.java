package gui.test;

import gui.Button;
import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;

public class Load2ImagesTest extends PApplet {

    // Elements de la Interfície Gràfica (Load Image)

    // Imatge
    PImage[] imgs;
    String[] titols;
    int numImgs = 0;

    // Botó
    Button b;

    // Color de fons
    int bgColor;


    public static void main(String[] args) {
        PApplet.main("gui.test.Load2ImagesTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        // Color de fons
        bgColor = color(255);

        // Creació del Botó
        b = new Button(this, "IMAGE", 50, height-120, 200, 80);

        imgs = new PImage[2];
        titols = new String[2];

    }

    public void draw() {

        // Fons de la finestra
        background(bgColor);

        // Dibuixa la imatge
        for(int i=0; i<imgs.length; i++) {
            if (imgs[i] != null) {
                image(imgs[i], 50 + i*350, 50, 350, 600);
                textSize(34);
                textAlign(RIGHT);
                fill(0);
                text(titols[i], 750, 350 + i*350);
            } else {
                fill(255);
                rect(50+  i*350, 50, 350 , 600);
                textSize(34);
                textAlign(RIGHT);
                text(i+ "¨: Sense imatge", 750, 350 + i*350);
            }
        }

        // Dibuixa el botó
        b.display(this);

        // Actualitza el cursor
        updateCursor(this);
    }

    // Carrega Imatge
    public void fileSelected(File selection) {
        if (selection == null) {
            println("No s'ha seleccionat cap fitxer.");
        } else {

            // Obtenim la ruta del fitxer seleccionat
            String rutaImatge = selection.getAbsolutePath();

            imgs[numImgs] = loadImage(rutaImatge);  // Actualitzam imatge
            titols[numImgs] = selection.getName();  // Actualitzam títol
            numImgs++;
        }
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if(b.mouseOverButton(p5)){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){
        // Si pitjam sobre el botó
        if(b.mouseOverButton(this)){
            // Obrim el dialeg
            selectInput("Selecciona una imatge ...", "fileSelected");
        }
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
