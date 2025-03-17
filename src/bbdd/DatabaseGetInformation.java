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

        // Obté informació de casella
        String infoCasella = db.getInfo("unitat", "nom", "numero", "5");
        println("CASELLA: " + infoCasella);

        // Obté informació de columna
        String[] infoColumna = db.getInfoArray("unitat", "nom");
        println("COLUMNA: " );
        printArray(infoColumna);

        // Obté informació de taula (array bidimensional)
        String[][] infoTaula= db.getInfoArray2DUnitat();
        println("TAULA: " );
        for(int i=0; i<infoTaula.length; i++) {
            print(i+": ");
            for(int j=0; j<infoTaula[i].length; j++) {
                System.out.print(infoTaula[i][j]+"\t");
            }
            println();
        }

        // Obté informació filtrada (preguntes dificultat = 2)
        String[][] infoQuery = db.getInfoPreguntaDificil();
        println("QUERY: " );
        for(int i=0; i<infoQuery.length; i++) {
            print(i+": ");
            for(int j=0; j<infoQuery[i].length; j++) {
                System.out.print(infoQuery[i][j]+"\t");
            }
            println();
        }

        // Obté informació de 2 taules relacionades (pregunta, unitat)
        String[][] infoJoin = db.getInfoPreguntesUnitats();
        println("JOIN: " );
        for(int i=0; i<infoJoin.length; i++) {
            print(i+": ");
            for(int j=0; j<infoJoin[i].length; j++) {
                System.out.print(infoJoin[i][j]+"\t");
            }
            println();
        }

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

