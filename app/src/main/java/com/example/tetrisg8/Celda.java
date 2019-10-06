package com.example.tetrisg8;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class Celda { //Clase celda de la que están formadas las piezas
    private int x; // Coordenada x de la celda en el tablero
    private int y; // Coordenada y de la celda en el tablero
    private int ancho; // Ancho de la celda
    private int alto; // Alto de la celda
    private int tipoPieza; // Tipo de pieza a la que pertenece la celda
    private Drawable dibujo; // Drawable que representa la celda
    private int anchoCeldaTabl;
    private int altoCeldaTabl;

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
        ancho = 0;
        alto = 0;
    }

    public void setTipoPieza(int tipoPieza) { this.tipoPieza = tipoPieza; }

    public Celda(int x, int y, int tamaño, int tipo, int anchoCeldaTablero, int altoCeldaTablero){
        this.x = x;
        this.y = y;
        ancho = tamaño;
        alto = tamaño;
        tipoPieza = tipo;
        anchoCeldaTabl = anchoCeldaTablero;
        altoCeldaTabl = altoCeldaTablero;
    }

    public void pintarCelda(Canvas canvas){ // método que dibuja la celda
        //int xTablero =  - ancho/2;
        // int y = yCentroTabl - alto/2;
        //int y = 0;
        Paint p = new Paint();
        p.setColor(Color.RED);
        canvas.drawRect(anchoCeldaTabl*y, altoCeldaTabl*x, anchoCeldaTabl, altoCeldaTabl, p);
        //dibujo.draw(canvas);
        //xAnterior = xCentroTabl;
        //yAnterior = y;
    }

}