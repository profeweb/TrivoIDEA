package gui.test;

import gui.MenuButton;
import processing.core.PApplet;

public class MenuButtonTest extends PApplet {

    // Elements de la Interfície Gràfica (TextFields)
    MenuButton mb;
    boolean menuOpened = false;

    public static void main(String[] args) {
        PApplet.main("gui.test.MenuButtonTest", args);
    }

    public void settings(){
        size(800, 800);        // Pantalla HD
        smooth(10);
    }

    public void setup(){
        // Crea els TextFields
        mb = new MenuButton(this, 100, 100, 100, 100);
    }

    public void draw(){
        background(255);
        fill(0); textSize(28);

        // Dibuixa el menu button
        mb.display(this);

        if(menuOpened){
            fill(200, 100, 100); stroke(0); strokeWeight(2);
            rect(205, 100, 400, 400, 5);
            fill(0); textSize(36);
            for(int i=0; i<4; i++) {
                text("Opció de Menú "+ (i+1), 220, 150 + i * 100);
            }
        }

        updateCursor();

    }

    // Estableix quin cursor emprar (HAND, ARROW)
    public void updateCursor(){
        if(mb.mouseOverButton(this)){
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

    public void mousePressed(){
        // Comprova si pitjam amb el mouse sobre el menu button
        if(mb.mouseOverButton(this)){
            menuOpened = !menuOpened;
        }

    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
