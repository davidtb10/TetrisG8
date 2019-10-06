package com.example.tetrisg8;


public class PiezaS extends Pieza {

    //Se construye la pieza
    Celda[] pieza = new Celda[4];

    public PiezaS (int x, int y, int nGiro) {
        switch (nGiro) {
            case 1:
                pieza[0] = new Celda(x+0, y+0, 5);
                pieza[1] = new Celda(x+1, y+0, 5);
                pieza[2] = new Celda(x+1, y+1, 5);
                pieza[3] = new Celda(x+2, y+1, 5);
            case 2:
                pieza[0] = new Celda(x+1, y+0, 5);
                pieza[1] = new Celda(x+1, y+1, 5);
                pieza[2] = new Celda(x+0, y+1, 5);
                pieza[3] = new Celda(x+0, y+2, 5);

            case 3:
                pieza[0] = new Celda(x+0, y+0, 5);
                pieza[1] = new Celda(x+1, y+0, 5);
                pieza[2] = new Celda(x+1, y+1, 5);
                pieza[3] = new Celda(x+2, y+1, 5);
            case 4:
                pieza[0] = new Celda(x+1, y+0, 5);
                pieza[1] = new Celda(x+1, y+1, 5);
                pieza[2] = new Celda(x+0, y+1, 5);
                pieza[3] = new Celda(x+0, y+2, 5);
        }

    }
}
