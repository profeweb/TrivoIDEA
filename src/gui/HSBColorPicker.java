package gui;

import processing.core.PApplet;

public class HSBColorPicker {

    float x, y, w, h;
    HueSlider hueSlider;
    float saturationValue=0;
    float brightnessValue=0;
    float hueValue;

    int selectedColor;
    float xClick, yClick;

    public HSBColorPicker(PApplet p5, float x, float y, float w, float h){
        this.x = x; this.y = y;
        this.w = w; this.h = h;
        this.hueSlider = new HueSlider(p5, x, y, 300, 50);
        this.selectedColor = p5.color(255, 255, 255);

        xClick = x + w/2;
        yClick = y + 80 + h/2;

        updateColor(p5);
    }


    public void display(PApplet p5){

        this.hueSlider.display(p5);

        p5.colorMode(p5.HSB);
        for(float xm = x; xm < x+w; xm+=0.5f){
            for(float ym=y + 80; ym < y+h+80; ym+=0.5f){
                float sat = p5.map(xm, x, x+w, 0, 255);
                float bri = p5.map(ym, y+80, y+h+80, 0, 255);
                int color = p5.color(hueValue, sat, bri);
                p5.stroke(color);
                p5.point(xm, ym);
            }
        }

        p5.fill(selectedColor); p5.stroke(0);
        p5.rect(x + w + 10, y + 80, 100, 100);

        p5.stroke(0);
        p5.line(xClick, yClick-10, xClick, yClick+10);
        p5.line(xClick-10, yClick, xClick+10, yClick);

    }

    public void updateColor(PApplet p5){
        saturationValue= p5.map(xClick, x, x+w, 0, 255);
        brightnessValue = p5.map(yClick, y+80, y+h+80, 0, 255);
        p5.colorMode(p5.HSB);
        selectedColor = p5.color(hueValue, saturationValue, brightnessValue);
    }

    public void updateClick(PApplet p5){
        if(p5.mouseX>= x && p5.mouseX<= x +w && p5.mouseY>= y +90 && p5.mouseY< y + h +80){
            xClick = p5.mouseX;
            yClick = p5.mouseY;
        }
    }

    public void mousePressed(PApplet p5){

        this.hueSlider.checkSlider(p5);
        hueValue = this.hueSlider.getValue();
        updateClick(p5);
        updateColor(p5);
    }

    public void mouseDragged(PApplet p5){
        this.hueSlider.checkSlider(p5);
        hueValue = this.hueSlider.getValue();
        updateColor(p5);
    }

}
