package com.example.tetrisg8;


import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

//Clase que controla el funcionamiento del juego y de la partida

public class FuncionamientoJuego {
    int puntuacion = 0;
    Tablero tablero;
    Pieza pieza, piezaSiguiente;
    GameView gameView;
    FichaView fichaView;
    MainActivity mainActivity;
    Timer timer;

    public FuncionamientoJuego(GameView gameView, FichaView fichaView, Tablero tab, Context context) {
        this.gameView = gameView;
        this.fichaView = fichaView;
        tablero = tab;
        mainActivity = (MainActivity) context;
    }

    public void partida() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mainActivity.runOnUiThread(new TimerTask() {
                    @Override
                    public void run() {
                        if (tablero.getEnjuego() == null) {  //Si es la primera pieza
                            pieza = generarPieza(); // Se genera una pieza aleatoria
                            tablero.setEnjuego(pieza);
                            piezaSiguiente = generarPieza();
                            fichaView.setPiezaSiguiente(piezaSiguiente);
                        } else {
                            if (tablero.posibleBajar(tablero.getEnjuego())) { //Si es posible bajar la pieza
                                tablero.bajarPieza(pieza);
                            } else {
                                if (tablero.ocupadoPosPieza(pieza)) { //Comprueba si es el final de la partida comprobando si hay otra pieza en su posición
                                    mainActivity.pantallaGameOver();
                                } else {
                                    tablero.asignarPieza(pieza);
                                    tablero.lineasCompletas();
                                    pieza = piezaSiguiente;
                                    tablero.setEnjuego(pieza);
                                    piezaSiguiente = generarPieza(); // Se genera una pieza aleatoria
                                    fichaView.setPiezaSiguiente(piezaSiguiente);
                                }
                            }
                        }
                        fichaView.invalidate();
                        gameView.invalidate();

                    }
                });
            }
        }, 0, 500);
    }

    public void finalizarTimer() {
        timer.cancel();
    }


    public Pieza generarPieza() {
        int tipoPieza = (int) Math.floor(Math.random() * 6 + 1); //función para generar un numero aleatorio del 1 al 7
        Pieza pieza = new Pieza(tipoPieza);
        return pieza;
    }


    /*public int actualizarPuntuacion(int puntuacion, Tablero tablero, Pieza pieza){ //le pasamos la puntuación actual
        puntuacion = puntuacion + lineasCompletas(tablero, pieza)*30;
        return puntuacion;
    }*/

    
    /*public void izquierda() {
        if (tablero.ocupadoIzq(pieza)){
            for (int i=0;i<4;i++){
                pieza.getPieza()[i].setY(pieza.getPieza()[i].getY()-1);
            }
        }
    }*/

    /*public void derecha() {
        if (tablero.ocupadoDcha(pieza)){
            for (int i=0;i<4;i++){
                pieza.getPieza()[i].setY(pieza.getPieza()[i].getY()+1);
            }
        }
    }*/

    public void girar() {

    }
}
