package com.example.tetrisg8;

public class PiezaL extends Pieza {

    //Se construye la pieza
    public PiezaL(int anchoCeldaTabl, int altoCeldaTabl) {
        pieza = new Celda[4];
        pieza[0] = new Celda(0, 4, 3);
        pieza[1] = new Celda(1, 4, 3);
        pieza[2] = new Celda(2, 4, 3);
        pieza[3] = new Celda(2, 5, 3);
    }

}
