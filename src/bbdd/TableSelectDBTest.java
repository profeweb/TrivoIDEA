package bbdd;

import gui.Select;
import gui.Table;
import processing.core.PApplet;

public class TableSelectDBTest extends PApplet {

    // Variable de BBDD
    DataBase db;

    // Elements de la Interfície Gràfica (Select, Table)
    Select s;
    Table t;

    // Valors dels Selects a emplenar de la BBDD
    String[] selectValues;

    // Dimensions dels botons
    float selectW = 300, selectH = 30;

    // Dimensions de la taula
    float tableW = 800, tableH = 300;

    // Títols de les columnes
    String[] headers = {"Id", "Nom"};

    // Amplades de les columnes
    float[] colWidths = {20, 80};

    // Dades de la taula ( a emplenar amb BBDD)
    String[][] info;

    public static void main(String[] args) {
        PApplet.main("bbdd.TableSelectDBTest", args);
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
        selectValues = db.getInfoColumnaCursTaulaUnitat();
        // Creació dels selects
        s = new Select(selectValues, 50, 100, selectW, selectH);

        // Dades d'una taula (unitat)
        info = db.getInfoTaulaUnitatCurs(1);
        // Creació de la taula
        t = new Table(info.length, 2);
        t.setHeaders(headers);
        t.setData(info);
        t.setColumnWidths(colWidths);
    }

    public void draw(){
        background(255);
        fill(0); textSize(28);

        // Dibuixa la Table
        t.display(this, 50, 150, tableW, tableH);

        // Dibuixa els selects
        fill(0); textSize(24);
        text("CURS", 50, 90);
        s.display(this);
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        // Si pitjam sobre el select
        if(s.mouseOverSelect(this) && s.isEnabled()){
            if(!s.isCollapsed()){
                s.update(this);      // Actualitzar valor
                int curs = Integer.valueOf(s.getSelectedValue());
                // Actualitzar la taula
                info = db.getInfoTaulaUnitatCurs(curs);
                // Creació de la taula
                t = new Table(info.length, 2);
                t.setHeaders(headers);
                t.setData(info);
                t.setColumnWidths(colWidths);

            }
            s.toggle();        // Plegar o desplegar
        }
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
