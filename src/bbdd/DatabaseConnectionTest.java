package bbdd;

import processing.core.PApplet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionTest extends PApplet {

    // Variable de connexió a la BBDD
    Connection con;

    // Dades de connexió (user, password, nom de la base de dades)
    String user     = "admin";
    String pass     = "12345";
    String database = "trivio";

    boolean connectat = false;

    int bgColor = color(255);

    public static void main(String[] args) {
        PApplet.main("bbdd.DatabaseConnectionTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        // Connecta amb BBDD
        connectBBDD();
    }

    public void draw() {
        // Fons de la finestra
        background(bgColor);

        String info = connectat ? "OK" : "ERROR";
        fill(0); textSize(48);
        text("Connexió a la BBDD : "+ info, 100, 100);

    }

    // Connexió a la BBDD
    public void connectBBDD(){
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, user, pass);
            System.out.println("Connectat a la BBDD! :) ");
            connectat = true;
        }
        catch(Exception e) {
            System.out.println(e);
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

