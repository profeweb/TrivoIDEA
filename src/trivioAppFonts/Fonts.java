package trivioAppFonts;

import processing.core.PApplet;
import processing.core.PFont;

public class Fonts {

    // Array de tipografies
    PFont[] fonts;

    // Constructor de les Fonts de l'App
    public Fonts(PApplet p5){
        this.setFonts(p5);
    }

    // Estableix les fonts de l'App
    void setFonts(PApplet p5){
        this.fonts = new PFont[3];
        this.fonts[0] = p5.createFont("data/Astila.ttf", Mides.midaTitol);
        this.fonts[1] = p5.createFont("data/GameOver.ttf", Mides.midaSubtitol);
        this.fonts[2] = p5.createFont("data/Graffiti.ttf", Mides.midaParagraf);
    }

    // Getter del número de fonts
    int getNumFonts(){
        return this.fonts.length;
    }

    // Getter de la font primaria
    PFont getFirstFont(){
        return  this.fonts[0];
    }

    // Getter del font secundaria
    PFont getSecondFont(){
        return  this.fonts[1];
    }

    // Getter del la font terciaria
    PFont getThirdFont(){
        return  this.fonts[2];
    }

    // Getter de la font i-èssima
    PFont getFontAt(int i){
        return this.fonts[i];
    }


    // Dibuixa les font de l'App
    void displayFonts(PApplet p5, float x, float y, float h){
        p5.pushStyle();
        for(int i=0; i<getNumFonts(); i++){
            p5.fill(0); p5.stroke(0); p5.strokeWeight(3);
            p5.textFont(getFontAt(i));
            p5.text("Tipografia "+i, x, y + i*h);
        }
        p5.popStyle();
    }
}
