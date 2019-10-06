package com.example.tetrisg8;

public class PiezaL extends Pieza {

    //Se construye la pieza
    Celda[] pieza = new Celda[4];

    public PiezaL (int x, int y, int nGiro) {
        switch (nGiro) {
            case 1:
                pieza[0] = new Celda(x+0, y+0, 3);
                pieza[1] = new Celda(x+0, y+1, 3);
                pieza[2] = new Celda(x+1, y+1, 3);
                pieza[3] = new Celda(x+2, y+1, 3);
            case 2:
                pieza[0] = new Celda(x+0, y+2, 3);
                pieza[1] = new Celda(x+1, y+0, 3);
                pieza[2] = new Celda(x+1, y+1, 3);
                pieza[3] = new Celda(x+1, y+2, 3);

            case 3:
                pieza[0] = new Celda(x+0, y+0, 3);
                pieza[1] = new Celda(x+1, y+0, 3);
                pieza[2] = new Celda(x+2, y+0, 3);
                pieza[3] = new Celda(x+2, y+1, 3);
            case 4:
                pieza[0] = new Celda(x+0, y+0, 3);
                pieza[1] = new Celda(x+0, y+1, 3);
                pieza[2] = new Celda(x+0, y+2, 3);
                pieza[3] = new Celda(x+1, y+0, 3);
        }

    }
}
