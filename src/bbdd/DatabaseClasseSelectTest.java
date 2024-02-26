package bbdd;

import processing.core.PApplet;

public class DatabaseClasseSelectTest extends PApplet {

    DataBase db;
    int n;

    int bgColor = color(255);

    public static void main(String[] args) {
        PApplet.main("bbdd.DatabaseClasseSelectTest", args);
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

        // Número de files d'una taula
        n = db.getNumRowsTaula("unitat");
        println("\nFiles Unitat:"+n);

        // Dades d'una taula (unitat)
        String[][] dades1 = db.getInfoTaulaUnitat();
        println("\nDades Taula Unitat:");
        printArray2D(dades1);
    }

    public void draw() {
        // Fons de la finestra
        background(bgColor);

        String info = db.connectat ? "OK" : "ERROR";
        fill(0); textSize(48);
        text("Connexió a la BBDD : "+ info, 100, 100);

        text("Num. Files Taula UNITAT : "+ n, 100, 300);

    }

    // Imprimeix contingut array 2D
    public void printArray2D(String[][] dades){
        for(int f=0; f<dades.length; f++){
            for(int c=0; c<dades[f].length; c++){
                print(dades[f][c]+" \t ");
            }
            println();
        }
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

