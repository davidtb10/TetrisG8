package com.example.tetrisg8;


public class PiezaZ extends Pieza {

    //Se construye la pieza
    public PiezaZ(int anchoCeldaTabl, int altoCeldaTabl) {
        pieza = new Celda[4];
        pieza[0] = new Celda(0, 3, 1, 7, anchoCeldaTabl, altoCeldaTabl);
        pieza[1] = new Celda(0, 4, 1, 7, anchoCeldaTabl, altoCeldaTabl);
        pieza[2] = new Celda(1, 4, 1, 7, anchoCeldaTabl, altoCeldaTabl);
        pieza[3] = new Celda(1, 5, 1, 7, anchoCeldaTabl, altoCeldaTabl);
    }

}
