package bbdd;

import processing.core.PApplet;

public class DatabaseGetInformation extends PApplet {

    DataBase db;

    int bgColor = color(255);

    public static void main(String[] args) {
        PApplet.main("bbdd.DatabaseGetInformation", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        // Configura els paràmetres de connexió a la BBDD
        db = new DataBase("admin", "12345", "trivio");
        // Connecta amb la BBDD
        db.connect();

        println(db.getInfo("unitat", "nom", "numero", "5"));


    }

    public void draw() {
        // Fons de la finestra
        background(bgColor);

        String info = db.connectat ? "OK" : "ERROR";
        fill(0); textSize(48);
        text("Connexió a la BBDD : "+ info, 100, 100);

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

