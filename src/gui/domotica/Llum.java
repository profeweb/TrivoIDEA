package gui.domotica;

import processing.core.PApplet;

public class Llum extends Sensor{

    public Llum (String n){
        super(n);
    }

    public Llum(String n, boolean ences){
        super(n, ences);
    }

    public void dibuixa(PApplet p5){

        p5.pushStyle();
        p5.fill(0);
        p5.circle(x, y, radi);
        p5.fill(this.ences? p5.color(255, 255, 0) : p5.color(0));
        p5.circle(x, y, 40);
        p5.fill(0); p5.textAlign(p5.CENTER);
        p5.text(this.nom, x, y +  60);
        p5.popStyle();
    }

}
