package com.example.tetrisg8;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.view.View;


public class GameView extends View {
    private Tablero tablero;
    private Paint p;
    private int gamaColores;

    public GameView(Context context, Tablero tablero) {
        super(context);
        this.tablero = tablero;
        p = new Paint();
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(context);
        gamaColores = Integer.parseInt(pref.getString("lista","1"));
    }

    @Override
    protected void onDraw(Canvas canvas) { //Pinta la cuadrícula del tablero
        super.onDraw(canvas);
        pintarTablero(canvas);
        pintarPieza(canvas);
        pintarPiezaExtra(canvas);
        pintarCuadricula(canvas);
    }

    private void pintarTablero(Canvas canvas) {
        int anchoCelda = this.getWidth() / 10;
        int altoCelda = this.getHeight() / 20;
        int color = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                color = colorCelda(tablero.getTablero()[i][j]);
                p.setColor(color);
                canvas.drawRect(j * anchoCelda, i * altoCelda, j * anchoCelda + anchoCelda, i * altoCelda + altoCelda, p);
            }
        }
    }

    private void pintarCuadricula(Canvas canvas) {
        p.setColor(Color.GRAY);
        int anchoCelda = this.getWidth() / 10;
        int ejeX = 0;
        for (int i = 0; i < 9; i++) {
            ejeX += anchoCelda;
            canvas.drawLine(ejeX, 0, ejeX, this.getHeight(), p);
        }
        int altoCelda = this.getHeight() / 20;
        int ejeY = 0;
        for (int i = 0; i < 19; i++) {
            ejeY += altoCelda;
            canvas.drawLine(0, ejeY, this.getWidth(), ejeY, p);
        }
    }

    public void pintarPieza(Canvas canvas) {
        int anchoCelda = this.getWidth() / 10;
        int altoCelda = this.getHeight() / 20;
        int color = 0;
        color = colorCelda(tablero.getEnjuego().tipopieza);
        p.setColor(color);
        int fila;
        int columna;
        int ite = 0;
        while (ite < 8) {
            fila = tablero.getEnjuego().cuadrados[ite];
            ite++;
            columna = tablero.getEnjuego().cuadrados[ite];
            ite++;
            canvas.drawRect(columna * anchoCelda, fila * altoCelda, columna * anchoCelda + anchoCelda, fila * altoCelda + altoCelda, p);
        }
    }

    public void pintarPiezaExtra(Canvas canvas) {
        if (tablero.getPiezaExtra() != null) {
            int anchoCelda = this.getWidth() / 10;
            int altoCelda = this.getHeight() / 20;
            int color = 0;
            color = colorCelda(tablero.getPiezaExtra().tipopieza);
            p.setColor(color);
            int fila;
            int columna;
            int ite = 0;
            while (ite < 8) {
                fila = tablero.getPiezaExtra().cuadrados[ite];
                ite++;
                columna = tablero.getPiezaExtra().cuadrados[ite];
                ite++;
                canvas.drawRect(columna * anchoCelda, fila * altoCelda, columna * anchoCelda + anchoCelda, fila * altoCelda + altoCelda, p);
            }
        }
    }

    public int colorCelda(int codigo) {
        int color = 0;
        if(gamaColores == 1){
            switch (codigo) {
                case -1:
                    color = Color.DKGRAY;
                    break;
                case 0:
                    color = Color.BLACK;
                    break;
                case 1:
                    color = Color.RED;
                    break;
                case 2:
                    color = Color.WHITE;
                    break;
                case 3:
                    color = Color.MAGENTA;
                    break;
                case 4:
                    color = Color.BLUE;
                    break;
                case 5:
                    color = Color.GREEN;
                    break;
                case 6:
                    color = Color.GRAY;
                    break;
                case 7:
                    color = Color.CYAN;
                    break;
            }
        }else if(gamaColores == 2){
            switch (codigo) {
                case -1:
                    color = Color.DKGRAY;
                    break;
                case 0:
                    color = Color.BLACK;
                    break;
                case 1:
                    color = Color.BLUE;
                    break;
                case 2:
                    color = Color.BLUE;
                    break;
                case 3:
                    color = Color.BLUE;
                    break;
                case 4:
                    color = Color.BLUE;
                    break;
                case 5:
                    color = Color.BLUE;
                    break;
                case 6:
                    color = Color.BLUE;
                    break;
                case 7:
                    color = Color.BLUE;
                    break;
            }
        }

        return color;
    }

    public void setGamaColores(int gamaColores) {
        this.gamaColores = gamaColores;
    }
}
