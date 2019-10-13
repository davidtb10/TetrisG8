package com.example.tetrisg8;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;


public class GameView extends View {
    Tablero tablero;

    public GameView(Context context, Tablero tablero) {
        super(context);
        this.tablero = tablero;
    }

    @Override
    protected void onDraw(Canvas canvas) { //Pinta la cuadrícula del tablero
        super.onDraw(canvas);
        pintarTablero(canvas);
        pintarPieza(canvas);
        pintarCuadricula(canvas);
    }
    
    private void pintarTablero(Canvas canvas){
        Paint p = new Paint();
        int color=0;
        for(int i=0;i<20;i++){
            for(int j=0;j<10;j++){
                color = colorCelda(tablero.tablero[i][j]);
                p.setColor(color);
                canvas.drawRect(j*70,i*70,j*70+70,i*70+70,p);
            }
        }
    }

    private void pintarCuadricula(Canvas canvas){
        Paint p = new Paint();
        p.setColor(Color.GRAY);
        int anchoCelda = this.getWidth() / 10;
        int ejeX = 0;
        for (int i = 0; i < 9; i++){
            ejeX += anchoCelda;
            canvas.drawLine(ejeX, 0, ejeX, this.getHeight(), p);
        }
        int altoCelda = this.getHeight() / 20;
        int ejeY = 0;
        for (int i = 0; i < 19; i++){
            ejeY += altoCelda;
            canvas.drawLine(0, ejeY, this.getWidth(), ejeY, p);
        }
    }

    public void pintarPieza(Canvas canvas){
        int color=0;
        color=colorCelda(tablero.enjuego.tipopieza);
        p.setColor(color);
        int fila;
        int columna;
        int ite=0;
        while(ite<8){
            fila=tablero.enjuego.cuadrados[ite];
            ite++;
            columna=tablero.enjuego.cuadrados[ite];
            ite++;
            canvas.drawRect(columna*70,fila*60,columna*70+70,fila*60+60,p);
        }
    }

    private int colorCelda(int codigo){
        int color=0;
        switch (codigo){
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
        return color;
    }
}
