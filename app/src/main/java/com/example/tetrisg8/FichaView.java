package com.example.tetrisg8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.core.content.ContextCompat;


public class FichaView extends View{

        public FichaView(Context context) {
            super(context);
            this.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorDarkBlue));
        }

        public Pieza generarPieza (int x, int y){// la pieza necesita unas coordenadas por defecto en las que aparecer
            int tipoPieza = (int) Math.floor(Math.random()*6+1); //función para generar un numero aleatorio del 1 al 7
            Pieza pieza = new Pieza (tipoPieza, x, y);
            return pieza;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint p = new Paint();
            p.setColor(Color.BLACK);
            p.setStyle(Paint.Style.FILL);
            canvas.drawRect(500,1000,500,1000, p);
        }
    }

