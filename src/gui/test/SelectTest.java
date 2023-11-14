package gui.test;

import gui.Select;
import gui.Table;
import processing.core.PApplet;

public class SelectTest extends PApplet {

    // Elements de la Interfície Gràfica (Select)
    Select s1, s2;

    // Valors dels Selects
    String[] selectValues = {"RED", "GREEN", "BLUE"};
    String[] selectValues2 = {"1", "2", "3"};

    // Dimensions dels botons
    float selectW = 300, selectH = 30;

    // Color de fons de l'App
    int bgColor = color(255);

    // Valor numèric
    int n = 0;

    public static void main(String[] args) {
        PApplet.main("gui.test.SelectTest", args);
    }

    public void settings(){
        size(1200, 600);
        smooth(10);
    }

    public void setup(){
        // Creació dels selects
        s1 = new Select(selectValues, width/3, height/5, selectW, selectH);
        s2 = new Select(selectValues2, width/3, 3*height/5, selectW, selectH);
    }

    public void draw() {
        // Fons de la finestra
        background(bgColor);

        // Dibuixa els selects
        s1.display(this);
        s2.display(this);

        // Actualitza forma del cursor
        updateCursor(this);

        // Dibuixa número n
        fill(0);
        textSize(38);
        text(n, 50, 50);
    }

    // Modifica el cursor
    void updateCursor(PApplet p5){
        if((s1.mouseOverSelect(p5) && s1.isEnabled())||
                (s2.mouseOverSelect(p5) && s2.isEnabled())){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){

        // Si pitjam sobre el select 1
        if(s1.mouseOverSelect(this) && s1.isEnabled()){
            if(!s1.isCollapsed()){
                s1.update(this);      // Actualitzar valor
                updateColor();    // Fer acció amb valor
            }
            s1.toggle();        // Plegar o desplegar
        }

        // Si pitjam sobre el select 2
        if(s2.mouseOverSelect(this) && s2.isEnabled()){
            if(!s2.isCollapsed()){
                s2.update(this);      // Actualitzar valor
                updateNumber();   // Fer acció amb valor
            }
            s2.toggle();        // Plegar o desplegar
        }
    }

    // Modifica el color segons Select 1
    void updateColor(){
        if(s1.getSelectedValue().equals("RED")){
            bgColor = color(255, 0, 0);
        }
        else if(s1.getSelectedValue().equals("GREEN")){
            bgColor = color(0, 255, 0);
        }
        else if(s1.getSelectedValue().equals("BLUE")){
            bgColor = color(0, 0, 255);
        }
    }

    // Modificar el número segons Select 2
    void updateNumber(){
        n = Integer.parseInt(s2.getSelectedValue());
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
