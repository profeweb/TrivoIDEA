package gui.test;

import gui.Calendari;
import gui.CheckBox;
import processing.core.PApplet;

public class CalendariTest extends PApplet {

    // Elements de la Interfície Gràfica (Calendari)

    // Variable de Calendari
    Calendari c;


    public static void main(String[] args) {
        PApplet.main("gui.test.CalendariTest", args);
    }

    public void settings(){
        size(1200, 800);
        smooth(10);
    }

    public void setup(){

        // Crea el Calendari
        c = new Calendari(50,100,700,550);
    }

    public void draw() {

        // Color de la finestra
        background(200, 100, 100);

        // Dibuixa el calendari
        c.display(this);
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        // Anar un mes enrere
        if(keyCode==LEFT){
            c.prevMonth();
            println("PREV MONTH");
        }
        // Anar un mes endavant
        else if(keyCode==RIGHT){
            c.nextMonth();
            println("PREV MONTH");
        }
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){

        // Comprovar si clicam sobre botons del Calendari
        c.checkButtons(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
