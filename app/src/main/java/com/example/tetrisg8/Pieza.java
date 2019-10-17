package com.example.tetrisg8;

import android.graphics.Canvas;

public class Pieza {
    protected int tipopieza; // Variable que determinará el tipo de pieza
    //posiciones de los cuadrados que forman la pieza(xfila,ycolumna):X1,Y1,...,X4,Y4
    protected int[] cuadrados;

    public Pieza(int tipo){
        tipopieza = tipo;
        //Posicion inicial de las celdas en funcion del tipo
        switch (tipo){
            case 1://tipo I
                cuadrados = new int[]{0,4,1,4,2,4,3,4};
                break;
            case 2://tipo J
                cuadrados = new int[]{2,4,0,5,1,5,2,5};
                break;
            case 3://tipo L
                cuadrados = new int[]{0,4,1,4,2,4,2,5};
                break;
            case 4://tipo O
                cuadrados = new int[]{0,4,1,4,0,5,1,5};
                break;
            case 5://tipo S
                cuadrados = new int[]{1,4,0,5,1,5,0,6};
                break;
            case 6://tipo T
                cuadrados = new int[]{0,4,0,5,1,5,0,6};
                break;
            case 7://tipo Z
                cuadrados = new int[]{0,4,0,5,1,5,1,6};
                break;
        }
    }

    public int[] getCuadrados() {
        return cuadrados;
    }

    public int getTipopieza() {
        return tipopieza;
    }
}
