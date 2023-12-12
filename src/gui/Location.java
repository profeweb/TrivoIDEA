package gui;

import processing.core.PApplet;
import processing.core.PImage;

public class Location {

    PImage foto;
    String nom;
    String pais;
    float lat, lng;

    float r = 30;

    public Location(PApplet p5, String n, String p, float lat, float lng, String f){
        this.nom = n;
        this.pais = p;
        this.lat = lat;
        this.lng = lng;
        this.foto = p5.loadImage(f);
    }

    public Location(PApplet p5, String[] info){
        this.nom = info[0];
        this.pais = info[1];
        this.lng = Float.parseFloat(info[2]);
        this.lat = Float.parseFloat(info[3]);
        this.foto = p5.loadImage(info[4]);
    }

    void displayMark(PApplet p5, float x, float y, float w, float h){

        p5.pushStyle();

        float posLong = p5.map(this.lng, -180, 180, x, x+w);
        float posLat  = p5.map(this.lat,   90, -90, y, y+h);

        p5.stroke(200, 100, 100); p5.strokeWeight(8);
        p5.fill(255);
        if(this.mouseOver(p5, x, y, w, h)){
            p5.fill(100, 100, 200);
        }
        p5.ellipse(posLong, posLat, r, r);

        p5.fill(0); p5.textSize(24); p5.textAlign(p5.CENTER);
        p5.text(this.nom, posLong , posLat - r);

        p5.popStyle();

    }

    public void displayInfo(PApplet p5, float x, float y, float w, float h){
        p5.pushStyle();
        p5.fill(250);
        p5.rect(x, y, w, h, 5);
        p5.image(this.foto, x+5, y+5, w-10, w-10);

        p5.fill(0); p5.textAlign(p5.CENTER); p5.textSize(28);
        p5.text(this.nom+ " ("+this.pais+")", x + w/2, y + w + 50);
        p5.popStyle();
    }

    public boolean mouseOver(PApplet p5, float x, float y, float w, float h){
        float posLong = p5.map(this.lng, -180, 180, x, x+w);
        float posLat  = p5.map(this.lat,   90, -90, y, y+h);
        return p5.dist(p5.mouseX, p5.mouseY, posLong, posLat) < r/2;
    }
}
