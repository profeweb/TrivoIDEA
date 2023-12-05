package gui;

import processing.core.PApplet;

public class TimeField {

    // Propietats del camp de temps
    int x, y, h, w;
    TextTimeField[] tf;

    // Constructor
    public TimeField(PApplet p5, int x, int y, int w, int h) {
        this.x = x; this.y = y; this.w = w; this.h = h;
        tf = new TextTimeField[3];
        tf[0] = new TextTimeField(p5, "HH", x, y, w/3.1f, h);
        tf[1] = new TextTimeField(p5, "MM", x + w/3, y, w/3.1f, h);
        tf[2] = new TextTimeField(p5, "SS", x + 2*w/3, y, w/3.1f, h);
    }

    // Dibuixa el Camp de Text
    public void display(PApplet p5) {
        for(int i=0; i<tf.length; i++){
            tf[i].display(p5);
        }
    }

    // Escritura en algun dels camps de texte
    public void keyPressed(PApplet p5, char key, int keyCode) {
        for(int i=0; i<tf.length; i++){
            tf[i].keyPressed(p5, key, keyCode);
        }
    }

    // Click sobre algun dels camps de texte
    public void isPressed(PApplet p5) {
        for(int i=0; i<tf.length; i++){
            tf[i].isPressed(p5);
        }
    }

    // Getter
    public String getValue(){
        return tf[0].text+"-"+tf[1].text+"-"+tf[2].text;
    }
}
