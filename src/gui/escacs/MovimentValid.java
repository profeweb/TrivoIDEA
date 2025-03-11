package gui.escacs;

import processing.core.PApplet;

import java.util.ArrayList;

public class MovimentValid {

    Tauler tauler;
    Tauler.Escac pieza;
    Posicion posicionInicial;
    ArrayList<Posicion> posiciones;

    public MovimentValid(Tauler t, Tauler.Escac p, Posicion pi){
        this.tauler = t;
        this.pieza = p;
        this.posicionInicial = pi;
        this.posiciones = new ArrayList<>();
    }

    // Afegegeix una posició als moviments vàlids
    public void agregarMovimiento(int fila, int columna){
        this.posiciones.add(new Posicion(fila, columna));
    }

    // Buida la llista de posicions
    public void resetPosicions(){
        this.posiciones = new ArrayList<>();
    }

    // Calcula les posicions vàlides a partir del tauler, figura i posició
    public void calculaPosicions(){

        // Moviments PEO BLANC (1 salt cap a baix) ///////////////////////////////////////////////////////////////////////////
        if(this.pieza == Tauler.Escac.PEO_B){
            if(posicionInicial.fila<tauler.caselles.length-1){
                if(tauler.caselles[posicionInicial.fila+1][posicionInicial.columna].figura == Tauler.Escac.BUIDA) {
                    agregarMovimiento(posicionInicial.fila + 1, posicionInicial.columna);
                }
            }
        }

        // Moviments PEO NEGRE (1 salt cap a dalt) //////////////////////////////////////////////////////////////////////
        if(this.pieza == Tauler.Escac.PEO_N){
            if(posicionInicial.fila>1){
                if(tauler.caselles[posicionInicial.fila-1][posicionInicial.columna].figura == Tauler.Escac.BUIDA) {
                    agregarMovimiento(posicionInicial.fila - 1, posicionInicial.columna);
                }
            }
        }

        // Moviments TORRE (Cap a dalt, baix, esquerra o dreta) ////////////////////////////////////////////////////////
        if(this.pieza == Tauler.Escac.TORRE_B || this.pieza == Tauler.Escac.TORRE_B) {
            // Cap a baix
            for (int f = posicionInicial.fila + 1; f < tauler.caselles.length; f++){
                if (tauler.caselles[f][posicionInicial.columna].figura == Tauler.Escac.BUIDA) {
                    agregarMovimiento(f, posicionInicial.columna);
                } else {
                    break;
                }
            }

            // Cap a dalt
            for (int f = posicionInicial.fila - 1; f >=0; f--){
                if (tauler.caselles[f][posicionInicial.columna].figura == Tauler.Escac.BUIDA) {
                    agregarMovimiento(f, posicionInicial.columna);
                } else {
                    break;
                }
            }

            // Cap a dreta
            for (int c = posicionInicial.columna + 1; c < tauler.caselles.length; c++){
                if (tauler.caselles[posicionInicial.fila][c].figura == Tauler.Escac.BUIDA) {
                    agregarMovimiento(posicionInicial.fila, c);
                } else {
                    break;
                }
            }

            // Cap a l'esquerra
            for (int c = posicionInicial.columna - 1; c >=0; c--){
                if (tauler.caselles[posicionInicial.fila][c].figura == Tauler.Escac.BUIDA) {
                    agregarMovimiento(posicionInicial.fila, c);
                } else {
                    break;
                }
            }
        }

        // Moviments ALFIL (Diagonals) ////////////////////////////////////////////////////////////////////////////////////
        if(this.pieza == Tauler.Escac.ALFIL_B || this.pieza == Tauler.Escac.ALFIL_N) {
            // Cap a baix i dreta
            for (int f = posicionInicial.fila + 1, c = posicionInicial.columna + 1; f < tauler.caselles.length && c < tauler.caselles.length; f++, c++) {
                if (tauler.caselles[f][c].figura == Tauler.Escac.BUIDA) {
                    agregarMovimiento(f, c);
                } else {
                    break;
                }
            }
            // Cap a baix i esquerra
            for (int f = posicionInicial.fila + 1, c = posicionInicial.columna - 1; f < tauler.caselles.length && c >= 0; f++, c--) {
                if (tauler.caselles[f][c].figura == Tauler.Escac.BUIDA) {
                    agregarMovimiento(f, c);
                } else {
                    break;
                }
            }
            // Cap a dalt i dreta
            for (int f = posicionInicial.fila - 1, c = posicionInicial.columna + 1; f >= 0 && c < tauler.caselles.length; f--, c++) {
                if (tauler.caselles[f][c].figura == Tauler.Escac.BUIDA) {
                    agregarMovimiento(f, c);
                } else {
                    break;
                }
            }

            // Cap a dalt i esquerra
            for (int f = posicionInicial.fila - 1, c = posicionInicial.columna - 1; f >= 0 && c >= 0; f--, c--) {
                if (tauler.caselles[f][c].figura == Tauler.Escac.BUIDA) {
                    agregarMovimiento(f, c);
                } else {
                    break;
                }
            }
        }

        // Falta fer: Cavall, Rei i Reina

        // Moviments CAVALL  ///////////////////////////////////////////////////////////////////////////
        if(this.pieza == Tauler.Escac.CAVALL_B || this.pieza == Tauler.Escac.CAVALL_N) {

        }

        // Moviments REINA  ///////////////////////////////////////////////////////////////////////////
        if(this.pieza == Tauler.Escac.REINA_B || this.pieza == Tauler.Escac.REINA_N) {

        }

        // Moviments REI  ///////////////////////////////////////////////////////////////////////////
        if(this.pieza == Tauler.Escac.REI_B || this.pieza == Tauler.Escac.REI_N) {

        }
    }

    // Dibuixa les caselles del tauler a les posicions indicades
    public void display(PApplet p5){
        for(Posicion p : posiciones){
            Casella ct = tauler.caselles[p.getFila()][p.getColumna()];
            ct.displayPosicio(p5);
        }
    }
}
