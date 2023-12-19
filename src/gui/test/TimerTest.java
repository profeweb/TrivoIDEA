package gui.test;

import gui.Button;
import gui.TextField;
import gui.Timer;
import processing.core.PApplet;

public class TimerTest extends PApplet {

    // Elements de la Interfície Gràfica (Timer)
    Timer t;

    Button b;

    // Color de fons
    int bgColor = color(0);

    public static void main(String[] args) {
        PApplet.main("gui.test.TimerTest", args);
    }

    public void settings(){
        size(800, 800);        // Pantalla HD
        smooth(10);
    }

    public void setup(){
        // Timer de 10 segons
        t = new Timer(this,10);

        b = new Button(this, "START", 10, 10, 100, 50);
    }

    public void draw(){

        background(bgColor);

        // Actualitza el color de fons
        updateColor();

        fill(255); textSize(64); textAlign(CENTER);
        text(t.getNumSeconds(), width/2, height/2);

        b.display(this);

    }

    void updateColor(){

        // Si s'ha esgotat el timer, canviam el color
        if(t.timeOver()){
            bgColor = color(random(255), random(255), random(255));
        }

        // Actualitza el timer
        t.update(this);
    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        if(b.mouseOverButton(this)){
            t.start(this);
        }
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
