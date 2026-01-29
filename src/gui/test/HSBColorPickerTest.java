package gui.test;

import gui.HSBColorPicker;
import processing.core.PApplet;

public class HSBColorPickerTest extends PApplet {

    // Elements de la Interfície Gràfica (HueSlider)
    HSBColorPicker sX;

    public static void main(String[] args) {
        PApplet.main("gui.test.HSBColorPickerTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){
        // Sliders
        sX = new HSBColorPicker(this,50, 50, 300, 300);
    }

    public void draw(){

        background(255);

        // Dibuixa els sliders
        sX.display(this);


    }



    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        sX.mousePressed(this);
    }

    public void mouseDragged(){
        sX.mouseDragged(this);
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
