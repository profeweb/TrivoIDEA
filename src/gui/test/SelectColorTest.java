package gui.test;

import gui.SelectColor;
import processing.core.PApplet;

public class SelectColorTest extends PApplet {

    // Elements de la Interfície Gràfica (SelectColor)
    SelectColor sc;

    // Valors dels Selects
    int[] selectValues = {color(255,0,0), color(0,255,0), color(0,0,255), color(255, 255, 0)};

    // Dimensions dels botons
    float selectW = 300, selectH = 50;

    // Color de fons de l'App
    int bgColor = color(255);

    public static void main(String[] args) {
        PApplet.main("gui.test.SelectColorTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){
        // Creació del select de colors
        sc = new SelectColor(this, selectValues, width/4, height/5, selectW, selectH);

    }

    public void draw() {
        // Fons de la finestra
        background(bgColor);

        // Rectangle del color seleccionat
        fill(sc.getSelectedValue()); noStroke();
        rect(0, height/2, width, height/2);

        // Dibuixa el select
        sc.display(this);

        // Actualitza forma del cursor
        updateCursor(this);

    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if((sc.mouseOverSelect(p5) && sc.isEnabled())){
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

        // Si pitjam sobre el select de colors
        if(sc.mouseOverSelect(this) && sc.isEnabled()){
            if(!sc.isCollapsed()){
                sc.update(this);      // Actualitzar valor
            }
            sc.toggle();        // Plegar o desplegar
        }
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
