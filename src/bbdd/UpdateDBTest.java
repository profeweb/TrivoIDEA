package bbdd;

import gui.*;
import processing.core.PApplet;
import processing.core.PImage;

public class UpdateDBTest extends PApplet {

    // Variable de BBDD
    DataBase db;

    // Elements de la Interfície Gràfica (Table, textfield, Counter, Button, Select)
    PagedTable t;
    Button bNext, bPrev, bUpdate, bReset, bSelect;
    TextField tNom;
    Counter cNumero;
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
        PApplet.main("bbdd.UpdateDBTest", args);
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
        bUpdate = new Button(this, "Update", 3*width/4, 480, 2*buttonW, buttonH);
        bReset = new Button(this, "Reset", 3*width/4 + 2*buttonW + 25, 480, 2*buttonW, buttonH);
        bSelect = new Button(this, "Select", 3*width/4, 100, 2*buttonW, buttonH);

        bUpdate.setEnabled(false);
        bReset.setEnabled(false);

        // Carregar de les imatges (icones);
        icona1 = loadImage("mes.png");
        icona2 = loadImage("menys.png");

        // Creació del counter
        cNumero = new Counter(this, icona1, icona2, 3*width/4, 300, compW, compH);
        cNumero.setValues(0, 12);
        cNumero.setInitialValue(0);
        cNumero.setStepValue(1);

        // Creació del camps de text
        tNom = new TextField(this,3*width/4, 400, 3*compW, compH);

        // Creació dels Botons


    }

    public void draw(){
        background(255);
        fill(0); textSize(28);

        // Dibuixa la Table
        t.display(this, 50, 50, tableW, tableH);

        // Dibuixa el Select
        sFila.display(this);

        // Etiqueta  Número
        fill(0); textSize(18);
        text("Número:", 3*width/4, 280);

        // Etiqueta  Nom
        fill(0); textSize(18);
        text("Nom:", 3*width/4, 380);

        // Dibuixa els camp de text
        tNom.display(this);

        // Dibuixa el comptador
        cNumero.display(this);

        // Dibuixa els botons
        bUpdate.display(this);
        bReset.display(this);
        bNext.display(this);
        bPrev.display(this);
        bSelect.display(this);

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

        if(bUpdate.mouseOverButton(this) && bUpdate.isEnabled()){

            // ID de la fila a canviar
            String idNumero = db.getNumeroFromTaulaUnitat(sFila.getSelectedValue());

            // Agafar els valors dels camps del formulari (counter i textfield).
            String valorNumero = String.valueOf(cNumero.getValue());
            String valorNom    = tNom.getText();

            // Inserir a la BBDD
            db.updateInfoTaulaUnitat(idNumero, valorNumero, valorNom);

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
        else if(bSelect.mouseOverButton(this) && bSelect.isEnabled()){

            // Agafa les dades del Select i les copia als camps del formulari
            String nom = sFila.getSelectedValue();
            String numero = db.getNumeroFromTaulaUnitat(sFila.getSelectedValue());

            tNom.setText(nom);
            cNumero.setValue(Integer.valueOf(numero));

            // Activa els botons del formulari
            bUpdate.setEnabled(true);
            bReset.setEnabled(true);
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
