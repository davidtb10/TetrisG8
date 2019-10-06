package com.example.tetrisg8;

import android.graphics.Canvas;

public class Pieza {
    protected int tipopieza;
    protected Celda[] pieza;

    public Celda[] getPieza() {
        return pieza;
    }

    public Pieza(){
        tipopieza = 0;
    }

    int nGiro;

    public Pieza(int tipopieza, int x, int y){
        switch (tipopieza){
            case 1:
                Pieza PiezaI = new PiezaI (x, y, nGiro);
                break;
            case 2:
                Pieza PiezaJ = new PiezaJ (x, y, nGiro);
                break;
            case 3:
                Pieza PiezaL = new PiezaL (x, y, nGiro);
                break;
            case 4:
                Pieza PiezaO = new PiezaO (x, y, nGiro);
                break;
            case 5:
                Pieza PiezaS = new PiezaS (x, y, nGiro);
                break;
            case 6:
                Pieza PiezaT = new PiezaT (x, y, nGiro);
               break;
            case 7:
                Pieza PiezaZ = new PiezaZ (x, y, nGiro);
                break;
        }
    }

    //Se pinta la pieza
    public void dibujarPieza(Canvas canvas){
        pieza[0].pintarCelda(canvas);
        pieza[1].pintarCelda(canvas);
        pieza[2].pintarCelda(canvas);
        pieza[3].pintarCelda(canvas);
    }

    public void borrarPieza(Canvas canvas){
        pieza[0].borrarCelda(canvas);
        pieza[1].borrarCelda(canvas);
        pieza[2].borrarCelda(canvas);
        pieza[3].borrarCelda(canvas);
    }
}
