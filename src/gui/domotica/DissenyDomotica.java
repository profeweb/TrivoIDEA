package gui.domotica;

import processing.core.PApplet;

public class DissenyDomotica extends PApplet {

    // Variable de classe Habitació i Sensor
    Habitacio[] habitacions;
    Habitacio h1, h2, hSelected;
    Sensor llum1a, llum1b, llum2, ac1;

    public static void main(String[] args) {
        PApplet.main("gui.domotica.DissenyDomotica", args);
    }

    public void settings(){
        size(1200, 800);
        smooth(10);
    }

    public void setup(){

        // Constructor de Sensors (Llums)
        llum1a = new Llum("Llum A", true);
        llum1b = new Llum("Llum B", true);
        llum2 = new Llum("Llum C");
        ac1 = new Sensor("Aire Condicionat");

        // Constructor d'Habitacions
        h1 = new Habitacio("Quarto 1", 0, 0, 300, 300, color(200, 100, 100, 10));
        h2 = new Habitacio("Quarto 2", 300, 0, 400, 600, color(100, 200, 100, 10));

        // Agregam Sensors a les Habitacions
        h1.addSensor(llum1a);
        h1.addSensor(llum1b);
        h1.addSensor(ac1);
        h2.addSensor(llum2);

        // Cream array d'habitacions
        habitacions = new Habitacio[2];
        habitacions[0] = h1;
        habitacions[1] = h2;

        // Habitació Seleccionada (cap)
        hSelected = null;
    }

    public void draw() {
        // Fons de la finestra
        background(255);

        // Dibuix de les Habitacions
        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(this);
        }

    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        // Encen tots els llums
        if(key=='n' || key=='N'){
            if(hSelected != null) {
                hSelected.encenLlums();
            }
        }
        // Apaga tots els llums
        else if(key=='f' || key=='F'){
            if(hSelected != null) {
                hSelected.apagaLlums();
            }
        }
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){

        // Comprova si clicam sobre els sensors de les habitacions
        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].updateSensors(this);
        }

        // Comprova si clicam sobre una habitació.
        for(int i=0; i<habitacions.length; i++) {
            if(habitacions[i].mouseOnHabitacio(this)){
                hSelected = habitacions[i];
                habitacions[i].setSelected(true);
            }
            else {
                habitacions[i].setSelected(false);
            }
        }

    }

    public void mouseDragged(){

    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }
}

