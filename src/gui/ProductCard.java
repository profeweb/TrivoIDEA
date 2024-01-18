package gui;

import processing.core.PApplet;
import processing.core.PImage;

public class ProductCard {

    // Propietats
    String id;
    String title;
    String category;
    String description;
    float price;
    boolean favorite;
    PImage photo;

    float x, y, w, h, b;

    Counter cQuantity;
    Button bShop;

    // Constructor

    public ProductCard(PApplet p5, float x, float y, float w, float h, float b, String[] data) {
        this.id = data[0];
        this.title = data[1];
        this.category = data[2];
        this.description = data[3];
        this.price = Float.parseFloat(data[4]);
        this.favorite = Boolean.parseBoolean(data[5]);
        this.photo = p5.loadImage(data[6]);

        this.x = x; this.y = y; this.w = w; this.h = h; this.b = b;
    }

    public void setButtons(PApplet p5, PImage imgMes, PImage imgMenys){

        float xC = x + 5;
        float yCB = y + 5*h/6;
        float xB = x + w - w/4 -5;
        float hCB = h/6 - 5;

        this.cQuantity = new Counter(p5, imgMes, imgMenys, xC, yCB, 1*w/4, hCB);
        this.cQuantity.setInitialValue(0);
        this.cQuantity.setValues(0, 10);
        this.cQuantity.setStepValue(1);
        this.bShop = new Button(p5, "SHOP", xB, yCB, w/4, hCB);
    }

    // Getters
    public String getTitle(){
        return this.title;
    }


    public float getPrice(){
        return  this.price;
    }

    public int getQuantity(){
        return this.cQuantity.value;
    }


    // Dibuixa la Card

    public void display(PApplet p5, boolean mouseOver) {

        p5.pushStyle();

        // Rectangle inferior
        p5.stroke(0);
        p5.fill(220);
        if (mouseOver) {
            p5.fill(220, 100, 100);
        }
        p5.rect(x, y, w, h, b/2);

        // Imatge
        p5.image(this.photo, x+10, y+10, w-20, 3*h/4 -20);

        // Títol
        p5.fill(0);
        p5.textSize(24);
        p5.textAlign(p5.LEFT);
        p5.text(title, x + 10, y + 3*h/4 + 20);

        // Preu
        p5.fill(0);
        p5.textSize(24);
        p5.textAlign(p5.RIGHT);
        p5.text(p5.nf(price, 1, 2)+"€", x + w -10, y + 3*h/4 + 20);


        // Categoria
        p5.fill(100, 100, 200);
        p5.noStroke();
        p5.rect(x + w - 80, y + 8, 80, 30);
        p5.fill(0);
        p5.textAlign(p5.RIGHT);
        p5.textSize(14);
        p5.text(category, x + w - 10, y + 25);

        // Favorit
        if(this.favorite){
            p5.fill(255, 0, 0);
            p5.circle(x + 30, y+30, 30);
            p5.fill(255); p5.textAlign(p5.CENTER); p5.textSize(14);
            p5.text("F",x + 30, y+35);
        }

        this.cQuantity.display(p5);
        this.bShop.display(p5);

        p5.popStyle();
    }


}
