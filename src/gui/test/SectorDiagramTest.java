package gui.test;

import gui.BarsDiagram;
import gui.SectorDiagram;
import processing.core.PApplet;

public class SectorDiagramTest extends PApplet {

    // Elements de la Interfície Gràfica (SectorDiagram)
    // Variable
    SectorDiagram s;

    // Dades del Diagrama (textos, valors i colors)
    String[] textos = {"WATER", "AIR", "FIRE", "EARTH"};
    float[] values = {400f, 600f, 100f, 300f};
    int[] colors = {color(0,0,255), color(50,50,200), color(255,50,50), color(0,255,0)};


    public static void main(String[] args) {
        PApplet.main("gui.test.SectorDiagramTest", args);
    }

    public void settings(){
        size(1200, 1000);
        smooth(10);
    }

    public void setup(){
        // Creació del Diagrama de Sectors
        s = new SectorDiagram(width/2, height/2, width/3);

        // Configuració de Dades (textos, valors, colors)
        s.setTexts(textos);
        s.setValues(values);
        s.setColors(colors);
    }

    public void draw() {
        // Fons de la finestra
        background(255);

        // Dibuix del Diagrama de Barres
        s.display(this);
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
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

