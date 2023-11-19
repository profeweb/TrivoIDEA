package gui.test;

import gui.CheckBox;
import gui.TextArea;
import processing.core.PApplet;

public class TextAreaTest extends PApplet {

    // Elements de la Interfície Gràfica (TextArea)

    // Declaració de les variables
    TextArea areaText;


    public static void main(String[] args) {
        PApplet.main("gui.test.TextAreaTest", args);
    }

    public void settings(){
        size(1200, 600);
        smooth(10);
    }

    public void setup(){
        // Creació dels camps de text
        areaText = new TextArea(this, 100, 100, 600, 250, 40, 5);
    }

    public void draw() {

        background(180);

        // Dibuixa les etiquetes de text
        fill(0); textSize(48); textAlign(LEFT);
        text("Text Area", 100, 60);

        // Dibuixa l'àrea de text
        areaText.display(this);

        // Actualitza el cursor
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if(areaText.mouseOverTextField(p5)){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        areaText.keyPressed(key, (int)keyCode);
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){

        // Si pitjam sobre el textarea
        areaText.isPressed(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
