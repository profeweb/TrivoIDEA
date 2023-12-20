package gui;

import processing.core.PApplet;

public class LinkItem {

    // Nom i URL del link
    String name;
    String url;

    // Posició i dimensions
    float x, y, w, h;

    // Constructor
    public LinkItem(String n, String u) {
        this.name = n;
        this.url = u;
    }

    // Setter de posició i mida
    public void setLocation(float x, float y, float w, float h) {
        this.x = x; this.y = y;
        this.w = w; this.h = h;
    }

    // Dibuixa botó de Link
    public void display(PApplet p5, boolean mouseOver) {
        p5.pushStyle();
        p5.rectMode(p5.CORNER);
        if (mouseOver) {
            p5.fill(255, 200, 200);
        } else {
            p5.fill(255);
        }
        p5.rect(x +5, y + 5, w-10, h - 10, 5);
        p5.textAlign(p5.CENTER);
        p5.fill(0);
        p5.textSize(24);
        p5.text(this.name, x + w/2, y + h/3 + 10);
        p5.fill(255, 0, 0);
        p5.textSize(18);
        p5.text(this.url, x + w/2, y + 2*h/3 +10);
        p5.popStyle();
    }

    // Determina si mouse sobre el Link
    public boolean mouseOverButton(PApplet p5) {
        return (p5.mouseX >= this.x) &&
                (p5.mouseX<=this.x + this.w) &&
                (p5.mouseY>= this.y) &&
                (p5.mouseY<= this.y + this.h);
    }

    // Obri la URL amb el navegador
    public void openWeb(OpenWeb ow) {
        ow.openWebPage(this.url);
    }
}
