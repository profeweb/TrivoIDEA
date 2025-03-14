package bbdd;

import gui.ListViewer;
import gui.RadioButton;
import gui.RadioButtonGroup;
import processing.core.PApplet;

public class RadioButonGroupDBTest extends PApplet {

    // Variable de BBDD
    DataBase db;

    // Variables radio buttons
    RadioButton[] rbs;

    // Variable radio button group
    RadioButtonGroup rbg;

    //
    String[] info;

    public static void main(String[] args) {
        PApplet.main("bbdd.RadioButonGroupDBTest", args);
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

        // Creació dels radiobuttons
        rbs = new RadioButton[info.length];
        for(int i=0; i<rbs.length; i++) {
            rbs[i] = new RadioButton(this, 180, 75 + i*50, 15);
            rbs[i].setText(info[i]);
        }

        //Construcció del radio button group
        rbg = new RadioButtonGroup(info.length);
        rbg.setRadioButtons(rbs);   // Format pels 3 radio buttons
        rbg.setSelected(2);
    }

    public void draw() {
        // Fons de la finestra
        background(255);

        // Dibuixam el radio button group
        rbg.display(this);

        // Actualitza forma del cursor
        updateCursor(this);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){

        boolean onRB = false;
        for(int i=0; i<rbs.length; i++) {
            if (rbs[i].onMouseOver(p5)) {
                onRB = true;
            }
        }
        if(onRB){
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
        // Si pitjam sobre el radiobuttongroup
        rbg.updateOnClick(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
