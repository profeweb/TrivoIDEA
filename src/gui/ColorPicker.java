package gui;

import processing.core.PApplet;

public class ColorPicker {

    float x, y;
    SliderValue redSlider, greenSlider, blueSlider;

    int pickedColor;

    public ColorPicker(PApplet p5, float x, float y){
        this.x = x; this.y = y;
        redSlider = new SliderValue(p5, "RED", x, y, 300, 50, 0, 255, 255);
        greenSlider = new SliderValue(p5, "GREEN", x, y +100, 300, 50, 0, 255, 255);
        blueSlider = new SliderValue(p5, "BLUE", x, y + 200, 300, 50, 0, 255, 255);
        pickedColor = p5.color(redSlider.slider.v,greenSlider.slider.v,blueSlider.slider.v);
    }

    public int getPickedColor(){ return  this.pickedColor; }

    public void display(PApplet p5){
        redSlider.display(p5);
        greenSlider.display(p5);
        blueSlider.display(p5);

        p5.colorMode(p5.RGB);
        p5.fill(pickedColor);
        p5.stroke(0); p5.strokeWeight(3);
        p5.rect(this.x + 450, this.y, 250, 250);
    }

    public void keyPressed(PApplet p5){
        redSlider.update(p5);
        greenSlider.update(p5);
        blueSlider.update(p5);
        pickedColor = p5.color(redSlider.slider.v,greenSlider.slider.v,blueSlider.slider.v);
    }

    public void mousePressed(PApplet p5){
        redSlider.isPressed(p5);
        greenSlider.isPressed(p5);
        blueSlider.isPressed(p5);
        pickedColor = p5.color(redSlider.slider.v,greenSlider.slider.v,blueSlider.slider.v);
    }

    public void mouseDragged(PApplet p5){
        redSlider.updatecheckSlider(p5);
        greenSlider.updatecheckSlider(p5);
        blueSlider.updatecheckSlider(p5);
        pickedColor = p5.color(redSlider.slider.v,greenSlider.slider.v,blueSlider.slider.v);
    }
}
