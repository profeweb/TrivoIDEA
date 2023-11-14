package gui.test;

import gui.Table;
import gui.TextField;
import processing.core.PApplet;

public class TableTest extends PApplet {

    // Elements de la Interfície Gràfica (Table)
    Table t;

    // Dimensions de la taula
    float tableW = 800, tableH = 300;

    // Número de files (capçalera inclosa) i columnes de la taula
    int files = 6, columnes = 5;

    // Títols de les columnes
    String[] headers = {"Id", "Nom", "Llinatges", "Edat", "Sexe"};

    // Amplades de les columnes
    float[] colWidths = {10, 20, 40, 10, 20};

    // Dades de la taula
    String[][] info = {
            {"1", "Pere", "Soler Miralles", "33", "Home"},
            {"2", "Maria", "Garcia Lopez", "25", "Dona"},
            {"3", "Joan", "Melis Cabrer", "47", "Home"},
            {"4", "Bel", "Riera Mates", "52", "Dona"},
            {"5", "Jose", "Perez Galdós", "37", "Home"},
    };

    public static void main(String[] args) {
        PApplet.main("gui.test.TableTest", args);
    }

    public void settings(){
        size(1200, 600);
        smooth(10);
    }

    public void setup(){
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
