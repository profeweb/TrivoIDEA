package bbdd;

import gui.TextList;
import processing.core.PApplet;

public class TextListDBTest extends PApplet {

    // Variable de BBDD
    DataBase db;

    TextList tList;   // Llista de textos

    // Dades de la taula ( a emplenar amb BBDD)
    String[][] info;

    public static void main(String[] args) {
        PApplet.main("bbdd.TextListDBTest", args);
    }

    public void settings(){
        size(1200, 600);
        smooth(10);
    }

    public void setup(){

        // Configura els paràmetres de connexió a la BBDD
        db = new DataBase("admin", "12345", "trivio");
        // Connecta amb la BBDD
        db.connect();

        // Agafa els valors de la columne NOM de la taula UNITAT
        info = db.getInfoTaulaUnitat();

        // Creació de la Llista de Textos
        tList = new TextList(this, info, width/8, height/12, 600, 60);

    }

    public void draw(){
        background(255);
        fill(0); textSize(28);

        // Dibuixa la TextList
        tList.display(this);

        // Actualitza el cursor
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if(tList.mouseOverButtons(p5)){
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

    public void mousePressed(){
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
