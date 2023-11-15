package gui.test;

import gui.RadioButton;
import gui.RadioButtonGroup;
import processing.core.PApplet;

public class RadioButtonGroupTest extends PApplet {

    // Elements de la Interfície Gràfica (RadioButtonGroup)

    // Variables radio buttons
    RadioButton rb1, rb2, rb3;

    // Variable radio button group
    RadioButtonGroup rbg;

    // Variables del color (RGB)
    float r, g, b;

    public static void main(String[] args) {
        PApplet.main("gui.test.RadioButtonGroupTest", args);
    }

    public void settings(){
        size(1200, 600);
        smooth(10);
    }

    public void setup(){
        // Creació dels radiobuttons
        rb1 = new RadioButton(this, 180,75,15);
        rb2 = new RadioButton(this, 180,175,15);
        rb3 = new RadioButton(this, 180,275,15);

        //Construcció del radio button group
        rbg = new RadioButtonGroup(3);
        rbg.setRadioButtons(rb1, rb2, rb3);   // Format pels 3 radio buttons
        rbg.setSelected(2);
    }

    public void draw() {
        // Fons de la finestra
        background(r, g, b);

        if(r==g && g==b && r==0){
            fill(255);
        }
        else {
            fill(0);
        }
        textSize(24);
        text("RED", 100, 85);
        text("GREEN", 70, 185);
        text("BLUE", 90, 285);

        // Dibuixam el radio button group
        rbg.display(this);

        // Actualitza el cursor (HAND o ARROW)
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if(rb1.onMouseOver(p5) || rb2.onMouseOver(p5)  || rb3.onMouseOver(p5)){
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

        // Si pitjam sobre el radiobuttongroup
        rbg.updateOnClick(this);

        // Miram el seu valor, per actualitzar r,g i b
        r = rb1.isChecked() ? 255 : 0;
        g = rb2.isChecked() ? 255 : 0;
        b = rb3.isChecked() ? 255 : 0;
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
