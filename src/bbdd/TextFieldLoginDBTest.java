package bbdd;

import gui.Button;
import gui.TextField;
import processing.core.PApplet;

public class TextFieldLoginDBTest extends PApplet {

    // Elements de la Interfície Gràfica (TextFields)
    TextField tf1, tf2;
    Button b1;

    DataBase db;
    boolean loginWrong = false;

    public static void main(String[] args) {
        PApplet.main("bbdd.TextFieldLoginDBTest", args);
    }

    public void settings(){
        size(800, 800);        // Pantalla HD
        smooth(10);
    }

    public void setup(){
        // Crea els TextFields
        tf1 = new TextField(this, 200, 200, 400, 40);
        tf2 = new TextField(this, 200, 400, 400, 40);
        b1 = new Button(this, "LOGIN", 200, 600, 400, 40);

        db = new DataBase("admin", "12345", "trivio");
        db.connect();
    }

    public void draw(){
        background(255);
        fill(0); textSize(28);

        // Dibuixa els TextFields

        text("USER NAME: ", 200, 180);
        tf1.display(this);

        text("PASSWORD: ", 200, 380);
        tf2.display(this);

        b1.display(this);

        // Si el login és correcte
        if (loginWrong) {
            text("YOU ARE NOT LOGGED IN!", 200, 100);
        }
    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyTyped(){
        tf1.keyTyped(key);
        tf2.keyTyped(key);
    }

    public void keyPressed(){
        // Comprova i actualitza l'escriptura dins els TextFields
        //tf1.keyPressed(key, keyCode);
        //tf2.keyPressed(key, keyCode);
        tf1.keyPressed(keyCode);
        tf2.keyPressed(keyCode);
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        // Comprova si pitjam amb el mouse sobre els TextFields
        tf1.isPressed(this);
        tf2.isPressed(this);

        if(b1.mouseOverButton(this)){
            String nom      = tf1.getText();
            String password = tf2.getText();
            if(db.loginCorrecte(nom, password)){
                println("LOGIN OK");
            }
            else {
                println("LOGIN WRONG");
                loginWrong = true;
            }
        }
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
