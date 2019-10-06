package com.example.tetrisg8;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class Celda { //Clase celda de la que están formadas las piezas
    private int x, y; // Coordenadas x e y de la celda en el tablero
    private int tipoPieza; // Tipo de pieza a la que pertenece la celda
    private Drawable dibujo; // Drawable que representa la celda
    private int anchoCeldaTabl = 70;
    private int altoCeldaTabl = 62;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getTipoPieza(){
        return tipoPieza;
    }

    public Celda(int x, int y){
        this.x = x;
        this.y = y;
        tipoPieza = 0;
    }

    public void setTipoPieza(int tipoPieza) { this.tipoPieza = tipoPieza; }

    public Celda(int x, int y, int tipo){
        this.x = x;
        this.y = y;
        tipoPieza = tipo;
    }

    public void pintarCelda(Canvas canvas){ // método que dibuja la celda
        Paint p = new Paint();
        p.setColor(Color.RED);
        canvas.drawRect(anchoCeldaTabl*y, altoCeldaTabl*x, (anchoCeldaTabl*y)+anchoCeldaTabl, (altoCeldaTabl*x)+altoCeldaTabl, p);
    }

}