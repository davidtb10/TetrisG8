package com.example.tetrisg8;



public class PiezaI extends Pieza {

    //Se construye la pieza
    public PiezaI(int anchoCeldaTabl, int altoCeldaTabl) {
        pieza = new Celda[4];
        pieza[0] = new Celda(0, 4, 1, 1, anchoCeldaTabl, altoCeldaTabl);
        pieza[1] = new Celda(1, 4, 1, 1, anchoCeldaTabl, altoCeldaTabl);
        pieza[2] = new Celda(2, 4, 1, 1, anchoCeldaTabl, altoCeldaTabl);
        pieza[3] = new Celda(3, 4, 1, 1, anchoCeldaTabl, altoCeldaTabl);
    }


}
