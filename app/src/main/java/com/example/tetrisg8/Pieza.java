package com.example.tetrisg8;

import android.graphics.Canvas;

public class Pieza { //Pieza genérica
    protected int tipopieza; // Variable que determinará el tipo de pieza
    protected int x; //coordenada x de la pieza
    protected int y; //coordenada y de la pieza
    protected int nGiro; //para saber la posicion de giro


    public Pieza(int x, int y, int tipopieza, int nGiro){
        switch (tipopieza){
            case 1:
                Pieza PiezaI = new PiezaI (x, y, tipopieza, nGiro);
                break;
            case 2:
                Pieza PiezaJ = new PiezaJ (x, y, tipopieza, nGiro);
                break;
            case 3:
                Pieza PiezaL = new PiezaL (x, y, tipopieza, nGiro);
                break;
            case 4:
                Pieza PiezaO = new PiezaO (x, y, tipopieza, nGiro);
                break;
            case 5:
                Pieza PiezaS = new PiezaS (x, y, tipopieza, nGiro);
                break;
            case 6:
                Pieza PiezaT = new PiezaT (x, y, tipopieza, nGiro);
               break;
            case 7:
                Pieza PiezaZ = new PiezaZ (x, y, tipopieza, nGiro);
                break;
        }
    }

    public Pieza() {
    }
}
