package com.example.tetrisg8;


public class PiezaJ extends Pieza {

    //Se construye la pieza
    public PiezaJ(int x, int y) {
        pieza = new Celda[4];
        pieza[0] = new Celda(x+0, y+0, 2);
        pieza[1] = new Celda(x+1, y+0, 2);
        pieza[2] = new Celda(x+2, y+0, 2);
        pieza[3] = new Celda(x+0, y+1, 2);
    }

}
