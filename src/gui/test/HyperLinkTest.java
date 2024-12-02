package gui.test;

import gui.Button;
import gui.HyperLink;
import gui.OpenWeb;
import processing.core.PApplet;

import java.awt.*;

public class HyperLinkTest extends PApplet {

    // Elements de la Interfície Gràfica (HyperLink)

    HyperLink hp1, hp2;


    public static void main(String[] args) {
        PApplet.main("gui.test.HyperLinkTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        // Creació dels HyperLinks
        hp1 = new HyperLink(Desktop.getDesktop(), "Google", "http://www.google.com", 300, height/3, 48);
        hp2 = new HyperLink(Desktop.getDesktop(), "Yahoo", "http://www.yahoo.com", 300, 2*height/3, 48);
    }

    public void draw() {

        // Fons de la finestra
        background(255);

        // Dibuixa els hipervincles
        hp1.display(this);
        hp2.display(this);

        // Actualitza forma del cursor
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if(hp1.mouseOverText(p5) || hp2.mouseOverText(this)){
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

        if(hp1.mouseOverText(this)){
            hp1.openWebPage();
        }

        if(hp2.mouseOverText(this)){
            hp2.openWebPage();
        }

    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
