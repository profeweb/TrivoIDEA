package gui;

import processing.core.PApplet;

public class Timer {

    int numSecondsToChange;
    int numSeconds;
    int lastTime;

    public Timer(PApplet p5, int ns){
        this.numSecondsToChange = ns;
        this.numSeconds = 0;
        this.lastTime = p5.millis();
    }

    public int getNumSeconds(){
        return  this.numSeconds;
    }

    public void update(PApplet p5){
        int now = p5.millis();
        numSeconds = (now - lastTime) / 1000;
        if(timeOver()){
            resetTimer(p5);
        }
    }

    public void resetTimer(PApplet p5){
        lastTime = p5.millis();
    }

    public boolean timeOver(){
        return (numSeconds>= numSecondsToChange);
    }
}
