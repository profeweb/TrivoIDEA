package bbdd;

import processing.core.PApplet;

import java.time.LocalDate;
import java.util.ArrayList;

import static bbdd.DateConversion.formataFechaEng;
import static bbdd.DateConversion.formataFechaEsp;

public class LocalDatesTest extends PApplet {


    public static void main(String[] args) {
        PApplet.main("bbdd.LocalDatesTest", args);
    }

    String fecha1 = "2021-03-16";
    String fecha2 = "2021-04-16";

    public void settings(){
        size(1000, 800);
        smooth(10);
    }

    public void setup(){

        LocalDate d1 = LocalDate.parse(fecha1);
        LocalDate d2 = LocalDate.parse(fecha2);

        ArrayList<LocalDate> days = DateConversion.getDaysBetween(d1, d2, 30);
        for(LocalDate ld : days){
            println(ld.toString());
            // INDERT
        }

    }

    public void draw(){
        background(255);

        // Conversió de Format YYY-MM-DD a DD/MM/YYYY:

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
