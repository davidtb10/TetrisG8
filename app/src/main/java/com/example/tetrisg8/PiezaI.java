package com.example.tetrisg8;



public class PiezaI extends Pieza {

    //Se construye la pieza
    public PiezaI(int x, int y) {
        pieza = new Celda[4];
        pieza[0] = new Celda(x+0, y+2, 1);
        pieza[1] = new Celda(x+1, y+2, 1);
        pieza[2] = new Celda(x+2, y+2 ,1);
        pieza[3] = new Celda(x+3, y+2 ,1);
    }


}
