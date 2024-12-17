package gui.test;

import gui.ArrayButtons;
import processing.core.PApplet;

public class CSVLoaderTest extends PApplet {

    // Elements de la Interfície Gràfica (ArrayButton)


    // Color de fons de l'App
    int bgColor = color(255);

    String[][] info;
    int numLine = 0;

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

    }

    public void draw() {
        // Fons de la finestra
        background(bgColor);

        fill(0);
        for(int i=0; i<info[numLine].length; i++) {
            textAlign(LEFT); textSize(14);
            text(info[numLine][i], 10 + i*100, 100);
        }
    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(keyCode==UP){
            numLine++;
            if(numLine>=info.length){
                numLine = 0;
            }
        }
        else if(keyCode==DOWN){
            numLine--;
            if(numLine<0){
                numLine = info.length-1;
            }
        }
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

