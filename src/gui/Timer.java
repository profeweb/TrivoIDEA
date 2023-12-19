package gui;

import processing.core.PApplet;

public class Timer {

    int numSecondsToChange;
    int numSeconds;
    int lastTime;
    boolean started;

    public Timer(PApplet p5, int ns){
        this.numSecondsToChange = ns;
        this.numSeconds = 0;
        this.lastTime = p5.millis();
        this.started = false;
    }

    public int getNumSeconds(){
        return  this.numSeconds;
    }

    public void update(PApplet p5){
        if(started) {
            int now = p5.millis();
            numSeconds = (now - lastTime) / 1000;
            if (timeOver()) {
                resetTimer(p5);
            }
        }
    }

    public void setStarted(boolean b){
        this.started = b;
    }

    public void resetTimer(PApplet p5){
        lastTime = p5.millis();
    }

    public boolean timeOver(){
        return (numSeconds>= numSecondsToChange);
    }
}
