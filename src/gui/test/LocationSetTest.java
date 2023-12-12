package gui.test;

import gui.Location;
import gui.LocationSet;
import gui.Timer;
import processing.core.PApplet;
import processing.core.PShape;

public class LocationSetTest extends PApplet {

    // Elements de la Interfície Gràfica (LocationSet)

    // Imatge del mapa
    PShape baseMap;

    // Conjunt de localitzacions
    LocationSet l;

    // Localització seleccionada
    Location selectedLoc;

    // Dades de ciutats
    String info[][]= {
            {"Madrid", "SPA", "-3.7176", "40.3919", "madrid.jpg"},
            {"New York", "USA", "-74.005974", "40.712776", "nyc.jpg"},
            {"Sidney", "AUS", "151.209290", "-33.868820", "sidney.jpg"},
    };

    public static void main(String[] args) {
        PApplet.main("gui.test.LocationSetTest", args);
    }

    public void settings(){
        size(1400, 900);        // Pantalla HD
        smooth(10);
    }

    public void setup(){

        // Carregam imatge del mapa
        baseMap = loadShape("WorldMap.svg");

        // Creació de les localitzacions
        l = new LocationSet(this, info);

        // Inicialment res seleccionat
        selectedLoc = null;
    }

    public void draw(){

        background(200, 100, 100);

        // Dibuixa el mapa
        shape(baseMap, 50, 50, width-100, height-100);

        // Dibuixa les localitzacions
        l.display(this, 50, 50, width-100, height-100);

        // Actualitza el cursor
        updateCursor(this);

        // Mostra localització seleccionada
        if(selectedLoc!=null){
            selectedLoc.displayInfo(this, 60, 60, 300, 400);
        }
    }

    void updateCursor(PApplet p5){
        if(l.mouseOverLocations(p5, 50, 50, width-100, height-100)){
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

    public void mousePressed(){
        int nl = l.getSelected(this, 50, 50, width-100, height-100);
        if(nl!=-1){
            selectedLoc = l.getLlocAt(nl);
        }
        else {
            selectedLoc = null;
        }
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
