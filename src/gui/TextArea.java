package gui;

import processing.core.PApplet;

import static java.lang.Math.min;
import static processing.core.PApplet.constrain;
import static processing.core.PConstants.BACKSPACE;

public class TextArea {

        // Propietats del camp de text
        int x, y, h, w;
        int numCols, numRows;

        // Colors
        int bgColor, fgColor, selectedColor, borderColor;
        int borderWeight = 1;

        // Text del camp
        String text = "";
        String[] lines;
        int sizeText = 24;

        boolean selected = false;

        // Constructor
        public TextArea(PApplet p5, int x, int y, int w, int h, int nc, int nr) {
            this.x = x; this.y = y; this.w = w; this.h = h;
            this.numCols = nc; this.numRows = nr;
            this.lines = new String[nr];

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
            p5.textSize(sizeText);
            for(int i=0; i<lines.length; i++){
                if(lines[i]!=null){
                    p5.text(lines[i], x + 5, y + (i+1)* sizeText);
                }
            }
            p5.popStyle();
        }

        public void updateLines(){
            if(text.length()>0){
                int numLines = constrain(text.length() / numCols, 0, this.numRows-1);
                for(int i=0; i<=numLines; i++){
                    int start = i*numCols;
                    int end = min(text.length(), (i+1)*numCols);
                    lines[i] = text.substring(start, end);
                }
            }
            else {
                for(int i=0; i<lines.length; i++){
                    lines[i] ="";
                }
            }
        }

        // Afegeix, lleva el text que es tecleja
        public void keyPressed(char key, int keyCode) {
            if (selected) {
                if (keyCode == (int)BACKSPACE) {
                    removeText();
                } else if (keyCode == 32) {
                    addText(' '); // SPACE
                } else {
                    addText(key);
                }
            }
        }

        // Afegeix la lletra c al final del text
        public void addText(char c) {
            if (this.text.length() < this.numCols*this.numRows) {
                this.text += c;
            }
            updateLines();
        }

        // Lleva la darrera lletra del text
        public void removeText() {
            if (text.length()> 0) {
                text = text.substring(0, text.length()-1);
            }
            updateLines();
        }

        // Indica si el ratolí està sobre el camp de text
        public boolean mouseOverTextField(PApplet p5) {
            return (p5.mouseX >= this.x && p5.mouseX <= this.x + this.w && p5.mouseY >= this.y && p5.mouseY <= this.y + this.h);
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
