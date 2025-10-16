package gui;

import processing.core.PApplet;

public class SliderValue {

    TextField tf;
    Slider slider;

    public SliderValue(PApplet p5, String s, float x, float y, float w, float h, float minV, float maxV, float val) {
        tf = new TextField(p5, (int)x - 105, (int)y, 100 , (int)h);
        slider = new Slider(p5, "VALUE", x, y, w, h, minV, maxV, minV);
    }

    public void display(PApplet p5) {
        p5.pushStyle();
        tf.display(p5);
        slider.display(p5);
        p5.popStyle();
    }


    public void update(PApplet p5){
        tf.keyPressed(p5.key, p5.keyCode);
        if(p5.keyCode == p5.ENTER){
            float val = Float.valueOf( tf.getText());
            slider.v = val;
        }
    }

    public void isPressed(PApplet p5){
        tf.isPressed(p5);
    }

    public void updatecheckSlider(PApplet p5){
        if(slider.mouseOnSlider(p5)){
            slider.updateSlider(p5);
            float val = slider.getVaue();
            tf.text = String.valueOf(val);
        }
    }
}
