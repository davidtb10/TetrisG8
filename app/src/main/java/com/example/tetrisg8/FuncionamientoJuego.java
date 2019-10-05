package com.example.tetrisg8;

public class FuncionamientoJuego {

    public int actualizarPuntuacion(int puntuacion, Tablero tablero, Pieza pieza){ //le pasamos la puntuación actual
        puntuacion = puntuacion + lineasCompletas(pieza)*30;
        return puntuacion;
    }
}
