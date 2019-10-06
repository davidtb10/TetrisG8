package com.example.tetrisg8;


import android.graphics.Canvas;

//Clase que controla el funcionamiento del juego y de la partida

public class FuncionamientoJuego {
    int puntuacion = 0;
    Tablero tablero = new Tablero();
    Pieza pieza;
    public void partida(TextView score, GameView gameView, FichaView fichaView, Tablero tab){
        tablero=tab;
        this.caja_score = score;
        caja_score.setText("0");
        //llamar a invalidate cada vez que se mueve una ficha
        gameView.invalidate();
    }
        
    public void partida1(){
        boolean derrota;
        Canvas canvas = new Canvas();
        tablero.inicializarTablero();  //Se crea un tablero inicial vacío

        derrota = false;

        //this.caja_score.setText("0");
        while(!derrota){  //Mientras no se pierda, se juega la partida
            pieza = generarPieza(0,4); // Se genera una pieza aleatoria
            derrota = finJuego(tablero, pieza); //comprueba si la pieza nueva entra en el tablero

            if (! derrota) {  //Si no se ha perdido se dibuja la pieza
                pieza.dibujarPieza(canvas);
                //acciones de mover pieza durante x tiempo ?

                //si no se produce ninguna acción:

                boolean fijado = false;
                while(!fijado){ //Mientras la ficha no esté fijada se va bajando por el tablero
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (! tablero.ocupadoBajar(pieza)) { //si se puede se baja la pieza si no se fija
                        pieza.borrarPieza(canvas);
                        tablero.bajarPieza(pieza);
                        pieza.dibujarPieza(canvas);
                    }
                    else{
                        tablero.asignarPieza(pieza);  //La pieza se asigna al tablero una vez ha colisionado con otra pieza por debajo de esta
                        fijado = true;
                        puntuacion = actualizarPuntuacion(puntuacion, tablero, pieza); //se comprueba si se han completado lineas y se actualiza la puntuacion
                        //eliminar las lineas llenas y bajar las lineas superiores
                        /*
                        caja_score.setText(String.valueOf(puntuacion));
                        */
                    }
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
    
    public void izquierda() {
        if (tablero.ocupadoIzq(pieza)){
            for (int i=0;i<4;i++){
                pieza.getPieza()[i].setY(pieza.getPieza()[i].getY()-1);
            }
        }
    }

    public void derecha() {
        if (tablero.ocupadoDcha(pieza)){
            for (int i=0;i<4;i++){
                pieza.getPieza()[i].setY(pieza.getPieza()[i].getY()+1);
            }
        }
    }
    
    public void girar() {
        
    }
}
