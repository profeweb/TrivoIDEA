package gui;

import processing.core.PApplet;

public class TextTimeField {

    // Propietats del camp de text
    float x, y, h, w;

    // Colors
    int bgColor, fgColor, selectedColor, borderColor;
    int borderWeight = 1;

    // Text del camp
    String text = "00";
    int textSize = 32;

    String labelText="";

    boolean selected = false;

    // Constructor
    public TextTimeField(PApplet p5, String lt, float x, float y, float w, float h) {
        this.labelText = lt;
        this.x = x; this.y = y;
        this.w = w; this.h = h;

        this.bgColor = p5.color(140, 140, 140);
        this.fgColor = p5.color(0, 0, 0);
        this.selectedColor = p5.color(190, 190, 60);
        this.borderColor = p5.color(30, 30, 30);
    }

    // Dibuixa el Camp de Text
    public void display(PApplet p5) {

        p5.pushStyle();

        if (selected) {
            p5.fill(selectedColor);
        } else {
            p5.fill(bgColor);
        }

        p5.strokeWeight(borderWeight);
        p5.stroke(borderColor);
        p5.rect(x, y, w, h, 5);

        p5.fill(fgColor);
        p5.textSize(textSize); p5.textAlign(p5.CENTER);
        p5.text(text, x + w/2, y + textSize +5);

        p5.fill(0); p5.textAlign(p5.CENTER);
        p5.text(labelText, x + w/2, y - textSize/2);
    }

    // Afegeix, lleva el text que es tecleja
    public void keyPressed(PApplet p5, char key, int keyCode) {
        if (selected) {
            if (keyCode == (int) p5.BACKSPACE) {
                removeText();
            } else if (keyCode == 32) {
                addText(' '); // SPACE
            } else {

                boolean isKeyNumber = (key >= '0' && key <= '9');

                if (isKeyNumber) {
                    addText(key);
                }
            }
        }
    }

    // Afegeix la lletra c al final del text
    void addText(char c) {
        if (this.text.length()<2) {
            this.text += c;
            int n = Integer.valueOf(this.text);
            if(n<0 || n>60){
                this.text="00";
            }
        }
    }

    // Lleva la darrera lletra del text
    void removeText() {
        if (this.text.length()> 0) {
            text = text.substring(0, text.length() - 1);
        }
    }

    // Indica si el ratolí està sobre el camp de text
    public boolean mouseOverTextField(PApplet p5) {
        return (p5.mouseX >= this.x && p5.mouseX <= this.x + this.w &&
                p5.mouseY >= this.y && p5.mouseY <= this.y + this.h);
    }

    // Selecciona el camp de text si pitjam a sobre
    // Deselecciona el camp de text si pitjam a fora
    public void isPressed(PApplet p5) {
        if (mouseOverTextField(p5)) {
            selected = true;
        } else {
            selected = false;
        }
    }

}
