package trivioAppColors;

import processing.core.PApplet;

public class Trivio001 extends PApplet {

    // Colors de l'App
    Colors appColors;

    // Cercles a dibuixar
    Cercle c1, c2, c3;

    public static void main(String[] args) {
        PApplet.main("trivioAppColors.Trivio001", args);
    }

    public void settings(){
        size(800, 800, P2D);
        smooth(10);
    }

    public void setup(){

        // Constructor dels colors de l'App
        appColors = new Colors(this);

        // Defineix els cercles (posició, mida i color).
        c1 = new Cercle(width/4, height/2, Mides.midaCercle);
        c1.setColor(appColors.getFirstColor());  // Color primari

        c2 = new Cercle(width/2, height/2, Mides.midaCercle);
        c2.setColor(appColors.getSecondColor());  // Color secundari

        c3 = new Cercle(3*width/4, height/2, Mides.midaCercle);
        c3.setColor(appColors.getThirdColor());  // Color terciari
    }

    public void draw(){
        // Dibuixa el fons (blanc)
        background(255);

        // Dibuixa els cercles (exemple de classes emprant colors).
        c1.display(this);
        c2.display(this);
        c3.display(this);

        // Dibuixa rectangle amb 5è color (exemple d'emprar els colors directament).
        fill(appColors.getColorAt(4)); noStroke();
        rect(0, 3*height/4, width, height/4);

        // Mostra la paleta de colors
        appColors.displayColors(this, 100,100,width-200);
    }


    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        println("KEY PRESSED");
    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        println("MOUSE PRESSED");
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
