package gui.test;

import gui.ArrayButtons;
import gui.LinesDiagram;
import processing.core.PApplet;

public class CSVLoaderTest extends PApplet {

    // Elements de la Interfície Gràfica (Diagrama de Línies)
    LinesDiagram s;
    // Dades del Diagrama (etiquetes)
    String[] textos;
    // Dades del Diagrama (valors)
    float[] values;

    // Color de la línia
    int colorLine = color(150,50,200);

    // Color de fons de l'App
    int bgColor = color(255);

    String[][] info;
    int numLine = 1;

    public static void main(String[] args) {
        PApplet.main("gui.test.CSVLoaderTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        String[] lines = loadStrings("resultados.csv");
        info = new String[lines.length][];
        for (int i = 0 ; i < lines.length; i++) {
            info[i] = lines[i].split(";");
        }

        // Creació del Diagrama de Barres
        s = new LinesDiagram(50, 50, width-100, height - 200);

        // Configuració de Dades (textos, valors, colors)
        s.setTexts(generateLabels());
        values =  extractDataFromLine(numLine);
        s.setValues(values);
        s.setColors(colorLine);

    }

    public void draw() {
        // Fons de la finestra
        background(bgColor);

        // Dibuix del Diagrama de Línies
        s.display(this);

        fill(0);
        textAlign(LEFT); textSize(24);
        text(numLine, width -100 , 50);

        text(info[numLine][0], width-100, 100);
        text(info[numLine][1], width-100, 150);
    }

    public float[] extractDataFromLine(int nl){
        float[] data = new float[10];
        for(int i=0; i<10; i++){
            data[i] = Float.valueOf(info[nl][i+2]);
        }
        return data;
    }

    public String[] generateLabels(){
        String[] labels = new String[10];
        for(int i=0; i<10; i++){
            labels[i] = String.valueOf(i+1);
        }
        return labels;
    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(keyCode==UP){
            numLine++;
            if(numLine>=info.length){
                numLine = 1;
            }
        }
        else if(keyCode==DOWN){
            numLine--;
            if(numLine<1){
                numLine = info.length-1;
            }
        }

        // Creació del Diagrama de Barres
        s = new LinesDiagram(50, 50, width-100, height - 200);

        // Configuració de Dades (textos, valors, colors)
        s.setTexts(generateLabels());
        values =  extractDataFromLine(numLine);
        s.setValues(values);
        s.setColors(colorLine);
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){

    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}

