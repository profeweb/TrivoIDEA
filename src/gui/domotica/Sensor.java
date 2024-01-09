package gui.domotica;

import processing.core.PApplet;

public class Sensor {

    String nom;
    boolean ences;

    float x, y;
    float radi = 50;

    public Sensor(String n){
        this.nom = n;
        this.ences = false;
    }

    public Sensor(String n, boolean ences){
        this.nom = n;
        this.ences = ences;
    }

    public void setPosicio(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void setEnces(boolean b){
        this.ences = b;
    }

    public void dibuixa(PApplet p5){

        p5.pushStyle();
        p5.stroke(0);
        p5.fill(this.ences? p5.color(255, 255, 0) : p5.color(0));
        p5.rectMode(p5.CENTER);
        p5.rect(x, y, 40, 40);
        p5.fill(0); p5.textAlign(p5.CENTER);
        p5.text(this.nom, x, y +  60);
        p5.popStyle();
    }

    public boolean mouseOnSensor(PApplet p5){
        return p5.dist(p5.mouseX, p5.mouseY, x, y)<=radi;
    }

    public void toggleEnces(){
        ences = !ences;
    }

    public void updateSensor(PApplet p5){
        if(mouseOnSensor(p5)){
            toggleEnces();
        }
    }

}
