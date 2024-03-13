package gui.test;

import gui.ArrayButtons;
import gui.Button;
import gui.Canvas;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

import java.io.File;

public class CanvasTest extends PApplet {

    // Elements de la Interfície Gràfica (Canvas)
    Canvas c;

    // Capa de dibuix
    PGraphics dibuix;
    int colorDibuix = color(255, 0, 0);

    // Darrera imatge carregada
    PImage img;

    // Botó
    Button bImg, bReset;

    // Color de fons de l'App
    int bgColor = color(255);


    public static void main(String[] args) {
        PApplet.main("gui.test.CanvasTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        // Creació del Botons
        bImg = new Button(this, "IMAGE", 50, height-120, 200, 80);
        bReset = new Button(this, "RESET", 300, height-120, 200, 80);

        // Creació del canvas
        c = new Canvas(10, 10, 500, 500);

        // Crea el dibuix buit
        dibuix = createGraphics(500, 500);

    }

    public void draw() {
        // Fons de la finestra
        background(bgColor);

        // Dibuixa el canvas
        c.display(this);

        // Dibuixa el dibuix
        if(dibuix!=null){
            image(dibuix, 10, 10, 500, 500);
        }


        // Dibuixa la darrera imatge carregada
        rect(600, 10, 100, 100);
        if(img!=null){
            image(img, 600, 10, 100, 100);
            fill(0); textSize(10);
            text("Darrera imatge carregada", 600, 120);
        }


        // Dibuixa el tipus de distribució
        textSize(18); fill(0);
        text(c.getDistribucio(), 100, 600);

        // Dibuixa els botons
        bImg.display(this);
        bReset.display(this);

        // Actualitza el cursor
        updateCursor(this);
    }

    // Fa el dibuix del color corresponent
    void ferDibuix(int c){
        dibuix.beginDraw();
        dibuix.fill(c);
        dibuix.noStroke();
        dibuix.circle(mouseX, mouseY, 50);
        dibuix.endDraw();
    }

    // Modifica el cursor
    void updateCursor(PApplet p5) {
        if(bImg.mouseOverButton(p5) ||
                bReset.mouseOverButton(p5)){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
        }
    }

    // Carrega Imatge
    public void fileSelected(File selection) {
        if (selection == null) {
            println("No s'ha seleccionat cap fitxer.");
        } else {

            // Obtenim la ruta del fitxer seleccionat
            String rutaImatge = selection.getAbsolutePath();

            img = loadImage(rutaImatge);  // Actualitzam imatge
            // Afegeix la nova imatge a l'array d'imatges
            c.addImage(this, img);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        // Canvia el color del dibuix
        if(key=='c' || key=='C'){
            colorDibuix = color(random(255), random(255), random(255));
        }
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){
        // Selecciona una nova imatge
        if(bImg.mouseOverButton(this)){
            selectInput("Selecciona una imatge ...", "fileSelected");
        }
        // Resetea el dibuix i el canvas
        else if(bReset.mouseOverButton(this)){
            dibuix = createGraphics(500, 500);
            c.resetCanvas();
        }
    }

    public void mouseDragged(){
        if(c.mouseOver(this)){
            ferDibuix(colorDibuix);
        }
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}

