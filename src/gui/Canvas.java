package gui;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class Canvas {

    enum DISTRIBUCIO {TRESxTRES, DOSxDOS, DOS_HORITZ};
    DISTRIBUCIO distribucio = DISTRIBUCIO.TRESxTRES;
    PGraphics canvas;
    PImage[] imgs;
    int numImatge = 0;

    int x, y, w, h;

    public Canvas(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        // Crea array d'imatges buit
        this.imgs = new PImage[9];
    }

    public void setDistribuicio(DISTRIBUCIO d) {
        this.distribucio = d;
    }

    public String getDistribucio(){
        return this.distribucio.toString();
    }

    public void addImage(PApplet p5, PImage img) {
        if (numImatge<imgs.length) {
            imgs[numImatge] = img;
            numImatge++;
            updateCanvas(p5, imgs, distribucio);
        }
    }

    public boolean mouseOver(PApplet p5){
        return p5.mouseX>= x && p5.mouseY>=y && p5.mouseX<= x + w && p5.mouseY<= y + h;
    }

    public void updateCanvas(PApplet p5, PImage[] imgs, DISTRIBUCIO dist) {
        canvas = p5.createGraphics(w, h);
        canvas.beginDraw();
        canvas.background(255);
        for (int i=0; i<imgs.length; i++) {
            if (imgs[i]!=null) {
                if (dist == DISTRIBUCIO.DOS_HORITZ) {
                    canvas.image(imgs[i], 250*i, 0, 250, 500);
                } else if (dist == DISTRIBUCIO.DOSxDOS) {
                    int f = i / 2;
                    int c = i % 2;
                    float wh = 500 / 2;
                    canvas.image(imgs[i], wh*c, wh*f, wh, wh);
                } else if (dist == DISTRIBUCIO.TRESxTRES) {
                    int f = i / 3;
                    int c = i % 3;
                    float wh = 500 / 3;
                    canvas.image(imgs[i], wh*c, wh*f, wh, wh);
                }
            }
        }
        canvas.endDraw();
    }

    public void resetCanvas() {
        imgs = new PImage[9];
        canvas = null;
        numImatge = 0;
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