package com.example.tetrisg8;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class Celda { //Clase celda de la que están formadas las piezas
    private int x, y; // Coordenadas x e y de la celda en el tablero
    private int tipoPieza; // Tipo de pieza a la que pertenece la celda
    private int anchoCeldaTabl = 70; //Dimensiones de las celdas del tablero
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

    public void setCelda(Celda celda){
        this.x = celda.getX();
        this.y = celda.getY();
        this.tipoPieza = celda.getTipoPieza();

    }

    public Celda(int x, int y, int tipo){
        this.x = x;
        this.y = y;
        tipoPieza = tipo;
    }

    public void pintarCelda(Canvas canvas){ // método que dibuja una celda de la pieza
        Paint p = new Paint();
        switch (tipoPieza){
            case 1: {
                p.setColor(Color.CYAN);
            }
            case 2:{
                p.setColor(Color.BLUE);
            }
            case 3:{
                p.setColor(Color.rgb(255, 128, 0));
            }
            case 4:{
                p.setColor(Color.YELLOW);
                break;
            }
            case 5:{
                p.setColor(Color.GREEN);
                break;
            }
            case 6:{
                p.setColor(Color.MAGENTA);
                break;
            }
            case 7:{
                p.setColor(Color.RED);
                break;
            }
        }
        canvas.drawRect(anchoCeldaTabl*y, altoCeldaTabl*x, (anchoCeldaTabl*y)+anchoCeldaTabl, (altoCeldaTabl*x)+altoCeldaTabl, p);
    }

    public void borrarCelda(Canvas canvas){
        canvas.drawRGB(1,7,34);
    } // Método que borra una celda

}