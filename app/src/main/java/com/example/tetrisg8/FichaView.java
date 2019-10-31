package com.example.tetrisg8;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.core.content.ContextCompat;

//Vista que muestra la siguiente ficha

public class FichaView extends View {
    private Paint p;
    private Pieza piezaSiguiente;
    private int gamaColores;

    public FichaView(Context context) {
        super(context);
        p = new Paint();
        this.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorDarkBlue));
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(context);
        gamaColores = Integer.parseInt(pref.getString("lista","1"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pintarPieza(canvas);
    }

    public void pintarPieza(Canvas canvas) {
        int anchoCelda = this.getWidth() / 5;
        int altoCelda = this.getHeight() / 10;
        int color = 0;
        color = colorCelda(piezaSiguiente.tipopieza);
        p.setColor(color);
        int fila;
        int columna;
        int ite = 0;
        while (ite < 8) {
            fila = piezaSiguiente.cuadrados[ite];
            ite++;
            columna = piezaSiguiente.cuadrados[ite];
            ite++;
            //Deja 8 celdas vacías por arriba para aparecer centrada
            canvas.drawRect(columna * anchoCelda, fila * altoCelda, columna * anchoCelda + anchoCelda, fila * altoCelda + altoCelda, p);
        }
    }

    public int colorCelda(int codigo) {
        int color = 0;
        if(gamaColores == 1){
            switch (codigo) {
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

    public void setPiezaSiguiente(Pieza piezaSiguiente) {
        this.piezaSiguiente = piezaSiguiente;
    }

    public void setGamaColores(int gamaColores) {
        this.gamaColores = gamaColores;
    }
}

