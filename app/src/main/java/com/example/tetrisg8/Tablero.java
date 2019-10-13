package com.example.tetrisg8;


public class Tablero {

    int tablero[][] = new int[20][10];  //Tablero que almacenará las piezas
    Pieza enjuego;
    Pieza siguiente;

    public void inicializarTablero() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = 0;
            }
        }
    }

    public void asignarPieza(Pieza pieza){
        for(int i = 0; i < 4; i++){
            Celda celdaTablero = tablero[pieza.getPieza()[i].getX()][pieza.getPieza()[i].getY()];
            celdaTablero.setTipoPieza(pieza.getPieza()[i].getTipoPieza());
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

    public boolean ocupado (Pieza pieza){
        boolean comprobar = false;
        for (int i = 0; i<4; i++){
            if (tablero[pieza.getPieza()[i].getX()][(pieza.getPieza()[i].getY())].getTipoPieza() == 0) {
                //comprueba si las celdas están ocupadas
                comprobar = false;
            }
            else {
                comprobar = true;
                return comprobar;
            }
        }
        return comprobar;
    }

    public void bajarPieza (Pieza pieza){
        int fila=0;
        boolean esposible=true;
        int i=0;
        //Comprueba si es posible (si existe la celda y si esta vacia)
        while (esposible && i<8){
            fila=enjuego.cuadrados[i]+1;
            esposible=(fila<21)&&(tablero[fila][enjuego.cuadrados[i+1]]==0);
            i+=2;
        }
        
        if (esposible) {
            //Si ha sido posible realiza el cambio en la pieza en juego
            i=0;
            while (i < 8) {
                this.enjuego.cuadrados[i]++;
                i += 2;
            }
        }
    }
    //Mover pieza a la izquierda
    public boolean izquierda(){
        int columna=0;
        boolean esposible=true;
        int i=0;
        //Comprueba si es posible (si existe la celda y si esta vacia)
        while (esposible && i<8) {
            columna=enjuego.cuadrados[i + 1]-1;
            esposible=(columna>-1 && columna<11)&&(tablero[enjuego.cuadrados[i]][columna]==0);
            i += 2;
        }
        
        if(esposible) {
            //Si ha sido posible realiza el cambio en la pieza en juego
            i=1;
            while (i < 8) {
                this.enjuego.cuadrados[i]--;
                i += 2;
            }
        }
        return esposible;
    }
    //Mover pieza a la derecha
    public boolean derecha(){
        int columna=0;
        boolean esposible=true;
        int i=0;
        //Comprueba si es posible (si existe la celda y si esta vacia)
        while (esposible && i<8) {
            columna=enjuego.cuadrados[i + 1]+1;
            esposible=(columna>-1 && columna<10)&&(tablero[enjuego.cuadrados[i]][columna]==0);
            i += 2;
        }

        if(esposible) {
            //Si ha sido posible realiza el cambio en la pieza en juego
            i=1;
            while (i < 8) {
                this.enjuego.cuadrados[i]++;
                i += 2;
            }
        }
        return esposible;
    }
}
