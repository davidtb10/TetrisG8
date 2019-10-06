package com.example.tetrisg8;


public class Tablero {

    Celda tablero[][] = new Celda[20][10];  //Tablero que almacenará las piezas

    public Celda[][] getTablero(){
        return tablero;
    }

    public void inicializarTablero() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = new Celda(i,j);
            }
        }
    }

    public void asignarPieza(Pieza pieza){
        for(int i = 0; i < 4; i++){
            tablero[pieza.getPieza()[i].getX()][pieza.getPieza()[i].getY()].setCelda(pieza.getPieza()[i]);
        }
    }

    public boolean ocupadoBajar(Pieza pieza) { //comprueba si la pieza puede bajar
        boolean comprobar = false;
        /*for (int i = 0; i < 4; i++) { //borra la pieza para que al comprobar no se encuentre con una celda de la propia pieza
            tablero[pieza.getPieza()[i].getX()][pieza.getPieza()[i].getY()].setTipoPieza(0);
        }*/
        for (int i = 0; i < 4; i++) {
            if (tablero[(pieza.getPieza()[i].getX()) + 1][pieza.getPieza()[i].getY()].getTipoPieza() == 0 && ! (pieza.getPieza()[i].getX()==19)) { //comprueba si la celda de abajo no está ocupada o es la última
                comprobar = false;
            } else {
                comprobar = true;
                //pintarPieza(pieza);
                return comprobar;
            }
        }
        /*for (int i = 0; i < 4; i++) {
            tablero[pieza.getPieza()[i].getX()][pieza.getPieza()[i].getY()].setTipoPieza(pieza.getPieza()[i].getTipoPieza()); //si no está ocupado también vuelve a pintar la pieza
        }*/
        //pintarPieza(pieza);//si no está ocupado también vuelve a pintar la pieza
        return comprobar;
    }

    public boolean ocupadoDcha(Pieza pieza) { //comprueba si la pieza puede moverse a la derecha
        boolean comprobar = false;
        for (int i = 0; i < 4; i++) { //borra la pieza para que al comprobar no se encuentre con una celda de la propia pieza
            tablero[pieza.getPieza()[i].getX()][pieza.getPieza()[i].getY()].setTipoPieza(0);
        }
        for (int i = 0; i < 4; i++) {
            if (tablero[pieza.getPieza()[i].getX()][(pieza.getPieza()[i].getY()) + 1].getTipoPieza() == 0 && !(pieza.getPieza()[i].getY() == 9)) { //comprueba si la celda de la derecha está ocupada o es la última
                comprobar = false;
            } else {
                comprobar = true;
                //pintarPieza(pieza); //si está ocupado vuelve a pintar la pieza y devuelve true
                return comprobar;
            }
        }
        //pintarPieza(pieza);//si no está ocupado también vuelve a pintar la pieza
        return comprobar;
    }

    public boolean ocupadoIzq(Pieza pieza) { //comprueba si la pieza puede moverse a la izquierda
        boolean comprobar = false;
        /*for (int i = 0; i < 4; i++) { //borra la pieza para que al comprobar no se encuentre con una celda de la propia pieza
            tablero[pieza.getPieza()[i].getX()][pieza.getPieza()[i].getY()].setTipoPieza(0);
        }*/
        for (int i = 0; i < 4; i++) {
            if (tablero[pieza.getPieza()[i].getX()][(pieza.getPieza()[i].getY()) - 1].getTipoPieza() == 0 && !(pieza.getPieza()[i].getY() == 0)) { //comprueba si la celda de la izquierda está ocupada o es la última
                comprobar = false;
            } else {
                comprobar = true;
                //pintarPieza(pieza); //si está ocupado vuelve a pintar la pieza y devuelve true
                return comprobar;
            }
        }
        //pintarPieza(pieza); //si no está ocupado también vuelve a pintar la pieza
        return comprobar;
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
        if (! ocupadoBajar (pieza)){ //si la fila de abajo no está ocupada la matriz de la ficha baja una posición
            for (int i=0; i<4; i++) {
                pieza.getPieza()[i].setX(pieza.getPieza()[i].getX() + 1);
            }
        }
    }

}
