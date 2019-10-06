package com.example.tetrisg8;


public class PiezaJ extends Pieza {

    //Se construye la pieza
    Celda[] pieza = new Celda[4];

    public PiezaJ (int x, int y, int nGiro) {
        switch (nGiro) {
            case 1:
                pieza[0] = new Celda(x+0, y+0, 2);
                pieza[1] = new Celda(x+1, y+0, 2);
                pieza[2] = new Celda(x+2, y+0, 2);
                pieza[3] = new Celda(x+0, y+1, 2);
            case 2:
                pieza[0] = new Celda(x+0, y+0, 2);
                pieza[1] = new Celda(x+0, y+1, 2);
                pieza[2] = new Celda(x+0, y+2, 2);
                pieza[3] = new Celda(x+1, y+2, 2);

            case 3:
                pieza[0] = new Celda(x+0, y+1, 2);
                pieza[1] = new Celda(x+1, y+1, 2);
                pieza[2] = new Celda(x+2, y+1, 2);
                pieza[3] = new Celda(x+2, y+0, 2);
            case 4:
                pieza[0] = new Celda(x+0, y+0, 2);
                pieza[1] = new Celda(x+1, y+0, 2);
                pieza[2] = new Celda(x+1, y+1, 2);
                pieza[3] = new Celda(x+1, y+2, 2);
        }

    }
}

