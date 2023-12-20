package gui;

import processing.core.PApplet;

public class ListItem {

    String info;

    public ListItem(String info){
        this.info = info;
    }

    public void display(PApplet p5, float x, float y){
        p5.pushStyle();
        p5.fill(0);
        p5.textAlign(p5.LEFT);
        p5.text(this.info, x, y);
        p5.popStyle();
    }

}
