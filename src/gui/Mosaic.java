package gui;

import gui.SelectImage;
import processing.core.PApplet;

public class Mosaic {

    // Dimensions del mosaic
    int x, y, w, h;

    // Informació del mosaic
    int numFiles, numColumnes;

    // Imatge seleccionada
    boolean imgSelected = false;
    String selectedImg = "";

    // Títols de les imatges del mosaic
    String[] imgs;

    // Imatges del mosaic
    private SelectImage[] selImgs;


    // Constructor
    public Mosaic(int x, int y, int w, int h, int nf, int nc){
        this.x = x; this.y = y; this.w = w; this.h = h;
        this.numFiles = nf; this.numColumnes = nc;
    }

    // Setters

    public void setImages(PApplet p5, String[] imgs){
        this.imgs = imgs;
        selImgs = new SelectImage[this.imgs.length];
        createSelectImages(p5);
    }

    public void createSelectImages(PApplet p5){

        float imgWidth  = w / numColumnes;
        float imgHeight = h / numFiles;

        int numImg = 0;
        for(int nf=0; nf<numFiles; nf++){
            for(int nc=0; nc<numColumnes; nc++){
                if(numImg>=imgs.length){
                    break;
                }
                else {

                    String title = imgs[numImg];
                    float xImg = x + imgWidth*nc;
                    float yImg = y + imgHeight*nf;

                    selImgs[numImg]= new SelectImage(p5, title, xImg, yImg, imgWidth, imgHeight);

                    numImg++;
                }
            }

        }
    }


    // Dibuixa el gui.Mosaic
    public void display(PApplet p5){

        p5.pushStyle();
        p5.fill(150); p5.noStroke();
        p5.rect(x, y, w, h);

        for(SelectImage s : selImgs){
            if(s!=null){
                s.display(p5);
            }
        }

        if(imgSelected){
            p5.fill(0); p5.textAlign(p5.CENTER); p5.textSize(38);
            p5.text(selectedImg, x+w/2, y + h + 100);
        }

        p5.popStyle();
    }

    // Comprova si pitjam sobre les imatges del gui.Mosaic
    public void checkImgs(PApplet p5){
        for(SelectImage s : selImgs){
            if((s!=null)&&(s.mouseOver(p5))){
                boolean prevState = s.isSelected();
                deselectAll();
                s.setSelected(!prevState);
                if(s.isSelected()){
                    imgSelected = true;
                    selectedImg = s.getTitle();
                }
                else {
                    imgSelected = false;
                }
            }
        }
    }

    // Deselecciona totes les imatges del mosaic
    public void deselectAll(){
        for(SelectImage s : selImgs){
            if(s!=null){
                s.setSelected(false);
            }
        }
    }

}
