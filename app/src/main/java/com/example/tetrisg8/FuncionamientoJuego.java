package com.example.tetrisg8;

import android.app.ActionBar;
import android.graphics.Canvas;

public class FuncionamientoJuego {
    int puntuacion = 0;

    public void partida(){
        Pieza pieza;
        boolean derrota;
        Canvas canvas = new Canvas();

        Tablero tablero = new Tablero();
        tablero.inicializarTablero();

        derrota = false;

        //this.caja_score.setText("0");
        while(!derrota){
            pieza = generarPieza(0,4);

            derrota = finJuego(tablero, pieza); //comprueba si la pieza nueva entra en el tablero
            if (! derrota) {
                //pintarPieza(pieza);
                //acciones de mover pieza durante x tiempo ?
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //si no se produce ninguna acción:
                if (! tablero.ocupadoBajar(pieza)) { //si se puede se baja la pieza si no se fija
                    tablero.bajarPieza(pieza);
                }
                else{
                    //se fija la pieza
                    puntuacion = funcionamiento.actualizarPuntuacion(puntuacion, tablero, piezaAct); //se comprueba si se han completado lineas y se actualiza la puntuacion
                    //eliminar las lineas llenas y bajar las lineas superiores
                        /*
                        caja_score.setText(String.valueOf(puntuacion));
                        */
                }

            }
        }
    }

    public Pieza generarPieza (int x, int y){
        Pieza pieza = new Pieza();
        int tipoPieza = (int) Math.floor(Math.random()*6+1); //función para generar un numero aleatorio del 1 al 7
        switch (tipoPieza){
            case 1: {
                pieza = new PiezaI(x, y);
                break;
            }
            case 2:{
                pieza = new PiezaJ(x, y);
                break;
            }
            case 3:{
                pieza = new PiezaL(x, y);
                break;
            }
            case 4:{
                pieza = new PiezaO(x, y);
                break;
            }
            case 5:{
                pieza = new PiezaS(x, y);
                break;
            }
            case 6:{
                pieza = new PiezaT(x, y);
                break;
            }
            case 7:{
                pieza = new PiezaZ(x, y);
                break;
            }
        }
        return pieza;
    }

    private int lineasCompletas (Tablero tablero, Pieza piezaActual){ //comprobamos todas las filas en las que se encuentra la pieza actual una vez haya acabado de caer
        int nLineasCompletas = 0;
        for (int i = 0; i<4; i++){
            boolean comprobarCompleta = true;
            int filaAComprobar = piezaActual.getPieza()[i].getX();
            for (int j = 0; j<10; j++){
                if (tablero.getTablero()[filaAComprobar][j].getTipoPieza() == 0){
                    comprobarCompleta = false;
                }
            }
            if (comprobarCompleta){
                nLineasCompletas++;
            }
        }
        return nLineasCompletas;
    }

    public int actualizarPuntuacion(int puntuacion, Tablero tablero, Pieza pieza){ //le pasamos la puntuación actual
        puntuacion = puntuacion + lineasCompletas(tablero, pieza)*30;
        return puntuacion;
    }

    public boolean finJuego (Tablero tablero, Pieza pieza){ //comprueba si el tablero está ocupado ANTES de salir una pieza nueva
        if (tablero.ocupado(pieza)){
            return true;
        }
        else{
            return false;
        }
    }
}
