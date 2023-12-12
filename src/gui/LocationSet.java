package gui;

import processing.core.PApplet;

public class LocationSet {

    int numLlocs;
    Location[] llocs;

    public LocationSet(PApplet p5, String[][] info){
        this.numLlocs = info.length;
        llocs = new Location[this.numLlocs];
        for(int i=0; i<info.length; i++){
            llocs[i] = new Location(p5, info[i]);
        }
    }

    public Location getLlocAt(int index){
        return this.llocs[index];
    }

    public void display(PApplet p5, float x, float y, float w, float h){
        for(int i=0; i<llocs.length; i++){
            llocs[i].displayMark(p5, x, y, w, h);
        }
    }

    public boolean mouseOverLocations(PApplet p5, float x, float y, float w, float h){
        for(int i=0; i<llocs.length; i++){
            if(llocs[i].mouseOver(p5, x, y, w, h)){
                return true;
            }
        }
        return false;
    }

    public int getSelected(PApplet p5, float x, float y, float w, float h){
        for(int i=0; i<llocs.length; i++){
            if(llocs[i].mouseOver(p5, x, y, w, h)){
                return i;
            }
        }
        return -1;
    }
}
