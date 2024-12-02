package gui;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class Pissarra {

    PGraphics canvas;

    int x, y, w, h;

    public Pissarra(int x, int y, int w, int h) {

        // Posició i dimensions
        this.x = x; this.y = y;
        this.w = w; this.h = h;
    }

    public void updateCanvas(PApplet p5) {
        canvas = p5.createGraphics(w, h);
        canvas.beginDraw();
        canvas.background(255);
        canvas.endDraw();
    }

    public void resetCanvas() {
        canvas = null;
    }

    public boolean mouseOver(PApplet p5){
        return p5.mouseX>= x && p5.mouseY>=y && p5.mouseX<= x + w && p5.mouseY<= y + h;
    }

    public PGraphics getCanvas(){
        return this.canvas;
    }

    public void display(PApplet p5) {
        p5.pushStyle();
        p5.fill(255);
        p5.rect(x, y, w, h);
        if (canvas!=null) {
            p5.image(canvas, x, y, w, h);
        }
        p5.popStyle();
    }
}