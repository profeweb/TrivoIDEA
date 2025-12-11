package gui;

import processing.core.PApplet;
import processing.core.PImage;

public class MyCard {

    PImage img;
    String titol;
    TextField txtField;
    Button boto;
    float x, y, w, h;

    public MyCard(PApplet p5, String titol, float x, float y, float w, float h){
        this.titol = titol;
        this.x = x; this.y = y;
        this.w = w; this.h = h;

        this.txtField = new TextField(p5, (int)x + 5, (int)(y + h - 110), (int)w - 10, 50);
        this.boto = new Button(p5, "Ver", (int)x + 5, (int)(y + h - 55), (int)w - 10, 50);
    }

    public void setImage(PApplet p5, String imgURL){
        this.img = p5.loadImage(imgURL);
    }

    public void display(PApplet p5){
        p5.pushStyle();

        p5.rect(x, y, w, h, 5);

        if(img==null){
            p5.rect(x + 5, y + 5, w-10, h/2 -10);
        }
        else {
            p5.image(img, x + 5, y + 5, w-10, h/2-10);
        }

        p5.fill(0);
        p5.textSize(18);
        p5.text(titol, x+5, y + h/2 + 25);

        txtField.display(p5);
        boto.display(p5);

        p5.popStyle();
    }

    public void clickMouseOnCardItems(PApplet p5){
        txtField.isPressed(p5);

        if(boto.mouseOverButton(p5)){
            System.out.println("Card Button clicked!");
        }
    }

    public void typeOnCardItems(PApplet p5){
        txtField.keyPressed(p5.key, p5.keyCode);
    }


}
