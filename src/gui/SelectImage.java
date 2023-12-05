package gui;

import processing.core.PApplet;
import processing.core.PImage;

public class SelectImage {

    // Dimensions
    float x, y, w, h;

    // Imatge
    PImage img;
    String title;

    // Estats del botó
    boolean selected;

    // Constructor
    public SelectImage(PApplet p5, String title, float x, float y, float w, float h){
        this.x = x; this.y=y; this.w = w; this.h = h;
        this.title = title;
        this.img = p5.loadImage(title);
        this.selected = false;
    }

    // Setters

    public void setSelected(boolean b){
        this.selected = b;
    }

    // Getters

    public boolean isSelected(){
        return this.selected;
    }

    public String getTitle(){
        return  this.title;
    }


    // Dibuixa
    public void display(PApplet p5){
        p5.pushStyle();
        p5.image(img, x, y, w, h);
        if(selected){

            p5.noFill(); p5.stroke(200, 100, 100); p5.strokeWeight(4);
            p5.rect(x+2, y+2, w-4, h-4);

            p5.fill(200, 100, 100, 200); p5.noStroke();
            p5.ellipse(x + w/2, y+h/2, 80, 80);
        }

        p5.popStyle();
    }

    // Ratolí sobre la imatge
    public boolean mouseOver(PApplet p5){
        return p5.mouseX>=this.x && p5.mouseX<=this.x+this.w &&
                p5.mouseY>=this.y && p5.mouseY<=this.y+this.h;
    }

}
