package com.example.tetrisg8;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Tablero {

    public int [][] tipoPieza;  //Tablero que almacenará las piezas

    Pieza [] pieza = new Pieza[4];

    Canvas canvas;

    public Tablero() {
        int [][] tipoPieza = new int [20][10];
    }

    public int[][] getTipoPieza () {
        return tipoPieza;
    }

    public void setTipoPieza(int x, int y, int tipoPiezanuevo){
        tipoPieza[x][y] = tipoPiezanuevo;
    }

    Tablero tablero = new Tablero();

    public void inicializarTablero() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                tablero.getTipoPieza()[i][j] = 0;
            }
        }
    }

    public void asignarPieza(Pieza [] pieza, int [][] tablero){
        for(int i = 0; i < 4; i++){
            tablero[pieza[i].x][pieza[i].y] = pieza[i].tipopieza;
        }
    }

    public void pintarCelda(int tipoPieza, Canvas canvas){ // método que dibuja una celda de la pieza
        Paint p = new Paint();
        switch (tipoPieza){
            case 0: {
                p.setColor(Color.BLACK);
            }
            case 1: {
                p.setColor(Color.CYAN);
            }
            case 2:{
                p.setColor(Color.BLUE);
            }
            case 3:{
                p.setColor(Color.rgb(255, 128, 0));
            }
            case 4:{
                p.setColor(Color.YELLOW);
                break;
            }
            case 5:{
                p.setColor(Color.GREEN);
                break;
            }
            case 6:{
                p.setColor(Color.MAGENTA);
                break;
            }
            case 7:{
                p.setColor(Color.RED);
                break;
            }
        }
    }

    //Se pinta la pieza
    public void dibujarPieza(Canvas canvas, Pieza[] pieza){
        tablero.pintarCelda(tablero.getTipoPieza()[this.pieza[0].x][this.pieza[0].y], canvas);
        tablero.pintarCelda(tablero.getTipoPieza()[this.pieza[1].x][this.pieza[1].y], canvas);
        tablero.pintarCelda(tablero.getTipoPieza()[this.pieza[2].x][this.pieza[2].y], canvas);
        tablero.pintarCelda(tablero.getTipoPieza()[this.pieza[3].x][this.pieza[3].y], canvas);
    }

    public boolean ocupadoBajar(Pieza [] pieza) { //comprueba si la pieza puede bajar
        boolean comprobar = false;
        for (int i = 0; i < 4; i++) { //borra la pieza para que al comprobar no se encuentre con una celda de la propia pieza
            tablero.setTipoPieza(pieza[i].x, pieza[i].y, 0);
        }
        for (int i = 0; i < 4; i++) {
            if (tablero.getTipoPieza()[(pieza[i].x) + 1][pieza[i].y] == 0 && ! (pieza[i].x==19)) { //comprueba si la celda de abajo no está ocupada o es la última
                comprobar = false;
            } else {
                comprobar = true;
                dibujarPieza(canvas, pieza);
                return comprobar;
            }
        }
        for (int i = 0; i < 4; i++) {
            tablero.setTipoPieza(pieza[i].x, pieza[i].y,pieza[i].tipopieza); //si no está ocupado también vuelve a pintar la pieza
        }
        dibujarPieza(canvas, pieza);//si no está ocupado también vuelve a pintar la pieza
        return comprobar;
    }

    public boolean ocupadoDcha(Pieza [] pieza) { //comprueba si la pieza puede moverse a la derecha
        boolean comprobar = false;
        for (int i = 0; i < 4; i++) { //borra la pieza para que al comprobar no se encuentre con una celda de la propia pieza
            tablero.setTipoPieza(pieza[i].x, pieza[i].y, 0);
        }
        for (int i = 0; i < 4; i++) {
            if (tablero.getTipoPieza()[pieza[i].x][(pieza[i].y) + 1] == 0 && !(pieza[i].y == 9)) { //comprueba si la celda de la derecha está ocupada o es la última
                comprobar = false;
            } else {
                comprobar = true;
                dibujarPieza(canvas, pieza); //si está ocupado vuelve a pintar la pieza y devuelve true
                return comprobar;
            }
        }
        dibujarPieza(canvas, pieza);//si no está ocupado también vuelve a pintar la pieza
        return comprobar;
    }

    public boolean ocupadoIzq(Pieza [] pieza) { //comprueba si la pieza puede moverse a la izquierda
        boolean comprobar = false;
        for (int i = 0; i < 4; i++) { //borra la pieza para que al comprobar no se encuentre con una celda de la propia pieza
            tablero.setTipoPieza(pieza[i].x, pieza[i].y, 0);
        }
        for (int i = 0; i < 4; i++) {
            if (tablero.getTipoPieza()[pieza[i].x][(pieza[i].y) - 1] == 0 && !(pieza[i].y == 0)) { //comprueba si la celda de la izquierda está ocupada o es la última
                comprobar = false;
            } else {
                comprobar = true;
                dibujarPieza(canvas, pieza); //si está ocupado vuelve a pintar la pieza y devuelve true
                return comprobar;
            }
        }
        dibujarPieza(canvas, pieza); //si no está ocupado también vuelve a pintar la pieza
        return comprobar;
    }

    public boolean ocupadoGiro(Pieza [] pieza){
        boolean comprobar = false;
        for (int i = 0; i < 4; i++) { //borra la pieza para que al comprobar no se encuentre con una celda de la propia pieza
            tablero.setTipoPieza(pieza[i].x, pieza[i].y, 0);
        }

        Pieza celdasComprobar;
        if (pieza[0].nGiro < 4) {
            celdasComprobar = new Pieza(pieza[0].x, pieza[0].y, pieza[0].tipopieza, pieza[0].nGiro +1);
        }
        else{
            celdasComprobar = new Pieza(pieza[0].x, pieza[0].y, pieza[0].tipopieza, 1);
        }

        /*for (int i = 0; i < 4; i++) {
            if (tablero.getTipoPieza(celdasComprobar[i].x, celdasComprobar[i].y) == 0 && !(celdasComprobar[i].getX() < 0)
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
        }*/
        return comprobar;
    }

    public boolean ocupado (Pieza [] pieza){
        boolean comprobar = false;
        for (int i = 0; i<4; i++){
            if (tablero.getTipoPieza()[pieza[i].x][(pieza[i].y)] == 0) {
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

    public void bajarPieza (Pieza [] pieza){
        if (! ocupadoBajar (pieza)){ //si la fila de abajo no está ocupada la matriz de la ficha baja una posición
            for (int i=0; i<4; i++) {
                pieza[i].x = pieza[i].x + 1;
            }
        }
    }

}
