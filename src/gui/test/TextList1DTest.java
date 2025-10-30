package gui.test;

import gui.Button;
import gui.TextList;
import gui.TextList1D;
import processing.core.PApplet;

public class TextList1DTest extends PApplet {

    // Elements de la Interfície Gràfica (TextList)
    TextList1D tList;   // Llista de textos
    Button b;         // Botons

    String[] listValues = {"Alemania", "Angola", "Canada", "Brasil"};
    String selectedText;

    // Dimensions del TextList i Botons
    float tListW = 600, tListH = 60;
    float buttonW = 120, buttonH = 60;

    public static void main(String[] args) {
        PApplet.main("gui.test.TextList1DTest", args);
    }

    public void settings(){
        size(1200, 600);
        smooth(10);
    }

    public void setup(){
        // Creació de la Llista de Textos
        tList = new TextList1D(this, listValues, width/8, height/12, tListW, tListH);

        // Creació del Botó
        b = new Button(this, "TRIA", 3*width/4, height/12, buttonW, buttonH);
    }

    public void draw() {
        // Fons de la finestra
        background(205);

        // Dibuixa la TextList
        tList.display(this);

        // Dibuixa els botons
        b.display(this);

        // Actualitza el cursor
        updateCursor(this);

        // Mostra la informació seleccionada
        if(selectedText!=null){
            pushStyle();
            textAlign(CENTER); fill(0);
            text(selectedText, width/2, height/2);
            popStyle();
        }


    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if( b.mouseOverButton(p5) || tList.mouseOverButtons(p5)){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(tList.getTextField().mouseOverTextField(this)){
            tList.getTextField().keyPressed(key, (int)keyCode);
            tList.update(this);
        }
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){

        // Pitjam sobre el botó de TRIA
        if(b.mouseOverButton(this) && b.isEnabled()){
            selectedText = tList.getSelectedValue();
        }

        // Mirarm si pitjam damunt el textList (camp de text o botó)
        tList.getTextField().isPressed(this);
        tList.buttonPressed(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
