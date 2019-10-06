package com.example.tetrisg8;


public class PiezaT extends Pieza {

    //Se construye la pieza
    public PiezaT(int anchoCeldaTabl, int altoCeldaTabl) {
        pieza = new Celda[4];
        pieza[0] = new Celda(0, 3, 6);
        pieza[1] = new Celda(0, 4, 6);
        pieza[2] = new Celda(1, 4, 6);
        pieza[3] = new Celda(0, 5, 6);
    }

}
