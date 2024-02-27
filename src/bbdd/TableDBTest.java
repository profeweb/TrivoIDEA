package bbdd;

import gui.Table;
import processing.core.PApplet;

public class TableDBTest extends PApplet {

    // Variable de BBDD
    DataBase db;

    // Elements de la Interfície Gràfica (Table)
    Table t;

    // Dimensions de la taula
    float tableW = 800, tableH = 300;

    // Títols de les columnes
    String[] headers = {"Id", "Nom"};

    // Amplades de les columnes
    float[] colWidths = {20, 80};

    // Dades de la taula ( a emplenar amb BBDD)
    String[][] info;

    public static void main(String[] args) {
        PApplet.main("bbdd.TableDBTest", args);
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

        // Número de files d'una taula
        int files = db.getNumRowsTaula("unitat");
        int columnes = 2;

        // Dades d'una taula (unitat)
        info = db.getInfoTaulaUnitat();

        // Creació de la taula
        t = new Table(files, columnes);
        t.setHeaders(headers);
        t.setData(info);
        t.setColumnWidths(colWidths);
    }

    public void draw(){
        background(255);
        fill(0); textSize(28);

        // Dibuixa la Table
        t.display(this, 50, 50, tableW, tableH);
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
