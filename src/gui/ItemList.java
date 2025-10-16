package gui;

import processing.core.PApplet;

public class ItemList {

    String info;

    public ItemList(String info){
        this.info = info;
    }

    public void display(PApplet p5, float x, float y, float w, float h){
        p5.pushStyle();
        p5.fill(255);
        p5.rect(x, y, w, h);
        p5.fill(0);
        p5.textAlign(p5.LEFT);
        p5.textSize(18);
        p5.text(this.info, x + 5, y + h/2);
        p5.popStyle();
    }

    public void display(PApplet p5, float x, float y, float w, float h, boolean selected){
        p5.pushStyle();
        p5.fill(selected ? 155 : 255);
        p5.rect(x, y, w, h);
        p5.fill(0);
        p5.textAlign(p5.LEFT);
        p5.textSize(18);
        p5.text(this.info, x + 5, y + h/2);
        p5.popStyle();
    }

}
