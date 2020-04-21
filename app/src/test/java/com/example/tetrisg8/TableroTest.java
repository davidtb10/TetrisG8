package com.example.tetrisg8;

import org.junit.Test;

import static org.junit.Assert.*;

public class TableroTest {

    @Test
    public void validarTableroInicialRelleno(){
        boolean filasNoVacias = false;
        Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        for (int i = 17; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if(!filasNoVacias){
                    filasNoVacias = tablero.getTablero()[i][j] != 0;
                }
            }
        }
        assertEquals(true, filasNoVacias);
    }

}