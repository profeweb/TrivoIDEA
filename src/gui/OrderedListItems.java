package gui;

import processing.core.PApplet;

import java.util.ArrayList;

public class OrderedListItems {

    ArrayList<ListItem> list;

    public OrderedListItems(){
        this.list = new ArrayList<>();
    }

    public void addItem(ListItem item){
        list.add(item);
    }

    public void display(PApplet p5, float x, float y, float w, float h){
        p5.pushStyle();

        p5.fill(200);
        p5.rect(x, y, w, h, 5);

        float lineHeight = 30;

        float hAcum = 0;

        for(int i=0; i<list.size(); i++){

            if(hAcum < h - lineHeight) {

                ListItem li = list.get(i);
                li.display(p5, x + 50, y + lineHeight * (i + 0.75f) + 5);

                p5.fill(0);
                p5.ellipse(x + 20, y + lineHeight * (i + 0.75f), 20, 20);

                p5.fill(255);
                p5.textAlign(p5.CENTER);
                p5.text(i, x + 20, y + lineHeight * (i + 0.75f) + 5);

                hAcum += lineHeight;
            }
        }
        p5.popStyle();
    }
}
