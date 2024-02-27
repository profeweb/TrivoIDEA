package bbdd;

import gui.Select;
import processing.core.PApplet;

public class SelectDBTest extends PApplet {

    // Variable de BBDD
    DataBase db;

    // Elements de la Interfície Gràfica (Select)
    Select s1;

    // Valors dels Selects a emplenar de la BBDD
    String[] selectValues;

    // Dimensions dels botons
    float selectW = 300, selectH = 30;

    // Color de fons de l'App
    int bgColor = color(255);

    // Valor numèric
    int n = 0;

    public static void main(String[] args) {
        PApplet.main("bbdd.SelectDBTest", args);
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
        selectValues = db.getColumnaNomTaulaUnitat();

        // Creació dels selects
        s1 = new Select(selectValues, width/3, height/5, selectW, selectH);
    }

    public void draw() {
        // Fons de la finestra
        background(bgColor);

        // Dibuixa els selects
        s1.display(this);

        // Actualitza forma del cursor
        updateCursor(this);

        // Dibuixa el valor seleccionat del select
        fill(0);
        textSize(38);
        text(s1.getSelectedValue(), 50, 50);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if(s1.mouseOverSelect(p5) && s1.isEnabled()){
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

        // Si pitjam sobre el select 1
        if(s1.mouseOverSelect(this) && s1.isEnabled()){
            if(!s1.isCollapsed()){
                s1.update(this);      // Actualitzar valor
            }
            s1.toggle();        // Plegar o desplegar
        }

    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
