package gui;

import processing.core.PApplet;

public class RadioButton {

    // Propietats
    int x, y, r;

    // Colors
    int bgColor, borderColor, checkedColor;

    boolean checked;

    // Constructor
    public RadioButton(PApplet p5, int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
        this.checked = false;
        this.bgColor = p5.color(255);
        this.borderColor = p5.color(0);
        this.checkedColor = p5.color(180);
    }

    // Getter
    public  boolean isChecked(){
        return  this.checked;
    }


    // Dibuixa el CheckBox
    public void display(PApplet p5){

        p5.pushStyle();
        p5.stroke(borderColor);
        p5.strokeWeight(2);
        p5.fill(bgColor);
        p5.ellipse(x, y, 2*r, 2*r);

        if(this.checked){
            p5.fill(checkedColor); p5.noStroke();
            p5.ellipse(x, y, 1.5f*r, 1.5f*r);
        }
    }

    public void setChecked(boolean b){
        this.checked = b;
    }

    // Canvia l'estat de selecció
    public void toggle(){
        this.checked = ! this.checked;
    }


    // Mira si el ratolí està sobre el checkbox
    public boolean onMouseOver(PApplet p5){
        return  p5.dist(p5.mouseX, p5.mouseY, this.x, this.y) < this.r;
    }
}
