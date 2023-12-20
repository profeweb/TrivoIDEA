package gui.test;

import gui.Button;
import gui.Slider;
import gui.Timer;
import processing.core.PApplet;

public class SliderTest extends PApplet {

    // Elements de la Interfície Gràfica (Slider)
    //Sliders de la gui
    Slider sX, sY, sR;

    public static void main(String[] args) {
        PApplet.main("gui.test.SliderTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){
        // Sliders
        sX = new Slider(this, "X_POS", 50, 50, 300, 50, 0, width, width/2);
        sY = new Slider(this, "Y_POS", 50, 150, 300, 50, 0, height, height/2);
        sR = new Slider(this, "R_SIZE", 50, 250, 300, 50, 5, 50, 10);

    }

    public void draw(){

        background(255);

        // Dibuixa els sliders
        sX.display(this);
        sY.display(this);
        sR.display(this);

        updateCercle();

    }

    void updateCercle(){

        float x = sX.getVaue();
        float y = sY.getVaue();
        float r = sR.getVaue();

        fill(200, 100, 100); strokeWeight(3);
        ellipse(x, y, 2*r, 2*r);
    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        sX.checkSlider(this);
        sY.checkSlider(this);
        sR.checkSlider(this);
    }

    public void mouseDragged(){
        sX.checkSlider(this);
        sY.checkSlider(this);
        sR.checkSlider(this);
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
