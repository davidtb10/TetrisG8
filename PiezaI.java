package com.example.tetrisg8;

//Pieza del tipo I

public class PiezaI extends Pieza {
    Pieza [] pieza = new Pieza[4]; //la pieza esta formada por 4 subpiezas ??
    //Se construye la pieza
    //Coordenadas para la pieza dependiendo de la posición en la que se encuentre
    public PiezaI (int x, int y, int tipopieza, int nGiro) {
        switch (nGiro) {
            case 1:
                pieza[0] = new Pieza (x + 0, y + 0, 1, 1);
                pieza[1] = new Pieza(x + 1, y + 0, 1, 1);
                pieza[2] = new Pieza (x + 2, y + 0, 1, 1);
                pieza[3] = new Pieza(x + 3, y + 0, 1, 1);
                break;
            case 2:
                pieza[0] = new Pieza(x + 0, y + 0, 1, 2);
                pieza[1] = new Pieza(x + 0, y + 1, 1, 2);
                pieza[2] = new Pieza(x + 0, y + 2, 1, 2);
                pieza[3] = new Pieza(x + 0, y + 3, 1, 2);
                break;

            case 3:
                pieza[0] = new Pieza(x + 0, y + 0, 1, 3);
                pieza[1] = new Pieza(x + 1, y + 0, 1, 3);
                pieza[2] = new Pieza(x + 2, y + 0, 1, 3);
                pieza[3] = new Pieza(x + 3, y + 0, 1, 3);
                break;

            case 4:
                pieza[0] = new Pieza(x + 0, y + 0, 1, 4);
                pieza[1] = new Pieza(x + 0, y + 1, 1, 4);
                pieza[2] = new Pieza(x + 0, y + 2, 1, 4);
                pieza[3] = new Pieza(x + 0, y + 3, 1, 4);
                break;
            }

        }
}

