package gui.test;

import gui.ArrayButtons;
import gui.PagedProducts;
import gui.ProductCard;
import processing.core.PApplet;
import processing.core.PImage;

public class PagedProductsTest extends PApplet {

    // Elements de la Interfície Gràfica (PagedProducts)

    // Productes Paginats
    PagedProducts ps;

    // Producte Seleccionat
    ProductCard cs = null;

    // Número de productes per pàgina
    int numProductsPage = 6;

    // Dimensions de la taula
    float cardsW = 1200, cardsH = 800;


    // Dades de la taula
    String[][] info = {
            {"1", "Producte 1", "A", "Descripció 1", "15.25", "true", "imatge1.png"},
            {"2", "Producte 2", "A", "Descripció 2", "9.75", "false", "imatge2.png"},
            {"3", "Producte 3", "B", "Descripció 3", "120.50" , "true", "imatge3.png"},
            {"4", "Producte 4", "C", "Descripció 4", "74.49", "true", "imatge4.png"},
            {"5", "Producte 5", "C", "Descripció 5", "49.95", "false", "imatge5.png"},
            {"6", "Producte 6", "A", "Descripció 6", "3.25", "true", "imatge6.png"},
            {"7", "Producte 7", "D", "Descripció 7", "10.15", "true", "imatge7.png"},
            {"8", "Producte 8", "B", "Descripció 8", "25.95", "true", "imatge8.png"},
            {"9", "Producte 9", "B", "Descripció 9", "4.75", "false", "imatge9.png"},
            {"10","Producte 10","A", "Descripció 10","3.05", "true", "imatge10.png"},
    };

    // Icones dels botons
    PImage imgMes, imgMenys;

    // Color de fons de l'App
    int bgColor = color(255);


    public static void main(String[] args) {
        PApplet.main("gui.test.PagedProductsTest", args);
    }

    public void settings(){
        size(800, 800);
        smooth(10);
    }

    public void setup(){

        // Carregar de les imatges (icones);
        imgMes = loadImage("mes.png");
        imgMenys = loadImage("menys.png");

        // Creació de la taula de productes paginada
        ps = new PagedProducts(this, numProductsPage, 50, 50, cardsW, cardsH);
        ps.setData(info);
        ps.setCards(this, imgMes, imgMenys);

    }

    public void draw() {
        // Fons de la finestra
        background(bgColor);

        // Dibuixa les Cards paginades
        ps.display(this);

        if(cs!=null){
            fill(0); textSize(24); textAlign(LEFT);
            text(cs.getTitle(), width - 280, height/2);
            text(cs.getPrice()+"€", width - 280, height/2 + 30);
            text(cs.getQuantity(), width - 280, height/2 + 60);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){
        cs = ps.ckechButtons(this);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}

