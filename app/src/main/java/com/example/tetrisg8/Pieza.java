package com.example.tetrisg8;


public class Pieza {
    protected int tipopieza; // Variable que determinará el tipo de pieza
    //posiciones de los cuadrados que forman la pieza(xfila,ycolumna):X1,Y1,...,X4,Y4
    protected int[] cuadrados;

    //Si es una pieza extra se genera desplazada 3 columnas hacia la izquierda

    public Pieza(int tipo, int desp) {
        tipopieza = tipo;
        //Posicion inicial de las celdas en funcion del tipo
        switch (tipo) {
            case 1://tipo I
                cuadrados = new int[]{0, 3 + desp, 1, 3 + desp, 2, 3 + desp, 3, 3 + desp};
                break;
            case 2://tipo J
                cuadrados = new int[]{2, 3 + desp, 0, 4 + desp, 1, 4 + desp, 2, 4 + desp};
                break;
            case 3://tipo L
                cuadrados = new int[]{0, 3 + desp, 1, 3 + desp, 2, 3 + desp, 2, 4 + desp};
                break;
            case 4://tipo O
                cuadrados = new int[]{0, 3 + desp, 1, 3 + desp, 0, 4 + desp, 1, 4 + desp};
                break;
            case 5://tipo S
                cuadrados = new int[]{1, 3 + desp, 0, 4 + desp, 1, 4 + desp, 0, 5 + desp};
                break;
            case 6://tipo T
                cuadrados = new int[]{0, 3 + desp, 0, 4 + desp, 1, 4 + desp, 0, 5 + desp};
                break;
            case 7://tipo Z
                cuadrados = new int[]{0, 3 + desp, 0, 4 + desp, 1, 4 + desp, 1, 5 + desp};
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
