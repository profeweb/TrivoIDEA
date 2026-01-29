package gui.test;

import gui.ColorPicker;
import processing.core.PApplet;

public class ColorPickerTest extends PApplet {

    // Elements de la Interfície Gràfica (Color Picker)
    ColorPicker cp;

    public static void main(String[] args) {
        PApplet.main("gui.test.ColorPickerTest", args);
    }

    public void settings(){
        size(1200, 800);
        smooth(10);
    }

    public void setup() {
        // Color Picker
        cp = new ColorPicker(this, 200, 100);
    }

    public void draw(){

        background(255);

        // Dibuixa els sliders
        cp.display(this);

    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        cp.keyPressed(this);
    }


    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        cp.mousePressed(this);
    }

    public void mouseDragged(){
        cp.mouseDragged(this);
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
