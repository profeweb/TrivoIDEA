package gui;

import processing.core.PApplet;

import java.util.ArrayList;

public class TextList1D {

    float x, y, w, h;          // Posició i dimensions
    String[] texts;          // Valors possibles

    TextField textField;       // Camp de text

    int selectedIndex;         // Fila seleccionada
    String selectedId;         // Id Seleccionat
    String selectedValue;      // Valor Seleccionat

    boolean enabled;           // Abilitat / desabilitat

    int numMatchs = 0;
    ArrayList<Button> buttons;

    public TextList1D(PApplet p5, String[] texts, float x, float y, float w, float h) {

        this.texts = texts;
        this.selectedId = "";
        this.selectedValue = "";
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.enabled = true;

        this.textField = new TextField(p5, (int)x, (int)y, (int)w, (int)h);
        this.buttons = new ArrayList<Button>();
    }

    public void display(PApplet p5) {
        p5.pushStyle();
        textField.display(p5);

        for(Button b : buttons){
            b.display(p5);
        }
        p5.popStyle();
    }

    public String getSelectedValue(){
        return this.selectedValue;
    }

    public TextField getTextField(){
        return  this.textField;
    }

    public void update(PApplet p5) {

        String searchFor = this.textField.text;
        System.out.println("SEARCH FOR: "+searchFor);

        this.numMatchs = 0;
        this.buttons = new ArrayList<Button>();

        if (searchFor.length() > 0) {
            for (int i=0; i<texts.length; i++) {
                if (texts[i].startsWith(searchFor)) {
                    Button b = new Button(p5, texts[i], x + 10, y + h + 50 + (h + 50)*numMatchs, w, h);
                    buttons.add(b);
                    this.numMatchs++;
                    if (this.numMatchs==5) {
                        break;
                    }
                }
            }
        }
    }

    public boolean mouseOverButtons(PApplet p5){
        for(Button b : buttons){
            if(b.mouseOverButton(p5)){
                return true;
            }
        }
        return false;
    }

    public void buttonPressed(PApplet p5){
        boolean pressed = false;
        for(Button b : buttons){
            if(b.mouseOverButton(p5)){
                textField.text = b.textBoto;
                this.selectedValue = b.textBoto;
                pressed = true;
            }
        }
        if(pressed){
            buttons.clear();
        }
    }
}
