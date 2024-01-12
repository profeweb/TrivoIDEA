package gui.test;

import gui.BarsDiagram;
import gui.PagedSongs;
import gui.SongCard;
import processing.core.PApplet;
import processing.core.PImage;

public class PagedSongsTest extends PApplet {

    // Elements de la Interfície Gràfica (BarsDiagram)
    // Cançons Paginades
    PagedSongs ps;

    // Cançó Seleccionada
    SongCard cs = null;

    // Dimensions de les cards
    float cardsW = 800, cardsH = 600;

    // Número de cançons per pàgina
    int numCardsPage = 8;

    // Dades de la taula
    String[][] info = {
            {"1", "Títol Cançó 1", "POP", "true"},
            {"2", "Títol Cançó 2", "ROCK", "false"},
            {"3", "Títol Cançó 3", "CLASSIC", "true"},
            {"4", "Títol Cançó 4", "POP", "true"},
            {"5", "Títol Cançó 5", "POP", "false"},
            {"6", "Títol Cançó 6", "ROCK", "true"},
            {"7", "Títol Cançó 7", "DANCE", "true"},
            {"8", "Títol Cançó 8", "CLASSIC", "true"},
            {"9", "Títol Cançó 9", "POP", "false"},
            {"10", "Títol Cançó 10", "ROCK", "true"},
    };

    // Icones dels botons
    PImage imgFave, imgNoFave, imgPlay;


    public static void main(String[] args) {
        PApplet.main("gui.test.PagedSongsTest", args);
    }

    public void settings(){
        size(1200, 800);
        smooth(10);
    }

    public void setup(){
        // Carregar de les imatges (icones);
        imgFave = loadImage("Fave.png");
        imgNoFave = loadImage("noFave.png");
        imgPlay = loadImage("play.png");

        // Creació de la taula
        ps = new PagedSongs(this, numCardsPage, 50, 50, cardsW, cardsH);
        ps.setData(info);
        ps.setCards(this, imgFave, imgNoFave, imgPlay);

    }

    public void draw() {
        // Fons de la finestra
        background(255);

        // Dibuixa les Cards paginades
        ps.display(this);

        // Actualitza forma del cursor
        updateCursor(this);

        // Indica el Resultat seleccionat
        if(cs!=null){
            fill(0); textSize(18);
            text("PLAY:", 900, 300);
            text(cs.getTitle(), 900, 350);
            text(cs.getCategory(), 900, 380);
        }

    }

    // Modifica el cursor
    void updateCursor(PApplet p5){

        if(ps.b1.mouseOverButton(p5) || ps.b2.mouseOverButton(p5)){
            cursor(HAND);
        }
        else if(ps.numCardOver(p5)!=-1){
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
        ps.checkButtons(this);
        cs = ps.checkCardClick(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}

