package botons;

import processing.core.PApplet;

public class TrivioBotons extends PApplet {

    // Interfície Gràfica (Pantalles i components)
    GUI gui;


    public static void main(String[] args) {
        PApplet.main("botons.TrivioBotons", args);
    }

    public void settings(){
        //fullScreen();                       // Pantalla completa
        size(1920, 1080);        // Pantalla HD
        smooth(10);
    }

    public void setup(){
        noStroke();                         // Sense bordes
        textAlign(CENTER); textSize(18);   // Alineació i mida del text
        gui = new GUI(this);                   // Constructor de la GUI
    }

    public void draw(){

        // Dibuixa la pantalla corresponent
        switch(gui.pantallaActual){
            case INICIAL:   gui.dibuixaPantallaInicial(this);
                            break;

            case ABOUT:     gui.dibuixaPantallaAbout(this);
                            break;

            case DETALLS:   gui.dibuixaPantallaDetalls(this);
                            break;
        }

        updateCursor(this);

    }

    public void updateCursor(PApplet p5){
        if(gui.b1.updateHandCursor(p5) || gui.b2.updateHandCursor(p5)){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){

        gui.t1.keyPressed(key, keyCode);

        if(key=='0'){
            gui.pantallaActual = GUI.PANTALLA.INICIAL;
        }
        else if(key=='1'){
            gui.pantallaActual = GUI.PANTALLA.DETALLS;
        }
        else if(key=='2'){
            gui.pantallaActual = GUI.PANTALLA.ABOUT;
        }
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        if(gui.b1.mouseOverButton(this)){
            println("B1 has been pressed!!!");
        }
        else if(gui.b2.mouseOverButton(this)){
            println("B2 has been pressed!!!");
        }

        gui.t1.isPressed(this);

    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
