package gui;

import processing.core.PApplet;

public class Casella {

    float x, y, w;
    int fila, columna;
    int c;

    Tauler.Escac figura;
    boolean selected;

    public Casella(float x, float y, float w, int f, int c, int col){
        this.x = x; this.y = y; this.w = w;
        this.fila = f; this.columna = c;
        this.c = col;
        this.figura = Tauler.Escac.BUIDA;
        this.selected = false;
    }

    public void setFigura(Tauler.Escac f){
        this.figura = f;
    }

    public void display(PApplet p5){
        p5.pushStyle();
        if(this.selected){
            p5.fill(200, 100, 100);
        }
        else {
            p5.fill(this.c);
        }
        p5.noStroke();
        p5.rect(this.x, this.y, this.w, this.w);
        p5.popStyle();
    }

    public boolean mouseDinsCasella(PApplet p5){
        return p5.mouseX> this.x &&  p5.mouseX< this.x + this.w &&
                p5.mouseY > this.y && p5.mouseY < this.y + this.w;
    }
}
