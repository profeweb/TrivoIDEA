package gui.test;

import gui.Slider;
import gui.SliderValue;
import processing.core.PApplet;

public class SliderValueTest extends PApplet {

    // Elements de la Interfície Gràfica (Slider)
    //Sliders de la gui
    SliderValue s1;

    public static void main(String[] args) {
        PApplet.main("gui.test.SliderValueTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){
        // Sliders
        s1 = new SliderValue(this, "X_POS", 200, 50, 300, 50, 0, width, width/2);
    }

    public void draw(){

        background(255);

        // Dibuixa els sliders
        s1.display(this);

    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        s1.update(this);
    }


    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        s1.isPressed(this);
    }

    public void mouseDragged(){
        s1.updatecheckSlider(this);
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
