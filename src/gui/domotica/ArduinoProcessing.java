package gui.domotica;

import gui.Button;
import processing.core.PApplet;
import processing.serial.*;


public class ArduinoProcessing extends PApplet {

    // Variable de classe Habitació i Sensor
    Button bLED;

    Serial myPort;  // Create object from Serial class
    static String val;    // Data received from the serial port
    int ledOnOFF = 0;

    public static void main(String[] args) {
        PApplet.main("gui.domotica.ArduinoProcessing", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        String portName = "COM5";// Change the number to match the corresponding port number connected to your Arduino.
        //myPort = new Serial(this, portName, 9600);

        bLED = new Button(this, "ON/OFF", 100, 100, 200, 50);

    }

    public void draw() {
        // Fons de la finestra
        background(255);
        bLED.display(this);

        int colorLed = ledOnOFF == 0 ? color(100) : color(255, 255, 0);
        fill(colorLed);
        circle(width/2, height/2, 200);

    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){

        if(key=='n' || key=='N'){
            //myPort.write('1');
            ledOnOFF = 1;
        }
        else if(key=='f' || key=='F'){
            //myPort.write('0');
            ledOnOFF = 0;
        }
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){
        if(bLED.mouseOverButton(this)){
            if(ledOnOFF==0) {
               // myPort.write(1);
                ledOnOFF = 1;
            }
            else {
                // myPort.write(0);
                ledOnOFF = 0;
            }
        }
    }

    public void mouseDragged(){

    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }
}

