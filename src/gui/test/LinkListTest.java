package gui.test;

import gui.Button;
import gui.LinkList;
import gui.OpenWeb;
import processing.core.PApplet;

import java.awt.*;

public class LinkListTest extends PApplet {

    // Elements de la Interfície Gràfica (LinkList, OpenWeb)

    OpenWeb ow;
    LinkList l;

    // Dades de la llista de links
    String[][] info = { {"Google", "http://www.google.com"},
                        {"IES Manacor", "http://www.iesmanacor.cat"},
                        {"Diari ElPais", "http://www.elpais.es"},
                        {"Diari Marca",  "http://www.marca.com"},
                        {"El Tiempo", "http://www.eltiempo.es"},
    };


    public static void main(String[] args) {
        PApplet.main("gui.test.LinkListTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        // Creació del mecanisme d'OpenWeb
        ow = new OpenWeb(Desktop.getDesktop());

        // Constructor de la Llista de Link
        l = new LinkList(4, 100, 100, 300, 350);
        l.setData(info);
    }

    public void draw() {

        // Fons de la finestra
        background(255);

        // Dibuix de la llista de Links
        l.display(this);

        // Actualitza forma del cursor
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if(l.mouseOver(p5)){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(keyCode==LEFT){
            l.prevPage();
        }
        else if(keyCode==RIGHT){
            l.nextPage();
        }
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){

        l.checkClicks(this, ow);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
