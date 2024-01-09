package gui.domotica;

import processing.core.PApplet;

public class Habitacio {

    float x, y, w, h;
    String nom;
    int c;
    boolean selected;

    Sensor[] sensors;
    int numSensors =  0;

    public Habitacio(String n, float x, float y, float w, float h, int c){
        this.nom = n;
        this.x = x; this.y = y;
        this.w = w; this.h = h;
        this.c = c;
        this.sensors = new Sensor[10];
        this.selected = false;
    }

    public void setSelected(boolean b){
        this.selected = b;
    }

    public void dibuixa(PApplet p5){

        p5.pushStyle();
        if(this.selected) {
            p5.fill(200, 100, 100);
        }
        else {
            p5.fill(this.c);
        }
        p5.rect(this.x, this.y, this.w, this.h);
        p5.fill(0); p5.textAlign(p5.CENTER);
        p5.text(this.nom, this.x + this.w/2, this.y + this.h/2);

        p5.popStyle();

        float ws = this.w / (numSensors + 1);
        for(int i=0; i<numSensors; i++){
            sensors[i].dibuixa(p5);
        }
    }

    public void addSensor(Sensor s){
        if(numSensors<sensors.length){
            sensors[numSensors] = s;
            numSensors++;

            float ws = this.w / (numSensors + 1);
            for(int i=0; i<numSensors; i++){
                sensors[i].setPosicio(this.x + ws*(i+1), this.y + this.h/8);
            }
        }
    }

    public void updateSensors(PApplet p5){
        for(int i=0; i<numSensors; i++){
            sensors[i].updateSensor(p5);
        }
    }

    public void encenLlums(){
        for(int i=0; i<numSensors; i++){
            if(sensors[i] instanceof Llum) {
                sensors[i].setEnces(true);
            }
        }
    }

    public void apagaLlums(){
        for(int i=0; i<numSensors; i++){
            System.out.println("APAGANT ???");
            if(sensors[i] instanceof Llum) {
                System.out.println("APAGANT LLUM");
                sensors[i].setEnces(false);
            }
        }
    }

    public boolean mouseOnHabitacio(PApplet p5){
        return p5.mouseX>= this.x && p5.mouseX<= this.x + this.w && p5.mouseY>= this.y && p5.mouseY<= this.y + this.h;
    }
}
