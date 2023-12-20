package gui.test;

import gui.LinkList;
import gui.ListItem;
import gui.OpenWeb;
import gui.OrderedListItems;
import processing.core.PApplet;

import java.awt.*;

public class OrderdListItemsTest extends PApplet {

    // Elements de la Interfície Gràfica (OrderedListItems)

    OrderedListItems ol;

    public static void main(String[] args) {
        PApplet.main("gui.test.OrderdListItemsTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){
        // Constructor de la Llista de Link
        ol = new OrderedListItems();
    }

    public void draw() {

        // Fons de la finestra
        background(255);

        // Dibuix de la llista
        ol.display(this, 100, 100, 200, 400);

    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(key== 'a'){
            ol.addItem(new ListItem("HOLA"));
        }

    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
