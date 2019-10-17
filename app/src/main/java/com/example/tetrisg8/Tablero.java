package com.example.tetrisg8;


public class Tablero {

    private int tablero[][] = new int[20][10];  //Tablero que almacenará las piezas
    private Pieza enjuego;
    private Pieza siguiente;

    public void inicializarTablero() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = 0;
            }
        }
    }

    public void asignarPieza(Pieza pieza){
        for(int i = 0; i < 8; i += 2){
            int fila = pieza.getCuadrados()[i];
            int columna = pieza.getCuadrados()[i+1];

            tablero[fila][columna] = pieza.getTipopieza();
        }
    }

    /*public boolean ocupadoGiro(Pieza pieza){
        boolean comprobar = false;
        for (int i = 0; i < 4; i++) { //borra la pieza para que al comprobar no se encuentre con una celda de la propia pieza
            tablero[pieza.getPieza()[i].getX()][pieza.getPieza()[i].getY()].setTipoPieza(0);
        }
        Celda celdasComprobar [] = pieza.coordPiezaGirada(); //METODO QUE DEVUELVE UN ARRAY CON LAS COORDENADAS QUE OCUPARIA LA PIEZA GIRADA
        for (int i = 0; i < 4; i++) {
            if (tablero[celdasComprobar[i].getX()][(celdasComprobar[i].getY())].getTipoPieza() == 0 && !(celdasComprobar[i].getX() < 0)
                    && !(celdasComprobar[i].getX() > 19) && !(celdasComprobar[i].getY() < 0) && !(celdasComprobar[i].getY() > 9)) {
                //comprueba si las celdas están ocupadas o se salen del tablero
                comprobar = false; //si no está ocupado devuelve false y se pintaría girada
            }
            else {
                comprobar = true;
                for (int j = 0; j < 4; j++) {
                    tablero[pieza.getPieza()[j].getX()][pieza.getPieza()[j].getY()].setTipoPieza(pieza.getPieza()[j].getTipoPieza()); //si está ocupado vuelve a pintar la pieza y devuelve true
                }
                return comprobar;
            }
        }
        return comprobar;
    }*/

    public boolean ocupadoPosPieza (Pieza pieza){
        boolean ocupado = false;
        for (int i = 0; i<8; i += 2){
            if(tablero[pieza.getCuadrados()[i]][pieza.getCuadrados()[i+1]] != 0){
                ocupado = true;
            }
        }
        return ocupado;
    }

    public void bajarPieza(Pieza pieza) {
        int i = 0;
        while (i < 8) {
            this.enjuego.cuadrados[i]++;
            i += 2;
        }
    }

    public boolean posibleBajar(Pieza pieza) {
        int filaSiguiente;
        boolean esposible = true;
        int i = 0;
        //Comprueba si es posible (si existe la celda y si esta vacia)
        while (esposible && i < 8) {
            filaSiguiente = enjuego.cuadrados[i] + 1;
            esposible = (filaSiguiente < 20) && (tablero[filaSiguiente][enjuego.cuadrados[i + 1]] == 0);
            i += 2;
        }
        return esposible;
    }

    //Mover pieza a la izquierda
    public boolean izquierda() {
        int columna = 0;
        boolean esposible = true;
        int i = 0;
        //Comprueba si es posible (si existe la celda y si esta vacia)
        while (esposible && i < 8) {
            columna = enjuego.cuadrados[i + 1] - 1;
            esposible = (columna > -1 && columna < 11) && (tablero[enjuego.cuadrados[i]][columna] == 0);
            i += 2;
        }

        if (esposible) {
            //Si ha sido posible realiza el cambio en la pieza en juego
            i = 1;
            while (i < 8) {
                this.enjuego.cuadrados[i]--;
                i += 2;
            }
        }
        return esposible;
    }

    //Mover pieza a la derecha
    public boolean derecha() {
        int columna = 0;
        boolean esposible = true;
        int i = 0;
        //Comprueba si es posible (si existe la celda y si esta vacia)
        while (esposible && i < 8) {
            columna = enjuego.cuadrados[i + 1] + 1;
            esposible = (columna > -1 && columna < 10) && (tablero[enjuego.cuadrados[i]][columna] == 0);
            i += 2;
        }

        if (esposible) {
            //Si ha sido posible realiza el cambio en la pieza en juego
            i = 1;
            while (i < 8) {
                this.enjuego.cuadrados[i]++;
                i += 2;
            }
        }
        return esposible;
    }
    
    //Rotar pieza
    public void rotar(){
        //Coordenadas del ultimo cuadrado de la pieza
        int fila = enjuego.cuadrados[6];
        int columna = enjuego.cuadrados[7];
        //cuadrados representados como puntos en una matriz
        Matrix matriz = new Matrix();
        matriz.setRotate(-90,fila,columna);
        float[] puntos = new float[]{0,0,0,0,0,0,0,0};
        for (int i=0;i<8;i++){
            puntos[i]=enjuego.cuadrados[i];
        }
        matriz.mapPoints(puntos);
        //comprobar si es posible
        boolean esposible = true;
        int j=0;
        while (esposible && j<8) {
            fila= (int) puntos[j];
            columna= (int) puntos[j+1];
            esposible=tablero[fila][columna]==0;
            j += 2;
        }
        //si ha sido posible guarda las nuevas coordenadas en pieza en juego
        if (esposible){
            for (int i = 0; i < 8; i++) {
                enjuego.cuadrados[i] = (int) puntos[i];
            }
        }
    }

    public int[][] getTablero() {
        return tablero;
    }

    public Pieza getEnjuego() {
        return enjuego;
    }

    public void setEnjuego(Pieza enjuego) {
        this.enjuego = enjuego;
    }

    public Pieza getSiguiente() {
        return siguiente;
    }

    public int lineasCompletas (){ //comprobamos todas las filas en las que se encuentra la pieza actual una vez haya acabado de caer
        int nLineasCompletas = 0;
        boolean lineaCompleta;
        for (int i = 0; i<8; i += 2){
            lineaCompleta= true;
            int filaAComprobar = enjuego.getCuadrados()[i];
            for (int j = 0; j<10; j++){
                if (tablero[filaAComprobar][j] == 0){
                    lineaCompleta = false;
                }
            }
            if (lineaCompleta){
                nLineasCompletas++;
                bajarLineas(filaAComprobar);
            }
        }
        return nLineasCompletas;
    }

    public void bajarLineas(int filaEliminar){
        for(int i = filaEliminar; i > 0; i--){ //Baja todas las filas una posición menos la primera
            for (int j=0; j< 10; j++){
                tablero[i][j] = tablero[i-1][j];
            }
        }
        for(int j=0; j<10;j++){ //Pone a 0 la primera fila
            tablero[0][j] = 0;
        }
    }
}
