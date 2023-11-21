package gui;

import processing.core.PApplet;

public class BarsDiagram {

    // Dimensions del diagrama de Barres
    float x, y, w, h;

    // Informació del diagrama (textos, valors i colors)
    String[] texts;
    float[] values;
    float[] percentages;
    int[] colors;

    // Suma total dels valors
    float total;

    // Constructor

    public BarsDiagram(float x, float y, float w, float h){
        this.x = x; this.y = y; this.w = w; this.h = h;
    }

    // Setters

    public void setTexts(String[] t){
        this.texts = t;
    }

    public void setValues(float[] v){
        this.values = v;
        this.total = 0;
        for(int i=0; i<values.length; i++){
            this.total += this.values[i];
        }

        this.percentages = new float[values.length];
        for(int i=0; i<percentages.length; i++){
            this.percentages[i] = (this.values[i] / this.total)*100;
        }
    }

    public void setColors(int[] c){
        this.colors = c;
    }

    // Dibuixa el Diagrama de Sectors

    public void display(PApplet p5){
        p5.pushStyle();

        float widthBar = w / (float) this.values.length;

        for(int i=0; i<this.values.length; i++){

            float barValue = (this.values[i] / this.total)*h;
            float xBar = this.x + widthBar*i;

            p5.fill(colors[i]); p5.stroke(0); p5.strokeWeight(5);
            p5.rect(xBar, this.y + this.h - barValue, widthBar, barValue);

            float textX = xBar + widthBar/2;
            float textY = this.y + this.h + 50;
            p5.fill(0); p5.textAlign(p5.CENTER); p5.textSize(24);
            p5.text(this.texts[i], textX, textY);

            float percX = xBar + widthBar/2;
            float percY = this.y + this.h - barValue - 50;
            String percentage = p5.nf(this.percentages[i], 2, 2);
            p5.fill(0); p5.textAlign(p5.CENTER); p5.textSize(18);
            p5.text(percentage+"%", percX, percY);

            p5.textSize(24);
            p5.text((int)this.values[i], percX, percY - 30);

        }
        p5.popStyle();
    }
}
