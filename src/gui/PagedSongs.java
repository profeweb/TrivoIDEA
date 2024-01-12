package gui;

import processing.core.PApplet;
import processing.core.PImage;

public class PagedSongs {

    String[][] resultsData;    // Dades de les Cards
    SongCard[] songs;              // Cançons
    int numSongs;              // Número total de Cançons
    int numSongsPage;        // Número de Cançons en 1 Pàgina

    int numPage;
    int numTotalPages;

    float x, y, w, h;

    // Botons
    public Button b1, b2;

    // Dimensions dels botons
    float buttonW = 60, buttonH = 60;

    // Constructor
    public PagedSongs(PApplet p5, int ncp, float x, float y, float w, float h) {

        this.numSongsPage = ncp;
        this.numPage = 0;

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        // Creació dels botons
        b1 = new Button(p5, "NEXT", 100 + w, 80, buttonW, buttonH);
        b2 = new Button(p5, "PREV", 100 + w, 100 + buttonH, buttonW, buttonH);
    }

    // Setters

    public void setData(String[][] d) {
        this.resultsData = d;
        this.numTotalPages = d.length / this.numSongsPage;
    }

    public void setCards(PApplet p5, PImage img1, PImage img2, PImage img3) {
        songs = new SongCard[this.resultsData.length];
        float hc = h / (float) numSongsPage;
        int k=0;
        for (int i=0; i<songs.length; i++) {
            float yc = y +(k%numSongsPage)*(hc + 10);
            songs[i] = new SongCard(x, yc, w, hc, 10, resultsData[i]);
            songs[i].setButtons(p5, img1, img2, img3);
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
        int firstCardPage = numSongsPage*numPage;
        int lastCardPage  = numSongsPage*(numPage+1) - 1;

        for (int i = firstCardPage; i <= lastCardPage; i++) {
            if (i<songs.length) {
                boolean mouseOver = (i==numCardOver(p5));
                songs[i].display(p5, mouseOver);
            }
        }

        // Informació de la Pàgina
        p5.fill(0);
        p5.text("Pag: "+(this.numPage+1)+" / "+(this.numTotalPages+1), x + w + 50, y+10);

        // Dibuixa els botons
        b1.display(p5);
        b2.display(p5);

        p5.popStyle();
    }


    public int numCardOver(PApplet p5) {

        int firstCardPage = numSongsPage*numPage;
        int lastCardPage  = numSongsPage*(numPage+1) - 1;

        for (int i = firstCardPage; i <= lastCardPage; i++) {
            if (i<songs.length) {
                if (songs[i].mouseOnCard(p5)) {
                    return i;
                }
            }
        }
        return -1;
    }


    public SongCard checkCardClick(PApplet p5) {

        int firstCardPage = numSongsPage*numPage;
        int lastCardPage  = numSongsPage*(numPage+1) - 1;

        for (int i = firstCardPage; i <= lastCardPage & i<songs.length; i++) {
            SongCard sc = songs[i].checkButtons(p5);
            if (sc!= null) {
                return sc;
            }
        }
        return null;
    }

    public void checkButtons(PApplet p5) {
        if (b1.mouseOverButton(p5)) {
            nextPage();
        } else if (b2.mouseOverButton(p5)) {
            prevPage();
        }
    }
}
