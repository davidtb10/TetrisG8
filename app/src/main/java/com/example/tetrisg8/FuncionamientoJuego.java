package com.example.tetrisg8;


import android.content.Context;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

//Clase que controla el funcionamiento del juego y de la partida

public class FuncionamientoJuego {
    private int puntuacion = 0;
    private Tablero tablero;
    private Pieza pieza, piezaSiguiente, piezaExtra;
    private GameView gameView;
    private FichaView fichaView;
    private MainActivity mainActivity;
    private Timer timer;
    private int periodo = 500;
    private int tiempoTranscurrido = 0;

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
                            if (tablero.posibleBajar(tablero.getEnjuego(),"normal")) { //Si es posible bajar la pieza
                                tablero.bajarPieza(pieza, "normal");
                            } else {
                                if (tablero.ocupadoPosPieza(pieza)) { //Comprueba si es el final de la partida comprobando si hay otra pieza en su posición
                                    mainActivity.pantallaGameOver();
                                } else {
                                    tablero.asignarPieza(pieza);
                                    pieza = piezaSiguiente;
                                    tablero.setEnjuego(pieza);
                                    piezaSiguiente = generarPieza(); // Se genera una pieza aleatoria
                                    fichaView.setPiezaSiguiente(piezaSiguiente);
                                }
                            }
                        }

                        //Se crea la pieza extra cada 30 segundos
                        if (tablero.getPiezaExtra() == null) {

                            if (tiempoTranscurrido > 0 && tiempoTranscurrido % 30000 == 0) {
                                Toast.makeText(mainActivity, "Creamos la pieza extra", Toast.LENGTH_SHORT).show();
                                piezaExtra = generarPieza();
                                tablero.setPiezaExtra(piezaExtra);
                            }
                        } else {
                            if (tablero.posibleBajar(tablero.getPiezaExtra(),"extra")) { //Si es posible bajar la pieza
                                tablero.bajarPieza(piezaExtra, "extra");
                            } else {
                                if (tablero.ocupadoPosPieza(piezaExtra)) { //Comprueba si es el final de la partida comprobando si hay otra pieza en su posición
                                    mainActivity.pantallaGameOver();
                                } else {
                                    tablero.asignarPieza(piezaExtra);
                                    piezaExtra = null;
                                    tablero.setPiezaExtra(null);
                                }
                            }
                        }


                        puntuacion += tablero.lineasCompletas();
                        mainActivity.actualizarPuntuacion();

                        fichaView.invalidate();
                        gameView.invalidate();
                        tiempoTranscurrido += periodo;

                    }
                });
            }
        }, 0, periodo);
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

    public int getPuntuacion() {
        return puntuacion;
    }
}
