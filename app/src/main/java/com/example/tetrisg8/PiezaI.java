package com.example.tetrisg8;

//Pieza del tipo I

public class PiezaI extends Pieza {
    Celda[] pieza = new Celda[4];
    //Se construye la pieza


    //Coordenadas para la pieza dependiendo de la posición en la que se encuentre
    public PiezaI (int x, int y, int nGiro) {
        switch (nGiro) {
            case 1:
                pieza[0] = new Celda(x + 0, y + 0, 1);
                pieza[1] = new Celda(x + 1, y + 0, 1);
                pieza[2] = new Celda(x + 2, y + 0, 1);
                pieza[3] = new Celda(x + 3, y + 0, 1);
                break;
            case 2:
                pieza[0] = new Celda(x + 0, y + 0, 1);
                pieza[1] = new Celda(x + 0, y + 1, 1);
                pieza[2] = new Celda(x + 0, y + 2, 1);
                pieza[3] = new Celda(x + 0, y + 3, 1);
                break;

            case 3:
                pieza[0] = new Celda(x + 0, y + 0, 1);
                pieza[1] = new Celda(x + 1, y + 0, 1);
                pieza[2] = new Celda(x + 2, y + 0, 1);
                pieza[3] = new Celda(x + 3, y + 0, 1);
                break;

            case 4:
                pieza[0] = new Celda(x + 0, y + 0, 1);
                pieza[1] = new Celda(x + 0, y + 1, 1);
                pieza[2] = new Celda(x + 0, y + 2, 1);
                pieza[3] = new Celda(x + 0, y + 3, 1);
                break;
            }

        }
}

