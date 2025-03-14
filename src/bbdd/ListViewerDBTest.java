package bbdd;

import gui.ListViewer;
import gui.Select;
import processing.core.PApplet;

public class ListViewerDBTest extends PApplet {

    // Variable de BBDD
    DataBase db;

    // Elements de la Interfície Gràfica (ListViewer)
    ListViewer lv;

    //
    String[] info;

    public static void main(String[] args) {
        PApplet.main("bbdd.ListViewerDBTest", args);
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
        info = db.getColumnaNomTaulaUnitat();

        // Creació del List viewer
        lv = new ListViewer(this, 50, 50, 300, 210);
        lv.setNumItems(4);

        for(int i=0; i<info.length; i++) {
            lv.addItemToList((i+1) + " " + info[i]);
        }
    }

    public void draw() {
        // Fons de la finestra
        background(255);

        // Dibuixa el ListViewer
        lv.display(this);

        // Actualitza forma del cursor
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if(lv.bUp.mouseOverButton(this) || lv.bDown.mouseOverButton(this)){
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
        lv.buttonPressed(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
