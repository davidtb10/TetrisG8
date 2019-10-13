package com.example.tetrisg8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.core.content.ContextCompat;

    //Vista que muestra la siguiente ficha

public class FichaView extends View{

        public FichaView(Context context) {
            super(context);
            this.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorDarkBlue));
        }

        public Pieza generarPieza (int x, int y){// la pieza necesita unas coordenadas por defecto en las que aparecer
            int tipoPieza = (int) Math.floor(Math.random()*6+1); //función para generar un numero aleatorio del 1 al 7
            Pieza pieza = new Pieza (x, y, tipoPieza, 1);
            return pieza;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

        }
    }

