package gui;

import processing.core.PApplet;

import java.util.ArrayList;

public class ListViewer {

    public ArrayList<ItemList> items;
    public Button bUp, bDown;

    float x, y, w, h;

    int start = 0;
    int numItems;
    int selectedItem = -1;


    public ListViewer(PApplet p5, float x, float y, float w, float h){
        this.x = x; this.y = y; this.w = w; this.h = h;
        this.items = new ArrayList();

        bUp = new Button(p5, "UP", this.x + this.w + 10, this.y, 100, 100);
        bUp.enabled = false;
        bDown = new Button(p5, "DOWN", this.x + this.w + 10, this.y + 120, 100, 100);
    }

    public void setStartItem(int n){
        this.start = n;
    }

    public void setNumItems(int n){
        this.numItems = n;
    }

    public void addItemToList(String s){
        this.items.add(new ItemList(s));
    }

    public void display(PApplet p5){

        p5.pushStyle();
        p5.fill(200);
        p5.rect(x, y, w, h, 5);
        int s = this.start;
        int e = p5.min(this.items.size(), s + numItems);
        for(int i= s; i< e; i++){
            this.items.get(i).display(p5, x+5, y + (i-s)*50 + 5, w-10, 50, i==selectedItem);
        }

        bUp.display(p5);
        bDown.display(p5);
        p5.popStyle();
    }

    public void buttonPressed(PApplet p5){
        if(bUp.mouseOverButton(p5) && this.start>0){
            this.start--;
        }
        else if(bDown.mouseOverButton(p5) && this.start < this.items.size()){
            this.start++;
        }
        if(this.start >0){
            bUp.enabled  = true;
        }
        else {
            bUp.enabled = false;
        }
        if(this.start >= this.items.size()){
            bDown.enabled = false;
        }
        else {
            bDown.enabled = true;
        }
    }

    public void mousePressed(PApplet p5){
        if(p5.mouseX>=x && p5.mouseX<= x + w && p5.mouseY>= y && p5.mouseY<= y + h){
            int n = (int) p5.map(p5.mouseY, y, y +h, 0, numItems);
            selectedItem = this.start + n;
            System.out.println("Selected: " + selectedItem);
        }
        else {
            selectedItem = -1;
            System.out.println("Deselected.");
        }
    }

    public int getSelectedIndex(){ return this.selectedItem; }

    public String getSelectedItem(){
        return items.get(selectedItem).info;
    }
}
