package com.example.tetrisg8;


public class PiezaJ extends Pieza {

    //Se construye la pieza
    Pieza [] pieza = new Pieza[4];

    //Coordenadas para la pieza dependiendo de la posición en la que se encuentre
    public PiezaJ (int x, int y, int tipopieza, int nGiro) {
        switch (nGiro) {
            case 1:
                pieza[0] = new Pieza(x+0, y+0, 2, 1);
                pieza[1] = new Pieza(x+1, y+0, 2, 1);
                pieza[2] = new Pieza(x+2, y+0, 2, 1);
                pieza[3] = new Pieza(x+0, y+1, 2, 1);
                break;
            case 2:
                pieza[0] = new Pieza(x+0, y+0, 2, 2);
                pieza[1] = new Pieza(x+0, y+1, 2, 2);
                pieza[2] = new Pieza(x+0, y+2, 2, 2);
                pieza[3] = new Pieza(x+1, y+2, 2, 2);
                break;
            case 3:
                pieza[0] = new Pieza(x+0, y+1, 2, 3);
                pieza[1] = new Pieza(x+1, y+1, 2, 3);
                pieza[2] = new Pieza(x+2, y+1, 2, 3);
                pieza[3] = new Pieza(x+2, y+0, 2, 3);
                break;
            case 4:
                pieza[0] = new Pieza(x+0, y+0, 2, 4);
                pieza[1] = new Pieza(x+1, y+0, 2, 4);
                pieza[2] = new Pieza(x+1, y+1, 2, 4);
                pieza[3] = new Pieza(x+1, y+2, 2, 4);
                break;
        }

    }
}

