package gui.test;

import gui.Button;
import gui.Calendari;
import gui.CalendariPlus;
import processing.core.PApplet;

public class CalendariPlusTest extends PApplet {

    // Elements de la Interfície Gràfica (CalendariPlus - Desplegable amb botons-)

    // Variable de CalendariPlus
    CalendariPlus c;
    String dataCalendari = "";

    // Botó de visiblitat del calendari
    Button b;


    public static void main(String[] args) {
        PApplet.main("gui.test.CalendariPlusTest", args);
    }

    public void settings(){
        size(1200, 800);
        smooth(10);
    }

    public void setup(){

        // Crea el Calendari
        c = new CalendariPlus(this,50,200,700,550);

        // Crea el Botó
        b= new Button(this, "Calendari", 10, 10, 150, 50);
    }

    public void draw() {

        // Fons
        background(200, 100, 100);

        // Rectangle
        fill(255); rect(180, 10, 200, 50, 5);

        // Text amb data seleccionada
        fill(0); textAlign(LEFT); textSize(24);
        text(dataCalendari, 190, 45);

        // Dibuixa el calendari
        c.display(this);

        // Dibuixa el botó
        b.display(this);
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){

        // Comprovar si clicam sobre botons del Calendari
        c.checkButtons(this);

        // Si pitja el botó, canvia la visibilitat del calendari.
        if(b.mouseOverButton(this)&&b.isEnabled()){
            c.toggleVisibility();
        }
        // Si pitjam el botó de Next, canviarà al seguent mes
        if(c.bNext.mouseOverButton(this)){
            c.nextMonth();
        }
        // Si pitjam el botó de Prev, canviarà al mes anterior
        if(c.bPrev.mouseOverButton(this)){
            c.prevMonth();
        }
        // Si pitjam el botó de OK, confirmarà la data seleccionada i amagarà el calendari
        if(c.bOK.mouseOverButton(this) && c.isDateSelected()){
            dataCalendari = c.getSelectedDate();
            c.setVisible(false);
        }
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
