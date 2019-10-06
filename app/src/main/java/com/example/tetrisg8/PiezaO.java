package com.example.tetrisg8;


public class PiezaO extends Pieza {

    //Se construye la pieza
    public PiezaO(int anchoCeldaTabl, int altoCeldaTabl) {
        pieza = new Celda[4];
        pieza[0] = new Celda(0, 4, 4, anchoCeldaTabl, altoCeldaTabl);
        pieza[1] = new Celda(1, 4, 4, anchoCeldaTabl, altoCeldaTabl);
        pieza[2] = new Celda(0, 5, 4, anchoCeldaTabl, altoCeldaTabl);
        pieza[3] = new Celda(1, 5, 4, anchoCeldaTabl, altoCeldaTabl);
    }

}
