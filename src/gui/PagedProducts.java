package gui;

import processing.core.PApplet;
import processing.core.PImage;

public
class PagedProducts {


    String[][] productsData;    // Dades dels Productes
    ProductCard[] products;       // Productes
    int numProducts;              // Número total de Productes
    int numProductsPage;        // Número de Productes en 1 Pàgina
    int numProductsRow = 3;

    int numPage;
    int numTotalPages;
    float espai;

    float x, y, w, h;
    float wCard, hCard;

    // Botons
    Button b1, b2;

    // Dimensions dels botons
    float buttonW = 60, buttonH = 60;

    // Constructor
    public PagedProducts(PApplet p5, int ncp, float x, float y, float w, float h) {

        this.numProductsPage = ncp;
        this.numPage = 0;

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.wCard = (w - espai*(numProductsRow-1)) / numProductsRow ;
        this.hCard = (h - espai) / 2f;

        // Creació dels botons
        b1 = new Button(p5, "NEXT", x + w + buttonW, y + 50, buttonW, buttonH);
        b2 = new Button(p5, "PREV", x + w + buttonW, y + buttonH + 70, buttonW, buttonH);

        this.espai = 20;
    }

    // Setters

    public void setData(String[][] d) {
        this.productsData = d;
        this.numProducts = d.length;
        this.numTotalPages = d.length / this.numProductsPage;
    }

    public void setCards(PApplet p5, PImage img1, PImage img2) {

        products = new ProductCard[this.productsData.length];

        int k=0;

        for (int i=0; i<products.length; i++) {

            float xc =  x + (i%numProductsRow)* (wCard + espai);
            float yc = (k%numProductsPage)<(numProductsPage/2)? y : y + hCard + espai;

            products[i] = new ProductCard(p5, xc, yc, wCard, hCard, espai, productsData[i]);
            products[i].setButtons(p5, img1, img2);
            k++;
        }
    }


    public void nextPage() {
        if (this.numPage<this.numTotalPages) {
            this.numPage++;
        }
    }

    public void prevPage() {
        if (this.numPage>0) {
            this.numPage--;
        }
    }

    // Dibuixa taula
    public void display(PApplet p5) {

        p5.pushStyle();


        // Dibuixa Cards
        int firstCardPage = numProductsPage*numPage;
        int lastCardPage  = numProductsPage*(numPage+1) - 1;

        for (int i = firstCardPage; i <= lastCardPage; i++) {
            if (i<products.length) {
                boolean mouseOver = (numCardOver(p5)==i);
                products[i].display(p5, mouseOver);
            }
        }

        // Informació de la Pàgina
        p5.fill(0); p5.textSize(18); p5.textAlign(p5.LEFT);
        p5.text("Pag: "+(this.numPage+1)+" / "+(this.numTotalPages+1), x + w + 60, y+30);


        // Dibuixa els botons
        b1.display(p5);
        b2.display(p5);

        p5.popStyle();
    }

    public ProductCard ckechButtons(PApplet p5){

        int firstCardPage = numProductsPage*numPage;
        int lastCardPage  = numProductsPage*(numPage+1) - 1;
        for (int i = firstCardPage; i <= lastCardPage; i++) {
            if (i<products.length) {

                products[i].cQuantity.update(p5);

                if(products[i].bShop.mouseOverButton(p5)){
                    return products[i];
                }
            }
        }

        if(b1.mouseOverButton(p5)){
            nextPage();
        }
        else if(b2.mouseOverButton(p5)){
            prevPage();
        }

        return null;
    }


    public int numCardOver(PApplet p5) {

        int firstCardPage = numProductsPage*numPage;
        int lastCardPage  = numProductsPage*(numPage+1) - 1;


        for (int i = firstCardPage; i <= lastCardPage; i++) {
            if (i<products.length) {

                float xc =  x + (i%numProductsRow)* (wCard + espai);
                float yc = ((i)%numProductsPage)<(numProductsPage/2)? y : y + hCard + espai;

                if (p5.mouseX > xc && p5.mouseX < xc + wCard &&
                        p5.mouseY > yc && p5.mouseY < yc + hCard) {
                    return i;
                }
            }
        }
        return -1;
    }

}
