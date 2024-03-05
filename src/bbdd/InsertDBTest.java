package bbdd;

import gui.*;
import processing.core.PApplet;
import processing.core.PImage;

public class InsertDBTest extends PApplet {

    // Variable de BBDD
    DataBase db;

    // Elements de la Interfície Gràfica (Table, textfield, Counter, Button)
    PagedTable t;
    Button bNext, bPrev;
    TextField tNom;
    Counter cNumero;
    Button bInsert, bReset;

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
        PApplet.main("bbdd.InsertDBTest", args);
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

        // Crea la taula amb dades de la BBDD
        setTableDataBase();

        // Creació dels botons
        bNext = new Button(this, "NEXT", 25 + tableW/2 + buttonW/1.5f, tableH + 80, buttonW, buttonH);
        bPrev = new Button(this, "PREV", 25 + tableW/2 - buttonW/1.5f, tableH + 80, buttonW, buttonH);

        // Carregar de les imatges (icones);
        icona1 = loadImage("mes.png");
        icona2 = loadImage("menys.png");

        // Creació del counter
        cNumero = new Counter(this, icona1, icona2, 3*width/4, 100, compW, compH);
        cNumero.setValues(0, 12);
        cNumero.setInitialValue(0);
        cNumero.setStepValue(1);

        // Creació del camps de text
        tNom = new TextField(this,3*width/4, 200, 3*compW, compH);

        // Creació dels Botons
        bInsert = new Button(this, "Inserir", 3*width/4, 300, 2*buttonW, buttonH);
        bReset = new Button(this, "Reset", 3*width/4 + 2*buttonW + 25, 300, 2*buttonW, buttonH);

    }

    public void draw(){
        background(255);
        fill(0); textSize(28);

        // Dibuixa la Table
        t.display(this, 50, 50, tableW, tableH);

        // Etiqueta  Número
        fill(0); textSize(18);
        text("Número:", 3*width/4, 80);

        // Etiqueta  Nom
        fill(0); textSize(18);
        text("Nom:", 3*width/4, 180);

        // Dibuixa els camp de text
        tNom.display(this);

        // Dibuixa el comptador
        cNumero.display(this);

        // Dibuixa els botons
        bInsert.display(this);
        bReset.display(this);
        bNext.display(this);
        bPrev.display(this);
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

    // Reset dels camps del formulari (counter i textfield).
    void resetFormulari(){
        cNumero.resetValue();
        tNom.removeAllText();
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        tNom.keyPressed(key, (int)keyCode);
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){

        tNom.isPressed(this);
        cNumero.update(this);

        if(bInsert.mouseOverButton(this) && bInsert.isEnabled()){

            // Agafar els valors dels camps del formulari (counter i textfield).
            String valorNumero = String.valueOf(cNumero.getValue());
            String valorNom    = tNom.getText();

            // Inserir a la BBDD
            db.insertInfoTaulaUnitat(valorNumero, valorNom);

            // Resetear (buidar) camps del formulari (counter i textfield).
            resetFormulari();

            // Actualitzar la taula amb els canvis
            setTableDataBase();
        }
        else if(bReset.mouseOverButton(this) && bReset.isEnabled()){
            // Resetear camps del formulari
            resetFormulari();
        }
        else if(bNext.mouseOverButton(this) && bNext.isEnabled()){
            t.nextPage();
        }
        else if(bPrev.mouseOverButton(this) && bPrev.isEnabled()){
            t.prevPage();
        }
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
