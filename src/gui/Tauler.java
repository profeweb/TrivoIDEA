package gui;

import processing.core.PApplet;
import processing.core.PImage;

public class Tauler {

    // Figures vàlides
    public enum Escac { REI_B, REINA_B, ALFIL_B, CAVALL_B, TORRE_B, PEO_B,
                        REI_N, REINA_N, ALFIL_N, CAVALL_N, TORRE_N, PEO_N,
                        BUIDA};

    Casella[][] caselles;
    float x, y, w, cw;

    PImage[] figures;

    int sel1Fila, sel1Col, sel2Fila, sel2Col;
    boolean sel1, sel2;

    public Tauler(PApplet p5, int x, int y, int w){

        this.x = x; this.y = y; this.w = w;
        this.cw = w / 8;

        caselles = new Casella[8][8];
        int nc=0;
        for(int f=0; f<8; f++){
            for(int c=0; c<8; c++){
                float xc = x + c*cw;
                float yc = y + f*cw;
                int cc = ((f+nc)%2==0) ? p5.color(100) : p5.color(255);
                caselles[f][c] = new Casella(xc, yc, cw, f, c , cc);
                nc++;
            }
        }

        resetSeleccio();
    }

    public void resetSeleccio(){
        sel1 = false; sel2 = false;
        sel1Fila = -1; sel1Col = -1;
        sel2Fila = -1; sel2Col = -1;
    }

    public void setImatges(PApplet p5){

        this.figures = new PImage[12];

        // Blanques
        figures[0] = p5.loadImage("reiB.png");  // Rei B
        figures[1] = p5.loadImage("reinaB.png");  // Reina B
        figures[2] = p5.loadImage("alfilB.png");  // Alfil B
        figures[3] = p5.loadImage("cavallB.png");  // Cavall B
        figures[4] = p5.loadImage("torreB.png");  // Torre B
        figures[5] = p5.loadImage("peoB.png");  // Peo B

        // Negres
        figures[6] = p5.loadImage("reiN.png");  // Rei N
        figures[7] = p5.loadImage("reinaN.png");  // Reina N
        figures[8] = p5.loadImage("alfilN.png");  // Alfil N
        figures[9] = p5.loadImage("cavallN.png");  // Cavall N
        figures[10] = p5.loadImage("torreN.png");  // Torre N
        figures[11] = p5.loadImage("peoN.png");  // Peo N
    }

    public int getFila(int f){
        return 8 - f;
    }

    public char getColumna(int c){
        char simbol = 'H';
        return (char)(simbol - c);
    }

    public void colocaFigures(){
        caselles[0][0].setFigura(Escac.TORRE_N);
        caselles[0][7].setFigura(Escac.TORRE_N);
        caselles[0][1].setFigura(Escac.CAVALL_N);
        caselles[0][6].setFigura(Escac.CAVALL_N);
        caselles[0][2].setFigura(Escac.ALFIL_N);
        caselles[0][5].setFigura(Escac.ALFIL_N);
        caselles[0][3].setFigura(Escac.REI_N);
        caselles[0][4].setFigura(Escac.REINA_N);
        for(int i=0; i<8; i++){
            caselles[1][i].setFigura(Escac.PEO_N);
        }

        caselles[7][0].setFigura(Escac.TORRE_B);
        caselles[7][7].setFigura(Escac.TORRE_B);
        caselles[7][1].setFigura(Escac.CAVALL_B);
        caselles[7][6].setFigura(Escac.CAVALL_B);
        caselles[7][2].setFigura(Escac.ALFIL_B);
        caselles[7][5].setFigura(Escac.ALFIL_B);
        caselles[7][3].setFigura(Escac.REI_B);
        caselles[7][4].setFigura(Escac.REINA_B);
        for(int i=0; i<8; i++){
            caselles[6][i].setFigura(Escac.PEO_B);
        }
    }

    public void display(PApplet p5){
        p5.pushStyle();
        for(int f=0; f<8; f++){
            for(int c=0; c<8; c++){
                Casella ct = caselles[f][c];
                ct.display(p5);
                if(ct.figura != Escac.BUIDA){
                    p5.imageMode(p5.CENTER);
                    int n = ct.figura.ordinal();
                    p5.image(figures[n], ct.x + this.cw/2, ct.y + this.cw/2, this.cw, this.cw);
                }
            }
        }

        dibuixaLletres(p5, this.y - 20);
        dibuixaLletres(p5, this.y + this.w + 20);

        dibuixaNúmeros(p5, this.x - 20);
        dibuixaNúmeros(p5, this.x +  this.w + 20);

        p5.popStyle();
    }

    public void dibuixaLletres(PApplet p5, float y){
        char c = 'H';
        for(int i=0; i<8; i++){
            p5.textAlign(p5.CENTER); p5.textSize(18);
            p5.text(c, this.x + i*this.cw + this.cw/2 , y);
            c--;
        }
    }

    public void dibuixaNúmeros(PApplet p5, float x){
        for(int f=0; f<8; f++) {
            p5.textAlign(p5.CENTER);
            p5.textSize(18);
            p5.text(8 - f, x, this.y + f * this.cw + this.cw / 2);
        }
    }

    public void casellaMouse(PApplet p5){
        for(int f=0; f<8; f++){
            for(int c=0; c<8; c++){
                Casella ct = caselles[f][c];
                // Seleccionar SEL1
                if(ct.mouseDinsCasella(p5) && !sel1){
                    sel1 = true;
                    ct.selected = true;
                    sel1Fila = f;
                    sel1Col = c;
                }
                // Deseleccionar SEL1
                else if(ct.mouseDinsCasella(p5) && sel1 && sel1Fila == f && sel1Col == c){
                    sel1 = false;
                    ct.selected = false;
                }
                // Seleccionar SEL2
                else if(ct.mouseDinsCasella(p5) && sel1 && !sel2){
                    sel2 = true;
                    ct.selected = true;
                    sel2Fila = f;
                    sel2Col = c;
                }
                // Deseleccionar SEL2
                else if(ct.mouseDinsCasella(p5) && sel1 && sel2 && sel2Fila == f && sel2Col == c){
                    sel2 = false;
                    ct.selected = false;
                }
            }
        }
    }

    public void mouJugada(){
        if(sel1 && sel2){
            System.out.println("MOVIMENT DE " + getFila(sel1Fila) +getColumna(sel1Col) + " A "+ getFila(sel2Fila) +getColumna(sel2Col));
            moviment(sel1Fila, sel1Col, sel2Fila, sel2Col);
        }
    }

    public void moviment(int fo, int co, int fd, int cd){
        this.caselles[fd][cd].figura = this.caselles[fo][co].figura;
        this.caselles[fo][co].figura = Escac.BUIDA;
        this.caselles[fd][cd].selected = false;
        this.caselles[fo][co].selected = false;
        resetSeleccio();
    }
}
