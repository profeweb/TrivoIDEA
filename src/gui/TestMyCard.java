package gui;

import processing.core.PApplet;

public class TestMyCard extends PApplet {

    MyCard mc1;

    public static void main(String[] args) {
        PApplet.main("gui.TestMyCard");
    }

    public void settings(){
        size(800, 800);
    }

    public void setup(){
        mc1 = new MyCard(this, "Hello Card", 100, 100, 300, 400);
        mc1.setImage(this, "camera.png");
    }

    public void draw(){
        background(255);
        mc1.display(this);
    }

    public void mousePressed(){
        mc1.clickMouseOnCardItems(this);
    }

    public void keyPressed(){
        mc1.typeOnCardItems(this);
    }

}
