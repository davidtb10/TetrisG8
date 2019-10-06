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
    private Rect block;
    private Pieza pieza;

    public GameView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pintarCuadricula(canvas);
        //pieza = new PiezaZ(0,4);
        pieza.dibujarPieza(canvas);
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


}
