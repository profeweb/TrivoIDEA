package gui.test;

import gui.CheckBox;
import gui.Counter;
import processing.core.PApplet;
import processing.core.PImage;

public class CounterTest extends PApplet {

    // Elements de la Interfície Gràfica (Checkbox)

    // Comptadors de la GUI
    Counter cr, cg, cb;

    // Icones dels botons
    PImage icona1, icona2;

    // Dimensions dels botons
    float counterW = 200, counterH = 80;

    // Color de fons
    int bgColor;


    public static void main(String[] args) {
        PApplet.main("gui.test.CounterTest", args);
    }

    public void settings(){
        size(1200, 600);
        smooth(10);
    }

    public void setup(){

        // Color de fons
        bgColor = color(255);

        // Carregar de les imatges (icones);
        icona1 = loadImage("mes.png");
        icona2 = loadImage("menys.png");

        // Creació dels botons
        cr = new Counter(this, icona1, icona2, width/4, height/4, counterW, counterH);
        cg = new Counter(this, icona1, icona2, width/4, height/2, counterW, counterH);
        cb = new Counter(this, icona1, icona2, width/4, 3*height/4, counterW, counterH);

    }

    public void draw() {

        // Fons de la finestra
        background(bgColor);

        // Dibuixa els botons
        cr.display(this);
        cg.display(this);
        cb.display(this);

        // Actualitza forma del cursor
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if(cr.mouseOverButtons(p5)|| cg.mouseOverButtons(p5) || cb.mouseOverButtons(p5)){
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

        cr.update(this);
        cg.update(this);
        cb.update(this);

        bgColor = color (cr.getValue(), cg.getValue(), cb.getValue());

    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
