package gui.test;

import gui.Button;
import gui.Canvas;
import gui.Pissarra;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

import java.io.File;

public class PissarraTest extends PApplet {

    // Elements de la Interfície Gràfica (Canvas)
    Pissarra c;

    // Capa de dibuix
    PGraphics dibuix;
    int colorDibuix = color(255, 0, 0);

    // Botó
    Button bReset, bSave;

    // Color de fons de l'App
    int bgColor = color(255);


    public static void main(String[] args) {
        PApplet.main("gui.test.PissarraTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        // Creació del Botons
        bReset = new Button(this, "RESET", 300, height-120, 200, 80);
        bSave = new Button(this, "SAVE", 550, height-120, 200, 80);

        // Creació del canvas
        c = new Pissarra(10, 10, width-20, 600);

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
            image(dibuix, 10, 10, width-20, 600);
        }

        // Dibuixa els botons
        bReset.display(this);
        bSave.display(this);

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
        if(bSave.mouseOverButton(p5) ||
                bReset.mouseOverButton(p5)){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
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

        // Resetea el dibuix i el canvas
        if(bReset.mouseOverButton(this)){
            dibuix = createGraphics(500, 500);
            c.resetCanvas();
        }
        // Guarda el dibuix i el canvas en una imatge a la carpeta
        else if(bSave.mouseOverButton(this)){
            //save(this, c, dibuix, "C:\\Users\\tonim\\IdeaProjects\\TrivoIDEA\\data", "imatgeMur123");
        }
    }

    public void saveImatgeMur(PApplet p5, Canvas c, PGraphics dibuix, String ruta, String nomImatge){
        PGraphics imgSave = p5.createGraphics(500, 500);
        imgSave.beginDraw();
        imgSave.image(c.getCanvas(), 0, 0);
        imgSave.image(dibuix, 0, 0);
        imgSave.endDraw();
        imgSave.save(ruta +"/" +nomImatge+".jpg");
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

