package gui.test;

import gui.TextField;
import processing.core.PApplet;

public class TextFieldTest extends PApplet {

    // Elements de la Interfície Gràfica (TextFields)
    TextField tf1, tf2;

    public static void main(String[] args) {
        PApplet.main("gui.test.TextFieldTest", args);
    }

    public void settings(){
        size(800, 800);        // Pantalla HD
        smooth(10);
    }

    public void setup(){
        // Crea els TextFields
        tf1 = new TextField(this, 200, 200, 400, 40);
        tf2 = new TextField(this, 200, 400, 400, 40);
    }

    public void draw(){
        background(255);
        fill(0); textSize(28);

        // Dibuixa els TextFields

        text("USER NAME: ", 200, 180);
        tf1.display(this);

        text("PASSWORD: ", 200, 380);
        tf2.display(this);

        // Si el login és correcte
        if (comprovaLogin()) {
            text("YOU ARE LOGGED IN!", 200, 100);
        }
    }


    boolean comprovaLogin() {
        return ( tf1.text.equals("admin") && tf2.text.equals("1234"));
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        // Comprova i actualitza l'escriptura dins els TextFields
        tf1.keyPressed(key, keyCode);
        tf2.keyPressed(key, keyCode);
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        // Comprova si pitjam amb el mouse sobre els TextFields
        tf1.isPressed(this);
        tf2.isPressed(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
