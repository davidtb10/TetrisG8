package com.example.tetrisg8;


public class PiezaO extends Pieza {

    //Se construye la pieza
    Celda[] pieza = new Celda[4];

    //Coordenadas para la pieza dependiendo de la posición en la que se encuentre
    public PiezaO (int x, int y, int nGiro) {
        switch (nGiro) {
            case 1:
                pieza[0] = new Celda(x+0, y+0, 4);
                pieza[1] = new Celda(x+1, y+0, 4);
                pieza[2] = new Celda(x+0, y+1, 4);
                pieza[3] = new Celda(x+1, y+1, 4);
            case 2:
                pieza[0] = new Celda(x+0, y+0, 4);
                pieza[1] = new Celda(x+1, y+0, 4);
                pieza[2] = new Celda(x+0, y+1, 4);
                pieza[3] = new Celda(x+1, y+1, 4);

            case 3:
                pieza[0] = new Celda(x+0, y+0, 4);
                pieza[1] = new Celda(x+1, y+0, 4);
                pieza[2] = new Celda(x+0, y+1, 4);
                pieza[3] = new Celda(x+1, y+1, 4);
            case 4:
                pieza[0] = new Celda(x+0, y+0, 4);
                pieza[1] = new Celda(x+1, y+0, 4);
                pieza[2] = new Celda(x+0, y+1, 4);
                pieza[3] = new Celda(x+1, y+1, 4);
        }

    }
}
