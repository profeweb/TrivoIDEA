package gui.test;

import gui.HueSlider;
import processing.core.PApplet;

public class HueSliderTest extends PApplet {

    // Elements de la Interfície Gràfica (HueSlider)
    HueSlider sX;

    public static void main(String[] args) {
        PApplet.main("gui.test.HueSliderTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){
        // Sliders
        sX = new HueSlider(this,50, 50, 300, 50);
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
        sX.checkSlider(this);
    }

    public void mouseDragged(){
        sX.checkSlider(this);
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
