package com.example.tetrisg8;

import android.app.ActionBar;

public class FuncionamientoJuego {

    public Pieza generarPieza (){
        int tipoPieza = (int) Math.floor(Math.random()*6+1); //función para generar un numero aleatorio del 1 al 7
        Pieza pieza = new Pieza (tipoPieza);
        return pieza;
    }

    public int lineasCompletas (Tablero tablero, Pieza piezaActual){ //comprobamos todas las filas en las que se encuentra la pieza actual una vez haya acabado de caer
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
