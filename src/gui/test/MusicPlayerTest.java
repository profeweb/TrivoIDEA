package gui.test;

import gui.MusicPlayer;
import gui.Timer;
import processing.core.PApplet;

public class MusicPlayerTest extends PApplet {

    // Elements de la Interfície Gràfica (MusicPlayer)

    // Music Player
    MusicPlayer mp;

    public static void main(String[] args) {
        PApplet.main("gui.test.MusicPlayerTest", args);
    }

    public void settings(){
        size(800, 800);        // Pantalla HD
        smooth(10);
    }

    public void setup(){
        // Creació del Music Player
        mp = new MusicPlayer(this,120, height/3);

        // Assignació del so a reproduir
        mp.setSound(this, "saxo.wav");
    }

    public void draw(){

        // Fons de la finestra
        background(200);

        // Dibuixa el MusicPlayer
        mp.display(this);

        // Actualitza cursor (ARROW o HAND).
        updateCursor(this);

    }

    // Modifica el cursor
    void updateCursor(PApplet p5){

        if(mp.mouseOverButtons(p5)){
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
        // Comprova si pitjam sobre els botons del MusicPlayer
        mp.checkButtons(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
