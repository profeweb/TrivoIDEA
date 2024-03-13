package bbdd;

import processing.core.PApplet;

import static bbdd.DateConversion.formataFechaEng;
import static bbdd.DateConversion.formataFechaEsp;

public class DateConversionTest extends PApplet {


    public static void main(String[] args) {
        PApplet.main("bbdd.DateConversionTest", args);
    }

    String fechaEng = "2021-03-16";
    String fechaEsp = "16/03/2021";

    public void settings(){
        size(1000, 800);
        smooth(10);
    }

    public void setup(){

        // Formata fecha a format DD/MM/YYYY
        String fecha1 = formataFechaEsp(fechaEng);
        println("Format ESP: "+fecha1);

        // Formata fecha a format YYYY-MM-DD
        String fecha2 = formataFechaEng(fechaEsp);
        println("Format ENG: "+fecha2);
    }

    public void draw(){
        background(255);

        // Conversió de Format YYY-MM-DD a DD/MM/YYYY:
        textAlign(LEFT); textSize(24);
        fill(0);
        text("Data en format YYY-MM-DD: ", 100, 100);
        text(fechaEng, 100, 130);
        fill(255, 0, 0);
        text("Data en format DD/MM/YY: ", 100, 180);
        text(formataFechaEsp(fechaEng), 100, 210);


        // Conversió de Format DD/MM/YYYY a YYY-MM-DD:
        textAlign(LEFT); textSize(24);
        fill(0);
        text("Data en format DD/MM/YYYY: ", 500, 100);
        text(fechaEsp, 500, 130);
        fill(0, 0, 255);
        text("Data en format YYY-MM-DD: ", 500, 180);
        text(formataFechaEng(fechaEsp), 500, 210);

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
