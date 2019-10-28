package com.example.tetrisg8;


import android.content.Context;

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
    private int periodo = 1000;
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


                        controlarPiezaNormal();
                        controlarPiezaExtra();
                        //acortarTablero();


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

    public void controlarPiezaNormal(){
        if (tablero.getEnjuego() == null) {  //Si es la primera pieza
            pieza = generarPieza(0); // Se genera una pieza aleatoria
            tablero.setEnjuego(pieza);
            piezaSiguiente = generarPieza();
            tablero.setPiezaSiguiente(piezaSiguiente);
            fichaView.setPiezaSiguiente(piezaSiguiente);
        } else {
            if (tablero.posibleBajar("normal")) { //Si es posible bajar la pieza
                tablero.bajarPieza("normal", 1);
            } else {
                if (tablero.ocupadoPosPieza(pieza)) { //Comprueba si es el final de la partida comprobando si hay otra pieza en su posición
                    mainActivity.pantallaGameOver();
                } else {
                    tablero.asignarPieza(pieza);
                    pieza = new Pieza(piezaSiguiente.getTipopieza(),tablero.getFilaInicial(), 0);
                    tablero.setEnjuego(pieza);
                    piezaSiguiente = generarPieza(); // Se genera una pieza aleatoria
                    tablero.setPiezaSiguiente(piezaSiguiente);
                    fichaView.setPiezaSiguiente(piezaSiguiente);
                }
            }
        }
    }

    public void controlarPiezaExtra(){
        int numPosiciones;
        //Se crea la pieza extra cada 30 segundos
        if (tablero.getPiezaExtra() == null) {

            if (tiempoTranscurrido > 0 && tiempoTranscurrido % 30000 == 0) {
                piezaExtra = generarPieza(3);
                tablero.setPiezaExtra(piezaExtra);
            }
        } else {
            if (tablero.posibleBajar("extra")) { //Si es posible bajar la pieza
                numPosiciones = tablero.numPosicionesBajar();
                tablero.bajarPieza("extra", numPosiciones);
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
    }

    public void acortarTablero(){
        if (tiempoTranscurrido > 0 && tiempoTranscurrido % 10000 == 0) {
            tablero.acortarTablero();
        }
    }

    public void finalizarTimer() {
        timer.cancel();
    }


    public Pieza generarPieza(int desplazamientoColumnas) {
        int tipoPieza = (int) Math.floor(Math.random() * 6 + 1); //función para generar un numero aleatorio del 1 al 7
        Pieza pieza = new Pieza(tipoPieza, tablero.getFilaInicial(), desplazamientoColumnas);
        return pieza;
    }

    public Pieza generarPieza(){
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