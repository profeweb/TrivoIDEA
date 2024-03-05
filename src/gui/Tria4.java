package gui;

import processing.core.PApplet;

public class Tria4 {

    // Dimensions
    float x, y, w, h;

    // Propietats
    String title;
    String message;

    public Button b1, b2, b3, b4;
    float buttonH = 80;
    boolean visible = true;

    // Constructor

    public Tria4(PApplet p5, String title, String message, float x, float y, float w, float h){
        this.title = title;
        this.message = message;
        this.x = x; this.y = y;
        this.w = w; this.h = h;

        float m = 50;
        float wButton = (w - 5*m)/4f;
        this.b1 = new Button(p5, "Opcio 1", x + m, y + h - buttonH*1.5f, wButton, buttonH);
        this.b2 = new Button(p5, "Opcio 2", x + 2*m + wButton, y + h - buttonH*1.5f, wButton, buttonH);
        this.b3 = new Button(p5, "Opcio 3", x + 3*m +2*wButton, y + h - buttonH*1.5f, wButton, buttonH);
        this.b4 = new Button(p5, "Opcio 4", x + 4*m +3*wButton, y + h - buttonH*1.5f, wButton, buttonH);
    }

    //Setters

    public void setTextButtons(String txt1, String txt2, String txt3, String txt4){
        this.b1.textBoto = txt1;
        this.b2.textBoto = txt2;
        this.b3.textBoto = txt3;
        this.b4.textBoto = txt4;
    }

    public void setTexts(String title, String message){
        this.title = title;
        this.message = message;
    }

    public void setVisible(boolean b){
        this.visible = b;
        if(!this.visible){
            this.b1.setEnabled(false);
            this.b2.setEnabled(false);
            this.b3.setEnabled(false);
            this.b4.setEnabled(false);
        }
        else {
            this.b1.setEnabled(true);
            this.b2.setEnabled(true);
            this.b3.setEnabled(true);
            this.b4.setEnabled(true);
        }
    }

    // Dibuixa el Confirm

    public void display(PApplet p5){

        if(this.visible){
            float b = 40;

            p5.pushStyle();

            // Rectangle
            p5.stroke(0); p5.strokeWeight(10); p5.fill(200, 200, 100);
            p5.rect(x, y, w, h, b/2);

            p5.line(x, y + 2*b , x+w, y + 2*b);

            // Títol
            p5.fill(0); p5.textSize(38); p5.textAlign(p5.LEFT);
            p5.text(title, x + b, y + 1.4f*b);

            // Missatge
            p5.fill(0); p5.textSize(24); p5.textAlign(p5.CENTER);
            p5.text(message, x + w/2, y + 4*b);

            // Botons d'opcions
            b1.display(p5);
            b2.display(p5);
            b3.display(p5);
            b4.display(p5);
            p5.popStyle();
        }
    }


}
