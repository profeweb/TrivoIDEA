package gui;

import processing.core.PApplet;
import processing.core.PImage;

public
class PagedCard2D {


    String[][] cardsData;    // Dades de les Cards
    Card[][] cards;            // Cards
    int numCards;            // Número total de Cards
    int numRowsPage;
    int numCardsRow;
    int numCardsPage;        // Número de Cards en 1 Pàgina

    int numPage;
    int numTotalPages;

    float x, y, w, h;
    float wc, hc;
    int selectedCardRow = -1;
    int selectedCardCol = -1;

    // Constructor
    public PagedCard2D(int numRows, int numCols) {
        this.numRowsPage = numRows;
        this.numCardsRow = numCols;
        this.numCardsPage = numRows * numCols;
        this.numPage = 0;
    }

    // Setters

    public void setDimensions(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.wc =( w - 5*(numCardsRow-1)) / numCardsRow;
        this.hc = (h - 5*(numRowsPage -1)) / numRowsPage;
    }

    public void setData(String[][] d) {
        this.cardsData = d;
        this.numCards = d.length;
        this.numTotalPages = d.length / this.numCardsPage;
    }

    public void setCards() {

        cards = new Card[cardsData.length][numCardsRow];
        float yCard;
        for(int r=0; r<cardsData.length; r++){
            int rPage = r % numRowsPage;
            yCard = y + (hc + 5) * rPage;
            for(int c=0; c<numCardsRow; c++){
                float xCard = x + (wc + 5)*c;
                int index = r*numCardsRow + c;
                if(index < numCards){
                    cards[r][c] = new Card(cardsData[r]);
                    cards[r][c].setDimensions(xCard, yCard, wc, hc, 10);
                }
            }
        }

    }


    public void setImages(PImage img1, PImage img2) {
        PImage img;
        for(int r=0; r<cardsData.length; r++){
            for(int c=0; c<numCardsRow; c++) {
                int index = r * numCardsRow + c;
                if (index < numCards) {
                    if (cards[r][c].section == "Secció 1") {
                        img = img1;
                    } else {
                        img = img2;
                    }
                    cards[r][c].setImage(img);
                }
            }
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

        // Dibuixa Cards corresponent a la Pàgina
        int firstCardPage = numCardsPage*numPage;
        int lastCardPage  = numCardsPage*(numPage+1) - 1;
        for(int r=0; r<cards.length; r++) {
            for (int c = 0; c < cards[r].length; c++) {
                int index = r * numCardsRow + c;
                if(index>=firstCardPage && index<= lastCardPage) {
                    if (index < this.numCards && cards[r][c] != null) {
                        cards[r][c].display(p5, r == this.selectedCardRow && c == this.selectedCardCol);
                    }
                }
            }
        }

        // Informació de la Pàgina
        p5.fill(0);
        p5.text("Pag: "+(this.numPage+1)+" / "+(this.numTotalPages+1), x + w + 50, y+10);

        p5.popStyle();
    }



    public void checkCardSelection(PApplet p5){

        boolean selected = false;
        int firstCardPage = numCardsPage*numPage;
        int lastCardPage  = numCardsPage*(numPage+1) - 1;
        for(int r=0; r<cards.length; r++) {
            for (int c = 0; c < cards[r].length; c++) {
                int index = r * numCardsRow + c;
                if (index >= firstCardPage && index <= lastCardPage) {
                    if (index < cards.length && cards[r][c] != null && cards[r][c].mouseOver(p5)) {
                        selectedCardRow = r;
                        selectedCardCol = c;
                        selected = true;
                        break;
                    }
                }
            }
        }
        if(!selected){
            selectedCardRow = -1;
            selectedCardCol = -1;
        }
    }

    public boolean checkMouseOver(PApplet p5){

        int firstCardPage = numCardsPage*numPage;
        int lastCardPage  = numCardsPage*(numPage+1) - 1;

        for(int r=0; r<cards.length; r++) {
            for (int c = 0; c < cards[r].length; c++) {
                int index = r * numCardsRow + c;
                if(index>=firstCardPage && index<= lastCardPage) {
                    if (index < this.numCards && cards[r][c] != null && cards[r][c].mouseOver(p5)) {
                            return true;
                    }
                }
            }
        }
        return false;
    }

    public void printSelectedCard(PApplet p5){
        if(selectedCardRow !=-1 && selectedCardCol !=-1){
            Card cSelected = cards[selectedCardRow][selectedCardCol];
            p5.pushStyle();
            p5.fill(0); p5.textSize(18);
            p5.text("Seleccionada: ", 900, 300);
            p5.textSize(24);
            p5.text(cSelected.title, 900, 340);
            p5.popStyle();
        }
    }


}
