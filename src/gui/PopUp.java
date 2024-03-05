package gui;

import processing.core.PApplet;

public class PopUp {

    // Dimensions
    float x, y, w, h;

    // Propietats
    String title, message;

    public Button bAceptar;
    float buttonW = 200, buttonH = 80;
    boolean visible = true;

    // Constructor

    public PopUp(PApplet p5, String title, String message, float x, float y, float w, float h){
        this.title = title;
        this.message = message;
        this.x = x; this.y = y;
        this.w = w; this.h = h;
        this.bAceptar = new Button(p5, "Acceptar", x + w/2 - buttonW/2,y + h - buttonH*1.5f, buttonW, buttonH);
    }

    //Setters

    public void setTexts(String title, String message){
        this.title = title;
        this.message = message;
    }

    public void setVisible(boolean b){
        this.visible = b;
        if(!this.visible){
            this.bAceptar.setEnabled(false);
        }
        else {
            this.bAceptar.setEnabled(true);
        }
    }

    // Dibuixa el PopUp

    public void display(PApplet p5){

        if(this.visible){
            float b = 40;

            p5.pushStyle();

            // Rectangle
            p5.stroke(0); p5.strokeWeight(10);p5.fill(200, 200, 100);
            p5.rect(x, y, w, h, b/2);

            p5.line(x, y + 2*b , x+w, y + 2*b);

            // Títol
            p5.fill(0); p5.textSize(38); p5.textAlign(p5.LEFT);
            p5.text(title, x + b, y + 1.4f*b);

            // Missatge
            p5.fill(0); p5.textSize(24); p5.textAlign(p5.CENTER);
            p5.text(message, x + w/2, y + 4*b);

            // Botó d'Acceptar
            bAceptar.display(p5);
            p5.popStyle();
        }
    }


}
