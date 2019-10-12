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
        pintarCeldas(canvas);
        pintarCuadricula(canvas);
        borrarTablero(canvas);
        pintarTablero(canvas);
        //pieza = new PiezaZ(0,4);
        //pieza.dibujarPieza(canvas);
    }
    
    public void pintarCeldas(Canvas canvas){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                tablero.pintarCelda(tablero.getTipoPieza()[i][j], canvas);
            }
        }
    }

    public void pintarCuadricula(Canvas canvas){
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

    public void pintarTablero(Canvas canvas){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                tablero.pintarCelda(tablero.getTipoPieza()[i][j], canvas);
            }
        }
    }

    public void borrarTablero(Canvas canvas){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                tablero.pintarCelda(tablero.getTipoPieza()[i][j],canvas);
            }
        }
    }
}
