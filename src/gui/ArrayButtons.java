package gui;

import processing.core.PApplet;

public class ArrayButtons {

    Button[] buttons;

    int currentButton = 0;

    public ArrayButtons(PApplet p5, int n, float x, float y, float r, float s) {
        buttons = new Button[n];
        for (int i=0; i<buttons.length; i++) {
            buttons[i] = new Button(p5, Integer.toString(i+1), x + (s+r)*i, y, r, r);
        }
        buttons[currentButton].enabled = false;
    }

    public void display(PApplet p5) {
        p5.pushStyle();
        for (int i=0; i<buttons.length; i++) {
            buttons[i].display(p5);
        }
        p5.popStyle();
    }

    public int getCurrentButton() {
        return (this.currentButton + 1);
    }

    public void updateButtons() {
        for (int i=0; i<buttons.length; i++) {
            buttons[i].enabled = (currentButton != i);
        }
    }

    public void checkMousePressed(PApplet p5) {
        for (int i=0; i<buttons.length; i++) {
            if (buttons[i].mouseOverButton(p5) && buttons[i].enabled) {
                currentButton = i;
                updateButtons();
                break;
            }
        }
    }

    public boolean checkMouseOver(PApplet p5) {
        for (int i=0; i<buttons.length; i++) {
            if (buttons[i].mouseOverButton(p5) && buttons[i].enabled) {
                return true;
            }
        }
        return false;
    }
}
