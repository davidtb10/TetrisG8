package com.example.tetrisg8;


public class PiezaJ extends Pieza {

    //Se construye la pieza
    public PiezaJ() {
        pieza = new Celda[4];
        pieza[0] = new Celda(2, 4, 1, 2);
        pieza[1] = new Celda(0, 5, 1, 2);
        pieza[2] = new Celda(1, 5, 1, 2);
        pieza[3] = new Celda(2, 5, 1, 2);
    }

}
