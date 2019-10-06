package com.example.tetrisg8;


public class PiezaJ extends Pieza {

    //Se construye la pieza
    public PiezaJ(int anchoCeldaTabl, int altoCeldaTabl) {
        pieza = new Celda[4];
        pieza[0] = new Celda(2, 4, 2);
        pieza[1] = new Celda(0, 5, 2);
        pieza[2] = new Celda(1, 5, 2);
        pieza[3] = new Celda(2, 5, 2);
    }

}
