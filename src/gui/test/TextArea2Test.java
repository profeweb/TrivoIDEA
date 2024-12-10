package gui.test;

import gui.TextArea;
import gui.TextArea2;
import processing.core.PApplet;

public class TextArea2Test extends PApplet {

    // Elements de la Interfície Gràfica (TextArea)

    // Declaració de les variables
    TextArea2 areaText;


    public static void main(String[] args) {
        PApplet.main("gui.test.TextArea2Test", args);
    }

    public void settings(){
        size(1200, 600);
        smooth(10);
    }

    public void setup(){
        // Creació dels camps de text
        areaText = new TextArea2(this, 100, 100, 600, 250, 20, 6);
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
