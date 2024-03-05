package bbdd;

import gui.*;
import processing.core.PApplet;
import processing.core.PImage;

public class DeleteDBTest extends PApplet {

    // Variable de BBDD
    DataBase db;

    // Elements de la Interfície Gràfica (Table, textfield, Counter, Button, Select)
    PagedTable t;
    Button bNext, bPrev, bDelete;
    Select sFila;

    // Icones dels botons del counter
    PImage icona1, icona2;

    // Dimensions dels components
    int compW = 100, compH = 40;

    // Dimensions dels botons
    float buttonW = 60, buttonH = 60;

    // Dimensions de la taula
    float tableW = 800, tableH = 400;

    // Títols de les columnes
    String[] headers = {"Id", "Nom"};

    // Amplades de les columnes
    float[] colWidths = {20, 80};

    // Dades de la taula ( a emplenar amb BBDD)
    String[][] info;

    public static void main(String[] args) {
        PApplet.main("bbdd.DeleteDBTest", args);
    }

    public void settings(){
        size(1300, 600);
        smooth(10);
    }

    public void setup(){

        // Configura els paràmetres de connexió a la BBDD
        db = new DataBase("admin", "12345", "trivio");

        // Connecta amb la BBDD
        db.connect();

        // Crea el select amb dades de la BBDD
        setSelectDataBase();

        // Crea la taula amb dades de la BBDD
        setTableDataBase();

        // Creació dels botons
        bNext = new Button(this, "NEXT", 25 + tableW/2 + buttonW/1.5f, tableH + 80, buttonW, buttonH);
        bPrev = new Button(this, "PREV", 25 + tableW/2 - buttonW/1.5f, tableH + 80, buttonW, buttonH);
        bDelete = new Button(this, "DELETE", 3*width/4, 100, 2*buttonW, buttonH);

    }

    public void draw(){
        background(255);

        // Dibuixa la Table
        t.display(this, 50, 50, tableW, tableH);

        // Dibuixa el Select
        sFila.display(this);

        // Dibuixa els botons
        bNext.display(this);
        bPrev.display(this);
        bDelete.display(this);

        // Dibuixa el Select
        sFila.display(this);
    }


    public void setSelectDataBase(){
        // Dades del Select
        String[] selectValues = db.getColumnaNomTaulaUnitat();

        // Creació del Select
        sFila = new Select(selectValues, 3*width/4, 50, 3*compW, compH);

    }

    // Crea la taula Table amb les dades de la BBDD.
    public void setTableDataBase(){

        // Número de files i columnes de la taula
        int files = 6, columnes = 2;

        // Dades d'una taula (BBDD -> taula unitat)
        info = db.getInfoTaulaUnitat();

        // Creació de la taula
        t = new PagedTable(files, columnes);
        t.setHeaders(headers);
        t.setData(info);
        t.setColumnWidths(colWidths);
    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){

    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){

        if(bNext.mouseOverButton(this) && bNext.isEnabled()){
            t.nextPage();
        }
        else if(bPrev.mouseOverButton(this) && bPrev.isEnabled()){
            t.prevPage();
        }
        else if(bDelete.mouseOverButton(this) && bDelete.isEnabled()){

            // Agafa les dades del Select
            String numero = db.getNumeroFromTaulaUnitat(sFila.getSelectedValue());

            // Elimina la fila de la taula
            db.deleteInfoTaulaUnitat(numero);

            // Actualitza la taula
            setTableDataBase();

            // Actualitza el select
            setSelectDataBase();
        }

        // Si pitjam sobre el select
        if(sFila.mouseOverSelect(this) && sFila.isEnabled()){
            if(!sFila.isCollapsed()){
                sFila.update(this);      // Actualitzar valor
            }
            sFila.toggle();        // Plegar o desplegar
        }
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
