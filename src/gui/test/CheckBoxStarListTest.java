package gui.test;

import gui.CheckBoxStarList;
import gui.Tria;
import processing.core.PApplet;

public class CheckBoxStarListTest extends PApplet {

    // Elements de la Interfície Gràfica (CheckBoxStarList)

    // Variable checkboxlist
    CheckBoxStarList cbl;

    // Imatges de les opcions del checkboxstarlist
    String[] imgs = {"starON.png", "starOFF.png"};



    // Color de fons
    int bgColor;

    public static void main(String[] args) {
        PApplet.main("gui.test.CheckBoxStarListTest", args);
    }

    public void settings(){
        size(1200, 600);
        smooth(10);
    }

    public void setup(){

        // Color de fons
        bgColor = color(255);

        // Construcció del checkboxstarlist
        cbl = new CheckBoxStarList(this, 5, imgs, 100, height/2 - 100, 100, 100);
        cbl.setCheckBoxStars(3);
    }

    public void draw() {

        // Fons de la finestra
        background(bgColor);

        // Dibuixam el checkboxlist
        cbl.display(this);

        //Actualitza cursor
        updateCursor(this);

        // Mostra el número d'elements seleccionats
        fill(0); textAlign(CENTER); textSize(24);
        text("Num Stars: "+ cbl.getNumSelected(), width/2, 100);

    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if (cbl.checkCursor(this)) {
            cursor(HAND);
        } else {
            cursor(ARROW);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){

        cbl.checkMouse(this);

    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
