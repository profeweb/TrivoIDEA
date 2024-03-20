package gui.test;

import gui.ListViewer;
import gui.Slider;
import processing.core.PApplet;

public class ListViewerTest extends PApplet {

    // Elements de la Interfície Gràfica (ListViewer)
    ListViewer lv;

    public static void main(String[] args) {
        PApplet.main("gui.test.ListViewerTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        lv = new ListViewer(this, 50, 50, 200, 510);
        lv.setNumItems(10);

        lv.addItemToList("1 Hola");
        lv.addItemToList("2 Hello");
        lv.addItemToList("3 Uep");
        lv.addItemToList("4 Aloha");
        lv.addItemToList("5 Hola");
        lv.addItemToList("6 Hello");
        lv.addItemToList("7 Uep");
        lv.addItemToList("8 Aloha");
        lv.addItemToList("9 Uep");
        lv.addItemToList("10 Aloha");
        lv.addItemToList("11 Uep");
        lv.addItemToList("12 Aloha");
    }

    public void draw(){

        background(255);

        // Dibuixa el ListViewer
        lv.display(this);
        updateCursor();

    }

    void updateCursor(){

        if(lv.bUp.mouseOverButton(this) || lv.bDown.mouseOverButton(this)){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
        }

    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(key=='a' || key=='A'){
            int num = lv.items.size() + 1;
            lv.addItemToList(num + " NOU ELEMENT");
        }
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        lv.buttonPressed(this);
    }

    public void mouseDragged(){
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
